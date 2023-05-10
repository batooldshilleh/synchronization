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
                        //System.out.println("I am thread #"+ Thread.currentThread().getId() +" about to go to sleep for"+Thread.currentThread().getId() % 10+ " nanoseconds");
                    long sleepTime = Thread.currentThread().getId() % 10;
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (App.class) {
                        System.out.println("I am thread #"+Thread.currentThread().getId()+" about to increment the counter, old value was" + shared_mem );
                        shared_mem++;
                        System.out.println("I am thread #"+Thread.currentThread().getId()+" finished incrementing the counter, new value is"+ shared_mem);
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
