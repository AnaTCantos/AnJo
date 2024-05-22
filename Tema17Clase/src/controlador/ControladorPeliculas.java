/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Peliculas;

/**
 *
 * @author Jose
 */
public class ControladorPeliculas {
    private ConexionMySQL con;
    private String fecha;
    public ControladorPeliculas(ConexionMySQL con) {
        this.con = con;
    }
    public ControladorPeliculas(ConexionMySQL con, String fecha) {
        this.con = con;
        this.fecha=fecha;
    }
    
    
    public ArrayList<Peliculas> obtenerPeliculas() throws SQLException{
        ArrayList<Peliculas> lista=new ArrayList<>();
        String consulta= "SELECT TITULO,DIRECTOR,PUBLICACION FROM PELICULAS";
        ResultSet res=con.ejecutarSelect(consulta);
        
        while(res.next()){
            String titulo= res.getString("titulo");
            String director= res.getString("director");               
            int publicacion= res.getInt("publicacion");
            Peliculas t=new Peliculas(titulo,director,publicacion);
                lista.add(t);
        }
        return lista;
    }
    public ArrayList<Peliculas> peliculasAnteriores() throws SQLException{
        ArrayList<Peliculas> lista=new ArrayList<>();
        String consulta= "SELECT TITULO,DIRECTOR,PUBLICACION FROM PELICULAS WHERE PUBLICACION> "+fecha;
        ResultSet res=con.ejecutarSelect(consulta);
        
        while(res.next()){
            String titulo= res.getString("titulo");
            String director= res.getString("director");               
            int publicacion= res.getInt("publicacion");
            Peliculas t=new Peliculas(titulo,director,publicacion);
                lista.add(t);
        }
        return lista;
    }
}
