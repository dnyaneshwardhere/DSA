import java.util.Scanner;

public class NqueenWithMatrix {

    public static void solveNQueen(int k, int n, int[] x) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i, x)) {
                x[k] = i;
                if (k == n) {
                    printSolution(x);
                } else {
                    solveNQueen(k + 1, n, x);
                }
            }
        }
    }

    public static boolean place(int k, int i, int[] x) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(int[] x) {
        int n = x.length - 1;
        System.out.println("Solutions :");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Queens:");
        int n = sc.nextInt();

        int[] x = new int[n + 1]; // index 0 is not used
        solveNQueen(1, n, x);
        sc.close();
    }
}
