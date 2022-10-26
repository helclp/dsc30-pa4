/*
 * NAME: Patrick Helcl
 * PID: A16340930
 */

import java.util.AbstractList;

/**
 * Holds the methods and attributes that create a doubly linked list
 * @author Patrick Helcl
 * @since 10/23/22
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            data = element;

        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {

            data = element;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {

            data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {

            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {

            prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {

            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {

            data = null; //? not sure if this is correct
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {

        head = new Node(null, null, null);
        tail = new Node (null, null, head);
        head.setNext(tail);
        nelems = 0;

    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element == null) throw new NullPointerException();

        Node toAdd = new Node(element); // resets the pointers of the last and 2nd to last to
        Node last = tail.getPrev(); // point to new element
        last.setNext(toAdd);
        toAdd.setNext(tail);
        toAdd.setPrev(last);
        tail.setPrev(toAdd);
        nelems += 1;
        return true;

    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     *create room. Does not accept null values.
     * @param index index position where element will be added into DLL
     * @param element data that will be added
     * @throws IndexOutOfBoundsException if given index is outside of the range of the DLL
     * @throws NullPointerException if element given is null
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {

        if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if(element == null) throw new NullPointerException();

        Node beforeInsert = new Node(null);
        beforeInsert = head;

        for (int i = 0; i < index; i++) { //for loop used to find current node at given index
            beforeInsert = beforeInsert.getNext();

        }

        Node afterInsert = beforeInsert.getNext(); // block below changes the pointers to include
        Node toAdd = new Node(element);  // new node
        beforeInsert.setNext(toAdd);
        toAdd.setPrev(beforeInsert);
        toAdd.setNext(afterInsert);
        afterInsert.setPrev(toAdd);
        nelems += 1;

    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        head = new Node(null, null, null);
        tail = new Node (null, null, head);
        head.setNext(tail);
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     * @param element element/data that is searched for in the DLL
     * @return true if element is found in DLL, false otherwise
     */
    @Override
    public boolean contains(Object element) {

        T data = (T)element;
        Node current = new Node(null);
        current = head.getNext();

        for(int i = 0; i < size(); i++){ // loops through DLL and compares each node to given one
            if(current.data.equals(data)) return true; // true if found
            current = current.getNext();
        }

        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     * @param index position of node desired to get data from
     * @return data of node at the index
     * @throws IndexOutOfBoundsException if given index is outside range of DLL
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size() -1) throw new IndexOutOfBoundsException();
        Node current = head.getNext();

        for(int i =0; i < index; i++){ //loops through DLL until current is set to node @ given
            current = current.getNext(); // index, then node's data is returned
        }

        return current.data;
    }

    /**
     * Helper method to get the Nth node in our list
     * @param index position fo desired node to retrieve
     * @return the node at the given index
     */
    private Node getNth(int index) {
        Node current = head;

        for(int i =0; i <= index; i++){ //loops through DLL until current is set to node @ given
            //index, then is returned
            if(i ==0){
                current = head;
            }
            else{
                current = current.getNext();
            }
        }
        return current;
    }

    /**
     * Determine if the list empty
     * @return true if no elements in DLL, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Remove the element from position index in the list
     * @param index position of node to be removed
     * @return removed node's data
     * @throws IndexOutOfBoundsException if given index is outside of DLL's range
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();

        Node toRemove = head.getNext();

        for (int i = 0; i < index; i++) { //loop through DLL to retrieve node @ given index

            toRemove = toRemove.getNext();
        }

        Node beforeRemove = toRemove.getPrev(); // pointers are reset to account for removed node
        Node afterRemove = toRemove.getNext();
        beforeRemove.setNext(afterRemove);
        afterRemove.setPrev(beforeRemove);
        nelems -= 1;

        return toRemove.data;
    }

    /**
     * Set the value of an element at a certain index in the list.
     * @param index position of node to have data altered
     * @param element data to be swapped with node's old data
     * @return data of node prior to swap
     * @throws IndexOutOfBoundsException if given index is out of DLL's range
     * @throws NullPointerException if data to be used for swap is null
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();
        if(element == null) throw new NullPointerException();

        Node current = head.getNext();

        for (int i = 0; i < index; i++) { //loops through DLL to get node at desired index
            current = current.getNext();
        }

        T oldData = current.data; // old data stored and returned, new data put in
        current.data = element;
        return oldData;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     * @return the number of elements in the DLL
     */
    @Override
    public int size() {

        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     * @return a string reprsentation of the elements in the DLL
     */
    @Override
    public String toString() {
        String result = "[(head) -> ";
        String holder = "";
        Node current = head;

        for(int i=0; i < nelems; i++){ // loops through DLL and formats needed info into string
            current = current.getNext();
            holder = String.valueOf(current.data) + " -> ";
            result += holder;
        }
        result += "(tail)]";

        return result; // result is used to create the final format of string, then is returned
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // TODO: complete implementation
    }
}

