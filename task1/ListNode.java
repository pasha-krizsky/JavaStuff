package task1;

/**
 * The node of the list
 * @param <E> - Type of the node of the list
 */
public class ListNode<E> {

    /** The value */
    E value;
    /** Link to the next element or null, if next element doesn't exist */
    ListNode next;

    /**
     * Change the value of the node
     * @param newValue - New value
     */
    public void insert(E newValue) {
        value = newValue;
    }
}
