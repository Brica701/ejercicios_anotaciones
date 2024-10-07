package org.example.pruebas;

import org.example.anotaciones.Empleado;
import org.example.anotaciones.Empleados;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<String> empleados;

    // Constructor
    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public void addEmpleado(String empleado) {
        empleados.add(empleado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String empleado : empleados) {
            sb.append(empleado).append("\n");
        }
        return sb.toString();
    }

    public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa();
        try {
            Method[] methods = Empresa.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Empleados.class)) {
                    Empleado[] empleadosAnotados = method.getAnnotationsByType(Empleado.class);
                    for (Empleado empleado : empleadosAnotados) {
                        String infoEmpleado = "Nombre: " + empleado.nombre() +
                                ", Apellidos: " + empleado.apellidos() +
                                ", DNI: " + empleado.dni() +
                                ", Dirección: " + empleado.direccion() +
                                ", Teléfono: " + empleado.telefono() +
                                ", Clase: " + empleado.clase();
                        if (!empleado.codigoDespacho().isEmpty()) {
                            infoEmpleado += ", Código Despacho: " + empleado.codigoDespacho();
                        }
                        empresa.addEmpleado(infoEmpleado);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empresa;
    }

    @Empleado(
            nombre = "Amancio",
            apellidos = "Ortega",
            dni = "66554433F",
            direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
            telefono = "981185596",
            clase = "Directivo",
            codigoDespacho = "1"
    )
    public void directivo() {}

    @Empleado(
            nombre = "Carlos",
            apellidos = "Fernandez",
            dni = "33445566T",
            direccion = "Calle Tecnológico 123, Madrid",
            telefono = "911234567",
            clase = "Técnico"
    )
    public void tecnico() {}

    @Empleado(
            nombre = "Lucía",
            apellidos = "González",
            dni = "77665544S",
            direccion = "Calle Industrial 456, Barcelona",
            telefono = "931234567",
            clase = "Oficial"
    )
    public void oficial() {}
}
