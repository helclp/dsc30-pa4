import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    @Test
    public void add_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(1);
        assertEquals("[(head) -> 1 -> (tail)]", test1.toString());
    }

    @Test
    public void add_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(2);
        test1.add(3);
        assertEquals("[(head) -> 2 -> 3 -> (tail)]", test1.toString());
    }

    @Test
    public void add_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);

        assertEquals("[(head) -> 10 -> 11 -> 13 -> (tail)]", test1.toString());
    }

    @Test (expected = NullPointerException.class)
    public void add_test_exception() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(null);
    }

    @Test
    public void IndexAdd_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(1, 11);
        test1.add(0, 13);

        assertEquals("[(head) -> 13 -> 10 -> 11 -> (tail)]", test1.toString());
    }

    @Test
    public void IndexAdd_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0,1);
        test1.add(0,2);
        test1.add(2, 20);

        assertEquals("[(head) -> 2 -> 1 -> 20 -> (tail)]", test1.toString());
    }

    @Test
    public void IndexAdd_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0,11);
        test1.add(1, 20);
        test1.add(2, 21);

        assertEquals("[(head) -> 11 -> 20 -> 21 -> (tail)]", test1.toString());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void IndexAdd_exception_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(20,11);
    }

    @Test (expected = NullPointerException.class)
    public void IndexAdd_exception_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0,null);
    }

    @Test
    public void clear_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        test1.clear();
        assertEquals("[(head) -> (tail)]", test1.toString());
    }

    @Test
    public void clear_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.clear();
        assertEquals("[(head) -> (tail)]", test1.toString());
    }

    @Test
    public void clear_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.clear();
        assertEquals("[(head) -> (tail)]", test1.toString());
    }

    @Test
    public void contains_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);

        assertTrue(test1.contains(11));
    }

    @Test
    public void contains_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);

        assertTrue(test1.contains(10));
    }

    @Test
    public void contains_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);

        assertTrue(test1.contains(13));
    }

    @Test
    public void get_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.get(2);
        assertEquals(13, answer);
    }

    @Test
    public void get_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.get(0);
        assertEquals(10, answer);
    }

    @Test
    public void get_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.get(1);
        assertEquals(11, answer);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get_exception_test() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.get(50);
    }

    @Test
    public void isEmpty_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        assertFalse(test1.isEmpty());
    }

    @Test
    public void isEmpty_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.clear();
        assertTrue(test1.isEmpty());
    }

    @Test
    public void isEmpty_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        assertTrue(test1.isEmpty());
    }

    @Test
    public void remove_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.remove(2);
        assertEquals(13, answer);
    }

    @Test
    public void remove_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.remove(0);
        assertEquals(10, answer);
    }

    @Test
    public void remove_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.remove(1);
        assertEquals(11, answer);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void remove_exception_test() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.remove(15);
        assertEquals(11, answer);
    }

    @Test
    public void set_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.set(0, 25);
        int answer2 = test1.get(0);
        assertEquals(10, answer);
        assertEquals(25, answer2);
    }

    @Test
    public void set_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.set(1, 25);
        int answer2 = test1.get(1);
        assertEquals(11, answer);
        assertEquals(25, answer2);
    }

    @Test
    public void set_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.set(2, 25);
        int answer2 = test1.get(2);
        assertEquals(13, answer);
        assertEquals(25, answer2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void set_exception_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.set(15, 25);

    }

    @Test (expected = NullPointerException.class)
    public void set_exception_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.set(0, null);
    }

    @Test
    public void size_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        test1.add(11);
        test1.add(13);
        int answer = test1.size();
        assertEquals(3, answer);
    }

    @Test
    public void size_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(10);
        int answer = test1.size();
        assertEquals(1, answer);
    }

    @Test
    public void size_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        int answer = test1.size();
        assertEquals(0, answer);
    }

    @Test
    public void testToString_test1() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(21);
        test1.add(22);
        test1.add(23);
        test1.clear();
        assertEquals("[(head) -> (tail)]", test1.toString());

    }

    @Test
    public void testToString_test2() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(0,12);
        test1.add(1, 24);
        test1.add(2, 36);

        assertEquals("[(head) -> 12 -> 24 -> 36 -> (tail)]", test1.toString());

    }
    @Test
    public void testToString_test3() {
        DoublyLinkedList<Integer> test1 = new DoublyLinkedList<>();
        test1.add(12);
        test1.add(25);
        assertEquals("[(head) -> 12 -> 25 -> (tail)]", test1.toString());

    }

}