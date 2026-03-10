import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        double[] p = {10.5, 20.0, 5.75, 100.0};
        int[] c = {2, 1, 5, 1};
        int[] t = {1, 2, 1, 2}
        
        double tt = 0;

        for (int i = 0; i < p.length; i++) {
            double sub = p[i] * c[i];
            double imp = 0;

            if (t[i] == 1) {
                imp = sub * 0.04;
            } else if (t[i] == 2) {
                imp = sub * 0.21;
            }

            double res = sub + imp;
            
            if (c[i] > 3) {
                res = res - (res * 0.1);
            }

            System.out.println("Item " + i + ": " + res);
            tt += res;
        }

        System.out.println("TOTAL FINAL: " + tt);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String s = sc.nextLine();
        if (s.equals("s")) {
            System.out.println("Guardando...");
        }
    }
}
