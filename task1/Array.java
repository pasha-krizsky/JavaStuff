package task1;

/**
 * Implementation of "Dynamic array" data structure
 * @param <E> - Type of the elements of the array
 */
public class Array<E> implements Collection<E> {

    /** Store the values of the array */
    Object[] values;
    /** Array size */
    int size;
    /** Current array capacity */
    int capacity;

    /** Constant INITIAL_CAPACITY */
    private static final int INITIAL_CAPACITY = 8;
    /** Constant INITIAL_SIZE */
    private static final int INITIAL_SIZE     = 0;
    /** Constant INCREASE_SIZE */
    private static final int INCREASE_SIZE    = 8;

    /**
     * Constructor without parameters
     */
    public Array() {
        values     = new Object[INITIAL_CAPACITY];
        size       = INITIAL_SIZE;
        capacity   = INITIAL_CAPACITY;
    }

    /**
     * Constructor with initial capacity
     * @param capacity - Initial capacity
     */
    public Array(int capacity) {
        values        = new Object[capacity];
        size          = INITIAL_SIZE;
        this.capacity = capacity;
    }

    @Override
    public void insert(E newValue) {
        if (size < capacity) {
            values[size] = newValue;
            size++;
        } else {
            capacity    += INCREASE_SIZE;
            Object[] tmp = new Object[capacity];

            // Copy elements to a new array
            for (int i = 0; i < size; ++i) {
                tmp[i] = values[i];
            }
            // Add new element
            tmp[size] = newValue;
            values    = tmp;
            size++;
        }
    }

    /**
     * Insert new value to the position defined by index
     * @param newValue - New value
     * @param index - Index
     */
    public void insert(E newValue, int index) {
        if (size >= capacity) {
            capacity    += INCREASE_SIZE;
            Object[] tmp = new Object[capacity];
            for (int i = 0; i < size; ++i) {
                tmp[i] = values[i];
            }
            values = tmp;
        }

        if (index < capacity) {
            for (int i = capacity - 1; i > index; --i) {
                values[i] = values[i-1];
            }
            values[index] = newValue;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Get the element of the array
     * @param index - Index of the element of the array
     * @return - The element of the array
     */
    public Object get(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    public void set(E value, int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException();
        }
        values[index] = value;
    }

    /**
     * Get array size
     * @return - size
     */
    public int getSize() {
        return size;
    }

    /**
     * Get array capacity
     * @return - capacity
     */
    public int getCapacity() {
        return this.capacity;
    }
}
