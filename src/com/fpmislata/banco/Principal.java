/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        //GREGORIAN CALENDAR
        //????????? gcalendar = new GregorianCalendar(int year, int month, int dayOfMonth);

        /* BigDecimal c = new BigDecimal("0.2");
         BigDecimal d = new BigDecimal("0.2");
         BigDecimal e;
         //se suma de la siguiente manera porque es un objeto
         e = c.add(d);
         */
        //crear dos de cada

        /*EntidadBancaria Entidad1, Entidad2;
        Entidad1 = new EntidadBancaria(01, "001", "entidad01", "4949494949", TipoEntidadBancaria.Banco);
        Entidad2 = new EntidadBancaria(01, "001", "entidad01", "4949494949", TipoEntidadBancaria.Banco);

        SucursalBancaria Sucursal1, Sucursal2;
        Sucursal1 = new SucursalBancaria(1, Entidad1, 1, "Sucursal1");
        Sucursal2 = new SucursalBancaria(1, Entidad2, 1, "Sucursal1");

        BigDecimal a = new BigDecimal("1000000");
        BigDecimal b = new BigDecimal("2000000");



        CuentaBancaria cuentaBancaria1, cuentaBancaria2;
        cuentaBancaria1 = new CuentaBancaria(001, Sucursal1, "000000001", "23", a, "noseque");
        cuentaBancaria2 = new CuentaBancaria(002, Sucursal2, "000000002", "24", b, "noseque");
        //Entidad1.getCodigoEntidad();
        //imprimir cuenta bancaria

        MovimientoBancario movimientoBancario1, movimientoBancario2;
        movimientoBancario1 = new MovimientoBancario(1, TipoMovimientoBancario.debe, a, "Enero", a, "pago1");
        movimientoBancario2 = new MovimientoBancario(2, TipoMovimientoBancario.haber, b, "febrero", b, "pago2");

        List<MovimientoBancario> movimientoBancarios = cuentaBancaria1.getMovimientoBancarios();
        movimientoBancarios.add(movimientoBancario1);
        movimientoBancarios.add(movimientoBancario2);
        imprimeDatosCuentaBancaria(cuentaBancaria1);
        imprimeDatosCuentaBancaria(cuentaBancaria2);*/

        //driver
        Class.forName("com.mysql.jdbc.Driver");
        //creamos los objetos DAO insert, update, delete
        EntidadBancaria entidadBancariaInsert = new EntidadBancaria(6, "654654", "entidadInsertadaDAO", "9865498654", TipoEntidadBancaria.Banco);
        EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAO();
        //entidadBancariaDAO.insert(entidadBancariaInsert);
        entidadBancariaDAO.update(entidadBancariaInsert);
        
        
        
    }

    static void imprimeDatosCuentaBancaria(CuentaBancaria cuentaBancaria) {

        for (MovimientoBancario movimientoBancarios : cuentaBancaria.getMovimientoBancarios()) {
            System.out.println(cuentaBancaria.getIdCuentaBancaria());
            System.out.println(cuentaBancaria.getSucursalBancaria());
            System.out.println(cuentaBancaria.getDc());
            System.out.println(cuentaBancaria.getNumeroCuenta());
        }

    }
}
