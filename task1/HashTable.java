package task1;

/**
 * Implementation of "Hash table" data structure
 * @param <E> - Type of the elements stored in hash table
 */
public class HashTable<E> implements Collection<E> {

    /** The num to calculate hash-function */
    private int n;
    /** The max index in Array */
    private int maxIndex;

    /** Hash table */
    public Array<List<E>> values;

    /** Constructor
     * Set capacity and N
     * @param capacity - Capacity of hash table
     * @param n - N
     */
    public HashTable(int capacity, int n) {
        this.n = n;
        values = new Array<>(capacity);
        maxIndex = 0;
    }

    @Override
    public void insert(E newValue) {
        // Hash function
        int index = (Integer) newValue % n;

        // Set max index in hash table
        if (maxIndex < index) {
            maxIndex = index;
        }

        // Create new list if null
        if (values.get(index) == null) {
            values.set(new List<E>(), index);
        }
        // Get list by index
        List l = (List) values.get(index);
        // Insert new value into the list
        l.insert(newValue);
        // Set this list in hash table
        values.set(l, index);
    }


    /**
     * Get list from hash table by its index
     * @param index - Index
     * @return - List of elements
     */
    public Object get(int index) {
        return values.get(index);
    }

    /**
     * Get max index from hash table
     * @return - Max index
     */
    public int getMaxIndex() {
        return maxIndex;
    }
}
