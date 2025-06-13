package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Disco;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

class DiscoJdbcImplTest {

    @Test
    void getInstance() { assertNotNull(DiscoJdbcImpl.getInstance()); }

    @Test
    void findAll() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        List<Disco> list = discoJdbc.findAll();
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
        Disco disco = new Disco();
        boolean res = false;
        DiscoJdbc discoJDBC = DiscoJdbcImpl.getInstance();
        disco.setTitulo("UwU");
        disco.setPrecio(24.75F);
        disco.setExistencia(490);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("2020-10-24").toLocalDate());
        disco.setImagen("XD");
        disco.setArtista_id(1);
        disco.setDisquera_id(1);
        disco.setGenero_id(1);
        res = discoJDBC.savetest(disco);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Disco disco = new Disco();
        boolean res = false;
        DiscoJdbc discoJDBC = DiscoJdbcImpl.getInstance();
        disco.setTitulo("Goku");
        disco.setPrecio(53.24F);
        disco.setExistencia(90);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("2020-10-24").toLocalDate());
        disco.setImagen("squerlter");
        disco.setArtista_id(1);
        disco.setDisquera_id(1);
        disco.setGenero_id(1);
        disco.setId(1);
        res = discoJDBC.updatetest(disco);
        assertEquals(true, res);
    }

}