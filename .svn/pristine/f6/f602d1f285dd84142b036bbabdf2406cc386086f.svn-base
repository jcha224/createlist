package mylistpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents basic array-based list.
 * 
 * @author John Chang
 * @version Oct 14, 2016
 * @param <E> is of any object type
 */
public abstract class AbstractLinkedMyList<E> implements MyList<E> {
	/**
     * Reference to the first node in the list.
     */
    protected ListNode<E> front; 
    
    /**
     * Reference to the last node in the list.
     */
    protected ListNode<E> back; 

    /**
     * index of the last list element
     */
    protected int size;  

    /**
     * Constructs an empty list.
     */
    public AbstractLinkedMyList() {
    	super();
        front = null;
        back = null;
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
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E value) {
        return getIndex(value) >= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(E value) {
    	ListNode<E> valueNode = new ListNode<E>(value);
        if (size == -1) {
        	front = valueNode;
        	back = valueNode;
        } else {
        	back.next = valueNode;
        	back = valueNode;
        }
        size++;
    }  

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        front = null;
        back = null;
        size = -1;
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
            String result = "[" + front.data;
            ListNode<E> current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(E value) {
        int location = getIndex(value);
        if (location > -1) 
           removeAtIndex(location);
    }

    /*********************************************
     * Index list methods follow
     *********************************************/

    /**
     * Returns the index of value.
     * 
     * @param value assigned.
     * @return index of value if in the list, -1 otherwise.
     * {@inheritDoc}
     */
    @Override
    public int getIndex(E value) {
        int index = 0;
        ListNode<E> current = front;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
    
    /**
     * Removes value at the given index, shifting subsequent values up.
     * 
     * @param index <= size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * {@inheritDoc}
     */
    @Override
    public void removeAtIndex(int index) {
        checkIndex(index);
        if (index == 0) {
            front = front.next;
            if (size == 0)
                back = null;
        }
        else {
            ListNode<E> current = nodeAt(index - 1);
            current.next = current.next.next;
            if (current.next == null)
                back = current;
        }
        
        size--;
    }
    
    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param 0 <= index <=size
     * @param value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * {@inheritDoc}
     */
    @Override
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }
    
    /**
     * Returns the value at the given index in the list.
     * 
     * @param 0 <= index <=size
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * @return the value at the given index in the list.
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    } 

    /**
     * Returns the node at a specific index.
     * @param index where 0 <= index <= size
     * @return reference to the node at a specific index
     */
    protected ListNode<E> nodeAt(int index) {
        ListNode<E> current = front;
        for (int i = 1; i <= index; i++) {
                current = current.next;
        }
        return current;
    }

    
    /**
     * Checks if the index is a legal index of the current list.
     * @param index
     * @throws IndexOutOfBoundsException if the given index is not a legal index of the current list
     */
    protected void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
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
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    /**
     * Represents a list node.
     * @author Building Java Programs 3rd ed.
     *
     * @param <E> is of any object type
     */
    protected static class ListNode<E> {

        /**
         * Data stored in this node.
         */
        public E data; 

        /**
         * Link to next node in the list.
         */
        public ListNode<E> next;  

       
        /**
         * Constructs a node with given data and a null link.
         * @param data assigned
         */
        public ListNode(E data) {
            this(data, null);
        }

        /**
         * Constructs a node with given data and given link.
         * @param data assigned
         * @param next assigned
         */
        public ListNode(E data, ListNode<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Represents an iterator for the list.
     * 
     * @author modified from BuildingJavaPrograms 3rd Edition
     */
    protected class LinkedIterator implements Iterator<E> {
        
        /**
         * Location of current value to return.
         */
        private ListNode<E> current; 

        /**
         * flag that indicates whether list element can be removed.
         */
        private boolean removeOK; 
        
        /**
         * Location of the prior value in case of removal.
         */
        private ListNode<E> prior;

        /**
         * Constructs an iterator for the given list.
         */
        public LinkedIterator() {
            current = front;
            removeOK = false;
            prior = null;
        }

        /**
         * Returns whether there are more list elements.
         * 
         * @return true if there are more elements left, false otherwise
         * @see java.util.Iterator#hasNext()
         */
        public boolean hasNext() {
            return current != null;
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
            prior = current;
            E result = current.data;
            current = current.next;
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
            AbstractLinkedMyList.this.remove(prior.data);
            removeOK = false;
        }
    }

    
}
