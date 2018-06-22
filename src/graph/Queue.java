package graph;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Integer> elements;

   public Queue(){
       elements = new ArrayList<>();
   }

   public void enqueue(int e){
       elements.add(e);
   }

   public int dequeue(){
       return elements.remove(0);
   }

   public boolean isEmpty(){
       return elements.isEmpty();
   }
}
