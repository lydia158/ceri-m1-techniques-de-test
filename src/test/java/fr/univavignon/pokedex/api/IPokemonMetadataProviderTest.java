package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;



public  class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider provider ;

    PokemonMetadata aquali;
    PokemonMetadata bulbizarre;


    @Before
    public void init() {
        provider = Mockito.mock(IPokemonMetadataProvider.class);

        // initialisation
        bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);
    }


    @Test
    public void getPokemonMetadataTest() throws PokedexException {


        Mockito.doReturn(aquali).when(provider).getPokemonMetadata(133);
        Mockito.doReturn(bulbizarre).when(provider).getPokemonMetadata(0);

        Assert.assertEquals(bulbizarre, provider.getPokemonMetadata(0));
        Assert.assertEquals(aquali, provider.getPokemonMetadata(133));


        Mockito.doThrow(new PokedexException("Erreur index ")).when(provider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));


    }


}