package com.falabella.pokemon.service.ifc;

import java.util.List;

import com.falabella.pokemon.repository.entity.PokemonEntity;

public interface IPokemonService {
	
	public List<PokemonEntity> getAll();
	
	public PokemonEntity getPokemon(Integer id);
	
	public void savePokemon(PokemonEntity pokemon) throws Exception;
	
	public void updatePokemon(PokemonEntity pokemon) throws Exception;
	
	public void deleteById(Integer id);
	

}
