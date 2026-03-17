import java.util.Scanner;

public class Main {

    public static double calcularIVA(double subtotal, int tipo) {
        if (tipo == 1) {
            return subtotal * 0.04;
        } else if (tipo == 2) {
            return subtotal * 0.21;
        }
        return 0;
    }

    public static double aplicarDescuento(double total, int cantidad) {
        if (cantidad > 3) {
            return total - (total * 0.1);
        }
        return total;
    }

    public static void confirmarPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String s = sc.nextLine();

        if (s.equals("s")) {
            System.out.println("Guardando...");
        }
    }

    public static void main(String[] args) {

        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2};

        double totalFinal = 0;

        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];

            double iva = calcularIVA(subtotal, tipos[i]);

            double total = subtotal + iva;

            total = aplicarDescuento(total, cantidades[i]);

            System.out.println("Item " + i + ": " + total);

            totalFinal += total;
        }

        System.out.println("TOTAL FINAL: " + totalFinal);

        confirmarPedido();
    }
}

/*
CAMBIOS REALIZADOS:

1. Refactorización de nombres:
- p → precios
- c → cantidades
- t → tipos
- tt → totalFinal

2. Modularización:
- Se creó el método calcularIVA() para separar el cálculo del impuesto
- Se creó el método aplicarDescuento() para gestionar descuentos

3. Separación de responsabilidades:
- Se creó el método confirmarPedido() para aislar la interacción con el usuario (Scanner)
- El método main ahora solo gestiona el flujo principal del programa

4. Mejora de legibilidad:
- Variables más claras (subtotal, iva, total)
- Código más organizado y reutilizable
*/
