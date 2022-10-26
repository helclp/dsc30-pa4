import org.junit.Test;

import static org.junit.Assert.*;

public class DLLStackTest {

    @Test
    public void size_test1() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(1);
        stack1.push(2);
        assertEquals(2, stack1.size());
    }

    @Test
    public void size_test2() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        assertEquals(0, stack1.size());
    }

    @Test
    public void size_test3() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        assertEquals(3, stack1.size());
    }

    @Test
    public void isEmpty_test1() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        assertFalse(stack1.isEmpty());
    }

    @Test
    public void isEmpty_test2() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(1);
        assertFalse(stack1.isEmpty());
    }

    @Test
    public void isEmpty_test3() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        assertTrue(stack1.isEmpty());
    }

    @Test
    public void push_test1() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        stack1.push(4);
        stack1.push(3);
        assertEquals(3, stack1.size());
    }

    @Test
    public void push_test2() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        stack1.push(4);
        int answer = stack1.peek();
        assertEquals(4, answer);
    }

    @Test
    public void push_test3() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        stack1.push(4);
        stack1.push(3);
        stack1.push(3);
        stack1.push(3);
        assertEquals(5, stack1.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void push_exception_test() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(null);
    }

    @Test
    public void pop_test1() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        stack1.push(4);
        stack1.push(3);
        stack1.push(3);
        stack1.push(7);
        int answer = stack1.pop();
        assertEquals(7, answer);
    }

    @Test
    public void pop_test2() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        assertEquals(null, stack1.pop());
    }

    @Test
    public void pop_test3() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        int answer = stack1.pop();
        assertEquals(5, answer);
    }

    @Test
    public void peek_test1() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        stack1.push(4);
        stack1.push(3);
        int answer = stack1.peek();
        assertEquals(3, answer);
    }

    @Test
    public void peek_test2() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        stack1.push(5);
        stack1.push(4);
        int answer = stack1.peek();
        assertEquals(4, answer);
    }

    @Test
    public void peek_test3() {
        DLLStack<Integer> stack1 = new DLLStack<>();
        assertEquals(null, stack1.peek());
    }
}