import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int k,n;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void choose(int count){
        if(count == n+1){
            for(int i=0; i<answer.size(); i++){
                sb.append(answer.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=k; i++){
            answer.add(i);
            choose(count+1);
            answer.remove(answer.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        choose(1);
        System.out.println(sb);
    }
}