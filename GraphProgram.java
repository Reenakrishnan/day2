
import java.util.*;

public class GraphProgram {

    static String[] stages = {
        "Registration", "Assessment", "Surveyor", "Settlement"
    };

    static ArrayList<Integer>[] graph = new ArrayList[4];

    static void addEdge(int from, int to) {
        graph[from].add(to);
    }

    // BFS - Find shortest path
    static void bfs(int start, int end) {
        int[] parent = {-1, -1, -1, -1};
        boolean[] visited = new boolean[4];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }

        if (!visited[end]) {
            System.out.println("No path found.");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int current = end;

        while (current != -1) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);

        System.out.println("Shortest path:");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(stages[path.get(i)]);
            if (i < path.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    // DFS - Detect cycle
    static boolean dfs(int node, int[] state) {
        state[node] = 1;

        for (int next : graph[node]) {
            if (state[next] == 1) {
                return true;
            }

            if (state[next] == 0 && dfs(next, state)) {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }

    static void detectCycle() {
        int[] state = new int[4];

        for (int i = 0; i < 4; i++) {
            if (state[i] == 0 && dfs(i, state)) {
                System.out.println("Loop detected in approval stages.");
                return;
            }
        }

        System.out.println("No loop detected.");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            graph[i] = new ArrayList<>();
        }

        // Default approval flow
        addEdge(0, 1);
        addEdge(1, 2);
        addEdge(2, 3);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Find shortest path");
            System.out.println("2. Detect loop");
            System.out.println("3. Add approval connection");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter start stage (0-3):");
                    int start = sc.nextInt();

                    System.out.println("Enter end stage (0-3):");
                    int end = sc.nextInt();

                    if (start >= 0 && start < 4 &&
                        end >= 0 && end < 4) {
                        bfs(start, end);
                    } else {
                        System.out.println("Invalid stage number.");
                    }
                    break;

                case 2:
                    detectCycle();
                    break;

                case 3:
                    System.out.println("Enter from stage (0-3):");
                    int from = sc.nextInt();

                    System.out.println("Enter to stage (0-3):");
                    int to = sc.nextInt();

                    if (from >= 0 && from < 4 &&
                        to >= 0 && to < 4) {
                        addEdge(from, to);
                        System.out.println("Connection added.");
                    } else {
                        System.out.println("Invalid stage number.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
