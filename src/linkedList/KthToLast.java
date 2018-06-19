package linkedList;

import java.util.Optional;

public class KthToLast {
    public static void main(String[] args){


        System.out.println("Case 1 : 1 2 3 4 5");
        int[] data = {1,2,3,4,5};
        System.out.println("Output " + getKthToLast(new LinkedList(data), 3));

        System.out.println("Case 2 : 1 2 3 4 5 and k=9");
        System.out.println("Output " + getKthToLast(new LinkedList(data), 9));

        System.out.println("Case 3 : k=9");
        System.out.println("Output " + getKthToLast(new LinkedList(), 9));

        System.out.println("Case 4 : 1 2 3 4 5 and k=0");
        System.out.println("Output " + getKthToLast(new LinkedList(data), 0));

        System.out.println("Case 5 : 1 2 3 4 5 and k=1");
        System.out.println("Output " + getKthToLast(new LinkedList(data), 1));
    }

    public static int getKthToLast(LinkedList linkedList, int k){
        if(!linkedList.head().isPresent() || k < 1){
            return -1; //throw exception
        }
        Node start = linkedList.head().get();
        Node offset = start;
        for(int i = 0; i < k; i++){
            if(!offset.next().isPresent()){
                return -1; //throw exception
            }
            offset = offset.next().get();
        }
        //System.out.println("Start " + linkedList.head().get().data());
        //System.out.println("Offset " + offset.data());

        while(offset.next().isPresent()){
            start = start.next().get();
            offset = offset.next().get();
        }
        return start.next().get().data();
    }
}
