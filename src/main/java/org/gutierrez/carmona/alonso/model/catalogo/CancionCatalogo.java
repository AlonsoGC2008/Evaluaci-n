package org.gutierrez.carmona.alonso.model.catalogo;

import org.gutierrez.carmona.alonso.Jdbc.CancionJdbc;
import org.gutierrez.carmona.alonso.Jdbc.CancionJdbcImpl;
import org.gutierrez.carmona.alonso.Jdbc.DiscoJdbcImpl;
import org.gutierrez.carmona.alonso.consola.Catalogos;
import org.gutierrez.carmona.alonso.model.normal.Cancion;
import org.gutierrez.carmona.alonso.model.normal.Disco;
import org.gutierrez.carmona.alonso.util.ReadUtil;

import java.util.List;

public class CancionCatalogo extends Catalogos<Cancion>
{
    private static CancionCatalogo cancionCatalogo;
    private static CancionJdbc cancionJdbc;

    public static CancionCatalogo getInstance()
    {
        if(cancionCatalogo==null)
        {
            cancionCatalogo=new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.println("Teclee el nombre de la cancion");
        cancion.setTitulo(ReadUtil.read());
        System.out.println("Teclee la duracion de la cancion HH:mm:ss");
        cancion.setDuracion(ReadUtil.readTime());
        boolean flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del disco al que pertenece la cancion");
            int idDisco =ReadUtil.readInt();
            Disco disco= DiscoJdbcImpl.getInstance().findById(idDisco);
            if(disco!=null)
            {
                cancion.setDisco(disco);
                flag3=false;
            }
            else{
                System.out.println("Disco no encontrado");
            }
        }
        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("-------------------");
        System.out.println("Id de la cancion "+cancion.getId());
        System.out.println("Cancion a editar: " + cancion.getTitulo());
        System.out.println("Teclee el valor nuevo del titulo");
        cancion.setTitulo(ReadUtil.read());
        System.out.println("Teclee la nueva duracion");
        cancion.setDuracion(ReadUtil.readTime());
        System.out.println("Teclee el nuevo disco al que pertenece");
        boolean flag3=true;
        while (flag3) {
            System.out.println("Escriba el id del nuevo disco al que pertenece la cancion");
            int idDisco =ReadUtil.readInt();
            Disco disco=DiscoJdbcImpl.getInstance().findById(idDisco);
            if (disco != null) {
                cancion.setDisco(disco);
                flag3=false;
            } else {
                System.out.println("Disco no encontrado");
            }
        }
    }

    @Override
    public List<Cancion> processList()
    {
        if(cancionJdbc==null)
        {
            if(!loadCancionJDBC())
            {
                System.out.println("Error al cargar CancionJDBC");
            }
        }
        return cancionJdbc.findAll();
    }

    private boolean loadCancionJDBC()
    {
        cancionJdbc= CancionJdbcImpl.getInstance();
        return cancionJdbc!=null;
    }
}
