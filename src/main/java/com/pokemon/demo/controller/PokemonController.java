package com.pokemon.demo.controller;

import com.pokemon.demo.model.Pokemon;
import com.pokemon.demo.service.PokemonService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping("/pokemon")
    private List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/findByName")
    private List<Pokemon> getPokemonByName(@RequestParam(value = "name",required = false) String name){
        return pokemonService.findByName(name);
    }


    @GetMapping("/search")
    @ResponseBody
    public Object findByCondition(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size,
                                  @RequestParam(value = "HPBegin",required = false) Integer HPBegin,
                                  @RequestParam(value = "HPEnd",required = false) Integer HPEnd,
                                  @RequestParam(value = "attackBegin",required = false) Integer attackBegin,
                                  @RequestParam(value = "attackEnd",required = false) Integer attackEnd,
                                  @RequestParam(value = "defenseBegin",required = false) Integer defenseBegin,
                                  @RequestParam(value = "defenseEnd", required = false) Integer defenseEnd) {
        List<Pokemon> list = pokemonService.findByCondition(page, size, HPBegin, HPEnd, attackBegin, attackEnd, defenseBegin, defenseEnd).getContent();
        Map<String, Object> map = new HashMap<>();
        map.put("num", list.size());
        map.put("listData", list);
        return map;
    }
}
