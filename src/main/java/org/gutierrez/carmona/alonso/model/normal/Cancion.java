package org.gutierrez.carmona.alonso.model.normal;

import org.gutierrez.carmona.alonso.consola.Catalogo;

import java.sql.Time;

public class Cancion extends Catalogo
{
    private String titulo;
    private Time duracion;
    private Disco disco;
    private Integer disco_id;

    public Cancion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Integer getDisco_id() { return disco_id; }

    public void setDisco_id(Integer disco_id) { this.disco_id = disco_id; }

    @Override
    public String toString() {
        return "ID de la cancion " + id +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", id del disco=" + disco_id;
    }
}

