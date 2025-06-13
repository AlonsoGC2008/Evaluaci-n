package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Disquera;
import org.gutierrez.carmona.alonso.model.normal.Artista;

import java.util.List;

public interface DisqueraJdbc
{
    List<Disquera> findAll();
    Disquera findById(Integer id);
    boolean save(Disquera disquera);
    boolean update(Disquera disquera);
    boolean delete(Disquera disquera);
}
