
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sieves
{
    public static void main(String[] args)
    {
        boolean verboseOutput=false; //Change to true if you want verbose marked lines to output in IDE.

        if ( args.length == 1 ) verboseOutput = args[0].equalsIgnoreCase("--VERBOSE");

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter an integer value of N: ");
        int n = kb.nextInt();

        // 1. Create a queue named queueOfIntegers, enqueue it with the
        // consecutive integers 2 through n.

        Queue<Integer> queueOfIntegers = new LinkedList<>(); //Queue declaration

        for(int i = 2; i <= n; i++){      //Enqueues integers 2 through n
            queueOfIntegers.add(i);
        }

        // 2. Create an empty queue to store primes, perhaps named queueOfPrimes.

        Queue<Integer> queueOfPrimes = new LinkedList<>(); //Queue declaration

        int p;

        do
        {
            // 3. Get the next prime number, p, by removing the first value in queueOfNumbers.
            p = queueOfIntegers.remove();
            if ( verboseOutput ) System.out.println("Dequeuing a prime number: "+p);

            // 4. Enqueue the value of p into queue of primes.
            queueOfPrimes.add(p);
            if ( verboseOutput ) { System.out.print("Content of: queueOfPrimes: "); System.out.println(queueOfPrimes); }

            int size = queueOfIntegers.size();

            if ( size==1 )
            {
                if ( queueOfIntegers.peek() % p != 0 ) queueOfPrimes.add(queueOfIntegers.remove());
                size--;
            }

            for(int i=0;i<size;i++)
            {
                int value=queueOfIntegers.remove();

                if ( value % p != 0 )
                {
                    // value is not divisible by p, kick it to the end of the queue again
                    queueOfIntegers.add(value);
                }
            }

            if ( verboseOutput ) { System.out.print("Content of: queueOfIntegers: "); System.out.println(queueOfIntegers); }

        } while ( p < (int)Math.sqrt( (double)n-1 ) );

        // copy what's left in the queueOfIntegers to queueOfPrimes
        while( !queueOfIntegers.isEmpty() ) queueOfPrimes.add(queueOfIntegers.remove());

        System.out.print("queueOfPrimes: "); System.out.println(queueOfPrimes);

    }

}