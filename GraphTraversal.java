import java.security.AllPermission;
import java.util.*;

public class GraphTraversal {

    // Edge class represents a directed edge in the graph
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Create the graph using adjacency lists
    public static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize the adjacency list for each node in the graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // Perform Breadth-First Search (BFS)
    public static void bfs(ArrayList<Edge>[] graph, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // start BFS from node 0

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                // add all unvisited neighbors to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Perform Depth-First Search (DFS)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;

        // visit all unvisited neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], int curr, String path, int tar, boolean vis[]) {
        if (curr == tar) {
            System.out.println(path); // Print the current path along with the target
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                vis[curr] = true; // Mark the current node as visited before the loop
                printAllPath(graph, e.dest, path + " " + curr, tar, vis); // Add the current node to the path
                vis[curr] = false; // Un-visit the current node after the loop for other paths
            }
        }
    }

    // Driver method
    public static void main(String[] args) {
        int V = 7; // number of vertices in the graph

        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean[] vis = new boolean[V]; // visited array

        createGraph(graph);
        // bfs(graph, vis); // Uncomment to perform BFS
        // dfs(graph, 0, vis); // perform DFS

        printAllPath(graph, 0, "", 5, vis);
    }
}
