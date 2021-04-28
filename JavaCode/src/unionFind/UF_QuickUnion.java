package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * API:
 * UF(int N) 初始化N个触点
 * void  union(int p, int q) 在p和q之间添加一条连线
 * int find(int p)   p所在分量的标识符
 * boolean connected(int p, int q)   如果p和q存在于同一个分量中则返回true
 * int count()   连通分量的数目
 * */
// quick-union
public class UF_QuickUnion {
    private int[] id;       // 分量id(以触点作为索引)
    private int count;      // 分量数量
    public UF_QuickUnion(int N){
        // 初始化分量id数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;      // 触电id[i]的分量名称是i
        }
    }

    public int count(){ return count; }
    public boolean connected(int p, int q){ return find(p) == find(q);}
    public int find(int p){
        // 找出分量的名称
        while (p != id[p])  p = id[p];
        return p;
    }
    public void union(int p, int q){
        // 将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)  return; // 根节点相同，属于同一个连接

        id[pRoot] = qRoot;          // 否则，将p的根节点连接到q的根节点
        count--;
    }

    // 大的数据文件目录 D:\temp\algs4-data\largeUF.txt
    public static void main(String[] args) {
        int N = StdIn.readInt();        // 读取触点数量
        UF_QuickUnion uf = new UF_QuickUnion(N);
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
