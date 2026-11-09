import java.util.Scanner;
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt();

        for(int i=0; i<q; i++){
            int r1 = queries[i][0]-1;
            int c1 = queries[i][1]-1;
            int r2 = queries[i][2]-1;
            int c2 = queries[i][3]-1;

            int temp1 = building[r1][c2];
            int temp2 = building[r2][c2];
            int temp3 = building[r2][c1];

            for(int c = c2; c>c1; c--){
                building[r1][c] = building[r1][c-1];
            }

            for(int r = r2; r>r1; r--){
                building[r][c2] = building[r-1][c2];
            }

            for(int c = c1; c<c2; c++){
                building[r2][c] = building[r2][c+1];
            }

            for(int r= r1; r<r2; r++){
                building[r][c1] = building[r+1][c1];
            }

            building[r1+1][c2] = temp1;
            building[r2][c2-1] = temp2;
            building[r2-1][c1] = temp3;

            int[][] copy = new int[n][m];
            for(int cp = 0; cp<n; cp++){
                copy[cp] = building[cp].clone();
            }

            for(int r=r1; r<=r2; r++){
                for(int c=c1; c<=c2; c++){
                    int sum = copy[r][c];
                    int cnt = 1;
                    for(int d=0; d<4; d++){
                        int nx = r+dx[d];
                        int ny = c+dy[d];
                        if(nx>=0 && ny>=0 && nx<n && ny<m){
                            sum += copy[nx][ny];
                            cnt++;
                        }
                    }
                    building[r][c] = (sum/cnt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(building[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        
    }
}