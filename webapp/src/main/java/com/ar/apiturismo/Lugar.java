package com.ar.apiturismo;

public class Lugar {

   private int id;
   private String nombre;
   private String descripcion;
   private String ubicacion;
   private String imagen;

   public Lugar () {

   }

   public Lugar(int id, String nombre, String descripcion, String ubicacion, String imagen) {
      this.id = id;
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.ubicacion = ubicacion;
      this.imagen = imagen;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getDescripcion() {
      return descripcion;
   }

   public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
   }

   public String getUbicacion() {
      return ubicacion;
   }

   public void setUbicacion(String ubicacion) {
      this.ubicacion = ubicacion;
   }

   public String getImagen() {
      return imagen;
   }

   public void setImagen(String imagen) {
      this.imagen = imagen;
   }

   @Override
   public String toString() {
      return "Lugar: id: " + id + ", nombre: " + nombre + ", descripcion: " + descripcion + ", ubicacion: " + ubicacion
            + ", imagen: " + imagen;
   }

}
