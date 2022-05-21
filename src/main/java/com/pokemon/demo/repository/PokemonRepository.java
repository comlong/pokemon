package com.pokemon.demo.repository;

import com.pokemon.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PokemonRepository extends JpaRepository<Pokemon,Long>, JpaSpecificationExecutor<Pokemon> {

}
