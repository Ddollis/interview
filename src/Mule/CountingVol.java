package Mule;

public class CountingVol implements Runnable {
    static CountingVol instance = new CountingVol();
    static volatile int i = 0;

    public static void add() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            synchronized (instance) {
                add();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
