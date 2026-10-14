import java.util.Scanner;
public class Main {
    public static void plusNumber(int n){
        if(n==0) {
            return;
        }
        plusNumber(n-1);
        System.out.print(n+" ");

    }
    public static void minusNumber(int n){
        if(n==0) {
            return;
        }
        System.out.print(n+" ");
        minusNumber(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        plusNumber(n);
        System.out.println();

        minusNumber(n);
        System.out.println();

    }
}