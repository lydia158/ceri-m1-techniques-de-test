package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokedex pokedex;
    IPokemonTrainerFactory trainerFactory; ;


    PokemonTrainer trainerPoke;
    IPokedexFactory factory;


    @Before
    public void init() {
        pokedex = Mockito.mock(IPokedex.class);
        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        factory = Mockito.mock(IPokedexFactory.class);

        trainerPoke = new PokemonTrainer("Lydia", Team.INSTINCT, pokedex);

    }


    @Test
    public void createTrainerTest() {

        Mockito.doReturn(trainerPoke).when(trainerFactory).createTrainer("Lydia", Team.INSTINCT, factory);
        Assert.assertEquals(trainerPoke.getClass(), trainerFactory.createTrainer("Lydia", Team.INSTINCT, factory).getClass());
        Assert.assertEquals(trainerPoke, trainerFactory.createTrainer("Lydia", Team.INSTINCT, factory));
        Assert.assertEquals("Lydia",trainerFactory.createTrainer("Lydia", Team.INSTINCT, factory).getName() );
        Assert.assertEquals(Team.INSTINCT, trainerFactory.createTrainer("Lydia", Team.INSTINCT, factory).getTeam());
        Assert.assertEquals(pokedex, trainerFactory.createTrainer("Lydia", Team.INSTINCT, factory).getPokedex());
        Assert.assertEquals(pokedex.size(), trainerFactory.createTrainer("Lydia", Team.INSTINCT, factory).getPokedex().size());


    }


}