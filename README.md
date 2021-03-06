# Algorithms Fourth Edition

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

