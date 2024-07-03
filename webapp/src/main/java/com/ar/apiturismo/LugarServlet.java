package com.ar.apiturismo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/lugares")
public class LugarServlet extends HttpServlet{

   //Generamos la instancia de las operaciones de la base de datos
   private LugarDAO lugarDAO = new LugarDAO();

   //Generar una instancia de un objeto que utiliza libreria JACKSON para conventir un objeto en json y viceversa
   private ObjectMapper objectMapper = new ObjectMapper();

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // Configurar cabeceras CORS
      resp.setHeader("Access-Control-Allow-Origin", "*");
      resp.setHeader("Access-Control-Allow-Methods", "*");
      resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

      // Establecer la codificación de caracteres
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");

      Lugar lugar = objectMapper.readValue(req.getInputStream(), Lugar.class);

      Long id = lugarDAO.insertarLugar(lugar);

      // Convertir el id a JSON
      String jsonResponse = objectMapper.writeValueAsString(id);

      // Establecer el tipo de contenido de la respuesta a JSON
      resp.setContentType("application/json");

      // Escribir la respuesta JSON
      resp.getWriter().write(jsonResponse);

      // Establecer el estado de la respuesta a 201 (Creado)
      resp.setStatus(HttpServletResponse.SC_CREATED);

      // No es necesario llamar a super.doPost(req, resp); al final, ya que podría causar una excepción "Servlet has already been committed".
      // super.doPost(req, resp);
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // Configurar cabeceras CORS
      resp.setHeader("Access-Control-Allow-Origin", "*");
      resp.setHeader("Access-Control-Allow-Methods", "*");
      resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

      // Establecer la codificación de caracteres
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");

      try {
         List<Lugar> lugares = lugarDAO.getAllLugares();
         String jsonResponse = objectMapper.writeValueAsString(lugares);
         // Establecer el tipo de contenido de la respuesta a JSON
         resp.setContentType("application/json");
         resp.getWriter().write(jsonResponse);

      } catch (NumberFormatException e) {
         e.printStackTrace();
         resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
      }
   }

   
}
