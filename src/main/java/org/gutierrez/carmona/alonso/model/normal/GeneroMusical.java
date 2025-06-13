package org.gutierrez.carmona.alonso.model.normal;

import org.gutierrez.carmona.alonso.consola.Catalogo;

public class GeneroMusical extends Catalogo
{
    private String descripcion;

    public GeneroMusical() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero_musical{" +
                "descripcion='" + descripcion + '\'' +
                ", id=" + id +
                '}';
    }
}
