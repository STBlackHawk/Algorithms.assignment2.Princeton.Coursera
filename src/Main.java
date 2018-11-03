

public class Main {





    public static void main(String[] args) {

        Deque<Double> test = new Deque<>();

        test.addFirst(1.0);
        test.addFirst(2.0);
        test.addFirst(3.0);
        test.addFirst(4.0);
        test.addLast(5.0);
        int i = test.size();

        double j = test.removeFirst();
        double k = test.removeLast();


    }




}


