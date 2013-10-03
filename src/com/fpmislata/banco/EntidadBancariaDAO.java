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

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAO {
    //hay que crear un constructor donde metamos la conexión de la db para no hacerlo en cada metodo
    /*
     *  Obtiene una entidad bancaria dada su id.
        Si no existe dicha entidad bancaria deberá
        returnar null.
        Si existe más de una entidad bancaria con
        ese id deberá lanzar una excepción del tipo
        RuntimeException..
     */
    EntidadBancaria read(int idEntidadBancaria) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");       
        
        String sql = "SELECT * FROM entidadbancaria WHERE Id=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, idEntidadBancaria);
        ResultSet rs = preparedStatement.executeQuery();
        
        String codigo;
        if (rs.next() == true) {
            codigo = rs.getString("codigo");

            if (rs.next() == true) {
                throw new RuntimeException("Existe más de una EntidadBancaria:" + idEntidadBancaria);
            }
        } else {
            /*
             * Porque es importante la excepcion:
             * Imaginemos que el codigo está puesto como entero
             * podría devolver más de una fila de una columna
             */
           RuntimeException runtimeException = new RuntimeException("No existe la entidad Bancaria" + idEntidadBancaria);
           throw runtimeException;
        }
        conn.close ();
        System.out.println ("Se ha conectado!!");
        return;
    }
    
    /*Añade una nueva entidad bancaria a la
    base de datos*/
    void insert( EntidadBancaria entidadBancaria) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "alumno");
        String insertTableSQL = "INSERT INTO entidadbancaria"
            + "(id, codigoEntidad, nombre, cif, tipoEntidadBancaria) VALUES"
            + "(?,?,?,?)";
        PreparedStatement preparedStatement2 = conn.prepareStatement(insertTableSQL);
        preparedStatement2.setInt    (1, entidadBancaria.getId());
        preparedStatement2.setString (2, entidadBancaria.getCodigoEntidad());
        preparedStatement2.setString (3, entidadBancaria.getNombre());
        preparedStatement2.setString (4, entidadBancaria.getCif());
        //preparedStatement2.setEnum (5, entidadBancaria.getTipoEntidadBancaria());
        preparedStatement2.executeUpdate();
        System.out.println("Entrada insertada");
        
        conn.close ();
        System.out.println ("Se ha conectado!!");
    }
    void update( EntidadBancaria entidadBancaria){
        
    }
    /*
     *  Borra la entidad bancaria de la base de
        datos.
        Si se borra más de una fila se deberá
l       anzar una RuntimeException. 
     */
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
    /*List<EntidadBancaria> findAll(){
        
    }
    List<EntidadBancaria> findByCodigo(String codigo){
        
    }*/
    
}
