import java.util.*;

public class MF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt(); int j = in.nextInt();
        while (i != 0 && j != 0) {
            System.out.println(i / j + " " + i % j+  " / " + j);
             i = in.nextInt(); j = in.nextInt();
        }
    }
}
