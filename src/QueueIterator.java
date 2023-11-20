import java.util.NoSuchElementException;

public class QueueIterator<T> implements Iterator<T> {
    private final Queue<T> queue;
    private int current;
    QueueIterator(Queue<T> queue) {
        this.queue = queue;
        current = -1;
    }

    @Override
    public T first() throws NoSuchElementException {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        current = 0;
        return queue.get(current);
    }

    @Override
    public T next() throws IndexOutOfBoundsException {
        current++;
        return queue.get(current);
    }

    @Override
    public boolean hasNext() {
        return current < queue.size() - 1;
    }
}
