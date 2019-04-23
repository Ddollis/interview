package Mule;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapMultiThread {
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static class HashMapAdd implements Runnable {
        int start = 0;

        public HashMapAdd(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = this.start; i < 100; i += 2) {
                map.put(String.valueOf(i), String.valueOf(i * i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new HashMapAdd(0));
        Thread thread2 = new Thread(new HashMapAdd(1));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map.size());
    }
}
