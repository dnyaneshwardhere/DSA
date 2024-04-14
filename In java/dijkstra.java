import java.util.*;

class dijkstra {
    public static void dijkstras_algo(int[] d, int[][] w, boolean[] visited, int n) {
        int u;
        for (int k = 0; k < n - 1; k++) {
            u = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (u == -1 || d[i] < d[u])) {
                    u = i;
                }
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && w[u][v] != 999) {
                    d[v] = Math.min(d[v], d[u] + w[u][v]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Cost of " + i + " is: " + d[i]);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();
        int[] d = new int[n];
        int[][] w = new int[n][n];
        boolean[] visited = new boolean[n];
        System.out.println("Enter the weight matrix where unreachable vertices are represented by 999:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }
        System.out.println("\n");
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        dijkstras_algo(d, w, visited, n);
        sc.close();
    }
}
