import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] rDeque;
    private int size;

    public RandomizedQueue(){
        rDeque = (Item[]) new Object[2];

        size = 0;
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public int size(){
        return size;
    }

    private void resize(int capacity){
        assert capacity >= size;

        Item[] temp = (Item[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            temp[i] = rDeque[i];
            rDeque = temp;
        }

    }


    public void enqueue(Item item){
        if(item == null) throw new IllegalArgumentException();


        if (size == rDeque.length) resize(2*rDeque.length);

        rDeque[size++] = item;
    }

    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("dequeue is empty");

        int rand = StdRandom.uniform(size);
        Item item = rDeque[rand];
        rDeque[rand] = rDeque[size-1];
        rDeque[size-1] = null;
        size--;

        if( size > 0 && size == rDeque.length/4) resize(rDeque.length/2);

        return item;
    }



    public Item sample(){
        if(isEmpty()) throw new NoSuchElementException("dequeue is empty");
        return rDeque[StdRandom.uniform(size)];
    }


    @Override
    public Iterator<Item> iterator(){

        return new RandomizedQueueIterator();
    }



    private class RandomizedQueueIterator implements Iterator<Item>{

        private int pointer;
        private Item holder = null;

        public RandomizedQueueIterator(){
            pointer = size-1;
        }



        public boolean hasNext(){return pointer >= 0; }
        public void remove(){throw new UnsupportedOperationException();}

        public Item next(){
            if (!hasNext())throw new NoSuchElementException();

            Item temp = rDeque[StdRandom.uniform(size)];
            if(temp == holder){
                next();
            }

            pointer--;
            return temp;

        }

    }


}
