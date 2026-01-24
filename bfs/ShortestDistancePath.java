package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancePath {

    /**
     * Finds out the path to the node with the shortest distance from source node.
     *
     * @param adjList     is the graph represented as adjacency list.
     * @param source      is one of the two nodes of the graph.
     * @param destination is one of the two nodes of the graph.
     */

    public void shortestDistancePath(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {

        System.out.println("shortestDistancePath----------------- ");

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];

        int[] parent = new int[adjList.size()]; // Stores the info about the parent node. // Extra line from BFS.
        Arrays.fill(parent, -1);

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int v = queue.poll();

            for (Integer nbr : adjList.get(v)) {
                if (!visited[nbr]) {
                    queue.add(nbr);
                    visited[nbr] = true;

                    parent[nbr] = v; // Extra line from BFS.
                }
            }
        }

        int temp = destination;

        while (temp != source) {
            System.out.print(temp + " --- ");
            temp = parent[temp];
        }
        System.out.println(source);

    }
}
