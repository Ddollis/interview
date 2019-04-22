package Mule;

public class JoinMain {

    public volatile static int i = 0;

    public static class AddMethod extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000; i++) {

            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new AddMethod();
        t.start();
        t.join();
        System.out.println(i);
    }
}
