import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListPractice {
    public static void main(String[] args) {

        // ============================================================
        // 1. add(E element) — Appends element to the end of the list
        // ============================================================
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");
        fruits.add("Pineapple");
        fruits.add("Strawberry");
        System.out.println("1. add(E): " + fruits);

        // ============================================================
        // 2. add(int index, E element) — Inserts element at the given index
        // ============================================================
        fruits.add(2, "Watermelon");
        System.out.println("2. add(2, 'Watermelon'): " + fruits);

        // ============================================================
        // 3. get(int index) — Returns the element at the specified index
        // ============================================================
        String fruit = fruits.get(3);
        System.out.println("3. get(3): " + fruit);

        // ============================================================
        // 4. set(int index, E element) — Replaces element at the given index, returns old value
        // ============================================================
        String old = fruits.set(0, "Dragon Fruit");
        System.out.println("4. set(0, 'Dragon Fruit') replaced: " + old);
        System.out.println("   List after set(): " + fruits);

        // ============================================================
        // 5. remove(int index) — Removes and returns element at given index
        // ============================================================
        String removed = fruits.remove(1);
        System.out.println("5. remove(1) removed: " + removed);
        System.out.println("   List after remove(index): " + fruits);

        // ============================================================
        // 6. remove(Object o) — Removes the first occurrence of the element, returns boolean
        // ============================================================
        boolean success = fruits.remove("Grapes");
        System.out.println("6. remove('Grapes'): " + success);
        System.out.println("   List after remove(object): " + fruits);

        // ============================================================
        // 7. size() — Returns the number of elements in the list
        // ============================================================
        System.out.println("7. size(): " + fruits.size());

        // ============================================================
        // 8. isEmpty() — Returns true if the list has no elements
        // ============================================================
        System.out.println("8. isEmpty(): " + fruits.isEmpty());
        System.out.println("   new ArrayList isEmpty(): " + new ArrayList<>().isEmpty());

        // ============================================================
        // 9. contains(Object o) — Returns true if the list contains the element
        // ============================================================
        System.out.println("9. contains('Dragon Fruit'): " + fruits.contains("Dragon Fruit"));
        System.out.println("   contains('Banana'): " + fruits.contains("Banana"));

        // ============================================================
        // 10. indexOf(Object o) — Returns index of first occurrence, or -1 if not found
        // ============================================================
        fruits.add("Watermelon"); // adding duplicate for demo
        System.out.println("10. List: " + fruits);
        System.out.println("    indexOf('Watermelon'): " + fruits.indexOf("Watermelon"));

        // ============================================================
        // 11. lastIndexOf(Object o) — Returns index of last occurrence, or -1 if not found
        // ============================================================
        System.out.println("11. lastIndexOf('Watermelon'): " + fruits.lastIndexOf("Watermelon"));

        // ============================================================
        // 12. addAll(Collection c) — Appends all elements from another collection
        // ============================================================
        ArrayList<String> more = new ArrayList<>(Arrays.asList("Kiwi", "Papaya"));
        fruits.addAll(more);
        System.out.println("12. addAll(): " + fruits);

        // ============================================================
        // 13. removeAll(Collection c) — Removes all elements that are in the given collection
        // ============================================================
        fruits.removeAll(Arrays.asList("Kiwi", "Papaya"));
        System.out.println("13. removeAll(['Kiwi','Papaya']): " + fruits);

        // ============================================================
        // 14. retainAll(Collection c) — Keeps ONLY elements that are in the given collection
        // ============================================================
        ArrayList<String> retainDemo = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        retainDemo.retainAll(Arrays.asList("B", "D"));
        System.out.println("14. retainAll(['B','D']) on [A,B,C,D]: " + retainDemo);

        // ============================================================
        // 15. containsAll(Collection c) — Returns true if list contains ALL given elements
        // ============================================================
        System.out.println("15. containsAll(['Dragon Fruit','Watermelon']): "
                + fruits.containsAll(Arrays.asList("Dragon Fruit", "Watermelon")));

        // ============================================================
        // 16. clear() — Removes all elements from the list
        // ============================================================
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        System.out.println("16. Before clear(): " + temp);
        temp.clear();
        System.out.println("    After clear(): " + temp);

        // ============================================================
        // 17. subList(int fromIndex, int toIndex) — Returns a view of part of the list
        //     (fromIndex inclusive, toIndex exclusive)
        // ============================================================
        System.out.println("17. List: " + fruits);
        List<String> sub = fruits.subList(1, 3);
        System.out.println("    subList(1, 3): " + sub);

        // ============================================================
        // 18. sort(Comparator) — Sorts the list using a comparator
        // ============================================================
        ArrayList<String> sortDemo = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry", "Date"));
        sortDemo.sort(Comparator.naturalOrder());
        System.out.println("18. sort(naturalOrder): " + sortDemo);
        sortDemo.sort(Comparator.reverseOrder());
        System.out.println("    sort(reverseOrder): " + sortDemo);

        // ============================================================
        // 19. toArray() — Converts the ArrayList to an array
        // ============================================================
        Object[] objArray = fruits.toArray();
        System.out.println("19. toArray(): " + Arrays.toString(objArray));

        String[] strArray = fruits.toArray(new String[0]);
        System.out.println("    toArray(String[]): " + Arrays.toString(strArray));

        // ============================================================
        // 20. clone() — Creates a shallow copy of the ArrayList
        // ============================================================
        @SuppressWarnings("unchecked")
        ArrayList<String> cloned = (ArrayList<String>) fruits.clone();
        System.out.println("20. clone(): " + cloned);
        System.out.println("    equals original? " + fruits.equals(cloned));
        System.out.println("    same reference? " + (fruits == cloned));

        System.out.println();

        // ================================================================
        //  WAYS TO ACCESS / ITERATE ELEMENTS
        // ================================================================

        System.out.println("========== ITERATION METHODS ==========\n");

        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Green", "Blue", "Yellow", "Purple"));
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

        // (7) forEach with lambda (Java 8+)
        System.out.print("(7) forEach lambda:   ");
        colors.forEach(c -> System.out.print(c + " "));
        System.out.println();

        // ============================================================
        // FINAL STATE
        // ============================================================
        System.out.println("\n=== Final state of 'fruits' ===");
        System.out.println("Contents: " + fruits);
        System.out.println("Size: " + fruits.size());

        System.out.println("\n✅ All ArrayList methods demonstrated successfully!");
    }
}
