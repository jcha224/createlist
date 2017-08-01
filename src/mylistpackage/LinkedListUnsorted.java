package mylistpackage;


/**
 * Represents basic unsorted node-based list.
 * 
 * @author modified from Building Java Programs 3rd ed.
 * @version Sep 2016
 * @param <E> is of any object type
 */
public class LinkedListUnsorted<E> extends AbstractLinkedMyList<E> {

    /**
     * Constructs an empty list.
     */
    public LinkedListUnsorted() {
    	super();
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
    
}
