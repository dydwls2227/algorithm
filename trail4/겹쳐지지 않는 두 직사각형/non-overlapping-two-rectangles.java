import java.util.Scanner;

public class Main {
    // 겹치지 않는다 -> 같은 칸을 점유하면 안 된다.
    // 직사각형 (r1,c1)~(r2,c2) -> 좌상, 우하
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxValue = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < n; r1++) {
            for (int r2 = r1; r2 < n; r2++) { 
                for (int c1 = 0; c1 < m; c1++) {
                    for (int c2 = c1; c2 < m; c2++) {  

                        int[][] grid2 = new int[n][m];
                        int sum1 = 0;
                        for (int r = r1; r <= r2; r++) {
                            for (int c = c1; c <= c2; c++) {
                                grid2[r][c] = 1;
                                sum1 += grid[r][c];
                            }
                        }

                        for (int r3 = 0; r3 < n; r3++) {
                            for (int r4 = r3; r4 < n; r4++) {
                                for (int c3 = 0; c3 < m; c3++) {
                                    for (int c4 = c3; c4 < m; c4++) {

                                        // 두 번째 직사각형: 겹침 확인 + 합 구하기
                                        boolean overlap = false;
                                        int sum2 = 0;
                                        check:
                                        for (int rr = r3; rr <= r4; rr++) {
                                            for (int cc = c3; cc <= c4; cc++) {
                                                if (grid2[rr][cc] == 1) {
                                                    overlap = true;
                                                    break check;
                                                }
                                                sum2 += grid[rr][cc];
                                            }
                                        }

                                        if (!overlap) {
                                            maxValue = Math.max(maxValue, sum1 + sum2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(maxValue);
    }
}