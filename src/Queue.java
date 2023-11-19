import java.util.*;

public class Queue<T> {
    private List<T> queue;

    Queue() {
        queue = new ArrayList<>();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public boolean equals(Object obj) {
        return queue.equals(obj);
    }

    public String toString() {
        return queue.toString();
    }

    public T front() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }

    public T back() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getLast();
    }

    public void push(T value) {
        queue.add(value);
    }

    public void pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        queue.removeFirst();
    }

    public void pushAll(Collection<? extends T> collection) {
        queue.addAll(collection);
    }





}
