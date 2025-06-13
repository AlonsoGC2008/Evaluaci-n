package org.gutierrez.carmona.alonso.model.catalogo;

import org.gutierrez.carmona.alonso.Jdbc.GeneroMusicalJdbc;
import org.gutierrez.carmona.alonso.Jdbc.GeneroMusicalJdbcImpl;
import org.gutierrez.carmona.alonso.consola.Catalogos;
import org.gutierrez.carmona.alonso.model.normal.GeneroMusical;
import org.gutierrez.carmona.alonso.util.ReadUtil;

import java.util.List;

    public class GeneroMusicalCatalogo extends Catalogos<GeneroMusical>
    {
        private static GeneroMusicalCatalogo generoMusicalCatalogo;
        private static GeneroMusicalJdbc generoMusicalJdbc;

        public static GeneroMusicalCatalogo getInstance()
        {
            if(generoMusicalCatalogo ==null)
            {
                generoMusicalCatalogo = new GeneroMusicalCatalogo();
            }
            return generoMusicalCatalogo;
        }

        @Override
        public GeneroMusical newT() {
            return new GeneroMusical();
        }

        @Override
        public boolean processNewT(GeneroMusical genero) {
            System.out.println("Teclee un genero");
            genero.setDescripcion(ReadUtil.read());
            return true;
        }

        @Override
        public void processEditT(GeneroMusical genero)
        {
            System.out.println("-------------------");
            System.out.println("Id del genero "+genero.getId());
            System.out.println("Genero a editar: " + genero.getDescripcion());
            System.out.println("Teclee el valor nuevo del genero");
            System.out.println("-------------------");
            genero.setDescripcion(ReadUtil.read());
        }

        @Override
        public List<GeneroMusical> processList()
        {
            if(generoMusicalJdbc ==null)
            {
                if(!loadGeneroJDBC())
                {
                    System.out.println("Error al cargar GeneroJDBC");
                }
            }
            return generoMusicalJdbc.findAll();
        }

        private boolean loadGeneroJDBC()
        {
            generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
            return generoMusicalJdbc !=null;
        }
    }
