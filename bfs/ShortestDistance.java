package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {

    /**
     * Finds out the shortest distance between given two nodes (source and destination).
     *
     * @param adjList     is the graph represented as adjacency list.
     * @param source      is one of the two nodes of the graph.
     * @param destination is one of the two nodes of the graph.
     */

    public void shortestDistance(ArrayList<ArrayList<Integer>> adjList, int source, int destination) {

        System.out.println("shortestDistance----------------- ");

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];

        int[] distance = new int[adjList.size()]; // Stores the distances of each node from the source. // Extra line from BFS.
        distance[source] = 0; // Since, distance of source node form the source node is 0. // Extra line from BFS.

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {

            int v = queue.poll();

            for (Integer nbr : adjList.get(v)) {
                if (!visited[nbr]) {
                    queue.add(nbr);
                    visited[nbr] = true;

                    distance[nbr] = distance[v] + 1; // Extra line from BFS.
                }
            }
        }

        System.out.print("Shortest distance between " + source + " and " + destination + " is " + distance[destination]);
    }
}
