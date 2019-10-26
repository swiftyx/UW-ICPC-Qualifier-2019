import java.util.*;

public class G {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(m(n));
    }

    static Map<Integer, Integer> map = new HashMap<>();
    static int m(int n) {
//        System.out.println(n);
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n < 9) {
            return n * 2 -1;
        }
        int i = 2;
        int k = (int)Math.sqrt(n);
        int power = (int) Math.pow(k, i);
        int newPower = power;
        do {
            power = newPower;
            int step = m (n - power);
            int cur = m(k);
            int r = step  + i * (cur + 3);
            if (!map.containsKey(n)) {
                map.put(n, r);
            } else if (map.get(n) > r) {
                map.put(n, r);
            }

            i++;
            k = (int) (Math.pow(n, 1. / i) + 1e-10);
            newPower = (int) Math.pow(k, i);
        } while (newPower > power);

        return map.get(n);
//        if (n < )
    }
}
