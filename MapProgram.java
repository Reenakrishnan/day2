
import java.util.Scanner;
import java.util.HashMap;

class ClaimMap {

    HashMap<String, Integer> claims = new HashMap<>();

    // Insert and detect duplicate claims
    void insert(int id, String policy, String date) {

        String key = policy.replaceAll("\\s+", "")
                .toLowerCase() + "|" + date.trim();

        if (claims.containsKey(key)) {

            System.out.println("Duplicate Claim Found");
            System.out.println("Existing Claim ID: "
                    + claims.get(key));

        }
        else {

            claims.put(key, id);
            System.out.println("Claim Inserted Successfully");
        }
    }

    // Search claim
    void search(String policy, String date) {

        String key = policy.replaceAll("\\s+", "")
                .toLowerCase() + "|" + date.trim();

        if (claims.containsKey(key))
            System.out.println("Claim Found: " + claims.get(key));

        else
            System.out.println("Claim Not Found");
    }

    // Display all claims
    void display() {

        if (claims.isEmpty()) {
            System.out.println("No Claims Available");
            return;
        }

        System.out.println("Stored Claims:");

        for (String key : claims.keySet()) {
            System.out.println(key + " : " + claims.get(key));
        }
    }
}

public class MapProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ClaimMap map = new ClaimMap();

        int choice, id;
        String policy, date;

        do {

            System.out.println("\n1. Insert Claim");
            System.out.println("2. Search Claim");
            System.out.println("3. Display Claims");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Claim ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Policy Number: ");
                    policy = sc.nextLine();

                    System.out.print("Enter Incident Date (YYYY-MM-DD): ");
                    date = sc.nextLine();

                    map.insert(id, policy, date);
                    break;

                case 2:
                    sc.nextLine();

                    System.out.print("Enter Policy Number: ");
                    policy = sc.nextLine();

                    System.out.print("Enter Incident Date: ");
                    date = sc.nextLine();

                    map.search(policy, date);
                    break;

                case 3:
                    map.display();
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
