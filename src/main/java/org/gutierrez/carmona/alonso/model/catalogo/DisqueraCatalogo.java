package org.gutierrez.carmona.alonso.model.catalogo;

import org.gutierrez.carmona.alonso.Jdbc.DisqueraJdbc;
import org.gutierrez.carmona.alonso.Jdbc.DisqueraJdbcImpl;
import org.gutierrez.carmona.alonso.consola.Catalogos;
import org.gutierrez.carmona.alonso.model.normal.Disquera;
import org.gutierrez.carmona.alonso.util.ReadUtil;

import java.util.List;

public class DisqueraCatalogo extends Catalogos<Disquera>
{
    private static DisqueraCatalogo disqueraCatalogo;
    private static DisqueraJdbc disqueraJdbc;

    public DisqueraCatalogo() {
        super();
    }

    public static DisqueraCatalogo getInstance(){
        if (disqueraCatalogo==null){
            disqueraCatalogo=new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT() {
        return new Disquera();
    }

    @Override
    public boolean processNewT(Disquera disquera) {
        System.out.println("Teclee una disquera");
        disquera.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Disquera disquera)
    {
        System.out.println("-------------------");
        System.out.println("Id de la disquera "+disquera.getId());
        System.out.println("Disquera a editar: " + disquera.getNombre());
        System.out.println("Teclee el valor nuevo de la disquera");
        System.out.println("-------------------");
        disquera.setNombre(ReadUtil.read());
    }

    @Override
    public List<Disquera> processList()
    {
        if(disqueraJdbc ==null)
        {
            if(!loadDisqueraJDBC())
            {
                System.out.println("Error al cargar DisqueraJDBC");
            }
        }
        return disqueraJdbc.findAll();
    }

    private boolean loadDisqueraJDBC()
    {
        disqueraJdbc = DisqueraJdbcImpl.getInstance();
        return disqueraJdbc !=null;
    }
}
