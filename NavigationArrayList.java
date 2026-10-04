public class NavigationArrayList<T> implements Iterable<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public NavigationArrayList() {
        data = (T[]) new Object[4];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = value;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public T set(int index, T value) {
        checkIndex(index);
        T old = data[index];
        data[index] = value;
        return old;
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = data[index];
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        data[--size] = null;
        return removed;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void clear() {
        for (int i = 0; i < size; i++) data[i] = null;
        size = 0;
    }

    private void ensureCapacity() {
        if (size == data.length) resize(data.length * 2);
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newData[i] = data[i];
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    public NavigationIterator<T> iterator() {
        return new NavigationIterator<T>(data, size);
    }
}

