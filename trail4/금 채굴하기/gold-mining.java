import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int bestScore = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) {
                    int score = 0;

                    // 중심에서 위아래로 d만큼 떨어진 행
                    for (int d = -k; d <= k; d++) {
                        int x = i + d;
                        if (x < 0 || x >= n) continue;
                        int w = k - Math.abs(d);        // 이 행의 반폭
                        for (int y = j - w; y <= j + w; y++) {
                            if (y < 0 || y >= n) continue;
                            score += grid[x][y];
                        }
                    }

                    int cost = k * k + (k + 1) * (k + 1);
                    if (m * score >= cost) {
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
        }

        System.out.print(bestScore);
    }
}