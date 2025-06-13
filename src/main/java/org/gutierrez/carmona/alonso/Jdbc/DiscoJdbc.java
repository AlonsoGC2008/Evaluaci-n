package org.gutierrez.carmona.alonso.Jdbc;

import org.gutierrez.carmona.alonso.model.normal.Disco;
import org.gutierrez.carmona.alonso.model.normal.Artista;

import java.util.List;

public interface DiscoJdbc
{
    List<Disco>findAll();
    Disco findById(Integer id);
    boolean save(Disco disco);
    boolean update(Disco disco);
    boolean savetest(Disco disco);
    boolean updatetest(Disco disco);
    boolean delete(Disco disco);
}
