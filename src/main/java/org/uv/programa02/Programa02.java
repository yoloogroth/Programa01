/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
//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

package org.uv.programa02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yolo0
 */
public class Programa02 {

    public static void main(String[] args) {
   
         
     Connection con = null;
      Statement st=null;
        try {
            String sql="insert into ejemplo (clave, nombre, direccion, telefono) values" +
                    "('01','Gabriel','Av','555')";
            String url = "jdbc:postgresql://localhost:8000/ejemplo";//si tienes corriendo postgres de manera local se pone el puerto que por defecto es 4532
            String pwd = "postgres";//contraseña que hayas puesto cuando instalaste postgress
            String user = "postgres";//usuario 
            con = DriverManager.getConnection(url,user,pwd);
            Logger.getLogger(Programa02.class.getName()).log(Level.INFO, "SE CONECTO A LA BASE DE DATOS");
            st=con.createStatement();
            st.execute(sql);
            Logger.getLogger(Programa02.class.getName()).log(Level.INFO, "SE GUARDO en la BASE DE DATOS");
             
        } catch (SQLException ex) {
            Logger.getLogger(Programa02.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           try{
               if(st!=null)
                   st.close();
           }catch (SQLException ex){
               Logger.getLogger(Programa02.class.getName()).log(Level.SEVERE, null, ex);
            }
           try{
            if(con != null)
                
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Programa02.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }
}