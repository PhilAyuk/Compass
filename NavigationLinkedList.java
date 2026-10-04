public class NavigationLinkedList<T> implements Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node prev;
        Node(T data) { this.data = data; }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T value) { addLast(value); }

    public void addFirst(T value) {
        Node n = new Node(value);
        if (head == null) head = tail = n;
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public void addLast(T value) {
        Node n = new Node(value);
        if (tail == null) head = tail = n;
        else {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public T get(int index) { return nodeAt(index).data; }

    public T set(int index, T value) {
        Node n = nodeAt(index);
        T old = n.data;
        n.data = value;
        return old;
    }

    public T remove(int index) {
        Node n = nodeAt(index);
        if (n.prev != null) n.prev.next = n.next;
        else head = n.next;
        if (n.next != null) n.next.prev = n.prev;
        else tail = n.prev;
        size--;
        return n.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return remove(0);
    }

    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        return remove(size - 1);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node nodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index < size / 2) {
            Node n = head;
            for (int i = 0; i < index; i++) n = n.next;
            return n;
        } else {
            Node n = tail;
            for (int i = size - 1; i > index; i--) n = n.prev;
            return n;
        }
    }

    public NavigationIterator<T> iterator() {
        Object[] values = new Object[size];
        Node n = head;
        int i = 0;
        while (n != null) {
            values[i++] = n.data;
            n = n.next;
        }
        @SuppressWarnings("unchecked")
        T[] result = (T[]) values;
        return new NavigationIterator<T>(result, size);
    }
}

