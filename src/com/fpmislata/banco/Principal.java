/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

import java.math.BigDecimal;

/**
 *
 * @author alumno
 */
public class Principal {
    public static void main (String[]args){
        BigDecimal a = new BigDecimal("0.2");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal c;
        //se suma de la siguiente manera porque es un objeto
        c = a.add(b);
    }
}
