package heaps;

/**
 * Priority queue interface defining basic priority queue operations.
 */
public interface PriorityQueue<T> {

    /**
     * Inserts an element into the priority queue.
     */
    void insert(T element);

    /**
     * Removes and returns the element with highest priority.
     */
    T extract();

    /**
     * Returns the element with highest priority without removing it.
     */
    T peek();

    /**
     * Returns the number of elements in the priority queue.
     */
    int size();

    /**
     * Returns true if the priority queue is empty.
     */
    boolean isEmpty();

    /**
     * Removes all elements from the priority queue.
     */
    void clear();
}
