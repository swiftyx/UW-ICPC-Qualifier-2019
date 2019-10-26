import java.util.*;

public class E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, Set<Integer>> routes = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();

            if (!routes.containsKey(key)){
                routes.put(key, new TreeSet<>());
            }
            routes.get(key).add(value);

            if (!routes.containsKey(value)){
                routes.put(value, new TreeSet<>());
            }
            routes.get(value).add(key);
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);

        int[] exits = new int[k];
        for (int i = 0; i<k;i++){
            exits[i] = scanner.nextInt();
            distances[exits[i]-1] = 0;
        }


        for (int exit : exits) {
            ArrayList<Integer> visited = new ArrayList<>();
            dfs(routes, distances, exit, 0,visited);
        }

        System.out.println(max(distances));
    }


    public static void dfs(Map<Integer,Set<Integer>> map, int[] distances, int start, int distance,ArrayList<Integer> visited){
        for (int destination: map.get(start)){
            if (distance + 1 < distances[destination - 1] && !visited.contains(destination)){
                distances[destination-1] = distance + 1;
                ArrayList<Integer> newVisited = new ArrayList<>(visited);
                newVisited.add(destination);
                dfs(map,distances,destination,distance + 1,newVisited);
            }
        }
    }



    public static int max(int[] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<array.length;i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }


}
