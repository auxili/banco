/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAO {
    EntidadBancaria read(int idEntidadBancaria) throws Exception{
        //declaramos variable para el constructor para que se vea en toda el metodo
        EntidadBancaria entidadBancaria;
        //conectamos
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");       
        //elegimos el select
        String sql = "SELECT nombre FROM entidadbancaria WHERE Id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, idEntidadBancaria);
        //no usamos while, no gusta
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next() == true) {
            //decaramos variables bd
            idEntidadBancaria = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");

            if (rs.next() == true) {
                throw new RuntimeException("Existe más de una EntidadBancaria:" + idEntidadBancaria);
            }
            //constructor con las variables de la bd
            entidadBancaria = new EntidadBancaria(idEntidadBancaria, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
        } else {
            RuntimeException runtimeException = new RuntimeException("No existe la entidad Bancaria" + idEntidadBancaria);
           throw runtimeException;
        }
         //cerramos la bd
        conn.close ();
        System.out.println ("Se ha conectado!!");
        //devolvemos el resultado
        return entidadBancaria;
    }
    
    void insert( EntidadBancaria entidadBancaria) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        String insertTableSQL = "INSERT INTO entidadbancaria"
            + "(id, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
            + "(?,?,?,?,?)";
        PreparedStatement preparedStatement2 = conn.prepareStatement(insertTableSQL);
        preparedStatement2.setInt    (1, entidadBancaria.getId());
        preparedStatement2.setString (2, entidadBancaria.getCodigoEntidad());
        preparedStatement2.setString (3, entidadBancaria.getNombre());
        preparedStatement2.setString (4, entidadBancaria.getCif());
        preparedStatement2.setString (5, entidadBancaria.getTipoEntidadBancaria().name());
        preparedStatement2.executeUpdate();
        System.out.println("Entrada insertada");
        
        conn.close ();
        System.out.println ("Se ha conectado!!");
    }
    void update( EntidadBancaria entidadBancaria) throws Exception{
        //actualiza el nombre de la entidad 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        
        String updateTableSQL = "UPDATE FROM entidadbancaria SET nombre = ?  WHERE id = ?";
        PreparedStatement preparedStatement4 = conn.prepareStatement(updateTableSQL);
        preparedStatement4.setString    (1, "TriodosBank");
        preparedStatement4.setInt (2, entidadBancaria.getId());
        // execute insert SQL stetement
        preparedStatement4.executeUpdate();
    }

    void delete(int idEntidadBancaria) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        String deleteSQL = "DELETE FROM entidadBancaria WHERE id = ?";
        PreparedStatement preparedStatement3 = conn.prepareStatement(deleteSQL);
        preparedStatement3.setInt(1, idEntidadBancaria);
        preparedStatement3.executeUpdate();
        System.out.println("Entrada eliminada");

        conn.close ();
        System.out.println ("Se ha conectado!!");
    }
    List<EntidadBancaria> findAll() throws Exception{
        List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
        EntidadBancaria entidadBancaria;
        //conectamos
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");       
        //elegimos el select
        String sql = "SELECT * FROM entidadbancaria";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            
            entidadBancaria = new EntidadBancaria(id, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidades.add(entidadBancaria);
        }

        
        return listaEntidades;
    }
    List<EntidadBancaria> findByCodigo(String codigo) throws Exception{
        
        List<EntidadBancaria> listaEntidades = new ArrayList<EntidadBancaria>();
        EntidadBancaria entidadBancaria;
        //conectamos
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");       
        //elegimos el select
        String sql = "SELECT * FROM entidadbancaria where codigo = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString (1, codigo);
        
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String codigoEntidad = rs.getString("codigoEntidad");
            String nombre = rs.getString("nombre");
            String cif = rs.getString("cif");
            String tipoEntidadBancaria = rs.getString("tipoEntidadBancaria");
            
            entidadBancaria = new EntidadBancaria(id, codigoEntidad, nombre, cif, TipoEntidadBancaria.valueOf(tipoEntidadBancaria));
            listaEntidades.add(entidadBancaria);
        }

        
        return listaEntidades;
    }
    
}
