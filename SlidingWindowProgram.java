
import java.util.Scanner;

public class SlidingWindowProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("No claim data available.");
            sc.close();
            return;
        }

        int[] claims = new int[n];

        System.out.println("Enter daily claim counts:");

        for (int i = 0; i < n; i++) {
            claims[i] = sc.nextInt();
        }

        int left = 0;
        int maxLength = 0;
        int bestStart = -1;
        int bestEnd = -1;

        // Sliding Window
        for (int right = 0; right < n; right++) {

            if (claims[right] <= 100) {
                left = right + 1;
            }

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                bestStart = left;
                bestEnd = right;
            }
        }

        System.out.println("Longest consecutive days: " + maxLength);

        if (maxLength > 0) {
            System.out.println("Starting day: " + (bestStart + 1));
            System.out.println("Ending day: " + (bestEnd + 1));
        } else {
            System.out.println("No day had more than 100 claims.");
        }

        sc.close();
    }
}
