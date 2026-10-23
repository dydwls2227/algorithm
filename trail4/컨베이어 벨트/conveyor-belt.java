import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];

        for (int i = 0; i < n; i++) {
                top[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
                bottom[i] = sc.nextInt();
        }

        for(int time=0; time<t; time++){
            int tempEnd = top[n-1];
            int tempStart = bottom[n-1];

            for(int k=n-1; k>0; k--){
                top[k] = top[k-1];
            }
            top[0] = tempStart;

            for(int k=n-1; k>0; k--){
                bottom[k] = bottom[k-1];
            }
            bottom[0] = tempEnd;
        }
        
        for(int i=0; i<n; i++){
            sb.append(top[i]).append(" ");
        }
    
        sb.append("\n");

        for(int i=0; i<n; i++){
            sb.append(bottom[i]).append(" ");
        }

        System.out.print(sb);
    }
}