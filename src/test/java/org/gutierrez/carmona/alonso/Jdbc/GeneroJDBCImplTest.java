package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.GeneroMusical;
import org.gutierrez.carmona.alonso.model.normal.GeneroMusical;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class GeneroJdbcImplTest {

    @Test
    void getInstance()  {
        assertNotNull(GeneroMusicalJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        List<GeneroMusical> list = generoMusicalJdbc.findAll();
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
    void save() {
        GeneroMusical generoMusical = new GeneroMusical();
        boolean res = false;
        GeneroMusicalJdbc generoJDBC = GeneroMusicalJdbcImpl.getInstance();
        generoMusical.setDescripcion("Regeton");
        res = generoJDBC.save(generoMusical);
        assertEquals(true, res);
    }

    @Test
    void update() {
        GeneroMusical generoMusical = new GeneroMusical();
        boolean res = false;
        generoMusical.setDescripcion("Corridos");
        generoMusical.setId(2);
        GeneroMusicalJdbc generoJDBC = GeneroMusicalJdbcImpl.getInstance();
        res = generoJDBC.update(generoMusical);
        assertEquals(true, res);
    }

}