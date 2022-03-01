package com.falabella.pokemon.repository.dao.ifc;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.falabella.pokemon.repository.entity.PokemonEntity;



@RepositoryRestResource(path="relaysRepoResource")
public interface IPokemonRepository extends PagingAndSortingRepository<PokemonEntity, Integer>{

}
