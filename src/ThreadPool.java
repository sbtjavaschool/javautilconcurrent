import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final Runnable poisonPill = () -> {
    };
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        pool.add(null);
        pool.add(null);
        pool.add(null);

        //end
        pool.usePoisonPill();
    }

    private void usePoisonPill() {
        add(poisonPill);
        add(poisonPill);
        add(poisonPill);
    }

    public void add(Runnable runnable) {
        queue.add(runnable);
    }

    public void worker() {
        try {
            Runnable task = queue.take();
            if (task == poisonPill) {

            }

            task.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        //logic
    }
}