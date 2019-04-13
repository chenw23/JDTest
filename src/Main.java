import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input;

        input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        input.nextLine();
        Graph graph = new Graph(m);
        for (int i = 0; i < n; i++) {
            int startEdge = input.nextInt() - 1;
            int finishEdge = input.nextInt() - 1;
            graph.vertices.get(startEdge).adj.add(graph.vertices.get(finishEdge));
            input.nextLine();
        }


        long time = System.currentTimeMillis();
        graph.PERT();
        System.out.println("The time is " + (System.currentTimeMillis() - time));
        int distance = 0;
        for (Vertex vertex : graph.vertices)
            if (vertex.d > distance)
                distance = vertex.d;
        System.out.println(distance);
    }
}
