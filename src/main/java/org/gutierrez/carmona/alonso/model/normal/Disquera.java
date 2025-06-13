package org.gutierrez.carmona.alonso.model.normal;

import org.gutierrez.carmona.alonso.consola.Catalogo;

public class Disquera extends Catalogo
{
    private String nombre;

    public Disquera() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Disquera{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
