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
}
