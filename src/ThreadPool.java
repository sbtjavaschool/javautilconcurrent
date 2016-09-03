import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final BlockingQueue<Runnable> queue
            = new LinkedBlockingQueue<>();

    public void add(Runnable runnable) {
        queue.add(runnable);
    }

    public void worker() {
        try {
            Runnable task = queue.take();
            task.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}