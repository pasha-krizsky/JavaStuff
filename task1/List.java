package task1;

/**
 * Implementation of "List" data structure
 * @param <E> - Type of the elements of the list
 */
public class List<E> implements Collection<E> {

    /** The head of the list */
    private ListNode head;
    /** The tail of the list */
    private ListNode tail;

    @Override
    public void insert(E newValue) {
        ListNode l = new ListNode();
        l.value = newValue;
        if (head == null) {
            head = l;
            tail = l;
        } else {
            tail.next = l;
            tail = l;
        }
    }

    /** Print all elements of the list */
    public void printList() {
        ListNode t = head;
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.next;
        }
    }
}
