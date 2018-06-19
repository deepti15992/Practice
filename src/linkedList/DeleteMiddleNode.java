package linkedList;

import java.util.Optional;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        LinkedList linkedList = null;

        for(int k = 1; k < 4; k++){
            System.out.println("------------");
            linkedList = new LinkedList(data);
            Node n = linkedList.head().get();
            for(int i = 0; i < k; i ++){
                n = n.next().get();
            }
            System.out.println("Deleted Node is " + n.data());
            deleteNode(n);
            linkedList.printList();
        }

    }
    private static void deleteNode(Node node){
        Node prev = node;
        while(node.next().isPresent()){
            prev = node;
            node.setData(node.next().get().data());
            node = node.next().get();
        }
        prev.setNext(Optional.empty());
    }
}
