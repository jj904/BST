//BST_sum of all greater keys
//jj904
class NodeTree
{
    int data;
    NodeTree left;
    NodeTree right;

    NodeTree(int data) {
        this.data = data;
    }
}

class BST_Sum {
   public static void preorder(NodeTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static NodeTree insert(NodeTree root, int key) {
        if (root == null) {
            return new NodeTree(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static int findSum(NodeTree root) {
        if (root == null) {
            return 0;
        }
        return root.data + findSum(root.left) + findSum(root.right);
    }

    public static int update(NodeTree root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = update(root.left, sum);
        sum = sum - root.data;
        root.data += sum;

        sum = update(root.right, sum);

        return sum;
    }

    public static void main(String[] args) {
        int[] keys = {5, 3, 2, 8, 4, 6, 10};

        /* Construct the following tree
                   5
                 /   \
                /     \
               3       8
              / \     / \
             /   \   /   \
            2    4  6     10
        */

        NodeTree root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
        preorder(root);
        System.out.println();
        int sum = findSum(root);
        update(root, sum);
        preorder(root);
    }
}

/*
//output of preorder :
5 3 2 4 8 6 10

29 36 38 33 18 24 10

          29
         /   \
        /     \
       36      18
       / \     / \
      /   \   /   \
    38    33 24    10

*/



