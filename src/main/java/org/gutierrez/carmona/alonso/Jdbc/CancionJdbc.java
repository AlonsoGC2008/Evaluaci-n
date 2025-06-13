package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Cancion;

import java.util.List;

public interface CancionJdbc
{
    List<Cancion> findAll();
    Cancion findById(Integer id);
    boolean save(Cancion cancion);
    boolean update(Cancion cancion);
    boolean savetest(Cancion cancion);
    boolean updatetest(Cancion cancion);
    boolean delete(Cancion cancion);
}
