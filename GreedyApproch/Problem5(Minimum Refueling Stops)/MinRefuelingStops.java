import java.util.*;

public class MinRefuelingStops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input target distance and start fuel
        System.out.print("Enter target distance: ");
        int target = sc.nextInt();
        System.out.print("Enter starting fuel: ");
        int startFuel = sc.nextInt();

        // Input number of stations
        System.out.print("Enter number of stations: ");
        int n = sc.nextInt();

        int[][] stations = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter position and fuel for station " + (i + 1) + ":");
            stations[i][0] = sc.nextInt(); // position
            stations[i][1] = sc.nextInt(); // fuel
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int fuel = startFuel, stops = 0, i = 0;

        while (fuel < target) {
            while (i < n && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            if (maxHeap.isEmpty()) {
                System.out.println("-1");
                return;
            }
            fuel += maxHeap.poll();
            stops++;
        }

        System.out.println("Minimum refueling stops: " + stops);
    }
}
