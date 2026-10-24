import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt()-1;
            char d = sc.next().charAt(0);

            char newUpD;
            char newDownD;

            // r행 바람 불기
            if(d=='L'){
                int temp = grid[r][m-1];
                for(int j=m-1; j>0; j--){
                    grid[r][j] = grid[r][j-1];
                }
                grid[r][0] = temp;
                newUpD='R';
                newDownD='R';
            }else{
                int temp = grid[r][0];
                for(int j=0; j<m-1; j++){ 
                    grid[r][j] = grid[r][j+1];
                }
                grid[r][m-1] = temp;
                newUpD='L';
                newDownD='L';
            }

            //위 체크
            int newUpR = r;
            boolean checkUp = true;
            while(checkUp){
                if(newUpR==0) {
                    break;
                }

            
                boolean same = false;
                for(int j=0; j<m; j++){
                    if(grid[newUpR][j]==grid[newUpR-1][j]){
                        same = true;
                        break;
                    }
                }

                if(same){
                    if(newUpD=='L'){
                        int temp = grid[newUpR-1][m-1];
                        for(int k=m-1; k>0; k--){
                            grid[newUpR-1][k] = grid[newUpR-1][k-1];
                        }
                        grid[newUpR-1][0] = temp;
                        newUpD='R';
                    }else{
                        int temp = grid[newUpR-1][0];
                        for(int k=0; k<m-1; k++){
                            grid[newUpR-1][k] = grid[newUpR-1][k+1];
                        }
                        grid[newUpR-1][m-1] = temp;
                        newUpD='L';
                    }
                    newUpR = newUpR-1;
                }else{
                    checkUp = false;
                }
            }

            //아래 체크
            int newDownR = r;
            boolean checkDown = true;
            while(checkDown){
              
                if(newDownR==n-1) break;

                boolean same = false;
                for(int j=0; j<m; j++){
                    if(grid[newDownR][j]==grid[newDownR+1][j]){
                        same = true;
                        break;
                    }
                }

                if(same){
                    if(newDownD=='L'){
                        int temp = grid[newDownR+1][m-1];
                        for(int k=m-1; k>0; k--){
                            grid[newDownR+1][k] = grid[newDownR+1][k-1];
                        }
                        grid[newDownR+1][0] = temp;
                        newDownD='R';
                    }else{
                        int temp = grid[newDownR+1][0];  
                        for(int k=0; k<m-1; k++){
                            grid[newDownR+1][k] = grid[newDownR+1][k+1];
                        }
                        grid[newDownR+1][m-1] = temp;
                        newDownD='L';
                    }
                    newDownR = newDownR+1;
                }else{
                    checkDown = false;
                }
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
    }
}