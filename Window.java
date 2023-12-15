/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023
 * Assignment 1, Problem 3: Window.java
 * Student Name:   Umairuddin Alvi
 * Student EECS account:  alviu02
 * Student ID number:  218137927
 **********************************************************/

public class Window {
    // Protected fields
    protected double left, right, bottom, top;

    // Constructor
    public Window(double left, double right, double bottom, double top) throws InvalidWindowException {
        // Check for the invariant and throw an exception if not satisfied
        if (left >= right || bottom >= top) {
            throw new InvalidWindowException("Invalid window parameters");
        }

        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
    }

    // Getters and setters with exception handling
    public double getLeft() {
        return left;
    }

    public void setLeft(double left) throws InvalidWindowException {
        if (left >= this.right) {
            throw new InvalidWindowException("Invalid left parameter");
        }
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) throws InvalidWindowException {
        if (right <= this.left) {
            throw new InvalidWindowException("Invalid right parameter");
        }
        this.right = right;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) throws InvalidWindowException {
        if (bottom >= this.top) {
            throw new InvalidWindowException("Invalid bottom parameter");
        }
        this.bottom = bottom;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) throws InvalidWindowException {
        if (top <= this.bottom) {
            throw new InvalidWindowException("Invalid top parameter");
        }
        this.top = top;
    }

    // Boolean instance method to check if this window encloses the argument window w
    public boolean encloses(Window w) {
        return this.left <= w.left && this.right >= w.right && this.bottom <= w.bottom && this.top >= w.top;
    }

    // Boolean instance method to check if this window overlaps the argument window w
    public boolean overlaps(Window w) {
        return this.left < w.right && this.right > w.left && this.bottom < w.top && this.top > w.bottom;
    }

    // Static method to count overlapping pairs of windows in the input array
    public static int overlapCount(Window[] windows) {
        int count = 0;
        for (int i = 0; i < windows.length; i++) {
            for (int j = i + 1; j < windows.length; j++) {
                if (windows[i].overlaps(windows[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    // Static method to count enclosing pairs of windows in the input array
    public static int enclosureCount(Window[] windows) {
        int count = 0;
        for (int i = 0; i < windows.length; i++) {
            for (int j = 0; j < windows.length; j++) {
                if (i != j && windows[i].encloses(windows[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    // main method for testing
    public static void main(String[] args) {
        // Create windows for testing
        Window window1, window2, window3, window4;

        try {
            window1 = new Window(0, 5, 0, 5);
            window2 = new Window(2, 7, 2, 7);
            window3 = new Window(6, 8, 6, 8);
            window4 = new Window(1, 4, 1, 4);
        } catch (InvalidWindowException e) {
            System.out.println("Invalid window parameters");
            return;
        }

        // Test encloses and overlaps methods
        System.out.println("Window 1 encloses Window 2: " + window1.encloses(window2));
        System.out.println("Window 1 overlaps Window 2: " + window1.overlaps(window2));
        System.out.println("Window 3 encloses Window 4: " + window3.encloses(window4));
        System.out.println("Window 3 overlaps Window 4: " + window3.overlaps(window4));

        // Test overlapCount and enclosureCount methods
        Window[] windows = {window1, window2, window3, window4};
        System.out.println("Overlap count: " + overlapCount(windows));
        System.out.println("Enclosure count: " + enclosureCount(windows));
    }
}
