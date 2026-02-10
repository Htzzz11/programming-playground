package queues;

/**
 * Double-ended queue interface allowing insertion and removal at both ends.
 */
public interface Deque<T> {

    /**
     * Adds an element to the front of the deque.
     */
    void addFirst(T element);

    /**
     * Adds an element to the rear of the deque.
     */
    void addLast(T element);

    /**
     * Removes and returns the element at the front of the deque.
     */
    T removeFirst();

    /**
     * Removes and returns the element at the rear of the deque.
     */
    T removeLast();

    /**
     * Returns the element at the front of the deque without removing it.
     */
    T peekFirst();

    /**
     * Returns the element at the rear of the deque without removing it.
     */
    T peekLast();

    /**
     * Returns the number of elements in the deque.
     */
    int size();

    /**
     * Returns true if the deque is empty.
     */
    boolean isEmpty();

    /**
     * Removes all elements from the deque.
     */
    void clear();
}
