import java.util.Scanner;

public class Main {
    
    private static final int TIPO_ALIMENTO = 1;
    private static final int TIPO_ELECTRONICA = 2;

    public static void main(String[] args) {
        // Refactorización de nombres: p -> precios, c -> cantidades, t -> tipos
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {TIPO_ALIMENTO, TIPO_ELECTRONICA, TIPO_ALIMENTO, TIPO_ELECTRONICA};

        double totalFinal = calcularTotalPedido(precios, cantidades, tipos);
        
        System.out.println("TOTAL FINAL: " + totalFinal);
        
        confirmarPedido();
    }


    public static double calcularTotalPedido(double[] precios, int[] cantidades, int[] tipos) {
        double totalFinal = 0; // tt -> totalFinal

        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            
            // Modularización: Extracción de cálculo de IVA
            double impuesto = calcularIVA(subtotal, tipos[i]);
            double subtotalConIva = subtotal + impuesto;
            
            // Modularización: Extracción de cálculo de descuento
            double precioFinalItem = calcularDescuento(subtotalConIva, cantidades[i]);

            System.out.println("Item " + i + ": " + precioFinalItem);
            totalFinal += precioFinalItem;
        }
        
        return totalFinal;
    }

    public static double calcularIVA(double subtotal, int tipoProducto) {
        if (tipoProducto == TIPO_ALIMENTO) {
            return subtotal * 0.04; // IVA Superreducido
        } else if (tipoProducto == TIPO_ELECTRONICA) {
            return subtotal * 0.21; // IVA General
        }
        return 0; // Sin impuesto si no coincide el tipo
    }

    public static double calcularDescuento(double precioConIva, int cantidad) {
        if (cantidad > 3) {
            return precioConIva - (precioConIva * 0.1);
        }
        return precioConIva;
    }


    public static void confirmarPedido() {
        // Limpieza: El Scanner se gestiona aquí de forma independiente
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("¿Confirmar pedido? (s/n)");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("s")) {
                System.out.println("Guardando...");
            }
        }
    }
}
