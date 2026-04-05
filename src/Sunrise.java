import java.util.Scanner;

public class Sunrise {

    // Task: Count how many buildings can see the sunrise from index 0
    public int countBuildings(int[] h, int n) {
        // If there are no buildings, 0 see the sunrise.
        if (n == 0) return 0;

        // The first building (index 0) will ALWAYS see the sunrise.
        int count = 1; 
        
        // Track the tallest building we have seen so far
        int currentMaxHeight = h[0];

        // Start checking from the second building
        for (int i = 1; i < n; i++) {
            // If this building is strictly taller than everything before it
            if (h[i] > currentMaxHeight) {
                count++; // It can see the sunrise
                currentMaxHeight = h[i]; // It becomes the new maximum height blocking others
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of buildings
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] h = new int[n];
            
            // Read heights
            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }
            
            Sunrise solver = new Sunrise();
            System.out.println(solver.countBuildings(h, n));
        }
        
        sc.close();
    }
}
