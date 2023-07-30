import java.util.*;

public class Graphs1 {
    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int wt) {
            this.dest = dest;
            this.src = src;
            this.weight = wt;
        }
    }

    public static void createGraph(ArrayList <Edge> graph[]){
        for(int i=0; i< graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));

    }
    public static void allNeighbours(ArrayList <Edge> graph[], int src){
        for (int i = 0; i < graph[src].size(); i++) {
            System.out.println(src + " -> " + "Destination: " + graph[src].get(i).dest + ", Weight: " + graph[src].get(i).weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList <Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        allNeighbours(graph, 2);
    }
}
