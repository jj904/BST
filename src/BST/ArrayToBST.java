package BST;

class BSTree{
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    Node root;
    public void makeTree(int[] arr){
        root = makeTree(arr, 0, arr.length-1);
    }
    public Node makeTree(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);
        node.left = makeTree(arr, start, mid-1);
        node.right = makeTree(arr, mid+1, end);
        return node;
    }
    public void searchTree(Node node, int find){
        if(find < node.data){
            System.out.println("Data is smaller than" + node.data);
            searchTree(node.left, find);
        }else if(find > node.data){
            System.out.println("Data is bigger than" + node.data);
            searchTree(node.right,find);
        }else {
            System.out.println("Data found!");
        }
    }
}

public class ArrayToBST {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        BSTree t = new BSTree();
        t.makeTree(arr);
        t.searchTree(t.root, 2);
        /*
                (4)
               /   \
              /     \
            (1)     (7)
            /  \    /  \
           (0) (2) (5) (8)
                 \   \   \
                 (3) (6) (9)
         */
    }
}
