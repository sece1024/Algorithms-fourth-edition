package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * API:
 * UF(int N) ��ʼ��N������
 * void  union(int p, int q) ��p��q֮�����һ������
 * int find(int p)   p���ڷ����ı�ʶ��
 * boolean connected(int p, int q)   ���p��q������ͬһ���������򷵻�true
 * int count()   ��ͨ��������Ŀ
 * */
// quick-union
public class UF_QuickUnion {
    private int[] id;       // ����id(�Դ�����Ϊ����)
    private int count;      // ��������
    public UF_QuickUnion(int N){
        // ��ʼ������id����
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;      // ����id[i]�ķ���������i
        }
    }

    public int count(){ return count; }
    public boolean connected(int p, int q){ return find(p) == find(q);}
    public int find(int p){
        // �ҳ�����������
        while (p != id[p])  p = id[p];
        return p;
    }
    public void union(int p, int q){
        // ��p��q�ĸ��ڵ�ͳһ
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)  return; // ���ڵ���ͬ������ͬһ������

        id[pRoot] = qRoot;          // ���򣬽�p�ĸ��ڵ����ӵ�q�ĸ��ڵ�
        count--;
    }

    // ��������ļ�Ŀ¼ D:\temp\algs4-data\largeUF.txt
    public static void main(String[] args) {
        int N = StdIn.readInt();        // ��ȡ��������
        UF_QuickUnion uf = new UF_QuickUnion(N);
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
