package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Artista;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class ArtistaJdbcImplTest {

    @Test
    void getInstance() {assertNotNull(ArtistaJdbcImpl.getInstance());}

    @Test
    void findAll() {
        ArtistaJdbc artistaJDBC = ArtistaJdbcImpl.getInstance();
        List<Artista> list = artistaJDBC.findAll();
        if(list == null || list.isEmpty())
        {
            System.out.println("No hay elementos");
            return;
        }
        list.stream().forEach( e-> System.out.println(e.toString()));
        assertNotNull(list);
        assertTrue(list.size() >= 1);

    }

    @Test
    void savetest() {
        Artista artista = new Artista();
        boolean res = false;
        ArtistaJdbc artistaJDBC = ArtistaJdbcImpl.getInstance();
        artista.setNombre("Billie Stone");
        res = artistaJDBC.save(artista);
        assertEquals(true, res);
    }

    @Test
    void updatetest() {
        Artista artista = new Artista();
        boolean res = false;
        artista.setNombre("Miguel Angel");
        artista.setId(1);
        ArtistaJdbc artistaJDBC = ArtistaJdbcImpl.getInstance();
        res = artistaJDBC.update(artista);
        assertEquals(true, res);
    }

}