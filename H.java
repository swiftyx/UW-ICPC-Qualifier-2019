import java.util.*;
public class H {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int W = in.nextInt();
        PriorityQueue<House> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new House(i, in.nextInt(), in.nextInt()));
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int sWei = 0;
            for (House h : pq) {
                if (h.i == i) continue;
                int newW = sWei + h.wei;
                if (newW > W) {
                    System.out.println(sum);
                    break;
                } else {
                    sWei = newW;
                    sum += h.point;
                }
            }
        }
    }
}

class House implements Comparable<House> {
    int i;
    int wei;
    int point;
    double ratio;
    House(int i, int wei, int point) {
        this.i = i;
        this.wei = wei;
        this.point = point;
        ratio = point / (double) wei;
        System.out.println(i + " " + wei + " " + point + " " + ratio);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof House) {
            House other = (House) obj;
            return wei == other.wei && point == other.point;
        } else {
            return false;
        }
    }
    @Override
    public int compareTo(House o) {
        return (int) ((-ratio + o.ratio) * 100);
    }
}