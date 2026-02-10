package heaps;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Min heap implementation of priority queue.
 * Elements with smaller values have higher priority.
 */
public class MinHeap<T> implements PriorityQueue<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] heap;
    private int size;
    private Comparator<T> comparator;

    public MinHeap(Comparator<T> comparator) {
        this.heap = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    @Override
    public void insert(T element) {
        ensureCapacity();
        heap[size] = element;
        heapifyUp(size);
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T extract() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = (T) heap[0];
        heap[0] = heap[--size];
        heap[size] = null;
        if (size > 0) {
            heapifyDown(0);
        }
        return min;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return (T) heap[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            heap[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare((T) heap[index], (T) heap[parentIndex]) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    @SuppressWarnings("unchecked")
    private void heapifyDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size &&
                comparator.compare((T) heap[leftChild], (T) heap[smallest]) < 0) {
                smallest = leftChild;
            }

            if (rightChild < size &&
                comparator.compare((T) heap[rightChild], (T) heap[smallest]) < 0) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            Object[] newHeap = new Object[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
    }
}
