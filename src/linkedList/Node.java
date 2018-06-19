package linkedList;

import java.util.Optional;

public class Node {
    private int _data;
    private Optional<Node> _next;

    public Node(int d){
        _data = d;
        _next = Optional.empty();
    }

    public int data(){ return _data;}
    public void setData(int d){ _data = d; }
    public void setNext(Optional<Node> n){ _next = n;}
    public Optional<Node> next(){
        return _next;
    }
}
