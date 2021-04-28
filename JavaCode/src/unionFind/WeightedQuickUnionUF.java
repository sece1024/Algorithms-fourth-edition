package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// ��Ȩquick-union
public class WeightedQuickUnionUF {
    private int[] id;   // ����������
    private int[] sz;   // (�ɴ���������)�������ڵ�����Ӧ�ķ����Ĵ�С
    private int count;  // ��ͨ����������
    public WeightedQuickUnionUF(int N){
        count = N;      // ��ʼ��ʱ��N����ͨ����
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;  // ���������ͨ���������Լ�
        }
        sz = new int[N];// ������С(Ȩ��)
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }
    // ������
    public int count(){ return count;}

    // ���Ҹ��ڵ�
    public int find(int p){
        while(p != id[p])   p = id[p];
        return p;
    }
    // �鿴�Ƿ���ͨ
    public boolean connected(int p, int q){ return find(p) == find(q);}

    // ����
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j)  return;

        // ��С�����ڵ����ӵ������ĸ��ڵ�
        if (sz[i] < sz[j])  { id[i] = j; sz[j] += sz[i];}
        else    { id[j] = i; sz[i] += sz[j];}
        count--;
    }

    public static void main(String[] args){
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();    // ��ȡ������
            int q = StdIn.readInt();
            if(uf.connected(p,q))   continue;
            uf.union(p, q);             // �鲢����
            // StdOut.println(p + " " + q);// ��ӡ����
        }
        StdOut.println(uf.count() + "components");

    }
}
