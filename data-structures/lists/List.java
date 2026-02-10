package lists;

import java.util.Iterator;

/**
 * Basic List interface defining common list operations.
 */
public interface List<T> extends Iterable<T> {

    /**
     * Adds an element to the end of the list.
     */
    void add(T element);

    /**
     * Adds an element at the specified index.
     */
    void add(int index, T element);

    /**
     * Removes and returns the element at the specified index.
     */
    T remove(int index);

    /**
     * Returns the element at the specified index.
     */
    T get(int index);

    /**
     * Returns the number of elements in the list.
     */
    int size();

    /**
     * Returns true if the list is empty.
     */
    boolean isEmpty();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Returns an iterator over the elements in the list.
     */
    Iterator<T> iterator();
}
