/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Chacho;

import java.util.Scanner;

/**
 *
 * @author WEB1-19
 */
public class Sergio_Parte {

    public static void main(String[] args) {
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2};

        double totalFinal = calcularTotal(precios, cantidades, tipos);

        System.out.println("TOTAL FINAL: " + totalFinal);

        confirmarPedido();

    }

    public static double calcularTotal(double[] precios, int[] cantidades, int[] tipos) {
        double totalFinal = 0;

        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double impuesto = calcularIVA(subtotal, tipos[i]);
            double precioFinal = subtotal + impuesto;
            precioFinal = aplicarDescuento(precioFinal, cantidades[i]);

            System.out.println("Item " + i + ": " + precioFinal);
            totalFinal += precioFinal;
        }

        return totalFinal;
    }

    public static double calcularIVA(double subtotal, int tipoProducto) {
        if (tipoProducto == 1) {
            return subtotal * 0.04; // IVA Superreducido
        } else if (tipoProducto == 2) {
            return subtotal * 0.21; // IVA General
        }
        return 0;
    }
    public static double aplicarDescuento(double precio, int cantidad) {
        if (cantidad > 3) {
            return precio - (precio * 0.1);
        }
        return precio;
    }

    // Método que gestiona la confirmación del pedido (interfaz)
    public static void confirmarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Confirmar pedido? (s/n)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si")) {
            System.out.println("Guardando el pedido...");
        } else {
            System.out.println("OK. Mensaje recibido, no lo guardaré.");
        }
    }
}
