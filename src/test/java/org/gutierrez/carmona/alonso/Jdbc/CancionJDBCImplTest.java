package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Cancion;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

class CancionJdbcImplTest {

    @Test
    void getInstance() {assertNotNull(CancionJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        List<Cancion> list = cancionJdbc.findAll();
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
        Cancion cancion = new Cancion();
        boolean res = false;
        CancionJdbc cancionJDBC = CancionJdbcImpl.getInstance();
        cancion.setTitulo("LLoloso");
        cancion.setDuracion(Time.valueOf("00:12:42"));
        cancion.setDisco_id(1);
        res = cancionJDBC.savetest(cancion);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Cancion cancion = new Cancion();
        boolean res = false;
        cancion.setTitulo("Fine");
        cancion.setDuracion(Time.valueOf("00:02:53"));
        cancion.setDisco_id(1);
        cancion.setId(1);
        CancionJdbc cancionJDBC = CancionJdbcImpl.getInstance();
        res = cancionJDBC.updatetest(cancion);
        assertEquals(true, res);
    }

}