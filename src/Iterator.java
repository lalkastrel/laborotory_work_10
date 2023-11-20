import java.util.NoSuchElementException;

public interface Iterator<T> {
    T first() throws NoSuchElementException;
    T next() throws IndexOutOfBoundsException;
    boolean hasNext();
}
