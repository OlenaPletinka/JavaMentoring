package com.epam.exercises.circularbuffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CircularBuffer<T> {
    private Object[] buffer;
    private int bufferSize;
    private int head;
    private int tail;
    private int length;

    CircularBuffer(int bufferSize) {
        this.buffer = new Object[bufferSize];
        this.bufferSize = bufferSize;
        this.head = 0;
        this.tail = 0;
        this.length = 0;
    }

    void put(T t) {
        if (isEmpty() || head != tail) {
            addElement(t);
        } else {
            throw new CircularBufferOverflowException("The buffer is full");
        }
    }

    boolean isEmpty() {
        return length == 0;
    }

    T get() {
        if (!isEmpty()) {
            tail = (tail + 1) % bufferSize;
            length--;
            return (T) buffer[tail - 1];
        } else {
            throw new CircularBufferEmptyException("The buffer is empty");
        }
    }

    Object[] toObjectArray() {
        Object[] result = new Object[length];
        int counter = tail;
        for (int i = 0; i < length; i++) {
            result[i] = buffer[counter];
            counter = (counter + 1) % bufferSize;
        }
        return result;
    }

    T[] toArray() {
        if (isEmpty()){
            throw new CircularBufferEmptyException("The buffer is empty");
        }

        T[] result = (T[]) java.lang.reflect.Array
                .newInstance(((T) (this.buffer[0])).getClass(), length);
        int counter = tail;
        for (int i = 0; i < length; i++) {
            result[i] = (T) buffer[counter];
            counter = (counter + 1) % bufferSize;
        }
        return result;
    }

    List<T> asList() {
        return Arrays.asList(toArray());
    }

    void addAll(List<? extends T> toAdd) {
        if ((length + toAdd.size()) <= bufferSize) {
            for (T t : toAdd) {
                addElement(t);
            }
        } else {
            throw new CircularBufferOverflowException("There is not enough free space in the buffer to add all elements.");
        }
    }

    void sort(Comparator<? super T> comparator) {
        Arrays.sort((T[]) buffer, comparator);
    }

    private void addElement(T t) {
        buffer[head] = t;
        head = (head + 1) % bufferSize;
        length++;
    }

    @Override
    public String toString() {
        return "CircularBuffer{" +
                "buffer=" + Arrays.toString(buffer) +
                ", bufferSize=" + bufferSize +
                ", head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
