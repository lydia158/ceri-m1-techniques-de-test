package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public  class IPokemonFactoryTest {  // permet de créer individu

    IPokemonFactory pokemonFactory;
    Pokemon bulbizarre; Pokemon aquali ; // création des pokémons
    @Before
    public void init() {

        pokemonFactory = Mockito.mock(IPokemonFactory.class);
// initialisation des pokémons
        bulbizarre =  new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
    }

    @Test
    public void createPokemonTest() {
        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        Mockito.when(pokemonFactory.createPokemon(133,2729, 202, 5000, 4)).thenReturn(aquali);


    }




}