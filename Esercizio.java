import java.util.Scanner;
import java.util.Random;

public class Esercizio {
    private static Random r = new Random();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int m, n, a, i, j, grossezza, ora;
        
        do {
            System.out.println("Inserisci il numero di animali che arrivano al lago.");
            a = Integer.ParseInt(in.next());
        }
        while (a <= 0);
        int[] pescato = new int[a * 10];
        int[] orario = new int[a * 10];
        
        n = 0;
        m = 0;
        i = 0;
        while (i < a) {
            grossezza = (r.nextInt(11) + 1) * 50;
            ora = (i + 10) % 24;
            System.out.println("Sta arrivando un animale grosso " + grossezza + " cm");
            n = inserisciElemento(pescato, n, grossezza, n);
            m = inserisciElemento(orario, m, ora, m);
            j = 0;
            while (j < n) {
                if (grossezza > pescato[j]) {
                    n = eliminaElemento(pescato, n, j);
                    m = eliminaElemento(orario, m, j);
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
            visualizzaVettore(pescato, orario, n);
        }
        System.out.println("Ecco le tipologie di grossezze dei pesci pescati: ");
        n = rimuoviDuplicati(pescato, n);
        visualizzaVettore(pescato, orario, n);
        System.out.println("Il pesce più grosso è di grandezza " + pescato[ricercaMassimo(pescato, n)]);
        System.out.println("Programma terminato.");
    }
    
    public static int eliminaElemento(int[] v, int n, int ie) {
        int i, n2;
        
        n2 = n - 1;
        for (i = ie; i <= n - 2; i++) {
            v[i] = v[i + 1];
        }
        
        return n2;
    }
    
    public static int inserisciElemento(int[] v, int n, int e, int ie) {
        int i, n2;
        
        n2 = n + 1;
        i = n2 - 1;
        while (i >= ie + 1) {
            v[i] = v[i - 1];
            i = i - 1;
        }
        v[ie] = e;
        
        return n2;
    }
    
    public static int ricercaMassimo(int[] v, int n) {
        int imax, i;
        
        imax = 0;
        for (i = 0; i <= n - 1; i++) {
            if (v[imax] > v[i]) {
            } else {
                imax = i;
            }
        }
        
        return imax;
    }
    
    public static int rimuoviDuplicati(int[] v, int n) {
        int i, j;
        
        i = 0;
        while (i <= n - 2) {
            j = i + 1;
            while (j <= n - 1) {
                if (v[i] == v[j]) {
                    System.out.println("Elimino " + v[j] + " da cella: " + j);
                    n = eliminaElemento(v, n, j);
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        
        return n;
    }
    
    public static void visualizzaVettore(int[] v, int[] w, int n) {
        int i;
        
        if (n == 0) {
            System.out.println("Vuoto.");
        } else {
            for (i = 0; i <= n - 1; i++) {
                System.out.println("Pesce numero " + i + ": " + v[i] + " | Orario di cattura: " + w[i]);
            }
        }
    }
}
