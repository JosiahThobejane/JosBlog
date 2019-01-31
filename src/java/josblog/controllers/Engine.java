/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josblog.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Josiah Thobejane
 */
public class Engine {
    String connString = "jdbc:mysql://localhost:3306/josblogdata?";
    String cred = "user=root&password=";
        
    public Connection conn;
    
    public Engine()
    {        
        //instantiate objects
        try {            
            //use the imported JDBC library.
            Class.forName("com.mysql.jdbc.Driver");

            //establish a new database connection
            conn = DriverManager.getConnection(connString + cred); 
        } catch (ClassNotFoundException | SQLException e ) {            
          System.out.println("THERE  IS A CONNECTION PROBLEM");
        }        
    }
}
