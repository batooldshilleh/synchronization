import java.util.ArrayList;

public class App {
    private static int shared_mem = 0;

    public static void main(String[] args) throws InterruptedException {
        int N = 677 + 748;
        ArrayList<Thread> threads = new ArrayList<Thread>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < N; i++) {

                    long sleepTime = Thread.currentThread().getId() % 10;
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (App.class) {
                        shared_mem++;
                    }
                }
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        int expected_value = N * N;
        System.out.println("Final counter value is "+shared_mem);
        System.out.println("Expected counter value is "+ expected_value);
        System.out.println("Time taken : " + (end - start));
    }
}