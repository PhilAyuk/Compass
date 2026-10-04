public class NavigationQueue<T> {
    private T[] data;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public NavigationQueue() {
        data = (T[]) new Object[4];
    }

    public void enqueue(T value) {
        if (size == data.length) resize(data.length * 2);
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T value = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return data[front];
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[(front + i) % data.length];
        data = newData;
        front = 0;
        rear = size;
    }
}

