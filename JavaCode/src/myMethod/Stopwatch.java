package myMethod;
// 2021.4.14
// ��ʱ��
public class Stopwatch {
    private final long start;
    public Stopwatch(){ start = System.currentTimeMillis(); }   // ����һ����ʱ��
    public double elapsedTime(){    // ���ش�������������������ʱ��
        long now = System.currentTimeMillis();
        return now;
    }
}
