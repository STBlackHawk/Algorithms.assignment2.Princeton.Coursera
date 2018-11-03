
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args){

        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> Random = new RandomizedQueue();

        while(!StdIn.isEmpty()){

            String i = StdIn.readString();

            Random.enqueue(i);

        }

        if (Random.isEmpty()){
            StdOut.println("Your Dequeue is empty");

        }

        for (int j = 0; j < k; j++) {
            StdOut.println(Random.dequeue());
        }




    }

}
