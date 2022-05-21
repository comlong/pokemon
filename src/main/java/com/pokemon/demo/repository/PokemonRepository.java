package com.pokemon.demo.repository;

import com.pokemon.demo.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {
}
