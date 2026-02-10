package queues;

/**
 * Basic Queue interface defining queue operations (FIFO).
 */
public interface Queue<T> {

    /**
     * Adds an element to the rear of the queue.
     */
    void enqueue(T element);

    /**
     * Removes and returns the element at the front of the queue.
     */
    T dequeue();

    /**
     * Returns the element at the front of the queue without removing it.
     */
    T peek();

    /**
     * Returns the number of elements in the queue.
     */
    int size();

    /**
     * Returns true if the queue is empty.
     */
    boolean isEmpty();

    /**
     * Removes all elements from the queue.
     */
    void clear();
}
