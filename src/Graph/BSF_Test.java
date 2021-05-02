//Graph
//Breath-First-Search (BFS)
//jj904

package Graph;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class Queue<T>{
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }
    private Node<T> first;
    private Node<T> last;

    //add -> enqueue
    public void enqueue(T item){
        Node<T> t = new Node<T>(item);

        if(last != null){
            last.next = t;
        }
        last = t;
        if(first == null){
            first = last;
        }
    }
    //remove -> dequeue
    public T dequeue(){
        if(first == null){
            throw  new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;

        if(first == null){
            last = null;
        }
        return data;
    }
    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }
    public boolean isEmpty(){
        return first == null;
    }
}

class Graph_BSF{
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node (int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    //Make A Graph
    Node[] nodes;
    Graph_BSF(int size) {
        nodes = new Node[size];
        for(int i=0; i <size; i++){
            nodes[i] = new Node(i);
        }
    }
    void addEdge (int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    //BFS
    void bfs() {
        bfs(0);
    }
    void bfs(int index){
        Graph_BSF.Node root = nodes[index];
        Queue<Graph_BSF.Node> queue = new Queue<Graph_BSF.Node>();
        queue.enqueue(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Graph_BSF.Node r = queue.dequeue();
            for(Graph_BSF.Node n : r.adjacent) {
                if(n.marked == false){
                    n.marked = true;
                    queue.enqueue(n);
                }
            }
            visit(r);

        }
    }
    void visit(Graph_BSF.Node n){
        System.out.print(n.data + " ");
    }
}
public class BSF_Test {
    public static void main(String[] args) {
        Graph_BSF g = new Graph_BSF(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);

        g.bfs();
    }
}
