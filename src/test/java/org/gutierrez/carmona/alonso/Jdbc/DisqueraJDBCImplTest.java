package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Disquera;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

class DisqueraJdbcImplTest {

    @Test
    void getInstance() {assertNotNull(DisqueraJdbcImpl.getInstance());    }

    @Test
    void findAll() {
        DisqueraJdbc disqueraJDBC = DisqueraJdbcImpl.getInstance();
        List<Disquera> list = disqueraJDBC.findAll();
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
        Disquera disquera = new Disquera();
        boolean res = false;
        DisqueraJdbc disqueraJDBC = DisqueraJdbcImpl.getInstance();
        disquera.setNombre("Billie Eilish");
        res = disqueraJDBC.save(disquera);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setNombre("Apple Music");
        disquera.setId(1);
        DisqueraJdbc disqueraJDBC = DisqueraJdbcImpl.getInstance();
        res = disqueraJDBC.update(disquera);
        assertEquals(true, res);
    }

}