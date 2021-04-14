package myMethod;
// 2021.4.14
// 计时器
public class Stopwatch {
    private final long start;
    public Stopwatch(){ start = System.currentTimeMillis(); }   // 创建一个计时器
    public double elapsedTime(){    // 返回创建对象以来所经过的时间
        long now = System.currentTimeMillis();
        return now;
    }
}
