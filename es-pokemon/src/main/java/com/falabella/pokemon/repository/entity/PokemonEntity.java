package com.falabella.pokemon.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class PokemonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 150)
	private Integer id;
	
	private String nombre;
	private Integer edad;
	private Integer nivel;

	@Column(name="pueblo_origen")
	private String puebloOrigen;
	
	@Column(name="cantidad_victorias")
	private Integer cantidadVictorias;
	
	@Column(name="cantidad_derrotas")
	private Integer cantidadDerrotas;
	
	private String tipo;
	private Entrenador entrenador;
	
	
	
	
	public PokemonEntity(Integer id, String nombre, Integer edad, Integer nivel, String puebloOrigen,
			Integer cantidadVictorias, Integer cantidadDerrotas, String tipo, Entrenador entrenador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.nivel = nivel;
		this.puebloOrigen = puebloOrigen;
		this.cantidadVictorias = cantidadVictorias;
		this.cantidadDerrotas = cantidadDerrotas;
		this.tipo = tipo;
		this.entrenador = entrenador;
	}
	
	
	public PokemonEntity() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setEstado(Integer nivel) {
		this.nivel = nivel;
	}
	public String getPuebloOrigen() {
		return puebloOrigen;
	}
	public void setPuebloOrigen(String puebloOrigen) {
		this.puebloOrigen = puebloOrigen;
	}
	public Integer getCantidadVictorias() {
		return cantidadVictorias;
	}
	public void setCantidadVictorias(Integer cantidadVictorias) {
		this.cantidadVictorias = cantidadVictorias;
	}
	public Integer getCantidadDerrotas() {
		return cantidadDerrotas;
	}
	public void setCantidadDerrotas(Integer cantidadDerrotas) {
		this.cantidadDerrotas = cantidadDerrotas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Entrenador getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	@Override
	public String toString() {
		return "PokemonEntity [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", nivel=" + nivel
				+ ", puebloOrigen=" + puebloOrigen + ", cantidadVictorias=" + cantidadVictorias + ", cantidadDerrotas="
				+ cantidadDerrotas + ", tipo=" + tipo + ", entrenador=" + entrenador + "]";
	}
	
	
	public void validarNombrePokemon() {
		if(this.nombre.isBlank()||this.nombre.isEmpty())
			throw new RuntimeException("Campo nombre requerido");
	}
	
	public void validarNivelPokemon() {
		if(this.nivel<1)
			throw new RuntimeException("Campo nivel debe ser mayor a cero");
	}
	
	public void validarEdadPokemon() {
		if(this.edad<1)
			throw new RuntimeException("Campo edad debe ser mayor a cero");
	}
	
	
	
}
