package com.example.pokemon.repository;

import androidx.lifecycle.LiveData;

import com.example.pokemon.db.Dao;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.PokemonResponse;
import com.example.pokemon.network.PokemonApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {
        private PokemonApiService pokemonApiService;
        private Dao dao;
  @Inject
    public Repository(PokemonApiService pokemonApiService, Dao dao) {
        this.pokemonApiService = pokemonApiService;
        this.dao = dao;
    }

    public Observable<PokemonResponse> getPokemons(){
        return pokemonApiService.getPokemon();
    }

    public void insertPokemon(Pokemon pokemon){
      dao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemoonName){
      dao.deletePokemon(pokemoonName);
    }

    public LiveData<List<Pokemon>> getFavPokemon(){
     return dao.getPokemons();
    }
}
