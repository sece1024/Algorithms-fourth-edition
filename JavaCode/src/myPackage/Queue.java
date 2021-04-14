package myPackage;
/*
 Queue.java
 Describe: ���Ͷ���
 author: HGX
 time: 2021.4.14
 */

/*
* API:
* boolean isEmpty()
* int size()
* void enqueue()
* Item dequeue()
* */

import java.util.Iterator;
import java.util.ListIterator;

public class Queue<Item> implements Iterable{
    private Node first;     // ָ��������ӽ�������
    private Node last;      // ָ�������ӽ�������
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public int size() { return N; }
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())   first = last;       // ��ʼʱ����Ϊ�գ�first��lastָ��ͬһ�����
        else    oldLast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty())   last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator(){ return new ListIterator(); }
    private class ListIterator implements Iterator<Item>{
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = first.item;
            first = first.next;
            return item;
        }

        @Override
        public void remove() {}
    }


}
