import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CopyOnWriteList<T> {
    private volatile List<T> list = new ArrayList<T>();

    public synchronized void add(T t){
        List<T> copy = new ArrayList<>(list);
        copy.add(t);

        list = copy;
    }

    public synchronized void remove(T t){
        List<T> copy = new ArrayList<>(list);
        copy.remove(t);

        list = copy;
    }

    public T get(int index){
        return list.get(index);
    }

    public List<T> all() {
        return new ArrayList<>(list);
    }
}
