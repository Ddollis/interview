package Mule;

public class ThreadGroupName implements Runnable {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("PrintGroup");
        Thread T1 = new Thread(group, new ThreadGroupName(), "T1");
        Thread T2 = new Thread(group, new ThreadGroupName(), "T2");
        T1.start();
        T2.start();
        System.out.println(group.activeCount());
        group.list();
    }

    @Override
    public void run() {
        String str = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("now is" + str);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
