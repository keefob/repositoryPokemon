package com.falabella.pokemon.repository.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Entrenador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2556031302303232270L;
	private String nombreEntrenador;
	private String apellidoEntrenador;
	
	
	
	public Entrenador() {
		super();
	}
	public Entrenador(String nombreEntrenador, String apellidoEntrenador) {
		super();
		this.nombreEntrenador = nombreEntrenador;
		this.apellidoEntrenador = apellidoEntrenador;
	}
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
	public String getApellidoEntrenador() {
		return apellidoEntrenador;
	}
	public void setApellidoEntrenador(String apellidoEntrenador) {
		this.apellidoEntrenador = apellidoEntrenador;
	}
	@Override
	public String toString() {
		return "Entrenador [nombreEntrenador=" + nombreEntrenador + ", apellidoEntrenador=" + apellidoEntrenador + "]";
	}
	
	
}
