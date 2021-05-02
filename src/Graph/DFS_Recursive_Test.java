//Graph
//DFS_Recursive
//jj904

package Graph;

import java.util.LinkedList;

class Graph_Recursive{
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    //Make A Graph
    Node[] nodes;

    Graph_Recursive(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfsR(Graph_Recursive.Node r){
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Graph_Recursive.Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }
    void dfsR(int index){
        Graph_Recursive.Node r = nodes[index];
        dfsR(r);
    }
    void dfsR() {
        dfsR(0);
    }

    void visit(Graph_Recursive.Node n) {
        System.out.print(n.data + " ");
    }
}

public class DFS_Recursive_Test {
    public static void main(String[] args) {
        Graph_Recursive g = new Graph_Recursive(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);

        g.dfsR();
    }

}
