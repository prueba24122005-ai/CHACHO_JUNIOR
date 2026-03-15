import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2};

        double totalFinal = procesarPedido(precios, cantidades, tipos);
        System.out.println("TOTAL FINAL: " + totalFinal);

        gestionarConfirmacion();
    }

    public static double procesarPedido(double[] precios, int[] cantidades, int[] tipos) {
        double totalFinal = 0;
        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double impuesto = calcularIVA(subtotal, tipos[i]);
            double resultadoItem = aplicarDescuento(subtotal + impuesto, cantidades[i]);
            
            System.out.println("Item " + i + ": " + resultadoItem);
            totalFinal += resultadoItem;
        }
        return totalFinal;
    }

    public static double calcularIVA(double subtotal, int tipo) {
        if (tipo == 1) return subtotal * 0.04;
        if (tipo == 2) return subtotal * 0.21;
        return 0;
    }

    public static double aplicarDescuento(double totalItem, int cantidad) {
        return (cantidad > 3) ? totalItem * 0.9 : totalItem;
    }

    public static void gestionarConfirmacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            System.out.println("Guardando...");
        }
    }
}
