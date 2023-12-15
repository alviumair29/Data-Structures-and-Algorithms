import java.util.Stack;


public class AugmentedStack<T extends Comparable<T>> {
    private Stack<T> stack;        // Main stack for elements
    private Stack<T> minStack;     // Stack for minimum elements

    /**
     * Constructs an AugmentedStack with main and auxiliary stacks.
     */
    public AugmentedStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushes an element onto the main stack and updates the minimum stack.
     *
     * @param x the element to be pushed onto the stack
     */
    public void push(T x) {
        stack.push(x);
        // Update the minimum stack if the new element is smaller or equal
        if (minStack.isEmpty() || x.compareTo(minStack.peek()) <= 0) {
            minStack.push(x);
        }
    }

    /**
     * Pops the top element from the main stack and updates the minimum stack if necessary.
     *
     * @return the popped element, or null if the stack is empty
     */
    public T pop() {
        if (!stack.isEmpty()) {
            T popped = stack.pop();
            // Update the minimum stack if the popped element was the minimum
            if (popped.equals(minStack.peek())) {
                minStack.pop();
            }
            return popped;
        }
        return null;
    }

    /**
     * Gets the minimum element in the stack.
     *
     * @return the minimum element, or null if the stack is empty
     */
    public T getMin() {
        return minStack.isEmpty() ? null : minStack.peek();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Gets the top element of the stack without removing it.
     *
     * @return the top element, or null if the stack is empty
     */
    public T top() {
        return stack.isEmpty() ? null : stack.peek();
    }

    /**
     * Main method for testing the AugmentedStack functionality.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        AugmentedStack<Integer> stack = new AugmentedStack<>();
        stack.push(2);
        stack.push(4);
        stack.push(8);

        System.out.println("Top element: " + stack.top());  // Output: 8
        System.out.println("Minimum element: " + stack.getMin());  // Output: 2

        stack.pop();  // Remove 8

        System.out.println("Top element: " + stack.top());  // Output: 4
        System.out.println("Minimum element: " + stack.getMin());  // Output: 2
    }
}