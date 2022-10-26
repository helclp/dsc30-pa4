/*
 * NAME: Patrick Helcl
 * PID: A16340930
 */

/**
 * Holds the methods and attributes that created the DLL queue object
 * @param <T> generic container
 * @author Patrick Helcl
 * @since 10/24/22
 */
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    /**
     * creates a DLL called queue used for following methods
     */
    public DLLQueue() {
        queue = new DoublyLinkedList<>();
    }

    /**
     * method that reveals how many elements are in the queue
     * @return an integer that represents $ of elements in queue
     */
    public int size() {
        return queue.size();
    }

    /**
     * method used to check if the queue is empty
     * @return boolean, true if there are no elements in queu, otherwise false
     */
    public boolean isEmpty() {
        return queue.size() ==0;
    }
    /**
     * method to insert an element into back of queue
     * @param data the element to be added into the queue
     */
    public void enqueue(T data) {
        queue.add(queue.size() -1, data);
    }

    /**
     * method that removes the element at the front of the queue
     * @return the element that was removed
     */
    public T dequeue() {
        return queue.remove(0);
    }
    /**
     * method that shows which element is at the front of the queue
     * @return the data from the element at the front
     */
    public T peek() {
        return queue.get(0);
    }

}

