/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco;

/**
 *
 * @author KIKE
 */
public class EntidadBancaria {
    	private int id;
	private int codigoEntidad;
	private String nombre;
	private String cif;
	private TipoEntidadBancaria tipoEntidadBancaria;

    public EntidadBancaria(int id, int codigoEntidad, String nombre, String cif, TipoEntidadBancaria tipoEntidadBancaria) {
        this.id = id;
        this.codigoEntidad = codigoEntidad;
        this.nombre = nombre;
        this.cif = cif;
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codigoEntidad
     */
    public int getCodigoEntidad() {
        return codigoEntidad;
    }

    /**
     * @param codigoEntidad the codigoEntidad to set
     */
    public void setCodigoEntidad(int codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the tipoEntidadBancaria
     */
    public TipoEntidadBancaria getTipoEntidadBancaria() {
        return tipoEntidadBancaria;
    }

    /**
     * @param tipoEntidadBancaria the tipoEntidadBancaria to set
     */
    public void setTipoEntidadBancaria(TipoEntidadBancaria tipoEntidadBancaria) {
        this.tipoEntidadBancaria = tipoEntidadBancaria;
    }

}
