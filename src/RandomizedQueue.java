import java.util.Iterator;
import java.util.NoSuchElementException;


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
        if (size == rDeque.length) resize(2*rDeque.length);

        rDeque[size++] = item;
    }

    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException("dequeue is empty");

        Item item = rDeque[size-1];
        rDeque[size-1] = null;
        size--;

        return rDeque[size-1];
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
