package mylistpackage;


/**
 * Represents basic unsorted array-based list.
 * 
 * @author modified from Building Java Programs 3rd ed. Modified by John Chang
 * @version Oct 14, 2016
 * @param <E> is of any object type
 */
public class ArrayListUnsorted<E> extends AbstractArrayMyList<E> {


    /**
     * Constructs an empty list of the given capacity.
     * 
     * @param capacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     */
	@SuppressWarnings("unchecked")
    public ArrayListUnsorted(int capacity) {
    	super();
    	if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];

    }

    /**
     * Constructs an empty list of the default capacity.
     * 
     */
    @SuppressWarnings("unchecked")
    public ArrayListUnsorted() {
        super();
        elementData = (E[]) new Object[DEFAULT_CAPACITY];

    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E value) {
        for (int i = 0; i <= size; i++) {
            if (elementData[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(E value) {
        super.ensureCapacity(size + 2);
        size++;
        elementData[size] = value;      
        
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
    	elementData = (E[]) new Object[DEFAULT_CAPACITY];
        size = -1;
    }

    /**
     * @see mylistpackage.MyList#remove(java.lang.Object)
     */
    @Override
    public void remove(E value) {
        int index = getIndex(value);
        if (size >= 0 && index >= 0) {
            elementData[index] = elementData[size];
            elementData[size] = null;
            size--;
        }
    }


    /*********************************************
     * Index list methods follow
     *********************************************/

    /**
     * Replaces the value at the given index with the given value.
     * 
     * @param index <= size and index >= 0
     * @value is assigned
     * @throws IndexOutOfBoundsException if index < 0 or index > size
     * {@inheritDoc}
     */
    @Override
    public void set(int index, E value) {	//
        if (index < 0 || index > size) {	//
            throw new IndexOutOfBoundsException();	//
        }										//
        elementData[index] = value;		//
    }

    /*********************************************
     * Index list methods end
     *********************************************/


}