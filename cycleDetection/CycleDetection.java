package cycleDetection;

import java.util.ArrayList;
import java.util.List;

/**
 * Any graph containing nocycle is a tree.
 * To have a cycle in a given graph means a given node can be visited from some other node in more than one way.
 * Either BFS or DFS can be used to detect presence of a cycle in a given graph.
 * While using DFS, just need to see if the neighbor of the current node is it's parent in the DFS path. If it is, there is a cycle.
 */
public class CycleDetection {

    /**
     * Normal DFS steps.
     * for each non-visited neighbor of the current node, recursive call is made.
     * If a neighbor is already visited, and it is not the parent of the current node, it means this neighbor is visited by some other way, and
     * current path is another way to reach it. Implies presence of a cycle.
     */

    private boolean dfs(ArrayList<ArrayList<Integer>> adjList, int currNode, int parent, boolean[] visited) {

        visited[currNode] = true;

        for (Integer nbr : adjList.get(currNode)) {
            if (!visited[nbr]) {
                boolean foundCycleByNbr = dfs(adjList, nbr, currNode, visited);
                if (foundCycleByNbr) return true;
            } else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }

    public void detectCycleInUndirectedGraphDfs(ArrayList<ArrayList<Integer>> adjList, int source) {

        System.out.println("Cycle Detection DFS---------");


        int v = adjList.size();
        boolean[] visited = new boolean[v];
        int sourceParent = -1;

        boolean cyclic = dfs(adjList, source, sourceParent, visited);

        System.out.println("Given graph is " + ((cyclic) ? "Cyclic" : "Acyclic"));
    }

    public void detectCycleInDirectedGraphDfs() {
        //TODO
    }

}
