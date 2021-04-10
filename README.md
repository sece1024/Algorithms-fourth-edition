# Algorithms Fourth Edition

## algs4.jar

### 标准输入

>  `StdIn`库从标准输入流中获取数据, 默认状态下系统会将标准输出定向到终端窗口——你输入的内容就是输入流(由<ctrl-d>或<ctrl-z>结束)



# 第1章 基础

## 数组

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



## 迭代器

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

