//BST
//Travel Level Order(2 options)
//jj904
import java.util.LinkedList;
import java.util.ArrayList;
class TreeL{
    class NodeL {
        int data;
        TreeL.NodeL left;
        TreeL.NodeL right;
        NodeL(int data) {
            this.data = data;
        }
    }
    NodeL root;

    TreeL(int size){
        root = makeBST(0, size -1);
    }

    NodeL makeBST(int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        NodeL node = new NodeL(mid);
        node.left = makeBST(start, mid-1);
        node.right = makeBST(mid+1, end);
        return node;
    }

    //option1
    ArrayList<LinkedList<NodeL>> BSTtoList(){
        ArrayList<LinkedList<NodeL>> lists = new ArrayList<LinkedList<NodeL>>();
        BSTtoList(root, lists, 0);
        return lists;
    }

    void BSTtoList(NodeL root, ArrayList<LinkedList<NodeL>> lists, int level){
        if(root == null){
            return;
        }
        LinkedList<NodeL>list = null;
        if(lists.size() == level){
            list = new LinkedList<NodeL>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        BSTtoList(root.left, lists, level+1);
        BSTtoList(root.right, lists, level+1);
    }

    //option2
    ArrayList<LinkedList<NodeL>> BSTtoList2(){
        ArrayList<LinkedList<NodeL>> result = new ArrayList<LinkedList<NodeL>>();
        LinkedList<NodeL> current = new LinkedList<NodeL>();
        if(root != null){
            current.add(root);
        }
        while (current.size() > 0){
            result.add(current);
            LinkedList<NodeL> parents = current;
            current = new LinkedList<NodeL>();
            for(NodeL parent : parents ){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    void printList(ArrayList<LinkedList<NodeL>> arr){
        for(LinkedList<NodeL> list : arr){
            for(NodeL node : list){
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}
public class BST_LevelOrder {
    public static void main(String[] args) {
        TreeL  t = new TreeL(10);
        t.printList(t.BSTtoList2());

    }
}
