import java.util.Scanner;

public class Main {
    
    // 1. Usar constantes evita los "números mágicos" y hace el código más claro
    private static final int TIPO_ALIMENTO = 1;
    private static final int TIPO_ELECTRONICA = 2;
    private static final double IVA_SUPERREDUCIDO = 0.04;
    private static final double IVA_GENERAL = 0.21;
    private static final double DESCUENTO_CANTIDAD = 0.10;
    
    public static void main(String[] args) {
        
        // 2. Nombres de variables descriptivos (en lugar de p, c, t)
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {TIPO_ALIMENTO, TIPO_ELECTRONICA, TIPO_ALIMENTO, TIPO_ELECTRONICA};
        
        double totalFinal = 0;

        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double impuesto = 0;

            // Calcular impuesto según el tipo de producto
            if (tipos[i] == TIPO_ALIMENTO) {
                impuesto = subtotal * IVA_SUPERREDUCIDO; 
            } else if (tipos[i] == TIPO_ELECTRONICA) {
                impuesto = subtotal * IVA_GENERAL; 
            }

            double precioItem = subtotal + impuesto;
            
            // Aplicar descuento si la cantidad es mayor a 3
            if (cantidades[i] > 3) {
                precioItem -= (precioItem * DESCUENTO_CANTIDAD);
            }

            // Usar printf para dar formato a los decimales (2 decimales)
            System.out.printf("Item %d: %.2f€\n", (i + 1), precioItem);
            totalFinal += precioItem;
        }

        System.out.println("--------------------");
        System.out.printf("TOTAL FINAL: %.2f€\n", totalFinal);
        System.out.println("--------------------");
        
        // 3. Manejo seguro del Scanner usando try-with-resources
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("¿Confirmar pedido? (s/n)");
            String respuesta = sc.nextLine();
            
            // Usar equalsIgnoreCase para aceptar tanto 's' como 'S'
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Guardando pedido...");
            } else {
                System.out.println("Pedido cancelado.");
            }
        }
    }
}
