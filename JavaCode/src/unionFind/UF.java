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
// quick-find
public class UF {
    private int[] id;       // 分量id(以触点作为索引)
    private int count;      // 分量数量
    public UF(int N){
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
        return id[p];       // 返回id[p]的连通分量
    }
    public void union(int p, int q){
        // 将p和q归并到相同的分量中
        int pID = id[p];
        int qID = id[q];

        // 已经在相同分量中，则不进行任何操作
        if(pID == qID)  return;

        // 将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++) {   // 遍历整个数组，修改所有分量为pID的索引
            if(pID == id[i])    id[i] = qID;
        }

        count--;
    }

// 大的数据文件目录 D:\temp\algs4-data\largeUF.txt
    public static void main(String[] args) {
        int N = StdIn.readInt();        // 读取触点数量
        UF uf = new UF(N);
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
