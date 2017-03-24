package task1;

/**
 * Base interface for all collections
 * @param <E> - type of the elements of collection
 */
public interface Collection<E> {

    /**
     * Insert new element into collection
     * @param newValue
     */
    public void insert(E newValue);
}
