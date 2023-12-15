import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Represents a hypercube in n-dimensional space and provides methods for recursive and iterative walks.
 */
public class Hypercube {

    private Stack<Corner> walk; // Stack to store the walk
    private int size; // Size of the hypercube

    /**
     * Constructor to initialize the hypercube with a given size.
     * 
     * @param n the size of the hypercube (number of dimensions)
     * @throws Exception if n is negative
     */
    public Hypercube(int n) throws Exception {
        if (n < 0) {
            throw new Exception("Please enter a positive integer");
        } else {
            this.size = n;
            this.walk = new Stack<>();
        }
    }

    /**
     * Represents a corner of the hypercube.
     */
    public static class Corner {
        private String coordinates;

        /**
         * Default constructor for Corner.
         */
        public Corner() {
            this.coordinates = new String("");
        }
    }

    /**
     * Prints one possible walk along the hypercube on n dimensions recursively.
     */
    public void recursiveWalk() {
        int len = this.size;
        Corner pre = new Corner();
        recursiveWalk(pre.coordinates, len);
    }

    // Helper method for reverseRecursiveWalk
    private static void reverseRecursiveWalk(String prefix, int n) {
        if (n == 0) {
            System.out.println(prefix);
        } else {
            recursiveWalk(prefix + "1", n - 1);
            reverseRecursiveWalk(prefix + "0", n - 1);
        }
    }

    // Helper method for recursiveWalk
    private static void recursiveWalk(String prefix, int n) {
        if (n == 0) {
            System.out.println(prefix);
        } else {
            recursiveWalk(prefix + "0", n - 1);
            reverseRecursiveWalk(prefix + "1", n - 1);
        }
    }

    /**
     * Prints one possible walk along the hypercube on n dimensions iteratively.
     */
    public void iterativeWalk() {
        int len = this.size;
        iterativeWalk(this, len);
        for (Corner c : this.walk) {
            System.out.println(c.coordinates);
        }
    }

    /*
     * Gives a walk along hypercube using only a single queue.
     */
    private static void iterativeWalk(Hypercube h, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;
        queue.add(0);

        for (int i = 0; i < n; i++) {
            int size = queue.size();
            for (int j = size - 1; j >= 0; j--) {
                int k = -1;
                if (k != j) {
                    Iterator<Integer> it = queue.iterator();
                    for (; k != j; k++) {
                        num = it.next();
                    }
                }
                queue.add(num + size);
            }
        }

        // Convert integers to binary representation and add to the hypercube's corner
        for (int i : queue) {
            Corner c = new Corner();
            c.coordinates = "";
            for (int k = 0; k < n; k++) {
                c.coordinates = c.coordinates + "0";
            }
            Corner cAdd = new Corner();
            cAdd.coordinates = (c.coordinates + Integer.toBinaryString(i)).substring(Integer.toBinaryString(i).length());
            h.walk.push(cAdd);
        }
    }

    // Main method for testing
    public static void main(String[] args) throws Exception {
        Hypercube Cube1 = new Hypercube(3); // Test n = 3 with recursion
        System.out.println("Walking through a hypercube of 3D using Recursion:");
        Cube1.recursiveWalk();

        System.out.println("\n");

        Hypercube Cube2 = new Hypercube(4); // Test n = 4 with Iteration
        System.out.println("Walking through a hypercube of 4D using Iteration:");
        Cube2.iterativeWalk();

        System.out.println("\n");

        Hypercube Cube3 = new Hypercube(5); // Test n = 5 with recursion
        System.out.println("Walking through a hypercube of 5D using Recursive");
        Cube3.recursiveWalk();
    }
}
