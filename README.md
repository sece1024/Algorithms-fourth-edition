# Algorithms Fourth Edition

标准输入

>  `StdIn`库从标准输入流中获取数据, 默认状态下系统会将标准输出定向到终端窗口——你输入的内容就是输入流(由<ctrl-d>或<ctrl-z>结束)



## 第1章 基础

### 数组

> 起别名：将一个数组变量赋予另一个变量，那么两个变量将会指向同一个数组

```java
// ...
int N = 3;
int 1 = 0;
int[] a = new int[N];
a[i] = 1234;
int[] b = a;
b[i] = 5678;	// a[i]的值也会变成5678
```

**复制数组应声明、创建并初始化一个新的数组**

```java
int[] b;			// 声明
b = new int[N];		// 创建
for(int i=0;i<N;i++){
    b[i] = a[i];	// 初始化
}
    
```



### 迭代器

> 迭代器`Iterator`是一个实现了`hasNext()`和`next()`方法的类对象

由以下接口定义：

```java

public interface Iterator<Item>
{
    boolean hasNext();
    Item next();
    void remove();
}
```



```java
//`iterator()`方法本身只是简单地从实现了Iterator接口的类对象中返回一个对象
public Iterator<Item> iterator(){ return new ListIterator(); }// 保证了类必然会实现方法：hasNext(), next(), remove()供用例的foreach语句使用

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
```



### 链表

> **链表**是一种递归的数据结构，它或者为空(null)，或者是指向一个结点(node)的引用，该结点含有一个泛型的元素和一个指向另一条链表的引用



```java
// 结点
private class Node
{
    Item item;
    Node next;
}
```

### union-find

**API**

```java
/*
* API:
* UF(int N) 初始化N个触点
* void  union(int p, int q) 在p和q之间添加一条连线
* int find(int p)   p所在分量的标识符
* boolean connected(int p, int q)   如果p和q存在于同一个分量中则返回true
* int count()   连通分量的数目
* */
```

## 第二章 排序

### Comparable 接口

> 在Java中，元素通常都是对象，对主键的描述则是通过一种内置的机制来完成。

# 一些问题

## 程序运行

### 在控制台运行

1. 需要导入自己写的类时

   * 如果被导入类和当前类不在同一个文件夹，需要cd到两个类的父路径中
   * 并且提前将两个类编译出`.class`文件

   

## 找不到或无法加载主类

*包下的类，编译成源文件(.class)以后，需要在包的上一级目录下运行，类目前面需要带包名并且以'.'隔开；*