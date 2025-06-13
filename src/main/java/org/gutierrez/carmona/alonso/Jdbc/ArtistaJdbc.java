package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Artista;

import java.util.List;

public interface ArtistaJdbc
{
    List<Artista> findAll();
    Artista findById(Integer id);
    boolean save(Artista artista);
    boolean update(Artista artista);
    boolean delete(Artista artista);
}
