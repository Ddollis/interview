package Mule;

import java.util.ArrayList;
import java.util.Vector;

public class ArraylistMultiThread {
    static Vector<Integer> a1 = new Vector<>();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                a1.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(a1.size());
    }
}
