import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class ArrayDequePractice {
    public static void main(String[] args) {

        /*
         * ArrayDeque class hierarchy:
         *
         *   java.lang.Object
         *     └── java.util.AbstractCollection<E>
         *           └── java.util.ArrayDeque<E>
         *
         * Implements: Deque, Queue, Collection, Iterable, Cloneable, Serializable
         *
         * Key points:
         *   - Resizable array implementation of Deque interface
         *   - Faster than LinkedList when used as Stack or Queue
         *   - Does NOT allow null elements
         *   - NOT thread-safe
         *   - No capacity limit (grows as needed)
         *   - Does NOT implement List interface (no index-based access like get(i))
         */

        // ================================================================
        //  PART A: CONSTRUCTORS
        // ================================================================

        System.out.println("========== PART A: CONSTRUCTORS ==========\n");

        // (a) Default constructor — creates an empty deque with initial capacity of 16
        ArrayDeque<String> deque1 = new ArrayDeque<>();
        System.out.println("1(a) Empty ArrayDeque: " + deque1);

        // (b) Constructor with initial capacity
        ArrayDeque<String> deque2 = new ArrayDeque<>(32);
        System.out.println("1(b) ArrayDeque with capacity 32: " + deque2);

        // (c) Constructor from another collection
        ArrayDeque<String> deque3 = new ArrayDeque<>(Arrays.asList("Alpha", "Beta", "Gamma"));
        System.out.println("1(c) ArrayDeque from collection: " + deque3);

        System.out.println();

        // ================================================================
        //  PART B: CORE METHODS (add, remove, size, contains, clear)
        // ================================================================

        System.out.println("========== PART B: CORE METHODS ==========\n");

        ArrayDeque<String> fruits = new ArrayDeque<>();

        // ============================================================
        // 1. add(E e) — Adds element to the tail (throws exception if fails)
        // ============================================================
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Pineapple");
        System.out.println("1. add(E): " + fruits);

        // ============================================================
        // 2. addFirst(E e) — Inserts element at the front
        // ============================================================
        fruits.addFirst("Apple");
        System.out.println("2. addFirst('Apple'): " + fruits);

        // ============================================================
        // 3. addLast(E e) — Inserts element at the end (same as add)
        // ============================================================
        fruits.addLast("Banana");
        System.out.println("3. addLast('Banana'): " + fruits);

        // ============================================================
        // 4. getFirst() — Returns the first element (throws exception if empty)
        // ============================================================
        System.out.println("4. getFirst(): " + fruits.getFirst());

        // ============================================================
        // 5. getLast() — Returns the last element (throws exception if empty)
        // ============================================================
        System.out.println("5. getLast(): " + fruits.getLast());

        // ============================================================
        // 6. removeFirst() — Removes and returns the first element
        // ============================================================
        String first = fruits.removeFirst();
        System.out.println("6. removeFirst(): " + first + " → " + fruits);

        // ============================================================
        // 7. removeLast() — Removes and returns the last element
        // ============================================================
        String last = fruits.removeLast();
        System.out.println("7. removeLast(): " + last + " → " + fruits);

        // ============================================================
        // 8. remove(Object o) — Removes the first occurrence of the element
        // ============================================================
        fruits.remove("Grapes");
        System.out.println("8. remove('Grapes'): " + fruits);

        // ============================================================
        // 9. removeFirstOccurrence(Object o) — Same as remove(Object), removes first match
        // ============================================================
        fruits.add("Mango"); // add duplicate
        System.out.println("9. Before removeFirstOccurrence: " + fruits);
        fruits.removeFirstOccurrence("Mango");
        System.out.println("   After removeFirstOccurrence('Mango'): " + fruits);

        // ============================================================
        // 10. removeLastOccurrence(Object o) — Removes the last occurrence
        // ============================================================
        fruits.addFirst("Orange");
        System.out.println("10. Before removeLastOccurrence: " + fruits);
        fruits.removeLastOccurrence("Orange");
        System.out.println("    After removeLastOccurrence('Orange'): " + fruits);

        // ============================================================
        // 11. size() — Returns the number of elements
        // ============================================================
        System.out.println("11. size(): " + fruits.size());

        // ============================================================
        // 12. isEmpty() — Returns true if the deque has no elements
        // ============================================================
        System.out.println("12. isEmpty(): " + fruits.isEmpty());
        System.out.println("    new ArrayDeque isEmpty(): " + new ArrayDeque<>().isEmpty());

        // ============================================================
        // 13. contains(Object o) — Returns true if element is present
        // ============================================================
        System.out.println("13. contains('Pineapple'): " + fruits.contains("Pineapple"));
        System.out.println("    contains('Banana'): " + fruits.contains("Banana"));

        // ============================================================
        // 14. clear() — Removes all elements
        // ============================================================
        ArrayDeque<String> temp = new ArrayDeque<>(Arrays.asList("X", "Y", "Z"));
        System.out.println("14. Before clear(): " + temp);
        temp.clear();
        System.out.println("    After clear(): " + temp);

        // ============================================================
        // 15. toArray() — Converts to an Object array
        // ============================================================
        Object[] arr = fruits.toArray();
        System.out.println("15. toArray(): " + Arrays.toString(arr));

        // ============================================================
        // 16. toArray(T[] a) — Converts to a typed array
        // ============================================================
        String[] strArr = fruits.toArray(new String[0]);
        System.out.println("16. toArray(String[]): " + Arrays.toString(strArr));

        // ============================================================
        // 17. clone() — Creates a shallow copy
        // ============================================================
        ArrayDeque<String> cloned = fruits.clone();
        System.out.println("17. clone(): " + cloned);

        // ============================================================
        // 18. addAll(Collection c) — Adds all elements from another collection
        // ============================================================
        fruits.addAll(Arrays.asList("Kiwi", "Papaya"));
        System.out.println("18. addAll(): " + fruits);

        System.out.println();

        // ================================================================
        //  PART C: QUEUE / DEQUE METHODS (offer, peek, poll, element)
        // ================================================================

        System.out.println("========== PART C: QUEUE / DEQUE METHODS ==========\n");

        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList("Alpha", "Beta", "Gamma", "Delta"));
        System.out.println("Starting deque: " + queue);
        System.out.println();

        // ============================================================
        // 19. offer(E e) — Adds element to the tail (returns true/false, no exception)
        // ============================================================
        boolean offered = queue.offer("Epsilon");
        System.out.println("19. offer('Epsilon'): " + offered + " → " + queue);

        // ============================================================
        // 20. offerFirst(E e) — Inserts element at the front
        // ============================================================
        queue.offerFirst("Zero");
        System.out.println("20. offerFirst('Zero'): " + queue);

        // ============================================================
        // 21. offerLast(E e) — Inserts element at the end
        // ============================================================
        queue.offerLast("Omega");
        System.out.println("21. offerLast('Omega'): " + queue);

        // ============================================================
        // 22. peek() — Returns the head element WITHOUT removing
        //     Returns null if empty (no exception)
        // ============================================================
        System.out.println("22. peek(): " + queue.peek());
        System.out.println("    Deque unchanged: " + queue);

        // ============================================================
        // 23. peekFirst() — Returns first element without removing, null if empty
        // ============================================================
        System.out.println("23. peekFirst(): " + queue.peekFirst());

        // ============================================================
        // 24. peekLast() — Returns last element without removing, null if empty
        // ============================================================
        System.out.println("24. peekLast(): " + queue.peekLast());

        // ============================================================
        // 25. poll() — Removes and returns the head element
        //     Returns null if empty (no exception)
        // ============================================================
        String polled = queue.poll();
        System.out.println("25. poll(): " + polled + " → " + queue);

        // ============================================================
        // 26. pollFirst() — Removes and returns first element, null if empty
        // ============================================================
        String pollFirst = queue.pollFirst();
        System.out.println("26. pollFirst(): " + pollFirst + " → " + queue);

        // ============================================================
        // 27. pollLast() — Removes and returns last element, null if empty
        // ============================================================
        String pollLast = queue.pollLast();
        System.out.println("27. pollLast(): " + pollLast + " → " + queue);

        // ============================================================
        // 28. element() — Returns the head element WITHOUT removing
        //     Throws NoSuchElementException if empty (unlike peek)
        // ============================================================
        System.out.println("28. element(): " + queue.element());

        System.out.println();

        // ================================================================
        //  PART D: STACK METHODS (push, pop, peek)
        // ================================================================

        System.out.println("========== PART D: STACK METHODS ==========\n");

        ArrayDeque<String> stack = new ArrayDeque<>();

        // ============================================================
        // 29. push(E e) — Pushes element onto the top of the stack (front of deque)
        // ============================================================
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("29. After push('First','Second','Third'): " + stack);
        System.out.println("    (Top of stack is the first element)");

        // ============================================================
        // 30. pop() — Removes and returns the top of the stack
        //     Throws NoSuchElementException if empty
        // ============================================================
        String popped = stack.pop();
        System.out.println("30. pop(): " + popped + " → " + stack);

        // ============================================================
        // 31. peek() — Returns top of stack without removing
        // ============================================================
        System.out.println("31. peek() on stack: " + stack.peek());

        System.out.println();

        // ================================================================
        //  PART E: SAFE vs UNSAFE METHODS COMPARISON
        // ================================================================

        System.out.println("========== PART E: SAFE vs UNSAFE METHODS ==========\n");

        /*
         * +------------------+----------------------------+-----------------------------+
         * |   Operation      |  Throws Exception          |  Returns null/false         |
         * +------------------+----------------------------+-----------------------------+
         * |  Insert (head)   |  addFirst(e)               |  offerFirst(e)              |
         * |  Insert (tail)   |  addLast(e) / add(e)       |  offerLast(e) / offer(e)    |
         * |  Remove (head)   |  removeFirst() / remove()  |  pollFirst() / poll()       |
         * |  Remove (tail)   |  removeLast()              |  pollLast()                 |
         * |  Examine (head)  |  getFirst() / element()    |  peekFirst() / peek()       |
         * |  Examine (tail)  |  getLast()                 |  peekLast()                 |
         * +------------------+----------------------------+-----------------------------+
         *
         * Note: ArrayDeque does NOT allow null elements, so null return means "empty".
         */

        ArrayDeque<String> emptyDeque = new ArrayDeque<>();

        // Safe methods return null on empty deque
        System.out.println("peek() on empty: " + emptyDeque.peek());           // null
        System.out.println("poll() on empty: " + emptyDeque.poll());           // null
        System.out.println("peekFirst() on empty: " + emptyDeque.peekFirst()); // null
        System.out.println("peekLast() on empty: " + emptyDeque.peekLast());   // null
        System.out.println("pollFirst() on empty: " + emptyDeque.pollFirst()); // null
        System.out.println("pollLast() on empty: " + emptyDeque.pollLast());   // null

        // Unsafe methods throw NoSuchElementException on empty deque
        // emptyDeque.getFirst();    // throws NoSuchElementException
        // emptyDeque.getLast();     // throws NoSuchElementException
        // emptyDeque.element();    // throws NoSuchElementException
        // emptyDeque.remove();     // throws NoSuchElementException
        // emptyDeque.removeFirst(); // throws NoSuchElementException
        // emptyDeque.removeLast();  // throws NoSuchElementException
        // emptyDeque.pop();        // throws NoSuchElementException

        System.out.println("(getFirst/getLast/element/remove/pop throw NoSuchElementException on empty deque)");

        System.out.println();

        // ================================================================
        //  PART F: USING ARRAYDEQUE AS STACK, QUEUE, AND DEQUE
        // ================================================================

        System.out.println("========== PART F: STACK, QUEUE & DEQUE USAGE ==========\n");

        // ---- Using ArrayDeque as a STACK (LIFO) ----
        // ArrayDeque is recommended over java.util.Stack for stack operations
        System.out.println("--- Stack (LIFO) ---");
        ArrayDeque<Integer> myStack = new ArrayDeque<>();
        myStack.push(10);  // push onto top
        myStack.push(20);
        myStack.push(30);
        System.out.println("Stack after pushes: " + myStack);
        System.out.println("peek (top): " + myStack.peek());
        System.out.println("pop: " + myStack.pop());
        System.out.println("pop: " + myStack.pop());
        System.out.println("Stack now: " + myStack);

        System.out.println();

        // ---- Using ArrayDeque as a QUEUE (FIFO) ----
        // ArrayDeque is recommended over LinkedList for queue operations
        System.out.println("--- Queue (FIFO) ---");
        Queue<Integer> myQueue = new ArrayDeque<>();
        myQueue.offer(10);  // enqueue at tail
        myQueue.offer(20);
        myQueue.offer(30);
        System.out.println("Queue after offers: " + myQueue);
        System.out.println("peek (front): " + myQueue.peek());
        System.out.println("poll (dequeue): " + myQueue.poll());
        System.out.println("poll (dequeue): " + myQueue.poll());
        System.out.println("Queue now: " + myQueue);

        System.out.println();

        // ---- Using ArrayDeque as a DEQUE (Double-Ended Queue) ----
        System.out.println("--- Deque (Double-Ended Queue) ---");
        Deque<Integer> myDeque = new ArrayDeque<>();
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
        //  PART G: WAYS TO ACCESS / ITERATE ELEMENTS
        // ================================================================

        System.out.println("========== PART G: ITERATION METHODS ==========\n");

        /*
         * Note: ArrayDeque does NOT support index-based access (no get(i) method).
         * Unlike ArrayList and LinkedList, you CANNOT use a traditional for loop
         * with indices. You must use iterators or for-each.
         */

        ArrayDeque<String> colors = new ArrayDeque<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));
        System.out.println("Deque: " + colors);
        System.out.println();

        // (1) Enhanced for-each loop
        System.out.print("(1) For-each loop:    ");
        for (String color : colors) {
            System.out.print(color + " ");
        }
        System.out.println();

        // (2) Iterator (forward — head to tail)
        System.out.print("(2) Iterator:         ");
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // (3) Descending Iterator (backward — tail to head)
        System.out.print("(3) descendingIter:   ");
        Iterator<String> descIt = colors.descendingIterator();
        while (descIt.hasNext()) {
            System.out.print(descIt.next() + " ");
        }
        System.out.println();

        // (4) forEach with lambda (Java 8+)
        System.out.print("(4) forEach lambda:   ");
        colors.forEach(c -> System.out.print(c + " "));
        System.out.println();

        // (5) Converting to array and using for loop (workaround for index access)
        System.out.print("(5) toArray + for:    ");
        String[] colorArr = colors.toArray(new String[0]);
        for (int i = 0; i < colorArr.length; i++) {
            System.out.print(colorArr[i] + " ");
        }
        System.out.println();

        System.out.println();

        // ================================================================
        //  PART H: ARRAYDEQUE vs LINKEDLIST vs STACK
        // ================================================================

        System.out.println("========== PART H: WHEN TO USE ARRAYDEQUE ==========\n");

        /*
         * ArrayDeque vs LinkedList:
         *   ✅ ArrayDeque is faster for both Stack and Queue operations
         *   ✅ ArrayDeque uses less memory (no node overhead)
         *   ❌ ArrayDeque does NOT allow null elements
         *   ❌ ArrayDeque does NOT implement List (no get(i), set(i), indexOf)
         *
         * ArrayDeque vs java.util.Stack:
         *   ✅ ArrayDeque is NOT synchronized (faster for single-threaded use)
         *   ✅ Stack extends Vector which is legacy and synchronized
         *   ✅ Java docs recommend ArrayDeque over Stack
         *
         * Use ArrayDeque when:
         *   - You need a Stack (LIFO) → use push(), pop(), peek()
         *   - You need a Queue (FIFO) → use offer(), poll(), peek()
         *   - You need a Deque → use offerFirst/Last(), pollFirst/Last()
         *   - You don't need null elements or index-based access
         */

        System.out.println("See comments in source code for comparison details.");

        // ============================================================
        // FINAL STATE
        // ============================================================
        System.out.println("\n=== Final state of 'fruits' ===");
        System.out.println("Contents: " + fruits);
        System.out.println("Size: " + fruits.size());

        System.out.println("\n✅ All ArrayDeque methods demonstrated successfully!");
    }
}
