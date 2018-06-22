package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph {
    public List<GraphNode> vertices;
    public Graph(){
        vertices = new ArrayList<>();
    }

    public void printAdjList(){
        vertices.forEach(n -> {
            StringBuilder s = new StringBuilder();
            s.append(n.value);
            s.append(" -> ");
            n.neighbours.forEach(x -> {
                s.append(x);
                s.append(" ");
            });
            System.out.println(s);
        });
    }

    public GraphNode getVertex(int value){
        Optional<GraphNode> v = vertices.stream().filter(x -> x.value == value).findFirst();
        if(v.isPresent()){
            GraphNode n = v.get();
            vertices.remove(n);
            return n;
        }
        return null;
    }

}
