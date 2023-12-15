import java.util.*;

public class SearchTree {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static class TreeNode {
        Point point;
        TreeNode left;
        TreeNode right;

        public TreeNode(Point point) {
            this.point = point;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeNode buildPrioritySearchTree(Set<Point> points) {
        List<Point> sortedPoints = new ArrayList<>(points);
        sortedPoints.sort(Comparator.comparingInt(p -> p.x));
        return buildCompleteBinaryTree(sortedPoints, 0, sortedPoints.size() - 1);
    }

    private static TreeNode buildCompleteBinaryTree(List<Point> points, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(points.get(mid));

        node.left = buildCompleteBinaryTree(points, start, mid - 1);
        node.right = buildCompleteBinaryTree(points, mid + 1, end);

        return node;
    }

    private static List<Point> inOrderTraversal(TreeNode root) {
        List<Point> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private static void inOrder(TreeNode node, List<Point> result) {
        if (node != null) {
            inOrder(node.left, result);
            result.add(node.point);
            inOrder(node.right, result);
        }
    }

    public static void main(String[] args) {
        // Example usage with a set of points
        Set<Point> points = new HashSet<>(Arrays.asList(
                new Point(4, 7),
                new Point(2, 5),
                new Point(6, 9),
                new Point(1, 3),
                new Point(3, 8),
                new Point(5, 1),
                new Point(7, 4)
        ));

        // Build a priority search tree from the set of points
        TreeNode prioritySearchTreeRoot = buildPrioritySearchTree(points);

        // Display the points in the priority search tree
        System.out.println("Points in the Priority Search Tree:");
        List<Point> prioritySearchTreePoints = inOrderTraversal(prioritySearchTreeRoot);
        for (Point point : prioritySearchTreePoints) {
            System.out.println(point);
        }
    }
}
