package BST;//BST
//By using Queue
//jj904

import java.util.*;
public class BST_Queue{
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void printView(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
            } else {
                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);

                System.out.print(curr.data + " ");
            }
        }
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }
        return root;
    }
    public static int findSum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + findSum(root.left) + findSum(root.right);
    }

    public static int update(Node root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = update(root.left, sum);
        sum = sum - root.data;
        root.data += sum;

        sum = update(root.right, sum);

        return sum;
    }

    public static void main(String[] args)
    {
        int[] arr = {5, 3, 2, 8, 4, 6, 10};
        Node root = null;
        for (int key : arr) {
            root = insert(root, key);
        }
        System.out.println();
        int sum = findSum(root);
        update(root, sum);
        printView(root);

    }
}