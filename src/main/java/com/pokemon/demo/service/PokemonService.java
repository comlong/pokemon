package com.pokemon.demo.service;

import com.pokemon.demo.model.Pokemon;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PokemonService {
    List<Pokemon> getAllPokemon();

    Page<Pokemon> findByCondition(Integer page, Integer size, Integer HPBegin, Integer HPEnd, Integer attackBegin, Integer attackEnd, Integer defenseBegin, Integer defenseEnd);
}
