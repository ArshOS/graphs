import java.util.ArrayList;
import java.util.LinkedList;

class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public Graph(int v) {
        this.vertices = v;
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, boolean isDirected) {
        adjList.get(source).add(destination);
        if (!isDirected) {
            adjList.get(destination).add(source);
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + "--> ");
            for (Integer node : adjList.get(i)) {
                System.out.print(node + ", ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1, false);
        g.addEdge(0, 4, false);
        g.addEdge(2, 1, false);
        g.addEdge(3, 4, false);
        g.addEdge(4, 5, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 5, false);

        g.printGraph();
    }
}
