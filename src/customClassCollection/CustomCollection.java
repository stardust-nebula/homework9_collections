package customClassCollection;

import java.util.Arrays;

public class CustomCollection<E> implements ICustomCollection<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] initArray;

    CustomCollection() {
        initArray = new Object[DEFAULT_CAPACITY];
    }

    CustomCollection(int setSize) {
        initArray = new Object[setSize];
    }

    public void add(E elem) {
        if (size == initArray.length) {
            resize();
        }
        initArray[size++] = elem;
    }

    public int size() {
        return size;
    }

    public E getElementByIndex(int index) throws CustomCollectionExceptions {
        if (index >= size || index < 0) {
            throw new CustomCollectionExceptions(index);
        }
        return (E) initArray[index];
    }

    public E deleteElementByIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        Object item = initArray[index];
        int numElements = initArray.length - (index + 1);
        System.arraycopy(initArray, index + 1, initArray, index, numElements);
        size--;
        return (E) item;
    }

    public void clearCollection() {
        for (int i = initArray.length - 1; i >= 0; i--) {
            initArray[i] = null;
        }
    }

    public void resize() {
        int newSize = initArray.length * 2;
        initArray = Arrays.copyOf(initArray, newSize);
    }

    public boolean isElementExist(E elem) {
        for (Object arrayEl : initArray) {
            if (arrayEl != null) {
                if (arrayEl.equals(elem)) {
                    return true;
                }
            }
        }
        return false;
    }
}