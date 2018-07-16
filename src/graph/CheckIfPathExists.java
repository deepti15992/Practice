package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckIfPathExists {
    public static void main(String[] args) {

    }

    public boolean pathVtoU(Node u, Node v, Graph g) throws Exception{
        Queue vq = new Queue();
        Queue uq = new Queue();
        vq.enqueue(v.id);
        uq.enqueue(u.id);
        while(!vq.isEmpty() && !uq.isEmpty()) {
                Node vNode = g.getVertex(vq.dequeue());
                vNode.v_visited = true;
                Node uNode = g.getVertex(uq.dequeue());
                uNode.u_visited = true;
                if (vNode.u_visited || uNode.v_visited) {
                    return true;
                }
                g.updateVertex(uNode);
                g.updateVertex(vNode);
                vNode.neighbours.forEach(vertex -> {
                    try {
                        if (!g.getVertex(vertex).v_visited) {
                            vq.enqueue(vertex);
                        }
                    }catch (Exception ex){
                        //log
                    }
                });
                uNode.neighbours.forEach(vertex -> {
                    try {
                        if (!g.getVertex(vertex).u_visited) {
                            vq.enqueue(vertex);
                        }
                    }catch (Exception e){
                        //log
                    }
                });

        }
        return false;
    }

    public boolean pathUtoV(Node u, Node v, Graph g) throws Exception{
        Queue q = new Queue();
        q.enqueue(u.id);
        while(!q.isEmpty()){
            Node node = g.getVertex(q.dequeue());
            if(node.id == v.id){
                return true;
            }
            node.visit();
            g.updateVertex(node);
            node.neighbours.forEach( vertex -> {
                try {
                    if (!g.getVertex(vertex).visited) {
                        q.enqueue(vertex);
                    }
                }catch(Exception ex){
                }
            });
        }
        return false;
    }

    class Node{
        public int id;
        public List<Integer> neighbours;
        public boolean visited;
        public boolean u_visited;
        public boolean v_visited;
        public Node(int id){
            this.id = id;
            visited = false;
            v_visited = false;
            u_visited = false;
            neighbours = new ArrayList<>();
        }
        public void visit(){
            visited = true;
        }
    }

    class Graph{
        public HashMap<Integer, Node> vertices;
        public Graph(){
            vertices = new HashMap<>();
        }

        public void updateVertex(Node node){
            vertices.put(node.id, node);
        }

        public Node getVertex(int value) throws Exception{
            if(vertices.containsKey(value)){
                return vertices.get(value);
            }
            throw new Exception("Vertex not present in graph for value " + value);
        }


    }
}
