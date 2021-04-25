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
// quick-find
public class UF {
    private int[] id;       // ����id(�Դ�����Ϊ����)
    private int count;      // ��������
    public UF(int N){
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
        return id[p];       // ����id[p]����ͨ����
    }
    public void union(int p, int q){
        // ��p��q�鲢����ͬ�ķ�����
        int pID = id[p];
        int qID = id[q];

        // �Ѿ�����ͬ�����У��򲻽����κβ���
        if(pID == qID)  return;

        // ��p�ķ���������Ϊq������
        for (int i = 0; i < id.length; i++) {   // �����������飬�޸����з���ΪpID������
            if(pID == id[i])    id[i] = qID;
        }

        count--;
    }

// ��������ļ�Ŀ¼ D:\temp\algs4-data\largeUF.txt
    public static void main(String[] args) {
        int N = StdIn.readInt();        // ��ȡ��������
        UF uf = new UF(N);
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
