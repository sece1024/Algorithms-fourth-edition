package myMethod;
// 2021.4.14
// ͳ���������ж�������֮�͵���0
public class ThreeSum {
    public static int count(int[] a){
        int N = a.length;
        int cnt =  0;
        // ����ѭ��
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i+1; j++) {
                for (int k = 0; k < j+1; k++) {
                    if(a[i] + a[j] + a[k] == 0){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
