package org.example.Ejercicio4;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;

public class Main4 {

    public static void main(String[] args) {
        try {
            Persona persona = new Persona("Juan");
            System.out.println(persona);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Producto producto = Producto.builder()
                .nombre("Ordenador Portátil")
                .precio(799.99)
                .build();
        System.out.println(producto);

        Pedido pedido = new Pedido("Pedido001", 5, 99.99);
        System.out.println(pedido);
    }
}

@Data
class Persona {
    @NonNull
    private String nombre;

    private int edad;
}


@Builder
class Producto {
    private String nombre;
    private double precio;
}


@Value
class Pedido {
    private String idPedido;
    private int cantidad;
    private double precioTotal;
}

