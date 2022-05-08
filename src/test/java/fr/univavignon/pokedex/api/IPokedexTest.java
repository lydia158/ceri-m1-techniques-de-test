package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    IPokedex pokedex;
    Pokemon aquali;
    Pokemon bulbizarre;List<Pokemon> listePoke;

    @Before
    public void init() {

        pokedex = Mockito.mock(IPokedex.class);
        // initialisation pokemons
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
        listePoke = new ArrayList<>(); // liste pokemons


        // on ajoute nos pokemons à la liste
        listePoke.add(bulbizarre);
        listePoke.add(aquali);

    }



    @Test
    public void addPokemonTest() {

        Mockito.doReturn(listePoke.size() + 1).when(pokedex).addPokemon(Mockito.any(Pokemon.class));

        Assert.assertEquals(3, pokedex.addPokemon(new Pokemon(0, "", 0, 0, 0,0,0,0, 0, 0.0)));

    }

    @Test
    public void getPokemonTest () throws PokedexException {

        Mockito.doReturn(aquali).when(pokedex).getPokemon(133);
        Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(0);
        Mockito.doThrow(new PokedexException("Inexistant ")).when(pokedex).getPokemon(Mockito.intThat(i -> i < 0 || i > 150));

        Assert.assertEquals(bulbizarre, pokedex.getPokemon(0));
        Assert.assertEquals(aquali, pokedex.getPokemon(133));

    }


    }