package com.pokemon.demo.ServiceImpl;

import com.pokemon.demo.model.Pokemon;
import com.pokemon.demo.repository.PokemonRepository;
import com.pokemon.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service("PokemonService")
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public Page<Pokemon> findByCondition(Integer page, Integer size, Integer HPBegin, Integer HPEnd, Integer attackBegin, Integer attackEnd, Integer defenseBegin, Integer defenseEnd) {

        Pageable pageable = PageRequest.of(page, size);
        return pokemonRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();

            if (HPBegin != null) {  //HP larger than
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("HP"), HPBegin));
            }
            if (HPEnd != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("HP"), HPEnd));
            }
            if (attackBegin != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("attack"), attackBegin));
            }
            if (attackEnd != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("attack"), attackEnd));
            }
            if (defenseBegin != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("defense"), defenseBegin));
            }
            if (defenseEnd != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("defense"), defenseEnd));
            }
            return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }
}
