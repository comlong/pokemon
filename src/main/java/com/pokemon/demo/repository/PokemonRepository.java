package com.pokemon.demo.repository;

import com.pokemon.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long>, JpaSpecificationExecutor<Pokemon> {

    List<Pokemon> findByNameContainingIgnoreCase(String name);
}
