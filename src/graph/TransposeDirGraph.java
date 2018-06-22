package graph;

public class TransposeDirGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        //1 -> 2 4 5
        n1.neighbours.add(2);
        n1.neighbours.add(4);
        n1.neighbours.add(5);
        //3 -> 1
        n3.neighbours.add(1);
        //4 -> 3
        n4.neighbours.add(3);
        //5 -> 2 4
        n5.neighbours.add(2);
        n5.neighbours.add(4);

        graph.vertices.add(n1);
        graph.vertices.add(n2);
        graph.vertices.add(n3);
        graph.vertices.add(n4);
        graph.vertices.add(n5);

        graph.printAdjList();
        System.out.println("----- Output ------");
        TransposeGraph transposeGraph = new TransposeGraph();
        transposeGraph.transpose(graph).printAdjList();

    }
}
class TransposeGraph{
    public Graph transpose(Graph g){
        Graph transpose = new Graph();
        g.vertices.forEach(vertex -> {
            GraphNode newNode = new GraphNode(vertex.value);
            transpose.vertices.add(newNode);
        });

        g.vertices.forEach(vertex -> {
            vertex.neighbours.forEach(n -> {
                GraphNode node = transpose.getVertex(n);
                node.neighbours.add(vertex.value);
                transpose.vertices.add(node);
            });
        });
        return transpose;
    }
}
