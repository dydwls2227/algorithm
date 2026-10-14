import java.util.Scanner;

public class Main {

    public static int nplus(int n){
        if(n==1){
            return 1;
        }

        return nplus(n-1)+n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = nplus(n);
        System.out.print(result);
    }
}