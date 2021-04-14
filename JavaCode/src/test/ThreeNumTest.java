package test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import myMethod.Stopwatch;
import myMethod.ThreeSum;

// ÔËÐÐÃüÁî£º
// D:\Git\my\Algorithms-fourth-edition\JavaCode\src>java test/ThreeNumTest.java 2000
public class ThreeNumTest {
    public static void main(String[] args) {
/*        int[] a = {1,2,4,5,6,-1,-2,-4,-1,-6,-7};
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.count(a));*/

        int N = Integer.parseInt(args[0]);
        int[] a= new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + "triples " + time + "seconds");

    }
}
