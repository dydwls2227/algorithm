import java.util.Scanner;
public class Main {
    public static int onemore(int n, int count){
        if(n==1) return count;
        if(n%2==0){
            count++;
            return onemore(n/2,count);
        }else if(n%2!=0){
            count++;
            return onemore(n/3,count);
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(onemore(n,0));
    }
}