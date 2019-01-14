import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    public int V;
    public LinkedList<Integer> adj[];

    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int node){
        adj[v].add(node);
    }

    public void create(ArrayList<String> words){
        for (int i = 0; i < words.size(); i++){
            for(int j = 0; j < words.size(); j++){
                if(j != i){
                    String w1 = words.get(i);
                    String w2 = words.get(j);
                    if(controlLetters(w1, w2)){
                        addEdge(i, j);
                    }
                }
            }
        }
    }

    public static boolean controlLetters(String w1, String w2) {
        String word = w1;
        boolean[] charPicked = new boolean[w2.length()];
        boolean charFound = false;
        int count = 0;
        for(int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            charFound = false;
            for(int j = 0; j < w2.length(); j++) {
                if(ch == w2.charAt(j) && !charPicked[j]) {
                    charFound = true;
                    charPicked[j] = true;
                    count++;
                    break;
                }
            }
            if(!charFound) {
                break;
            }
        }
        if(count > 3) {
            return true;
        }
        return false;
    }
}
