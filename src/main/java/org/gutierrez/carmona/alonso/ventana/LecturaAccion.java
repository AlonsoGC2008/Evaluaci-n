package org.gutierrez.carmona.alonso.ventana;

import org.gutierrez.carmona.alonso.ejecutable.Ejecutable;
import org.gutierrez.carmona.alonso.util.ReadUtil;

// Estructura logica para opciones de los menus
public abstract class LecturaAccion implements Ejecutable
{
    // Campos para los procesos
    protected Integer opcion;
    protected boolean flag;

    // Constructor
    public LecturaAccion()
    {
        flag = true;
    }

    // Metodos de ejecucion para el programa
    public abstract void despliegaMenu();
    public abstract int valorMinMenu();
    public abstract int valorMaxMenu();
    public abstract void procesaOpcion();

    // Metodo de deteccion de errores (Menus)
    @Override
    public void run()
    {
        while (flag)
        {
            despliegaMenu();
            opcion = ReadUtil.readInt( );
            if (opcion >= valorMinMenu( ) && opcion <= valorMaxMenu( ) )
            {
                if( opcion == valorMaxMenu( ) )
                {
                    flag = false;
                }
                else
                {
                    procesaOpcion( );
                }
            }
        }
    }

    // Metodos de acceso a los campos
    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    public Integer getOpcion()
    {
        return opcion;
    }
    public void setOpcion(Integer opcion)
    {
        this.opcion = opcion;
    }
}
