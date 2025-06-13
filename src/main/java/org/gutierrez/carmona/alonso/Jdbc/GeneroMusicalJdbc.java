package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.GeneroMusical;

import java.util.List;

public interface GeneroMusicalJdbc
{
    List<GeneroMusical> findAll();
    GeneroMusical findById(Integer id);
    boolean save(GeneroMusical generoMusical);
    boolean update(GeneroMusical generoMusical);
    boolean delete(GeneroMusical generoMusical);
}
