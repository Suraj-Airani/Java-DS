import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class LinkedListPractice {
    public static void main(String[] args) {

        /*
         * LinkedList class hierarchy:
         *
         *   java.lang.Object
         *     └── java.util.AbstractCollection<E>
         *           └── java.util.AbstractList<E>
         *                 └── java.util.AbstractSequentialList<E>
         *                       └── java.util.LinkedList<E>
         *
         * Implements: List, Deque, Queue, Cloneable, Serializable
         *
         * Because it implements Deque, it can be used as:
         *   - Queue (FIFO)
         *   - Stack (LIFO)
         *   - Double-ended Queue (Deque)
         */

        // ================================================================
        //  PART A: CORE LINKEDLIST METHODS (List interface)
        // ================================================================

        System.out.println("========== PART A: CORE LINKEDLIST METHODS ==========\n");

        // ============================================================
        // 1. add(E element) — Appends element to the end of the list
        // ============================================================
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Pineapple");
        System.out.println("1. add(E): " + fruits);

        // ============================================================
        // 2. add(int index, E element) — Inserts element at the given index
        // ============================================================
        fruits.add(2, "Watermelon");
        System.out.println("2. add(2, 'Watermelon'): " + fruits);

        // ============================================================
        // 3. get(int index) — Returns the element at the specified index
        // ============================================================
        System.out.println("3. get(3): " + fruits.get(3));

        // ============================================================
        // 4. set(int index, E element) — Replaces element at the given index
        // ============================================================
        String old = fruits.set(0, "Dragon Fruit");
        System.out.println("4. set(0, 'Dragon Fruit') replaced: " + old);
        System.out.println("   List: " + fruits);

        // ============================================================
        // 5. remove(int index) — Removes element at given index
        // ============================================================
        String removed = fruits.remove(1);
        System.out.println("5. remove(1) removed: " + removed);

        // ============================================================
        // 6. remove(Object o) — Removes first occurrence of the element
        // ============================================================
        fruits.remove("Grapes");
        System.out.println("6. remove('Grapes'): " + fruits);

        // ============================================================
        // 7. size() — Returns the number of elements
        // ============================================================
        System.out.println("7. size(): " + fruits.size());

        // ============================================================
        // 8. contains(Object o) — Returns true if element is present
        // ============================================================
        System.out.println("8. contains('Dragon Fruit'): " + fruits.contains("Dragon Fruit"));

        // ============================================================
        // 9. indexOf(Object o) — First occurrence index, -1 if not found
        // ============================================================
        System.out.println("9. indexOf('Watermelon'): " + fruits.indexOf("Watermelon"));

        // ============================================================
        // 10. clear() — Removes all elements
        // ============================================================
        LinkedList<String> temp = new LinkedList<>(Arrays.asList("X", "Y", "Z"));
        temp.clear();
        System.out.println("10. After clear(): " + temp);

        // ============================================================
        // 11. addFirst(E e) — Inserts element at the beginning
        // ============================================================
        fruits.addFirst("Apple");
        System.out.println("11. addFirst('Apple'): " + fruits);

        // ============================================================
        // 12. addLast(E e) — Inserts element at the end
        // ============================================================
        fruits.addLast("Banana");
        System.out.println("12. addLast('Banana'): " + fruits);

        // ============================================================
        // 13. getFirst() — Returns the first element (throws exception if empty)
        // ============================================================
        System.out.println("13. getFirst(): " + fruits.getFirst());

        // ============================================================
        // 14. getLast() — Returns the last element (throws exception if empty)
        // ============================================================
        System.out.println("14. getLast(): " + fruits.getLast());

        // ============================================================
        // 15. removeFirst() — Removes and returns the first element
        // ============================================================
        String first = fruits.removeFirst();
        System.out.println("15. removeFirst(): " + first + " → List: " + fruits);

        // ============================================================
        // 16. removeLast() — Removes and returns the last element
        // ============================================================
        String last = fruits.removeLast();
        System.out.println("16. removeLast(): " + last + " → List: " + fruits);

        System.out.println();

        // ================================================================
        //  PART B: QUEUE METHODS (from Queue / Deque interface)
        // ================================================================

        System.out.println("========== PART B: QUEUE / DEQUE METHODS ==========\n");

        LinkedList<String> queue = new LinkedList<>(Arrays.asList("Alpha", "Beta", "Gamma", "Delta"));
        System.out.println("Starting list: " + queue);
        System.out.println();

        // ============================================================
        // 17. offer(E e) — Adds element to the tail (returns true/false, no exception)
        //     Safer alternative to add() for capacity-restricted queues
        // ============================================================
        boolean offered = queue.offer("Epsilon");
        System.out.println("17. offer('Epsilon'): " + offered + " → " + queue);

        // ============================================================
        // 18. offerFirst(E e) — Inserts element at the front
        // ============================================================
        queue.offerFirst("Zero");
        System.out.println("18. offerFirst('Zero'): " + queue);

        // ============================================================
        // 19. offerLast(E e) — Inserts element at the end
        // ============================================================
        queue.offerLast("Omega");
        System.out.println("19. offerLast('Omega'): " + queue);

        // ============================================================
        // 20. peek() — Returns the head element WITHOUT removing it
        //     Returns null if the queue is empty (no exception)
        // ============================================================
        System.out.println("20. peek(): " + queue.peek());
        System.out.println("    List unchanged: " + queue);

        // ============================================================
        // 21. peekFirst() — Returns first element without removing, null if empty
        // ============================================================
        System.out.println("21. peekFirst(): " + queue.peekFirst());

        // ============================================================
        // 22. peekLast() — Returns last element without removing, null if empty
        // ============================================================
        System.out.println("22. peekLast(): " + queue.peekLast());

        // ============================================================
        // 23. poll() — Removes and returns the head element
        //     Returns null if the queue is empty (no exception)
        // ============================================================
        String polled = queue.poll();
        System.out.println("23. poll(): " + polled + " → " + queue);

        // ============================================================
        // 24. pollFirst() — Removes and returns first element, null if empty
        // ============================================================
        String pollFirst = queue.pollFirst();
        System.out.println("24. pollFirst(): " + pollFirst + " → " + queue);

        // ============================================================
        // 25. pollLast() — Removes and returns last element, null if empty
        // ============================================================
        String pollLast = queue.pollLast();
        System.out.println("25. pollLast(): " + pollLast + " → " + queue);

        // ============================================================
        // 26. element() — Returns the head element WITHOUT removing
        //     Throws NoSuchElementException if empty (unlike peek)
        // ============================================================
        System.out.println("26. element(): " + queue.element());

        System.out.println();

        // ================================================================
        //  PART C: STACK METHODS (from Deque interface)
        // ================================================================

        System.out.println("========== PART C: STACK METHODS (Deque) ==========\n");

        LinkedList<String> stack = new LinkedList<>();

        // ============================================================
        // 27. push(E e) — Pushes element onto the top of the stack (beginning of list)
        // ============================================================
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("27. After push('First','Second','Third'): " + stack);
        System.out.println("    (Top of stack is the first element)");

        // ============================================================
        // 28. pop() — Removes and returns the top of the stack
        //     Throws NoSuchElementException if empty
        // ============================================================
        String popped = stack.pop();
        System.out.println("28. pop(): " + popped + " → " + stack);

        // ============================================================
        // 29. peek() — Returns top of stack without removing (same as Queue)
        // ============================================================
        System.out.println("29. peek() on stack: " + stack.peek());

        // ============================================================
        // 30. descendingIterator() — Iterates in reverse order (tail to head)
        // ============================================================
        LinkedList<String> descDemo = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.print("30. descendingIterator(): ");
        Iterator<String> descIter = descDemo.descendingIterator();
        while (descIter.hasNext()) {
            System.out.print(descIter.next() + " ");
        }
        System.out.println();

        System.out.println();

        // ================================================================
        //  PART D: KEY DIFFERENCES — peek vs element, offer vs add, poll vs remove
        // ================================================================

        System.out.println("========== PART D: SAFE vs UNSAFE METHODS ==========\n");

        /*
         * +------------------+----------------------------+-----------------------------+
         * |   Operation      |  Throws Exception          |  Returns null/false         |
         * +------------------+----------------------------+-----------------------------+
         * |  Insert (head)   |  addFirst(e)               |  offerFirst(e)              |
         * |  Insert (tail)   |  addLast(e)                |  offerLast(e)               |
         * |  Remove (head)   |  removeFirst() / remove()  |  pollFirst() / poll()       |
         * |  Remove (tail)   |  removeLast()              |  pollLast()                 |
         * |  Examine (head)  |  getFirst() / element()    |  peekFirst() / peek()       |
         * |  Examine (tail)  |  getLast()                 |  peekLast()                 |
         * +------------------+----------------------------+-----------------------------+
         */

        LinkedList<String> emptyList = new LinkedList<>();

        // Safe methods return null on empty list
        System.out.println("peek() on empty list: " + emptyList.peek());       // null
        System.out.println("poll() on empty list: " + emptyList.poll());       // null
        System.out.println("peekFirst() on empty: " + emptyList.peekFirst()); // null
        System.out.println("peekLast() on empty:  " + emptyList.peekLast());  // null

        // Unsafe methods throw NoSuchElementException on empty list
        // emptyList.getFirst();  // throws NoSuchElementException
        // emptyList.element();   // throws NoSuchElementException
        // emptyList.remove();    // throws NoSuchElementException
        // emptyList.pop();       // throws NoSuchElementException

        System.out.println("(getFirst/element/remove/pop throw NoSuchElementException on empty list)");

        System.out.println();

        // ================================================================
        //  PART E: USING LINKEDLIST AS STACK, QUEUE, AND DEQUE
        // ================================================================

        System.out.println("========== PART E: STACK, QUEUE & DEQUE USAGE ==========\n");

        // ---- Using LinkedList as a STACK (LIFO) ----
        System.out.println("--- Stack (LIFO) ---");
        LinkedList<Integer> myStack = new LinkedList<>();
        myStack.push(10);  // push onto top
        myStack.push(20);
        myStack.push(30);
        System.out.println("Stack after pushes: " + myStack);
        System.out.println("peek (top): " + myStack.peek());
        System.out.println("pop: " + myStack.pop());
        System.out.println("pop: " + myStack.pop());
        System.out.println("Stack now: " + myStack);

        System.out.println();

        // ---- Using LinkedList as a QUEUE (FIFO) ----
        System.out.println("--- Queue (FIFO) ---");
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.offer(10);  // enqueue at tail
        myQueue.offer(20);
        myQueue.offer(30);
        System.out.println("Queue after offers: " + myQueue);
        System.out.println("peek (front): " + myQueue.peek());
        System.out.println("poll (dequeue): " + myQueue.poll());
        System.out.println("poll (dequeue): " + myQueue.poll());
        System.out.println("Queue now: " + myQueue);

        System.out.println();

        // ---- Using LinkedList as a DEQUE (Double-Ended Queue) ----
        System.out.println("--- Deque (Double-Ended Queue) ---");
        Deque<Integer> myDeque = new LinkedList<>();
        myDeque.offerFirst(20);   // add to front
        myDeque.offerFirst(10);   // add to front
        myDeque.offerLast(30);    // add to rear
        myDeque.offerLast(40);    // add to rear
        System.out.println("Deque after inserts: " + myDeque);
        System.out.println("peekFirst: " + myDeque.peekFirst());
        System.out.println("peekLast:  " + myDeque.peekLast());
        System.out.println("pollFirst: " + myDeque.pollFirst());
        System.out.println("pollLast:  " + myDeque.pollLast());
        System.out.println("Deque now: " + myDeque);

        System.out.println();

        // ================================================================
        //  PART F: WAYS TO ACCESS / ITERATE ELEMENTS
        // ================================================================

        System.out.println("========== PART F: ITERATION METHODS ==========\n");

        LinkedList<String> colors = new LinkedList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));
        System.out.println("List: " + colors);
        System.out.println();

        // (1) For loop (index-based)
        System.out.print("(1) For loop:         ");
        for (int i = 0; i < colors.size(); i++) {
            System.out.print(colors.get(i) + " ");
        }
        System.out.println();

        // (2) Enhanced for-each loop
        System.out.print("(2) For-each loop:    ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();

        // (3) Iterator (forward only)
        System.out.print("(3) Iterator:         ");
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // (4) ListIterator (forward)
        System.out.print("(4) ListIterator →:   ");
        ListIterator<String> listIt = colors.listIterator();
        while (listIt.hasNext()) {
            System.out.print(listIt.next() + " ");
        }
        System.out.println();

        // (5) ListIterator (backward) — continues from where forward left off
        System.out.print("(5) ListIterator ←:   ");
        while (listIt.hasPrevious()) {
            System.out.print(listIt.previous() + " ");
        }
        System.out.println();

        // (6) ListIterator from a specific index
        System.out.print("(6) ListIterator(2):  ");
        ListIterator<String> listIt2 = colors.listIterator(2);
        while (listIt2.hasNext()) {
            System.out.print(listIt2.next() + " ");
        }
        System.out.println();

        // (7) Descending Iterator (reverse order, from Deque)
        System.out.print("(7) descendingIter:   ");
        Iterator<String> descIt = colors.descendingIterator();
        while (descIt.hasNext()) {
            System.out.print(descIt.next() + " ");
        }
        System.out.println();

        // (8) forEach with lambda (Java 8+)
        System.out.print("(8) forEach lambda:   ");
        colors.forEach(c -> System.out.print(c + " "));
        System.out.println();

        System.out.println("\n✅ All LinkedList methods demonstrated successfully!");
    }
}
