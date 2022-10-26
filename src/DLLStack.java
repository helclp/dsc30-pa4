/*
 * NAME: Patrick Helcl
 * PID: A16340930
 */

/**
 * Holds the methods and attributes that create the DLL stack object
 * @param <T> generic container
 * @author Patrick Helcl
 * @since 10/24/22
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    /**
     * creates a DLL called stack used for following methods
     */
    public DLLStack() {
        stack = new DoublyLinkedList<>();
    }

    /**
     * method that reveals how many elements are in the stack
     * @return an integer that represents $ of elements in stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * method used to check if the stack is empty
     * @return boolean, true if there are no elements in stack, otherwise false
     */
    public boolean isEmpty() {

        return stack.size() == 0;
    }

    /**
     * method to add an element to top of stack
     * @param data the element to be added into the stack
     */
    public void push(T data) {
        stack.add(data);
    }

    /**
     * method that removes the element at the top of the stack
     * @return the element that was removed
     */
    public T pop() {
        return stack.remove(size()-1);
    }

    /**
     * method that shows which element is at the top of the stack
     * @return the data from the element at the top
     */
    public T peek() {
        return stack.get(size()-1);
    }

}

