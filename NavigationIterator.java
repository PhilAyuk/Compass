import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavigationIterator<T> implements Iterator<T> {
    private final T[] items;
    private final int size;
    private int index;

    public NavigationIterator(T[] items, int size) {
        this.items = items;
        this.size = size;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < size;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[index++];
    }
}

