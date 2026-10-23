import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }


        for(int time=0; time<t; time++){
            int firstEnd = l[n-1];
            int secondEnd = r[n-1];
            int lastEnd = d[n-1];

            for(int j=n-1; j>0; j--){
                l[j] = l[j-1];
            }
            l[0] = lastEnd;

            for(int j=n-1; j>0; j--){
                r[j] = r[j-1];
            }
            r[0] = firstEnd;

            for(int j=n-1; j>0; j--){
                d[j] = d[j-1];
            }
            d[0] = secondEnd;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            sb.append(l[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0; i<n; i++){
            sb.append(r[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0; i<n; i++){
            sb.append(d[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}