package dfs;

import java.util.ArrayList;

public class DfsTraversal {

    /**
     * <strong>In DFS, a node is considered “visited” the moment function starts execution.</strong>
     *
     * <p>Standard Problems and Algorithms based on the DFS:</p>
     * <ol>
     *     <li>Single-source-shortest-path Algorithm. AKA the shortest distance.</li>
     * </ol>
     *
     * @param adjList is the graph represented as adjacency list.
     * @param source  is the source node of the graph.
     */

    public void dfs(ArrayList<ArrayList<Integer>> adjList, int source) {

        System.out.println("DFS---------");

        boolean[] visited = new boolean[adjList.size()];

        dfsHelper(adjList, source, visited);
    }

    private void dfsHelper(ArrayList<ArrayList<Integer>> adjList, int source, boolean[] visited) {

        visited[source] = true;

        System.out.print(source + " ");

        for (Integer nbr : adjList.get(source)) {
            if (!visited[nbr]) {
                dfsHelper(adjList, nbr, visited);
            }
        }
    }
}
