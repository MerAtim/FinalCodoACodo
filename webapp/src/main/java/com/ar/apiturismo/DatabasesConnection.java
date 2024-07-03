package com.ar.apiturismo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabasesConnection {

   private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
   private static final String URL = "jdbc:mysql://localhost:1234/turismo.arg";
   private static final String USER = "root";
   private static final String PASS = "";
   
   static {
      try {
         Class.forName(CONTROLADOR);
       }
      catch (ClassNotFoundException error) {
         JOptionPane.showMessageDialog(null, "Error al cargar Driver JDBC");
         error.printStackTrace();
      }
   }
   
   public Connection conectar() {
      
      Connection conexion = null;
      
      try {
         conexion = DriverManager.getConnection(URL, USER, PASS);
        
      }
      catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al establecer la conexión");
         e.printStackTrace();
      }
      
      return conexion;
   }
   
}
 