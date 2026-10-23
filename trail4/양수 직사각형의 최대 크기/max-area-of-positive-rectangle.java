import java.util.Scanner;
public class Main {
    // 직사각형을 만들건데 -> 안이 양수여야 하고, 만들 수 있는 가장 최대 크기
    // 직사각형을 만든다 -> r1,c1 ~ r2,c2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int answerCount = -1;

        for(int r1 = 0; r1<n; r1++){
            for(int r2 = r1; r2<n; r2++){
                for(int c1 = 0; c1<m; c1++){
                    for(int c2 = c1; c2<m; c2++){
                        boolean val = true;

                        check:
                        for(int r = r1; r<=r2; r++){
                            for(int c= c1; c<=c2; c++){
                                if(grid[r][c]<=0) {
                                    val = false;
                                    break check;
                                }
                            }
                        }

                        if(val){
                            int count = (r2-r1+1)*(c2-c1+1);
                            answerCount = Math.max(answerCount, count);
                        }
                    }
                }
            }
        }

        System.out.print(answerCount);
    }
}