import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Datos con nombres para mejor comprension
        Scanner sc = new Scanner(System.in);
        String[] producto = {"Manzanas", "Auriculares", "Pan", "Tablet"};
        double[] precio = {10.5, 20.0, 5.75, 100.0};
        int[] cantidad = {2, 1, 5, 1};
        int tipo = 0;

        double total = 0;
        System.out.println("Dime el tipo de producto que es [1]Alimentos [2]Electronica");
        tipo = sc.nextInt();
        
        System.out.println("\n--- FACTURA ---");
        for (int i = 0; i < precio.length; i++) {
            double subtotal = precio[i] * cantidad[i];
            double impuesto = (tipo == 1) ? subtotal * 0.04 : subtotal * 0.21;
            double totalItem = subtotal + impuesto;
            
            // Descuento si compra mas de 3
            if (cantidad[i] > 3) {
                totalItem = totalItem * 0.9; // 10% descuento
                System.out.printf("%s: %.2f (con descuento incluido)%n", producto[i], totalItem);
            } else {
                System.out.printf("%s: %.2f%n", producto[i], totalItem);
            }
            
            total += totalItem;
        }

        System.out.printf("TOTAL: %.2f€%n", total);
        
        // Confirmacion simple
        
        System.out.print("Confirmar? (s/n): ");
        if (sc.nextLine().equals("s")) {
            System.out.println("Guardado");
        }
        sc.close();
    }
}
