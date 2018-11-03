import java.util.Iterator;

public class Main {





    public static void main(String[] args) {

        RandomizedQueue<Double> test = new RandomizedQueue<>();

        test.enqueue(1.0);
        double k = test.size();
        test.enqueue(2.0);
        k = test.dequeue();
        test.enqueue(3.0);
        test.enqueue(4.0);
        test.enqueue(5.0);
        int i = test.size();
        Iterator<Double> l = test.iterator();
        while (l.hasNext()) {
            double m = l.next();
        }






    }




}


