/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema17clase;

import java.util.Calendar;
import java.util.TimeZone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Tema17Clase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        
        ConexionMySQL c=new ConexionMySQL("programacion");
        try {
            c.conectar();
            
            String in1="INSERT INTO PERSONAS VALUES('12345','Manuel','Luján',80)";
            int filas=c.ejecutarInsertDeleteUpdate(in1);
            System.out.println("Se han insertado "+filas+" filas");
            
            String borrar="DELETE FROM PERSONAS WHERE EDAD>50";
            System.out.println("Se han borrado "+c.ejecutarInsertDeleteUpdate(borrar)+" filas");
            
            String actualizar="UPDATE PERSONAS SET EDAD=EDAD+1";
            System.out.println("Se han actualizado "+c.ejecutarInsertDeleteUpdate(actualizar)+" filas");
            
            String consulta="SELECT NOMBRE, EDAD FROM PERSONAS ORDER BY LENGTH(NOMBRE) desc";
            ResultSet res=c.ejecutarSelect(consulta);
            while(res.next()){
                String n=res.getString("nombre");
                int edad=res.getInt("edad");
                System.out.println(n+": "+edad);
            }
            
            String borrarPaco="Delete from personas where nombre='Paco'";
            System.out.println("Se han borrado "+c.ejecutarInsertDeleteUpdate(borrarPaco));
            
         
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        finally{
            try {
                c.desconectar();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
}
