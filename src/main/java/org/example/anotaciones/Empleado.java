package org.example.anotaciones;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Empleado {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    String telefono();
    String clase();  // Directivo, Técnico, Oficial
    String codigoDespacho() default "";  // Solo para directivos
}
