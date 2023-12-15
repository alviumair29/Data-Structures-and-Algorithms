// The balance factor of an internal position p of a proper binary tree is the difference between the heights of the right and left subtrees of p. Show how to
// specialize the Euler tour traversal of Section 8.4.6 to print the balance factors of
// all the internal nodes of a proper binary tree.

/* BalanceFactor.java
    Name: Umairuddin Alvi
    Student # 218137927
*/

import java.io.PrintStream;
import java.util.Scanner;

public class BalanceFactor<E> {

    // Inner class representing a Binary Search Tree
    public static class BinarySearchTree<E extends Comparable<? super E>> {

        // Node class representing individual nodes in the tree
        private class Node<E> {
            private E data;
            private Node<E> parent;
            private Node<E> leftSubTree;
            private Node<E> rightSubTree;

            public Node(E data, Node<E> leftSubTree, Node<E> rightSubTree) {
                this.data = data;
                this.leftSubTree = leftSubTree;
                this.rightSubTree = rightSubTree;
            }
        }

        private Node<E> root; // Root of the binary search tree

        // Constructor to initialize an empty binary search tree
        public BinarySearchTree() {
            root = null;
        }

        // Method to add a value to the binary search tree
        public void add(E value) {
            root = addNode(root, value);
        }

        // Private helper method to recursively add a value to the tree
        private Node<E> addNode(Node<E> root, E value) {
            Node<E> result = null;
            if (root == null) {
                result = new Node<E>(value, null, null);
            } else if (root.data.compareTo(value) > 0) {
                root.leftSubTree = addNode(root.leftSubTree, value);
                result = root;
            } else {
                root.rightSubTree = addNode(root.rightSubTree, value);
                result = root;
            }
            return result;
        }

        // Method to calculate and print the balance factors of all internal nodes in the tree
        public int BalanceFactor(Node<E> root) {
            if (root == null) {
                return 0;
            }
            if (root.leftSubTree == null && root.rightSubTree == null) {
                System.out.println("Balance Factor: [" + root.data + ", 0]");
                return 0;
            }

            // Recursively calculate balance factors for left and right subtrees
            int LeftHeight = BalanceFactor(root.leftSubTree);
            int RightHeight = BalanceFactor(root.rightSubTree);

            // Calculate and print the balance factor for the current node
            System.out.println("Balance Factor: [" + root.data + ", " + Math.abs(LeftHeight - RightHeight) + "]");

            // Return the height of the current subtree
            return RightHeight + LeftHeight + 1;
        }
    }

    // Main method to demonstrate the BalanceFactor class
    public static void main(String[] args) {

        // Initialize scanner for user input and print stream for output
        Scanner input = new Scanner(System.in);

        // Create an instance of BinarySearchTree to work with integers
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        // Prompt user to enter the number of integers for the tree
        System.out.println("Enter the number of integers you want the tree to be made of:-");
        int elements = input.nextInt();
        int x = 0;

        // Prompt user to enter the list of integers to add to the tree
        System.out.println("Enter the list of integers to be added to the tree: ");
        while (x < elements) {
            int temp = input.nextInt();
            bst.add(temp);
            x++;
        }

        // Print the balance factors of all internal nodes in the tree
        System.out.println("\nBalance Factor: [Element, Factor]\n");
        bst.BalanceFactor(bst.root);
    }
}