package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 加权quick-union
public class WeightedQuickUnionUF {
    private int[] id;   // 父链接数组
    private int[] sz;   // (由触点索引的)各个根节点所对应的分量的大小
    private int count;  // 连通分量的数量
    public WeightedQuickUnionUF(int N){
        count = N;      // 初始化时有N个连通分量
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;  // 各触点的连通分量名是自己
        }
        sz = new int[N];// 分量大小(权重)
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }
    // 分量数
    public int count(){ return count;}

    // 查找根节点
    public int find(int p){
        while(p != id[p])   p = id[p];
        return p;
    }
    // 查看是否连通
    public boolean connected(int p, int q){ return find(p) == find(q);}

    // 连接
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j)  return;

        // 将小树根节点连接到大树的根节点
        if (sz[i] < sz[j])  { id[i] = j; sz[j] += sz[i];}
        else    { id[j] = i; sz[i] += sz[j];}
        count--;
    }

    public static void main(String[] args){
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();    // 读取整数对
            int q = StdIn.readInt();
            if(uf.connected(p,q))   continue;
            uf.union(p, q);             // 归并分量
            // StdOut.println(p + " " + q);// 打印连接
        }
        StdOut.println(uf.count() + "components");

    }
}
