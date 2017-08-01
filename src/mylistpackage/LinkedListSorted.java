package mylistpackage;

public class LinkedListSorted<E extends Comparable<? super E>> extends AbstractLinkedMyList<E> {
	 /**
     * Constructs an empty list.
     */
    public LinkedListSorted() {
    	super();
    }    
    
    /**
     * {@inheritDoc}
     * IllegalArgumentException if value is out of place.
     */
    @Override
    public void insert(E value) {
    	ListNode<E> valueNode = new ListNode<E>(value);
        if (size == -1) {
        	front = valueNode;
        	back = valueNode;
        } else {
        	if(value.compareTo(back.data) < 0) {
        		throw new IllegalArgumentException();
        	} else {
        		back.next = valueNode;
        		back = valueNode;
        	}
        }
        size++;
    }     

    
    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param 0 <= index <=size
     * @param value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * @throws IllegalArgumentException if value is in wrong location
     * {@inheritDoc}
     */
    @Override
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        if(index > 1) {
        	if(value.compareTo(nodeAt(index - 1).data) < 0) {
        		throw new IllegalArgumentException();
        	}
        	if(index < size) {
        		if(value.compareTo(current.next.data) > 0) {
        			throw new IllegalArgumentException();
        		}
        	}
        }
        current.data = value;
    }
}
