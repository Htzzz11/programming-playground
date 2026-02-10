package stacks;

/**
 * Basic Stack interface defining stack operations (LIFO).
 */
public interface Stack<T> {

    /**
     * Pushes an element onto the top of the stack.
     */
    void push(T element);

    /**
     * Removes and returns the element at the top of the stack.
     */
    T pop();

    /**
     * Returns the element at the top of the stack without removing it.
     */
    T peek();

    /**
     * Returns the number of elements in the stack.
     */
    int size();

    /**
     * Returns true if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Removes all elements from the stack.
     */
    void clear();
}
