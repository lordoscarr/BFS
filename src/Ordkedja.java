import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ordkedja {

    private ArrayList<String> getWords(String path) throws Exception{
        BufferedReader r =
                new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        ArrayList<String> words = new ArrayList<String>();
        while (true) {
            String word = r.readLine();
            if (word == null) { break; }
            words.add(word);
        }
        return words;
    }

    private void testWords(String path, Graph graph, ArrayList<String> words) throws Exception{
        BufferedReader r =
                new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        while (true) {
            String line = r.readLine();
            if (line == null) { break; }
            String start = line.substring(0, 5);
            String goal = line.substring(6, 11);
            int startIndex = words.indexOf(start);
            int goalIndex = words.indexOf(goal);
            BFS bfs = new BFS(graph, startIndex);
            System.out.println(bfs.distTo(goalIndex));
        }
    }

    public static void main(String[] args) throws Exception
    {
        Ordkedja ordkedja = new Ordkedja();
        ArrayList<String> words = ordkedja.getWords("./files/words-" + 5757 + "-data.txt");
        Graph graph = new Graph(words.size());
        graph.create(words);

        ordkedja.testWords("./files/words-" + 5757 + "-test.txt", graph, words);
        //System.out.println(graph.BFS(words.indexOf("other"), words.indexOf("there")));
    }
}
