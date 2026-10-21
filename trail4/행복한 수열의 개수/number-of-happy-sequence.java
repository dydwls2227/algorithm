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
        
        
        int realCount = 0;

        for(int i=0; i<n; i++){
            int count = 1;
            int standard = grid[i][0];

            if(m==1){
                realCount++;
                continue;
            }

            for(int j=1; j<n; j++){
                int next = grid[i][j];

                if(standard==next){
                    count++;
                }else{
                    standard = next;
                    count=1;
                }

                if(count == m){
                    realCount++;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++){
            int count = 1;
            int standard = grid[0][i];
            if(m==1){
                realCount++;
                continue;
            }
            for(int j=1; j<n; j++){
                int next = grid[j][i];

                if(standard==next){
                    count++;
                }else{
                    standard = next;
                    count=1;
                }

                if(count == m){
                    realCount++;
                    break;
                }
            }
        }

        System.out.print(realCount);
    }
}