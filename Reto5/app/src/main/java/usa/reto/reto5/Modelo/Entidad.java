package usa.reto.reto5.Modelo;

import android.net.Uri;

public class Entidad {

    //int imagen;
    //Uri imagen;
    String imagen;
    String titulo;
    String descripcion;
    String precio;

    public Entidad(String imagen, String titulo, String descripcion, String precio) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getImagen() {
       return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecio() {
        return precio;
    }
}
