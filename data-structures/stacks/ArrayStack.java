package stacks;

import java.util.EmptyStackException;

/**
 * Array-based stack implementation.
 */
public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top;

    public ArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    @Override
    public void push(T element) {
        ensureCapacity();
        elements[++top] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = (T) elements[top];
        elements[top--] = null;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elements[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= top; i++) {
            elements[i] = null;
        }
        top = -1;
    }

    private void ensureCapacity() {
        if (top == elements.length - 1) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
}
