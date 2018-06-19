package linkedList;

import java.util.Arrays;
import java.util.Optional;

public class LinkedList {
    private Optional<Node> _head;

    public LinkedList(){
        _head = Optional.empty();
    }

    public LinkedList(int data){
        Node n = new Node(data);
        _head = Optional.of(n);
    }

    public LinkedList(Node n){
        _head = Optional.of(n);
    }

    public LinkedList(int[] inputs){
        Node hed = new Node(inputs[0]);
        _head = Optional.of(hed);
        Node prev = hed;
        for(int i = 1; i < inputs.length; i++){
            Node n = new Node(inputs[i]);
            prev.setNext(Optional.of(n));
            prev = n;
        }
        printList();
    }

    public void printList(){
        StringBuilder list = new StringBuilder(" List : ");
        Optional<Node> n = _head;
        while( n.isPresent()){
            list.append(n.get().data());
            list.append("  ");
            n = n.get().next();
        }
        System.out.println(list);
    }

    public Optional<Node> head(){
        return _head;
    }

    public Optional<Node> setHead( int data){
        Node n = new Node(data);
        _head = Optional.of(n);
        return _head;
    }
}
