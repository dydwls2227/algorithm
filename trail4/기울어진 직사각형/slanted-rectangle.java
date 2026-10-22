import java.util.Scanner;

// 중심 지점에서 우상이 있는지 확인 있으면 거기서 반시계 체크 갱신
// 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};

        int maxValue = -1;

        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
    
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int a=1; a<n; a++){
                    for(int b=1; b<n; b++){
                        int[] len = {a,b,a,b};
                        int x = i;
                        int y = j;
                        int sum = 0;
                        boolean valid = true;

                        for(int d = 0; d<4; d++){
                            for(int t=0; t<len[d]; t++){
                                x += dx[d];
                                y += dy[d];

                                if(x<0 || y<0 || x>=n || y>=n){
                                    valid = false;
                                    break;
                                }

                                sum += grid[x][y];
                            }
                        }

                        if(valid){
                            maxValue = Math.max(maxValue, sum);
                        }
                    }
                }
            }
        }

        System.out.print(maxValue);
    }
}