import java.util.*;

public class Problem1_ActivitySelection {
    public static void main(String[] args) {
        int[][] activities = {
            {1, 3},
            {2, 4},
            {3, 5},
            {0, 6},
            {5, 7},
            {8, 9}
        };

        // Sort by end time using Integer.compare
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        // Always select the first activity
        int count = 1;
        int lastEnd = activities[0][1];

        System.out.println("Selected activities:");
        System.out.println("(" + activities[0][0] + ", " + activities[0][1] + ")");

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= lastEnd) {
                count++;
                lastEnd = activities[i][1];
                System.out.println("(" + activities[i][0] + ", " + activities[i][1] + ")");
            }
        }

        System.out.println("Total activities selected: " + count);
    }
}
