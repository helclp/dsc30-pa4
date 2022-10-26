import org.junit.Test;

import static org.junit.Assert.*;

public class DLLQueueTest {

    @Test
    public void size_test1() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        assertEquals(2, queue1.size());
    }

    @Test
    public void size_test2() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        assertEquals(0, queue1.size());
    }

    @Test
    public void size_test3() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(1);
        queue1.enqueue(1);
        assertEquals(3, queue1.size());
    }

    @Test
    public void isEmpty_test1() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(1);
        queue1.enqueue(1);
        assertFalse(queue1.isEmpty());

    }

    @Test
    public void isEmpty_test2() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(1);
        assertFalse(queue1.isEmpty());

    }

    @Test
    public void isEmpty_test3() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        assertTrue(queue1.isEmpty());

    }

    @Test
    public void enqueue_test1() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(5);
        queue1.enqueue(4);
        queue1.enqueue(3);
        assertEquals(3, queue1.size());
    }

    @Test
    public void enqueue_test2() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(5);
        queue1.enqueue(4);
        assertEquals(2, queue1.size());
    }

    @Test
    public void enqueue_test3() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(5);
        queue1.enqueue(4);
        queue1.enqueue(4);
        queue1.enqueue(4);
        assertEquals(4, queue1.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void enqueue_exception_test() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(null);
    }

    @Test
    public void dequeue_test1() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(5);
        queue1.enqueue(4);
        queue1.enqueue(3);
        queue1.enqueue(3);
        queue1.enqueue(7);
        int answer = queue1.dequeue();
        assertEquals(5, answer);
    }

    @Test
    public void dequeue_test2() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(3);
        queue1.enqueue(3);
        queue1.enqueue(7);
        int answer = queue1.dequeue();
        assertEquals(3, answer);
    }

    @Test
    public void dequeue_test3() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        assertEquals(null, queue1.dequeue());
    }

    @Test
    public void peek_test1() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(3);
        queue1.enqueue(3);
        queue1.enqueue(7);
        int answer = queue1.peek();
        assertEquals(3, answer);
    }

    @Test
    public void peek_test2() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        queue1.enqueue(8);
        queue1.enqueue(7);
        int answer = queue1.peek();
        assertEquals(8, answer);
    }

    @Test
    public void peek_test3() {
        DLLQueue<Integer> queue1 = new DLLQueue<>();
        assertEquals(null, queue1.peek());
    }

}
