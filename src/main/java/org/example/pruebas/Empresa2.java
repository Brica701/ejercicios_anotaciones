package org.example.pruebas;

import org.example.anotaciones.Directivo;
import org.example.anotaciones.Oficial;
import org.example.anotaciones.Tecnico;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Empresa2 {
    private List<String> empleados;

    // Constructor
    public Empresa2() {
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

    public static Empresa2 cargadorDeContexto() {
        Empresa2 empresa = new Empresa2();
        try {
            Method[] methods = Empresa2.class.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Directivo.class)) {
                    Directivo directivo = method.getAnnotation(Directivo.class);
                    String infoDirectivo = "Directivo: " + directivo.nombre() +
                            ", Apellidos: " + directivo.apellidos() +
                            ", DNI: " + directivo.dni() +
                            ", Dirección: " + directivo.direccion() +
                            ", Teléfono: " + directivo.telefono() +
                            ", Código Despacho: " + directivo.codigoDespacho();
                    empresa.addEmpleado(infoDirectivo);
                }
                if (method.isAnnotationPresent(Tecnico.class)) {
                    Tecnico tecnico = method.getAnnotation(Tecnico.class);
                    String infoTecnico = "Técnico: " + tecnico.nombre() +
                            ", Apellidos: " + tecnico.apellidos() +
                            ", DNI: " + tecnico.dni() +
                            ", Dirección: " + tecnico.direccion() +
                            ", Teléfono: " + tecnico.telefono();
                    empresa.addEmpleado(infoTecnico);
                }
                if (method.isAnnotationPresent(Oficial.class)) {
                    Oficial oficial = method.getAnnotation(Oficial.class);
                    String infoOficial = "Oficial: " + oficial.nombre() +
                            ", Apellidos: " + oficial.apellidos() +
                            ", DNI: " + oficial.dni() +
                            ", Dirección: " + oficial.direccion() +
                            ", Teléfono: " + oficial.telefono();
                    empresa.addEmpleado(infoOficial);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empresa;
    }

    @Directivo(
            nombre = "Amancio",
            apellidos = "Ortega",
            dni = "66554433F",
            direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
            telefono = "981185596",
            codigoDespacho = "1"
    )
    public void directivo() {}

    @Tecnico(
            nombre = "Carlos",
            apellidos = "Fernandez",
            dni = "33445566T",
            direccion = "Calle Tecnológico 123, Madrid",
            telefono = "911234567"
    )
    public void tecnico() {}

    @Oficial(
            nombre = "Lucía",
            apellidos = "González",
            dni = "77665544S",
            direccion = "Calle Industrial 456, Barcelona",
            telefono = "931234567"
    )
    public void oficial() {}
}

