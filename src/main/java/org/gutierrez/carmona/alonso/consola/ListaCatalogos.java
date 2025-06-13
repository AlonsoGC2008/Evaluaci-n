package org.gutierrez.carmona.alonso.consola;

import org.gutierrez.carmona.alonso.ejecutable.Ejecutable;
import org.gutierrez.carmona.alonso.model.catalogo.*;
import org.gutierrez.carmona.alonso.model.normal.GeneroMusical;
import org.gutierrez.carmona.alonso.ventana.LecturaAccion;

public class ListaCatalogos extends LecturaAccion
{
    public static ListaCatalogos listaCatalogos;
    public int tipo;
    public ListaCatalogos() {
    }

    public static ListaCatalogos getInstance()
    {
        if(listaCatalogos==null)
        {
            listaCatalogos=new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("___________________________________________");
        System.out.println("Seleccione una opcion");
        System.out.println("1.-Artista ");
        System.out.println("2.-Disquera");
        System.out.println("3.-Genero Musical");
        System.out.println("4.-Disco");
        System.out.println("5.-Cancion");
        System.out.println("6.-Salir");
        System.out.println("___________________________________________");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 6;
    }

    @Override
    public void procesaOpcion()
    {
        Ejecutable ejecutable=null;
        switch (opcion)
        {
            case 1:
                ejecutable= ArtistaCatalogo.getInstance();
                break;
            case 2:
                ejecutable= DisqueraCatalogo.getInstance();
                break;
            case 3:
                ejecutable= GeneroMusicalCatalogo.getInstance();
                break;
            case 4:
                ejecutable= DiscoCatalogo.getInstance();
                break;
            case 5:
                ejecutable= CancionCatalogo.getInstance();
                break;
        }
        tipo=opcion;
        ejecutable.setFlag(true);
        ejecutable.run();
    }
}
