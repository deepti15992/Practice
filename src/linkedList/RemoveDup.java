package linkedList;

import java.util.HashSet;
import java.util.Optional;

public class RemoveDup {

    public static void main(String[] args){

        /**
         * Case 1 : 1 2 3 4 3 2 1 5
         * Case 2 : 1 1 1
         * Case 3 :
         * Case 4 : 9 8 7
         * Case 5 : 6
         **/

        System.out.println("Case 1 : 1 2 3 4 3 2 1 5");
        int[] data = {1,2,3,4,3,2,1,5};
        removeDuplicates(new LinkedList(data)).printList();
        rmDup(new LinkedList(data)).printList();


        System.out.println("Case 2 : 1 1 1");
        int[] d2 = {1,1,1};
        removeDuplicates(new LinkedList(d2)).printList();
        rmDup(new LinkedList(d2)).printList();


        System.out.println("Case 3 :  ");
        removeDuplicates(new LinkedList()).printList();
        rmDup(new LinkedList()).printList();


        System.out.println("Case 4 : 9 8 7");
        int[] d4 = {9,8,7};
        removeDuplicates(new LinkedList(d4)).printList();
        rmDup(new LinkedList(d4)).printList();


        System.out.println("Case 5 : 6");
        int[] d5 = {6};
        removeDuplicates(new LinkedList(d5)).printList();
        rmDup(new LinkedList(d5)).printList();

    }

    public static LinkedList removeDuplicates(LinkedList linkedList){
        if(!linkedList.head().isPresent()){
            return linkedList;
        }
        HashSet<Integer> set = new HashSet<>();
        Node prev = linkedList.head().get();
        Optional<Node> n = linkedList.head();
        while( n.isPresent()){
            Node current = n.get();
            if(set.contains(current.data())){
                prev.setNext(current.next());
            }else{
                set.add(current.data());
                prev = current;
            }
            n = current.next();
        }
        return linkedList;
    }

    public static LinkedList rmDup(LinkedList linkedList){
        if(!linkedList.head().isPresent()){
            return linkedList;
        }
        Optional<Node> current = linkedList.head();
        while(current.isPresent()){
            int currentData = current.get().data();
            Node prev = current.get();
            Optional<Node> n = current.get().next();
            while(n.isPresent()){
                if(n.get().data() == currentData){
                    prev.setNext(n.get().next());
                }else {
                    prev = n.get();
                }
                n = n.get().next();
            }
            current = current.get().next();
        }
        return linkedList;
    }

}


