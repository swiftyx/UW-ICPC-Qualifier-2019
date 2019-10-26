import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class bNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Character> pattern = new ArrayList<>();

        for (int i = 0; i<n;i++){
            pattern.add('x');
        }

        int count = 1;

        while (count < 2000000 && pattern.size() > 1){
            char first = pattern.remove(0);
            pattern.remove(0);
            if (first == 'x'){
                pattern.add('y');
                pattern.add('z');
            }else if (first == 'y'){
                pattern.add('x');
            }else{
                pattern.add('x');
                pattern.add('x');
                pattern.add('x');
            }
            count++;
        }

        if (count == 2000000){
            System.out.println("NOT HAUNTING");
        }else{
            System.out.println(count);
        }

    }

    public static void print(ArrayList<Character> pattern){
        for (int i = 0; i<pattern.size();i++){
            System.out.print(pattern.get(i));
        }
        System.out.println();
    }



}
