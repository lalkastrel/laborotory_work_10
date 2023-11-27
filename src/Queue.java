import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.*;

public class Queue<T> implements Aggregate<T> {
    private final List<T> queue;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (T queueValue : queue) {
            stringBuilder.append(queueValue).append(' ');
        }
        return stringBuilder.toString();
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

    public T get(int index) throws IndexOutOfBoundsException {
        return queue.get(index);
    }

    @Override
    public Iterator<T> createIterator() {
        return new QueueIterator<>(this);
    }

    public ListModel<T> getListModel() {
        DefaultListModel<T> listModel = new DefaultListModel<>();
        listModel.addAll(queue.stream().toList());
        return listModel;
    }
}
