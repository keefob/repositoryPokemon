package com.falabella.pokemon;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.falabella.pokemon.repository.entity.Entrenador;
import com.falabella.pokemon.repository.entity.PokemonEntity;
import com.falabella.pokemon.service.ifc.IPokemonService;
import com.falabella.pokemon.service.imp.PokemonService;

@SpringBootTest
class PokemonServiceTest {

	@Autowired
	IPokemonService service= new PokemonService();
	

	
	@Test
	void testGuardaPokemon() {
		PokemonEntity pokeObjeto= new PokemonEntity(null, "Blastoise", 10, 100, "Paleta", 50, 10, "Agua", new Entrenador("Gary", "Oak"));
		try {
			service.savePokemon(pokeObjeto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<PokemonEntity> pokeLista= (List<PokemonEntity>) service.getAll();
		int size = pokeLista.size();
		//
		assertTrue(size>0);
	}
	
	
	@Test
	void testNoDebeInsertarPokemon() {
		PokemonEntity pokeObjeto= new PokemonEntity(null, "Blastoise", 0, 100, "Paleta", 50, 10, "Agua", new Entrenador("Gary", "Oak"));
		
		try {
		service.savePokemon(pokeObjeto);
		}catch(Exception e) {e.printStackTrace();}
		
		List<PokemonEntity> pokeLista= (List<PokemonEntity>) service.getAll();
		int size = pokeLista.size();
		System.out.println("size:"+ size+"-"+pokeLista.get(size-1).getNombre());
		assertFalse(size>1);
	}

}
