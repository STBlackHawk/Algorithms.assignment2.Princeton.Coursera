import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.NoSuchElementException;


class Node<Item>{
    Item key;
    Node next;
    Node prev;

    public Node(Item item){
        this.key = item;
        this.next = null;
        this.prev = null;
    }

}



public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Node front;
    private Node rear;



    public Deque(){
    front = null;
    rear = null;
    size = 0;

    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        if (item == null){throw new IllegalArgumentException();}

        Node temp = new Node(item);

        this.front.prev = temp;

        temp.next = this.front;

        temp.prev = null;

        this.front = temp;

        size++;

    }


    public void addLast(Item item){
        if (item == null){throw new IllegalArgumentException();}

        Node temp = new Node(item);

        this.rear.next = temp;

        temp.prev = this.rear;

        temp.next = null;

        this.rear = temp;

        size++;

    }


    public Item removeFirst(){
        if(size == 0){throw new NoSuchElementException();}

        Node temp = new Node (front);

        this.front = this.front.next;

        this.front.prev = null;

        size--;

        return (Item)temp;


    }

    public Item removeLast(){
        if(size == 0){throw new NoSuchElementException();}

        Node temp = new Node (rear);

        this.rear = this.rear.prev;

        this.rear.next = null;

        size--;

        return (Item)temp;
    }

    @Override
    public Iterator<Item> iterator(){

        return new dequeIterator();
    }



    private class dequeIterator implements Iterator<Item>{

        private Node current = new Node(front);
        public boolean hasNext(){return current.next != null;}
        public void remove(){throw new UnsupportedOperationException();}

        public Item next(){
            if (!hasNext())throw new NoSuchElementException();
            Item item = (Item) current.key;
            current = current.next;
            return (Item) item;


        }




    }


}
