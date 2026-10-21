import java.util.Scanner;
public class Main {
    static int[] dx = {-1,1,0,0,-1,-1,1,1}; //상하좌우 좌상 우상 좌하 우하
    static int[] dy = {0,0,-1,1,-1,1,-1,1}; //상하좌우 좌상 우상 좌하 우하
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int maxCount = -1;

        for(int i=1; i<=n-2; i++){
            for(int j=1; j<=n-2;j++){
                int count = 0;

                if(grid[i][j]==1) count++;

                for(int k=0; k<8; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(grid[nx][ny]==1) count++;
                }

                if(count>maxCount) maxCount=count;
            }
        }

        System.out.print(maxCount);
    }
}