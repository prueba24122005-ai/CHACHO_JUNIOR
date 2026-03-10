import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2}
        
        double totalFinal = 0;

        for (int i = 0; i < precios.length; i++) {
            double sub = precios[i] * cantidades[i];
            double imp = 0;

            if (tipos[i] == 1) {
                imp = sub * 0.04; // IVA Superreducido
            } else if (tipos[i] == 2) {
                imp = sub * 0.21;// IVA General
            }
       
            double res = sub + imp;
            
            // Descuento si la cantidad es grande
            if (cantidades[i] > 3) {
                res = res - (res * 0.1);
            }

            System.out.println("Item " + i + ": " + res);
            tt += res;
        }

        System.out.println("TOTAL FINAL: " + tt);
       
        System.out.println("¿Confirmar pedido? (s/n)");
        String s = sc.nextLine();
        if (s.equals("s")) {
            System.out.println("Guardando...");
        }
    }

}
