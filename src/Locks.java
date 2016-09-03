import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    private final Lock lock = new ReentrantLock();
    private final Condition readCondition;
    private final Condition writeCondition;

    public Locks() {
        readCondition = lock.newCondition();
        writeCondition = lock.newCondition();
    }

    public void read() {
        lock.lock();
        try {
            while (isEmpty()) {
                try {
                    readCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Object o = doRead();
            writeCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    private Object doRead() {
        return null;
    }

    private boolean isEmpty() {
        return false;
    }

    public void write() {
        lock.lock();
        try {
            while (isFull()) {
                try {
                    writeCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            doWrite();
            readCondition.signal();
        } finally {
            lock.unlock();

        }
    }

    private void doWrite() {

    }

    private boolean isFull() {
        return false;
    }
}
