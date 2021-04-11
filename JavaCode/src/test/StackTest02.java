package test;

import edu.princeton.cs.algs4.StdIn;
import myPackage.Stack;


public class StackTest02 {
    public static void main(String[] args) {
        Stack st = new Stack();

        while(!StdIn.isEmpty()){
            String str = StdIn.readString();
            if (!str.equals("-"))   st.push(str);
            else{
                if (!st.isEmpty()) System.out.println(st.pop());
            }
        }
        System.out.println("left on stack: "+ st.size());
    }
}
