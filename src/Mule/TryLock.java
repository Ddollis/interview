package Mule;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (this.lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 获得了lock1");
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " 获得了lock2");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }

            }

        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 获得了lock2");
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " 获得了lock1");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TryLock(1));
        Thread t2 = new Thread(new TryLock(2));
        t1.start();
        t2.start();
    }
}
