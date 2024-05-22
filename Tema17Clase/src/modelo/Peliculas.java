/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jose
 */
public class Peliculas {
    private int id;
    private String titulo;
    private String director;
    private int publicacion;

    public Peliculas(int id, String titulo, String director, int publicacion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.publicacion = publicacion;
    }

    public Peliculas(String titulo, String director, int publicacion) {
        this.titulo = titulo;
        this.director = director;
        this.publicacion = publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }
    
    
}
