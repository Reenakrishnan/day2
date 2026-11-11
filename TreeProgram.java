
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
    }
}

class BST {

    Node root;

    // Insert Claim ID
    Node insert(Node root, int value) {

        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);

        else if (value > root.data)
            root.right = insert(root.right, value);

        else
            System.out.println("Duplicate Claim ID");

        return root;
    }

    // Search Claim ID
    boolean search(Node root, int value) {

        if (root == null)
            return false;

        if (root.data == value)
            return true;

        if (value < root.data)
            return search(root.left, value);

        return search(root.right, value);
    }

    // Inorder: Left, Root, Right
    void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder: Root, Left, Right
    void preorder(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left, Right, Root
    void postorder(Node root) {

        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}

public class TreeProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BST tree = new BST();

        int choice, value;

        do {

            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Inorder");
            System.out.println("4. Preorder");
            System.out.println("5. Postorder");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Claim ID: ");
                    value = sc.nextInt();
                    tree.root = tree.insert(tree.root, value);
                    break;

                case 2:
                    System.out.print("Enter Claim ID to Search: ");
                    value = sc.nextInt();

                    if (tree.search(tree.root, value))
                        System.out.println("Claim Found");
                    else
                        System.out.println("Claim Not Found");
                    break;

                case 3:
                    System.out.print("Inorder: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Preorder: ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Postorder: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
