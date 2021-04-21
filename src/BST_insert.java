//BST
//insert node
//jj904

public class BST_insert {
    static class Node{
        int key;
        Node left, right;
    };
    static Node newNode(int data){
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }
    static Node insert(Node root, int key){
        Node node = newNode(key);
        Node x = root;
        Node y = null;

        while (x != null){
            y = x;
            if(key < x.key){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        if(y == null){
            y = node;
        }
        else if(key < y.key){
            y.left = node;
        }else{
            y.right = node;
        }
        return y;

    }

    static void Inorder(Node root){
        if(root == null){
            return;
        }
        else{
            Inorder(root.left);
            System.out.print(root.key + " ");
            Inorder(root.right);
        }
    }

    public static void main(String[] args) {
        /*  50
          /   \
        30     70
        / \    / \
       20 40  60 80 */

        Node root = null;
        root = insert(root, 50);
        insert(root,30);
        insert(root,20);
        insert(root,40);
        insert(root,70);
        insert(root,60);
        insert(root,80);

        Inorder(root);


    }
}
