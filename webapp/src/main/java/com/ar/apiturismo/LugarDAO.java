package com.ar.apiturismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LugarDAO {
   // ----------------Create-----------------------//
   public Long insertarLugar(Lugar lugar) {

      String insertLugarSql = "INSERT INTO lugares (nombre, descripcion, ubicacion, imagen) VALUES (?,?,?,?)";

      DatabasesConnection conexion = new DatabasesConnection();

      Statement stm = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      Connection cn = conexion.conectar();

      try {
         pstm = cn.prepareStatement(insertLugarSql);

         pstm.setString(1, lugar.getNombre());
         pstm.setString(2, lugar.getDescripcion());
         pstm.setString(3, lugar.getUbicacion());
         pstm.setString(4, lugar.getImagen());

         int result = pstm.executeUpdate();

         if (result > 0) {

            rs = pstm.getGeneratedKeys();

            if (rs.next()) {
               System.out.println("El lugar fue insertado correctamente");
               return rs.getInt(1);
            } else {
               System.out.println("Error al obtener el ID del lugar insertada");
               return null;
            }
         }

      } catch (SQLException e) {
         e.printStackTrace();
         return null;
      }
      return null;
   }

   // ------------------Read----------------------//
   public List<Lugar> getAllLugares() {

      String selectAllLugaresSql = "SELECT * FROM lugares";

      DatabasesConnection conexion = new DatabasesConnection();

      List<Lugar> lugares = new ArrayList<>();

      Statement stm = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      Connection cn = conexion.conectar();

      try {

         stm = cn.createStatement();

         rs = stm.executeQuery(selectAllLugaresSql);

         while (rs.next()) {

            int id = rs.getInt("idLugar");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String ubicacion = rs.getString("ubicacion");
            String imagen = rs.getString("imagen");

            Lugar lugar = new Lugar(id, nombre, descripcion, ubicacion, imagen);

            lugares.add(lugar);

         }

      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
         return null;
      }

      return lugares;
   }

}
