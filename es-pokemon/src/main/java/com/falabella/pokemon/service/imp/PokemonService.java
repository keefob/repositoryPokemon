package com.falabella.pokemon.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falabella.pokemon.repository.dao.ifc.IPokemonRepository;
import com.falabella.pokemon.repository.entity.Entrenador;
import com.falabella.pokemon.repository.entity.PokemonEntity;
import com.falabella.pokemon.service.ifc.IPokemonService;

@Service
public class PokemonService implements IPokemonService{

	@Autowired
	private IPokemonRepository repo;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Transactional(readOnly=true)
	public List<PokemonEntity> getAll() {
		
		logger.info("ingresa Service getAll");
		List<PokemonEntity> pokemons =(List<PokemonEntity> ) repo.findAll();
		
		if(pokemons!=null)
			if(pokemons.size()==0) {
				PokemonEntity pokeObjeto= new PokemonEntity(null, "Pikachu", 20, 100, "Paleta", 50, 10, "Electrico", new Entrenador("Ash", "Ketchup"));
				repo.save(pokeObjeto);
				pokemons =(List<PokemonEntity> ) repo.findAll();
				
			}
				
		
		return pokemons;
	}

	@Override
	@Transactional(readOnly=true)
	public PokemonEntity getPokemon(Integer id) {
		logger.info("ingresa Service getPokemon");
		PokemonEntity pokemon = repo.findById(id).orElse(new PokemonEntity());
		return pokemon;
	}

	@Override
	public void savePokemon(PokemonEntity pokemon) throws Exception {
		
		validaPokemon(pokemon);
		repo.save(pokemon);

	}

	@Override
	public void updatePokemon(PokemonEntity pokemon) throws Exception {
		validaPokemon(pokemon);
		repo.save(pokemon);
		
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	public void validaPokemon(PokemonEntity pokeObjeto) {
		pokeObjeto.validarEdadPokemon();
		pokeObjeto.validarNivelPokemon();
		pokeObjeto.validarNombrePokemon();
	}
	

}
