package org.example.pruebas;

import org.example.anotaciones.Tarea;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AgendaSemana {
    private List<String> tareas;

    // Constructor
    public AgendaSemana() {
        this.tareas = new ArrayList<>();
    }

    // Método para agregar tareas a la lista
    public void addTarea(String tarea) {
        tareas.add(tarea);
    }

    // Método para cargar las tareas usando Reflection
    public static AgendaSemana cargarTareas() {
        AgendaSemana agenda = new AgendaSemana();
        try {
            // Obtener todos los métodos de la clase AgendaSemana
            Method[] methods = AgendaSemana.class.getDeclaredMethods();
            for (Method method : methods) {
                // Verificar si el método tiene la anotación @Tarea
                if (method.isAnnotationPresent(Tarea.class)) {
                    Tarea tarea = method.getAnnotation(Tarea.class);
                    String infoTarea = "Tarea: " + tarea.titulo() +
                            ", Descripción: " + tarea.descripcion() +
                            ", Día: " + tarea.dia() +
                            ", Hora: " + tarea.hora();
                    agenda.addTarea(infoTarea);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agenda;
    }

    // Método para imprimir las tareas
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String tarea : tareas) {
            sb.append(tarea).append("\n");
        }
        return sb.toString();
    }

    // Anotaciones repetidas para agregar tareas
    @Tarea(
            titulo = "Reunión de equipo",
            descripcion = "Reunión con el equipo para revisar el estado de los proyectos.",
            dia = "Lunes",
            hora = "10:00 AM"
    )
    public void tareaLunes() {}

    @Tarea(
            titulo = "Presentación cliente",
            descripcion = "Presentación del proyecto al cliente.",
            dia = "Miércoles",
            hora = "3:00 PM"
    )
    public void tareaMiercoles() {}

    @Tarea(
            titulo = "Revisión de código",
            descripcion = "Revisión de código del equipo de desarrollo.",
            dia = "Viernes",
            hora = "1:00 PM"
    )
    public void tareaViernes() {}
}

