package myPackage;

import java.util.Iterator;

// 栈(链表实现)
/*
* API:
* void push(Item item)
* Item pop()
* boolean isEmpty()
* int size()
* */
public class Stack<Item> implements Iterable {
    private class Node{
        // 结点的嵌套类
        Item item;
        Node next;
    }
    private Node first;
    private int N;
    public boolean isEmpty(){
        return N == 0;  // 或: first == null
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public  Item pop(){
//        Node temp = first;
//        first = first.next;
//        N--;
//
//        return temp.item;
        Item item = first.item;
        first = first.next;
        N--;

        return item;
    }

    public Iterator<Item> iterator(){
        return  new ListIterator();
    }
    private class ListIterator implements Iterator{
        private Node current = first;
        public Item next(){ return first.item; }
        public boolean hasNext(){ return current != null;}
        public void remove(){}

    }
}
