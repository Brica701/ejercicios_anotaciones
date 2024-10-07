package org.example.pruebas;

public class Main3 {
    public static void main(String[] args) {
        // Cargar las tareas de la agenda
        AgendaSemana agenda = AgendaSemana.cargarTareas();

        // Imprimir las tareas
        System.out.println(agenda);
    }
}
