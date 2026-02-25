package cycleDetection;

import java.util.ArrayList;

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
    public void detectCycleInUndirectedGraphDfs(ArrayList<ArrayList<Integer>> adjList, int source) {

        System.out.println("Cycle Detection Undirected DFS---------");


        int v = adjList.size();
        boolean[] visited = new boolean[v];
        int sourceParent = -1;

        boolean cyclic = dfsHelperDetectCycleInUndirectedGraphDfs(adjList, source, sourceParent, visited);

        System.out.println("Given graph is " + ((cyclic) ? "Cyclic" : "Acyclic"));
    }

    private boolean dfsHelperDetectCycleInUndirectedGraphDfs(ArrayList<ArrayList<Integer>> adjList, int currNode, int parent, boolean[] visited) {

        visited[currNode] = true;

        for (Integer nbr : adjList.get(currNode)) {
            if (!visited[nbr]) {
                boolean foundCycleByNbr = dfsHelperDetectCycleInUndirectedGraphDfs(adjList, nbr, currNode, visited);
                if (foundCycleByNbr) return true;
            } else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Normal DFS steps.
     * Keep two data structures, one to remember visited nodes (say visited) and another to track visited nodes in the current call (say stack).
     * Note that remove current node from the stack DS after its call and operations are over.
     * </p>
     * <br/>
     * <strong>Steps:</strong>
     * <ol>
     *     <li>Mark the current node visited and add it to the stack (note that, stack is just a name note the actual Stack DS).</li>
     *     <li>Make recursive call to neighbor nodes, and see if any of it returns presence of a back-edge.</li>
     *     <li>After the recursive call ends, remove current node from the stack.</li>
     * </ol>
     *
     */
    public void detectCycleInDirectedGraphDfs(ArrayList<ArrayList<Integer>> adjList, int source) {

        System.out.println("Cycle Detection Directed DFS---------");

        int v = adjList.size();

        boolean[] visited = new boolean[v];
        boolean[] stack = new boolean[v];

        boolean cyclic = dfsHelperDetectCycleInDirectedGraphDfs(adjList, source, visited, stack);

        System.out.println("Given graph is " + ((cyclic) ? "Cyclic" : "Acyclic"));
    }

    private boolean dfsHelperDetectCycleInDirectedGraphDfs(ArrayList<ArrayList<Integer>> adjList, int source, boolean[] visited, boolean[] stack) {

        // Arrived at current node
        visited[source] = true;
        stack[source] = true;

        for (Integer nbr : adjList.get(source)) {
            // If current neighbor is not visited, make call to it.
            if (!visited[nbr]) {
                boolean foundBackEdgeInNbr = dfsHelperDetectCycleInDirectedGraphDfs(adjList, nbr, visited, stack);

                // If any neighbor finds a back-edge, cycle detected.
                if (foundBackEdgeInNbr) {
                    return true;
                }

                // The current neighbor is visited and also present in current call stack, back-edge detected.
            } else if (stack[nbr]) {
                return true;
            }
        }

        // Remove current node from the stack call.
        stack[source] = false;

        return false;
    }

}
