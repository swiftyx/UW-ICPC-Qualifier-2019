import java.util.*;
public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = m(n);
        if (r == -1) {
            System.out.println("NOT HAUNTING");
        } else {
            System.out.println(r);
        }
    }
    static int m(int n) {
//        if (n == 1) return 0;
        int k = (int)(Math.log(n) / Math.log(2) + 1e-10);
        int v = 1 << k;
        if (n == v) {
            return 2 * n - 1;
        } else {
            return -1;
        }
//        if (n == 1) return  1;
//        if (n % 2 == 1) return -1;
//        int p = m(n / 2);
//        if (p == -1) return -1;
//        return p + n;
    }
}
