
/*
 * Student information for assignment:
 * On my honor, Mohammad Kashif, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID: mnk665
 * email address: mohammadnkashif@utexas.edu
 * TA name: Pranav Chandupatla
 * Number of slip days I am using: 0
 */

import java.util.Iterator;

public class LinkedList<E> implements IList<E> {

    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements.
    // No ArrayLists or Java LinkedLists.
    private DoubleListNode<E> first;
    private int size;
    private DoubleListNode<E> last;

    // CS314 students, add constructors here:

    /**
     * Linked List constructor.
     * Constructs a linked list with first and last nodes as null, as well
     * as size 0, to indicate it is currently empty.
     * pre: none
     * post: Returns a new, empty LinkedList
     *
     * Time Complexity: O(1)
     */
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    // CS314 students, add methods here:

    /**
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     * @param item the data to add to the front of this list
     *
     * Time Complexity: O(1)
     */
    public void addFirst(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Item inputted can't be null.");
        }
        if (size == 0) {
            add(item);
        }
        else {
            DoubleListNode<E> temp = new DoubleListNode<>(null, item, first);
            first.myPrev = temp;
            first = temp;
            size++;
        }
    }

    /**
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(size() -1) = item
     * @param item the data to add to the end of this list
     *
     * Time Complexity: O(1)
     */
    public void addLast(E item) {
        add(item);
    }

    /**
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * @return the old first element of this list
     *
     * Time Complexity: O(1)
     */
    public E removeFirst() {
        if (!(size > 0)) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        E tempData = first.myData;
        if (size == 1) {
            makeEmpty();
        }
        else {
            first = first.myNext;
            first.myPrev = null;
            size--;
        }
        return tempData;
    }

    /**
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * @return the old last element of this list
     *
     * Time Complexity: O(1)
     */
    public E removeLast() {
        if (!(size() > 0)) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        E tempData = last.myData;
        if (size == 1) {
            makeEmpty();
        }
        else {
            last = last.myPrev;
            last.myNext = null;
            size--;
        }
        return tempData;
    }

    /**
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list,
     * item != null
     *
     * Time Complexity: O(1)
     */    @Override
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Item inputted can't be null.");
        }
        if (size() == 0) {
            DoubleListNode<E> temp = new DoubleListNode<>(null, item, null);
            first = temp;
            last = temp;
        }
        else {
            DoubleListNode<E> temp = new DoubleListNode<>(last, item, null);
            last.myNext = temp;
            last = temp;
        }
        size++;
    }

    /**
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a positon >= pos have a
     * position = old position + 1
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list, item != null
     *
     * Time Complexity: O(N) worst case
     */    @Override
    public void insert(int pos, E item) {
        if (pos > size || pos < 0 || item == null) {
            throw new IllegalArgumentException("Invalid Position or null item.");
        }
        DoubleListNode<E> temp = getNodeAtPos(pos);
        // Case: inserting after last position
        if (pos == size) {
            add(item);
        }
        // Case: inserting at first position
        else if (temp == first) {
            addFirst(item);
        }
        // Case: inserting at last position
        else if (temp == last) {
            DoubleListNode<E> temp2 = new DoubleListNode<>(last.myPrev, item, last);
            last.myPrev.myNext = temp2;
            last.myPrev = temp2;
            size++;
        }
        // Standard case
        else {
            DoubleListNode<E> temp2 = new DoubleListNode<>(temp.myPrev, item, temp);
            temp.myPrev.myNext = temp2;
            temp.myPrev = temp2;
            size++;
        }
    }

    /**
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     * item != null
     * @return the old data at the specified position
     *
     * Time Complexity: O(N)
     */
    @Override
    public E set(int pos, E item) {
        if (pos >= size || pos < 0 || item == null) {
            throw new IllegalArgumentException("Position not in range or item is null.");
        }
        DoubleListNode temp = getNodeAtPos(pos);
        E temp2 = null;
        temp2 = (E) temp.myData;
        temp.myData = item;
        return temp2;
    }

    /**
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     *
     * Time Complexity: O(N)
     */
    @Override
    public E get(int pos) {
        if (pos > size) {
            throw new IllegalArgumentException("Invalid Position.");
        }
        return getNodeAtPos(pos).getData();
    }

    /**
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a position > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     *
     * Time Complexity: O(N)
     */
    @Override
    public E remove(int pos) {
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException("Position not in range.");
        }
        DoubleListNode<E> temp = getNodeAtPos(pos);
        E data = (E) temp.getData();
        if (pos == size - 1) {
            removeLast();
        }
        else if (pos == 0) {
            removeFirst();
        }
        else {
            temp.myPrev.myNext = temp.myNext;
            temp.myNext.myPrev = temp.myPrev;
            size--;
        }
        return data;
    }

    /**
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurrence
     * has been removed and size() = old size() - 1.
     * If obj is not present the list is not altered in any way.
     * @param obj The item to remove from this list. obj != null
     * @return Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     *
     * Time Complexity: O(N)
     */
    @Override
    public boolean remove(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object should not be null.");
        }
        int index = indexOf(obj, 0);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Return a sublist of elements in this list
     * from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start
     * and contains the elements at positions start through stop - 1
     * in this list.
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element
     * of the sublist.
     * @return a list with <tt>stop - start</tt> elements,
     * The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     * If start == stop an empty list is returned.
     *
     * Time Complexity (Normal Case): O(stop - start)
     * Time Complexity (Worst Case): O(N)
     */
    @Override
    public IList<E> getSubList(int start, int stop) {
        LinkedList<E> sub = new LinkedList<E>();

        DoubleListNode<E> temp = getNodeAtPos(start);
        while (temp != getNodeAtPos(stop)) {
            sub.add(temp.getData());
            temp = temp.getNext();
        }
        return sub;
    }

    /**
     * Return the size of this list.
     * In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * @return the number of items in this list
     *
     * Time Complexity: O(1)
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     * @param item the element to search for in the list. item != null
     * @return return the index of the first element equal to item
     * or a -1 if item is not present
     *
     * Time Complexity: O(N)
     */
    @Override
    public int indexOf(E item) {
        return indexOf(item, 0);
    }

    /**
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     *
     * Time Complexity: O(N)
     */
    @Override
    public int indexOf(E item, int pos) {
        if (item == null || pos > size || pos < 0) {
            throw new IllegalArgumentException("Item null or invalid position.");
        }
        DoubleListNode<E> temp = getNodeAtPos(pos);
        int index = pos;
        while (temp != null) {
            if (temp.getData().equals(item)) {
                return index;
            }
            temp = temp.getNext();
            index++;
        }
        return -1;
    }

    /**
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     *
     * Time Complexity; O(1)
     */
    @Override
    public void makeEmpty() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Remove all elements in this list from <tt>start</tt>
     * inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements
     * to be removed
     * @param stop stop - 1 is the position at the end
     * of the range of elements to be removed
     *
     * Time Complexity: O(stop - start)
     */
    @Override
    public void removeRange(int start, int stop) {
        if (start < 0 || stop < start || stop > size) {
            throw new IllegalArgumentException("Invalid start and stop values.");
        }
        if (stop == size) {
            removeRemaining(start, stop);
        }
        else if (start + 1 == stop) {
            remove(start);
        }
        else if (start != stop){
            DoubleListNode<E> startPoint = getNodeAtPos(start);
            DoubleListNode<E> endPoint = getNodeAtPos(stop);
            if (start == 0) {
                first = endPoint;
            }
            else {
                startPoint.myPrev.myNext = endPoint;
            }
            endPoint.myPrev = startPoint.myPrev;
            size -= (stop - start);
        }
        if (stop == size) {
            last = getNodeAtPos(start);
        }
    }

    /**
     * Remove all elements in this list from <tt>start</tt>
     * to the end of the LinkedList.
     * <br>pre:none
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements
     * to be removed
     * @param stop only used to decrement size in this context
     *
     * Time Complexity: O(1)
     */
    private void removeRemaining(int start, int stop) {
        if (start == 0) {
            makeEmpty();
        }
        else {
            DoubleListNode<E> startPoint = getNodeAtPos(start);
            last = startPoint.myPrev;
            last.myNext = null;
            size -= (stop - start);
        }
    }

    /**
     * Return a String version of this list enclosed in
     * square brackets, []. Elements are in
     * order based on position in the
     * list with the first element
     * first. Adjacent elements are separated by comma's
     * @return a String representation of this IList
     *
     * Time Complexity: O(N)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            DoubleListNode temp = first;
            while (temp.myNext != null) {
                sb.append(temp.getData().toString() + ", ");
                temp = temp.myNext;
            }
            sb.append(temp.getData().toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Determine if this IList is equal to other. Two
     * ILists are equal if they contain the same elements
     * in the same order.
     * @return true if this IList is equal to other, false otherwise
     *
     * add Time complexity
     */
    public boolean equals(LinkedList<E> other) {
        for (int i = 0; i < size; i++) {
            if (getNodeAtPos(i).getData() != other.getNodeAtPos(i).getData()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the node at a given position and returns given node to program.
     * @param pos: Position to find node
     * @return The node stored at the index/ position pos
     *
     * Time Complexity: O(N)
     */
    private DoubleListNode<E> getNodeAtPos(int pos) {
        assert (pos > 0 && pos < size);
        if (pos == size - 1) {
            return last;
        }
        DoubleListNode<E> temp = first;
        for (int i = 0; i < pos; i++) {
             temp = temp.myNext;
        }
        return temp;
    }

    /**
     * return an Iterator for this list.
     * <br>pre: none
     * <br>post: return an Iterator object for this List
     *
     * Time Complexity: O(1)
     */
    @Override
    public Iterator<E> iterator() {
        return new LLIterator();
    }

    // Nested class used to create an iterator object for LinkedList
    private class LLIterator implements Iterator<E>{
        // Instance Variables
        private DoubleListNode nextNode;
        private boolean removeOK;
        private int posToRemove;

        /**
         * Creates new iterator, which starts with nextNode at first,
         * position to remove set to -1 (1 step before index 0), and
         * boolean removeOK set as false.
         * pre: none
         * post: Creates and returns a new iterator object for a LinkedList
         *
         * Time Complexity: O(1)
         */
        private LLIterator() {
            nextNode = first;
            removeOK = false;
            posToRemove = -1;
        }

        /**
         * pre: none
         * post: Returns boolean for whether the LinkedList has a next value stored.
         *
         * Time Complexity: O(1)
         */
        public boolean hasNext(){
            return nextNode != null;
        }

        /**
         * pre: none
         * post: Returns the next data piece stored in the next node in the LinkedList.
         *
         * Time Complexity: O(1)
         */
        public E next(){
            assert hasNext();

            Object result = nextNode.getData();
            nextNode = nextNode.getNext();
            removeOK = true;
            posToRemove++;
            return (E)result;
        }

        /**
         * pre: none
         * post: Removes node at index posToRemove from LinkedList using
         * this.remove(), which has O(N) time complexity.
         *
         * Time Complexity: O(N)
         */
        public void remove(){
            assert removeOK;
            removeOK = false;
            LinkedList.this.remove(posToRemove);
            posToRemove--;
        }
    }

    /**
     * A class that represents a node to be used in a linked list.
     * These nodes are doubly linked. All methods are O(1).
     *
     * @author Mike Scott
     * @version July 25, 2005
     */

    private static class DoubleListNode<E> {

        // instance variables

        // The data stored in this node.
        private E myData;

        // The link to the next node (presumably in a list).
        private DoubleListNode<E> myNext;

        // The link to the previous node (presumably in a list).
        private DoubleListNode<E> myPrev;

        /**
         * default constructor.
         * <br>pre: none
         * <br>post: getData() = null, getNext() = null, getPrev() = null
         */
        public DoubleListNode() {
            this(null, null, null);
        }

        /**
         * create a DoubleListNode that holds the specified data
         * and refers to the specified next and previous elements.
         * <br>pre: none
         * <br>post: getData() = data, getNext() = next, getPrev() = prev
         * @param prev the previous node
         * @param data the  data this DoubleListNode should hold
         * @param next the next node
         */
        public DoubleListNode(DoubleListNode<E> prev, E data,
                DoubleListNode<E> next) {

            myData = data;
            myNext = next;
            myPrev = prev;
        }

        /**
         * return the data in this node.
         * <br>pre: none
         * @return the data this DoubleListNode holds
         */
        public E getData() {
            return myData;
        }

        /**
         * return the DoubleListNode this ListNode refers to.
         * <br>pre: none
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the next one in a list)
         */
        public DoubleListNode<E> getNext() {
            return myNext;
        }

        /**
         * return the DoubleListNode this DoubleListNode refers to.
         * <br>pre: none
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the previous one in a list)
         */
        public DoubleListNode<E> getPrev() {
            return myPrev;
        }

        /**
         * set the data in this node.
         * The old data is over written.
         * <br>pre: none
         * <br>post: getData() == data
         * @param data the new data for this DoubleListNode to hold
         */
        public void setData(E data) {
            myData = data;
        }

        /**
         * set the next node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getNext() = next
         * @param next the next node this DoubleListNode should refer to
         */
        public void setNext(DoubleListNode<E> next) {
            myNext = next;
        }

        /**
         * set the previous node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getPrev() = next
         * @param prev the previous node this DoubleListNode should refer to
         */
        public void setPrev(DoubleListNode<E> prev) {
            myPrev = prev;
        }
    }
}
