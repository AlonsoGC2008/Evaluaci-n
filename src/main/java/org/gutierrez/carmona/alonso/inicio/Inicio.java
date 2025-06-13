package org.gutierrez.carmona.alonso.inicio;

import org.gutierrez.carmona.alonso.consola.Consola;

// Clase Inicial
public class Inicio
{
    // Primer ejecucion (Menu - 1)
    public static void main(String[] args)
    {
        // Titulo
        System.out.println("=== Bienvenido al catalogo de discos ===");
        // Ejecución del programa mediante un instancia
        Consola.getInstance().run();
        // Mensajes de despedida (Finalización)
        System.out.println("Cerrando programa ...");
        System.out.println("=== Programa Finalizado ===");
    }
}