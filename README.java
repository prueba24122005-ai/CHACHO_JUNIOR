import java.util.Scanner;

/**
 * Clase principal para la gestión y cálculo de pedidos.
 * Implementa refactorización de nombres, modularización y separación de lógica.
 */
public class Main {
    public static void main(String[] args) {
        // Inicialización de datos de prueba
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2};

        // Ejecución de la lógica de negocio
        double totalFinal = procesarPedido(precios, cantidades, tipos);
        System.out.println("TOTAL FINAL: " + totalFinal);

        // Interfaz de usuario para confirmación
        gestionarConfirmacion();
    }

    /**
     * Coordina el cálculo de cada ítem y acumula el total.
     */
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

    /**
     * Calcula el impuesto (IVA) basado en el tipo de producto.
     * Tipo 1: Superreducido (4%), Tipo 2: General (21%)
     */
    public static double calcularIVA(double subtotal, int tipo) {
        if (tipo == 1) return subtotal * 0.04;
        if (tipo == 2) return subtotal * 0.21;
        return 0;
    }

    /**
     * Aplica un 10% de descuento si el volumen de compra es superior a 3 unidades.
     */
    public static double aplicarDescuento(double totalItem, int cantidad) {
        return (cantidad > 3) ? totalItem * 0.9 : totalItem;
    }

    /**
     * Gestiona la entrada del usuario para la confirmación del pedido.
     */
    public static void gestionarConfirmacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String respuesta = sc.nextLine();
        
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Guardando...");
        }
    }
}
