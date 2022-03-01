package com.falabella.pokemon.controller.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.falabella.pokemon.repository.entity.PokemonEntity;
import com.falabella.pokemon.service.ifc.IPokemonService;

@RestController
public class PokemonController {
	
	@Autowired
	private IPokemonService service;
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("/v1/pokemon")
	public List<PokemonEntity> getAll(){
		
		return service.getAll();
	}
	
	@GetMapping("/v1/pokemon/{id}")
	public PokemonEntity getById(@PathVariable("id") Integer id) {
		
		return service.getPokemon(id);
	}
	
	
	@PostMapping("/v1/pokemon")
	public ResponseEntity<Object> savePokemon(@RequestBody PokemonEntity peticion) {
		
		try {
			service.savePokemon(peticion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);	
		}
		
		
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@PutMapping("/v1/pokemon")
	public ResponseEntity<Object>  updatePokemon(@RequestBody PokemonEntity peticion) {
		
		try {
			service.savePokemon(peticion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);	
		}
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	@DeleteMapping("/v1/pokemon/{id}")
	public void deletePokemon(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}

}
