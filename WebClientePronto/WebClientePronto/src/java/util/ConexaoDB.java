/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;

/**
 *
 * @author  Henriq
 */
public class ConexaoDB {
        public static Connection getConexao()throws ClassNotFoundException, SQLException{
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/cliente";
            //conexão em casa
            String USER = "postgres";
            String PASSWORD = "99877832";
            //conexão umc
            //String USER = "postgres";
            //String PASSWORD = "";
            
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }
    
    
}
