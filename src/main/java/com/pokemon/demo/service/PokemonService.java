package com.pokemon.demo.service;

import com.pokemon.demo.model.Pokemon;
import com.pokemon.demo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemonRepository.findAll().forEach(pokemon -> pokemons.add(pokemon));
        return pokemons;
    }

    public Pokemon getPokemonById(int id)
    {
        return pokemonRepository.findById(id).get();
    }

}
