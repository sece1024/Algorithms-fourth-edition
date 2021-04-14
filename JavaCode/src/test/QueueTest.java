package test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import myPackage.Queue;

public class QueueTest {
    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
       /* q.enqueue("hello");
        q.enqueue("world");
        System.out.println(q.dequeue());*/
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))    q.enqueue(item);
            else if(!q.isEmpty()) StdOut.print(q.dequeue()+" ");

        }

        StdOut.println("("+q.size()+") left on queue");
    }
}
