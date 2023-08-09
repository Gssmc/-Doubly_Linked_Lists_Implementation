public class DoublyLinkedListDemo {
    public static void main(String[]args){
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        list.insertAtBeginning(3);
        list.insertAtBeginning(7);
        list.insertAtBeginning(9);
        //list.insertAtPos(3, 10);
        //list.deleteAtPos(2);
        //list.get(2);
        //list.update(2, 5);
        //list.deleteAtEnd();
        //list.insertAtEnd(5);
        list.search(7);
        list.traversal();
        System.out.println();
        list.traversalRev();
    }
}
