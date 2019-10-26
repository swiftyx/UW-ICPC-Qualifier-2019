import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class J {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Point[] points = new Point[n];

        for (int i = 0; i<n;i++){
            points[i] = new Point(in.nextInt(),in.nextInt());
        }

        int count = 0;
        List<int[]> combinations = generate(n,3);
        for (int[] comb: combinations){
//            for (int i = 0; i<comb.length;i++){
//                System.out.print(comb[i]);
//            }
//            System.out.println();

            Point p1 = points[comb[0]];
            Point p2 = points[comb[1]];
            Point p3 = points[comb[2]];

            double d1 = distance(p1,p2), d2 = distance(p2,p3), d3 = distance(p1,p3);
            if (d1 == d2 && d1 + d2 != d3 || d1 == d3 && d1 + d3 != d2 || d2 == d3 && d2 + d3 != d1) {
                    count++;
            }
        }
        System.out.println(count);
    }

    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((double)p1.x - (double)p2.x,2)+Math.pow((double)p1.y - (double)p2.y,2));
    }

    public static void getCombinations(List<int[]> combinations,  int[] data, int start, int end, int index){
        if (index == data.length){
            int[] combination = data.clone();
            combinations.add(combination);
        }else if (start<=end){
            data[index] = start;
            getCombinations(combinations,data,start + 1, end,index+1);
            getCombinations(combinations,data,start + 1, end,index);
        }

    }

    public static List<int[]> generate(int n, int r){
        List<int[]> combinations = new ArrayList<>();
        getCombinations(combinations,new int[r],0,n-1,0);
        return combinations;
    }
}
