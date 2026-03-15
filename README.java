import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2};

        double totalFinal = 0;
        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double impuesto = calcularIVA(subtotal, tipos[i]);
            double resultadoItem = subtotal + impuesto;

            resultadoItem = aplicarDescuento(resultadoItem, cantidades[i]);
            
            System.out.println("Item " + i + ": " + resultadoItem);
            totalFinal += resultadoItem;
        }
        System.out.println("TOTAL FINAL: " + totalFinal);

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equals("s")) {
            System.out.println("Guardando...");
        }
    }

    public static double calcularIVA(double subtotal, int tipo) {
        if (tipo == 1) {
            return subtotal * 0.04;
        } else if (tipo == 2) {
            return subtotal * 0.21;
        }
        return 0;
    }

    public static double aplicarDescuento(double totalItem, int cantidad) {
        if (cantidad > 3) {
            return totalItem * 0.9;
        }
        return totalItem;
    }
}
