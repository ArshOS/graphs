package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {

    /**
     * <strong>In BFS, a node is considered “visited” the moment it is discovered (enqueued), not when it is processed (dequeued).</strong>
     *
     * <p>Standard Problems and Algorithms based on the BFS:</p>
     * <ol>
     *     <li>Single-source-shortest-path Algorithm. AKA the shortest distance.</li>
     * </ol>
     *
     * @param adjList is the graph represented as adjacency list.
     * @param source  is the source node of the graph.
     */

    public void bfs(ArrayList<ArrayList<Integer>> adjList, int source) {

        System.out.println("BFS---------");

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            // Print the current node. Instead of printing the node can be stored into some data structure.
            System.out.print(v + " ");

            for (Integer nbr : adjList.get(v)) {
                if (!visited[nbr]) {
                    queue.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }
}
