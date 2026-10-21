import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n && j + 1 < m) {
                    int a = grid[i][j], b = grid[i][j + 1];
                    int c = grid[i + 1][j], d = grid[i + 1][j + 1];
                    int sum = a + b + c + d;
                    int min = Math.min(Math.min(a, b), Math.min(c, d));
                    max = Math.max(max, sum - min);
                }
                if (j + 2 < m) {
                    max = Math.max(max, grid[i][j] + grid[i][j + 1] + grid[i][j + 2]);
                }
                if (i + 2 < n) {
                    max = Math.max(max, grid[i][j] + grid[i + 1][j] + grid[i + 2][j]);
                }
            }
        }

        System.out.print(max);
    }
}