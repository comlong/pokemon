package com.pokemon.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import com.pokemon.demo.model.Pokemon;
import com.pokemon.demo.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Autowired
    private PokemonRepository pokemonRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            log.info("Start loading data ");
            List<Pokemon> pokemons = csvToPokemons("./Data/pokemon.csv");
            List<Pokemon> pokemonsJSON = jsonToPokemons("./Data/pokemon.json");
            pokemons.addAll(pokemonsJSON);

            pokemons = pokemons.stream()
                    .filter(x -> x.isLegendary() == false)
                    .filter(checkTypes("Ghost", false))
                    .collect(Collectors.toList());

            pokemons.stream().filter(checkTypes("Steel", true)).forEach(x -> x.setHP(2 * x.getHP()));
            //Not sure Attack should be double or int
            pokemons.stream().filter(checkTypes("Fire", true)).forEach(x -> x.setAttack(((int) Math.round(0.9 * x.getAttack()))));
            //For Pokémon of Type: Bug & Flying, increase their Attack Speed by 10%
            pokemons.stream().filter(checkTypes("Bug", true).and(checkTypes("Flying", true))).forEach(x -> x.setSpeed(((int) Math.round(1.1 * x.getSpeed()))));
            //For Pokémon that start with the letter G, add +5 Defense for every letter in their name (excluding G)
            pokemons.stream().filter(x -> x.getName().startsWith("G")).forEach(x -> x.setDefense(x.getDefense() + 5 * (x.getName().length() - 1)));

            pokemonRepository.saveAll(pokemons);
            log.info("All data saved");
        };
    }

    private Predicate<Pokemon> checkTypes(String type, Boolean include) {
        if (include == false)
            return p -> !p.getType1().equals(type) && !p.getType2().equals(type);
        else
            return p -> p.getType1().equals(type) || p.getType2().equals(type);
    }

    private List<Pokemon> csvToPokemons(String filePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CsvToBean<Pokemon> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Pokemon.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<Pokemon> csvPokemonIterator = csvToBean.iterator();

            List<Pokemon> pokemons = new ArrayList<Pokemon>();

            while (csvPokemonIterator.hasNext()) {
                Pokemon pokemon = csvPokemonIterator.next();
                pokemons.add(pokemon);
            }
            return pokemons;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Pokemon> jsonToPokemons(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Pokemon> pokemons = mapper.readValue(new URL("file:" + filePath), new TypeReference<List<Pokemon>>() {
        });
        return pokemons;
    }
}
