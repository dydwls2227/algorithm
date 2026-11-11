import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static int n;
    static int cnt=0;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static boolean isBeautiful(){
        for(int i=0; i<n; i+=answer.get(i)){
            int d = answer.get(i);

            if(i+d>n) return false;

            for(int j=i; j<i+d;j++){
                if(answer.get(j)!=d) return false;
            }
        }

        return true;
    }

    public static void choose(int count){
        if(count == n+1){
            if(isBeautiful()) cnt++;
            return;
        }

        for(int i= 1; i<=4; i++){
            answer.add(i);
            choose(count+1);
            answer.remove(answer.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choose(1);
        System.out.println(cnt);
    }
}