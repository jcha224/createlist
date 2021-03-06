package mylistpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Represents basic array-based list.
 * 
 * @author John Chang
 * @version Oct 14, 2016
 * @param <E> is of any object type
 */
public abstract class AbstractArrayMyList<E> implements MyList<E> {

    /**
     * default list capacity.
     */
    protected static final int DEFAULT_CAPACITY = 100;

    /**
     * list of values
     */
    protected E[] elementData;

    /**
     * index of the last element in the list
     */
    protected int size;
    
    /**
     * Constructs an empty list of the given capacity.
     */
   
    public AbstractArrayMyList() {
    	super();
    	elementData = null;
    	size = -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return size + 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == -1;
    }


    /**
     * Creates a comma-separated, bracketed version of the list.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (size == -1) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i <= size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }


    /**
     * Ensures that the underlying array has the given capacity; if not,
     * increases the size by 100.
     * 
     * @param capacity > elementData.length.
     */
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length + 100;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /*********************************************
     * Index list methods follow
     *********************************************/

    /**
     * Returns the index of value.
     * 
     * @param value assigned.
     * @return index of value if in the list, -1 otherwise.
     *
     * {@inheritDoc}
     */
    @Override
    public int getIndex(E value) {
        for (int i = 0; i <= size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Removes value at the given index, replaced with the last index.
     * 
     * @param index <= size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     *
     * {@inheritDoc}
     */
    @Override
    public void removeAtIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        
        elementData[index] = elementData[size];
        elementData[size] = null;
        size--;
    }

    /**
     * Returns the value at the given index in the list.
     * 
     * @param index <= size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * @return the value at the given index in the list.
     *
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    /*********************************************
     * Index list methods end
     *********************************************/

    /*********************************************
     * Iterator list class / methods follow
     *********************************************/

    /**
     * Returns an iterator for this list.
     * 
     * @return an iterator for the list.
     *
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Represents an iterator for the list.
     * 
     * @author BuildingJavaPrograms 3rd Edition
     */
    protected class ArrayListIterator implements Iterator<E> {

        /**
         * current position within the list.
         */
        private int position;

        /**
         * flag that indicates whether list element can be removed.
         */
        private boolean removeOK;

        /**
         * Constructs an iterator for the given list
         */
        public ArrayListIterator() {
            position = 0;
            removeOK = false;
        }

        /**
         * Returns whether there are more list elements.
         * 
         * @return true if there are more elements left, false otherwise
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            return position <= size;
        }

        /**
         * Returns the next element in the iteration.
         * 
         * @throws NoSuchElementException if no more elements.
         * @return the next element in the iteration.
         * @see java.util.Iterator#next()
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        /**
         * Removes the last element returned by the iterator.
         * 
         * @throws IllegalStateException if a call to next has not been made
         *             before call to remove.
         * @see java.util.Iterator#remove()
         */
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            AbstractArrayMyList.this.removeAtIndex(position - 1);
            position--;
            removeOK = false;
        }
        
        /**
         * Resets the iterator to the first list element.
         */
        public void reset() {
        	position = 0;
        }
    }
}
