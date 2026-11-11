
import java.util.Scanner;
import java.util.ArrayList;

class ClaimList {

    void merge(int[] a, int[] b) {

        int i = 0, j = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j]) {
                result.add(a[i]);
                i++;
            }
            else {
                result.add(b[j]);
                j++;
            }
        }

        while (i < a.length) {
            result.add(a[i]);
            i++;
        }

        while (j < b.length) {
            result.add(b[j]);
            j++;
        }

        System.out.println("Merged Claim List: " + result);
    }
}

public class ListProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ClaimList list = new ClaimList();

        int choice;

        do {

            System.out.println("\n1. Merge Claims");
            System.out.println("2. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter First List Size: ");
                    int n = sc.nextInt();

                    int[] a = new int[n];

                    System.out.println("Enter Sorted First List:");

                    for (int i = 0; i < n; i++)
                        a[i] = sc.nextInt();

                    System.out.print("Enter Second List Size: ");
                    int m = sc.nextInt();

                    int[] b = new int[m];

                    System.out.println("Enter Sorted Second List:");

                    for (int i = 0; i < m; i++)
                        b[i] = sc.nextInt();

                    list.merge(a, b);
                    break;

                case 2:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 2);

        sc.close();
    }
}
