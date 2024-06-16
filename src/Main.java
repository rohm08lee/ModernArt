import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("art.in"));
        PrintWriter pw = new PrintWriter("art.out");

        int n = sc.nextInt();
        int[][] canvas = new int[n][n];
        boolean[] color = new boolean[10];
        boolean[] exists = new boolean[10];
        for (int i = 0; i < n; i++) {
            String[] temp = sc.next().split("");
            for (int j = 0; j < n; j++) {
                canvas[i][j] = Integer.parseInt(temp[j]);
                if (canvas[i][j] > 0) {
                    color[canvas[i][j]] = true;
                    exists[canvas[i][j]] = true;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (exists[i]){
                int l = n, r = 0, u = 0, d = n;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (canvas[j][k] == i) {
                            l = Math.min(l, j);
                            r = Math.max(r, j);
                            d = Math.min(d, k);
                            u = Math.max(u, k);
                        }
                    }
                }
                for (int j = l; j <= r; j++) {
                    for (int k = d; k <= u; k++) {
                        if (canvas[j][k] != i) { color[canvas[j][k]] = false;}
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (color[i]) {
                count++;
            }
        }
        pw.println(count);
        pw.close();
    }
}