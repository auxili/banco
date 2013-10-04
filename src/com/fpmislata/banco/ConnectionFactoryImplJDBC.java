/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplJDBC implements ConnectionFactory{

    @Override
    public Connection getConnection(){
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        }
        catch(Exception e){
            System.out.println(e);}
        
        return conn;
    }
    
}
