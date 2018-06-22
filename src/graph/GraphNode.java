package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int value;
    public boolean isTransposed;
    public List<Integer> neighbours;
    public GraphNode(int d){
        isTransposed = false;
        value = d;
        neighbours = new ArrayList<>();
    }
}
