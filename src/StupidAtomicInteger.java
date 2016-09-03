import java.util.concurrent.atomic.AtomicInteger;

public class StupidAtomicInteger {
    private int current;

    public void compareAndSwap(int offsetToAdd) {
        while (true) {
            int old = current;
            int newValue = old + offsetToAdd;
            if (current == old) {
                current = newValue;
                return;
            }
        }
    }

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(10);
        int result = i.getAndUpdate(old -> {
            int q = old * 85 - 12 - old;
            return q + 45 * old;
        });
    }
}
