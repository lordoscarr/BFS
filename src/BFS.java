import java.util.LinkedList;

public class BFS {
    private boolean[] visited;
    private int[] edgeTo;
    private int[] distTo;

    public BFS(Graph graph, int s) {
        visited = new boolean[graph.V];
        distTo = new int[graph.V];
        edgeTo = new int[graph.V];
        for (int i = 0; i < graph.V; i++) {
            distTo[i] = -1;
        }
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        distTo[s] = 0;
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()) {
            int n = queue.remove();
            for(int v : graph.adj[n]) {
                if(!visited[v]) {
                    edgeTo[v] = n;
                    distTo[v] = distTo[n] + 1;
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    public int distTo(int v) {
        return distTo[v];
    }
}
