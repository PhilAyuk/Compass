public class NavigationStack<T> {
    private NavigationLinkedList<T> list = new NavigationLinkedList<T>();

    public void push(T value) { list.addLast(value); }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.removeLast();
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() { return list.isEmpty(); }
    public int size() { return list.size(); }
    public void clear() { list.clear(); }
}
