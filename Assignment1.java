import java.util.Iterator;

public class ShoppingList<E> implements Iterable <E> {
    public Node<E> head;
    public Node<E> tail;
    public int size = 0;


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static class Node<E> {
        public String element;
        public Node<E> prev;
        public Node<E> next;
        public Node(String e, Node <E> p, Node <E> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

        public void print() {
            System.out.println("Element stored is " + this.element);
        }
    }


    // constructors follow per JAVA convention

    public ShoppingList() {
        // The linked list starts with size of 0 and it contains two Nodes each with empty data.
        int size = 0;
        Node <E> head = null;
        Node <E> tail = null;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    //adds String to the end or the tail of a linked List
    public void add(String newItem) {
        if (isEmpty()) {
            head = tail = new Node<E>(newItem, null, null);
        } else {
            tail.next = new Node<E>(newItem, tail, null);
            tail = tail.next;
        }

        size++;

    }
    public void removeFirst(){
            if (isEmpty())throw new RuntimeException("Empty List");
            head = head.next;
            --size;
            if (isEmpty()) tail = null;
            else head.prev = null;

    }
    public void removeLast(){
        if (isEmpty()) throw new RuntimeException("Empty List");
            tail = tail.prev;
            --size;
            if(isEmpty()) head = null;

            else tail.next = null;
    }


    public void remove(String oldItem) {
        Node<E> traverse;

        for(traverse = head; traverse!= null; traverse = traverse.next){
            if(oldItem.equals(traverse.element)){
                //If it's the first or last node in list calls other functions
                if(traverse.prev == null) {removeFirst();}
                if(traverse.next == null) {removeLast();}
                else{
                //Rewiring the Nodes
                traverse.next.prev = traverse.prev;
                traverse.prev.next = traverse.next;
                //Data Cleanup
                traverse.element = null;
                traverse = traverse.prev = traverse.next = null;

                --size;
                }
            }
        }


    }

    public void print() {
        Node <E> traverse;
        for(traverse = head; traverse!= null; traverse = traverse.next){
            System.out.println(traverse.element);
        }

    }

    public int numItem() {
        return size;

    }
}
