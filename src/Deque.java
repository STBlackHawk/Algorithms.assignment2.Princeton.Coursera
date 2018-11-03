

import java.util.Iterator;
import java.util.NoSuchElementException;






public class Deque<Item> implements Iterable<Item> {

    private class Node{
        private Item key;
        private Node next;
        private Node prev;
    }


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

        Node temp = new Node();

        temp.key = item;

        temp.next = front;

        temp.prev = null;

        if (front == null){

            front = rear = temp;

        } else  {
            front.prev = temp;
            front = temp;
        }



        size++;

    }


    public void addLast(Item item){
        if (item == null){throw new IllegalArgumentException();}

        Node temp = new Node();
        temp.key = item;

        temp.prev = rear;

        temp.next = null;

        if (rear == null){
            front = rear = temp;
        } else  {
            rear.next = temp;
            rear = temp;
        }

        rear = temp;

        size++;

    }


    public Item removeFirst(){
        if(size == 0){throw new NoSuchElementException();}

        Node temp = front;

        front = front.next;

        if(front==null){ }
        else {front.prev = null;}

        size--;

        return temp.key;


    }

    public Item removeLast(){
        if(size == 0){throw new NoSuchElementException();}

        Node temp = rear;

        rear = rear.prev;

        if(rear==null){}
        else {rear.next = null;}
        size--;

        return temp.key;
    }

    @Override
    public Iterator<Item> iterator(){

        return new dequeIterator();
    }



    private class dequeIterator implements Iterator<Item>{

        private Node current = front;
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
