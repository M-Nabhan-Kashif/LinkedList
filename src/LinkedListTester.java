/*  Student information for assignment:
 *
 *  On my honor, Mohammad Kashif, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Mohammad kashif
 *  email address: mohammadnkashif@utexas.edu
 *  UTEID: mnk665
 *  Section 5 digit ID: 52055
 *  Grader name: Pranav Chandupatla
 *  Number of slip days used on this assignment: 0
 */

/* Experiment results:
 *
 * Adding at end: ArrayList is faster
        * ArrayList: O(N) Time increases linearly with size of input.
        * LinkedList: O(N) Time increases linearly with size of input.
 * Adding at front: LinkedList is faster
        * ArrayList:O(N) Time increases linearly with size of input.
        * LinkedList: O(N) Time increases linearly with size of input.
 * Removing from front: LinkedList is faster
        * ArrayList:O(N^2) Time increases quadratically as size doubles.
        * LinkedList: O(N) Time increases linearly with size of input.
 * Getting random: ArrayList is faster
        * ArrayList:O(1) Time is doubling as size doubles, getting a random
        * element requires constant time regardless of ArrayList size
        * LinkedList: O(N) Time increases linearly with size of input.
 * Getting all using iterator: ArrayList is faster
        * ArrayList:O(N) Time increases linearly with size of input.
        * LinkedList: O(N) Time increases linearly with size of input.
 * Getting all using get method: Arraylist is faster
        * ArrayList: O(N) Time increases linearly with size of input.
        * LinkedList: O(N^2) Time increases quadratically as size doubles.
 *
 */

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {
        basicTests();
    }

    private static void basicTests() {

        System.out.println("****** ALL TESTS *******\n");
        LinkedList<String> list = new LinkedList<>();

        // test 1
        System.out.println("\nTest 1: Adding at front");
        list.addFirst("Q");
        Object[] actual = toArray(list);
        Object[] expected = new Object[] {"Q"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Failed test 1");
        }

        // test 2
        System.out.println("\nTest 2: Adding at front");
        list.addFirst("P");
        actual = toArray(list);
        expected = new Object[] {"P", "Q"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Failed test 2");
        }

        // test 3
        System.out.println("\nTest 3: Adding at front");
        list.addFirst("O");
        actual = toArray(list);
        expected = new Object[] {"O", "P", "Q"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Failed test 3");
        }

        // test 4
        System.out.println("\nTest 4: Adding at end");
        list = new LinkedList<>();
        list.addLast("D");
        actual = toArray(list);
        expected = new Object[] {"D"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Failed test 4");
        }

        // test 5
        System.out.println("\nTest 5: Adding at end");
        list.addLast("K");
        actual = toArray(list);
        expected = new Object[] {"D", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Failed test 5");
        }

        // test 6
        System.out.println("\nTest 6: Adding at end");
        list.addLast("s");
        actual = toArray(list);
        expected = new Object[] {"D", "K", "s"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Failed test 6");
        }

        // test 7
        System.out.println("\nTest 7: Removing first");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {"K", "s"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Failed test 7");
        }

        // test 8
        System.out.println("\nTest 8: Removing first");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {"s"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Failed test 8");
        }

        // test 9
        System.out.println("\nTest 9: Removing first");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 9");
        } else {
            System.out.println("Failed test 9");
        }

        list.add("a");
        list.add("b");
        list.add("c");

        // test 10
        System.out.println("\nTest 10: Removing last");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {"a", "b"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }

        // test 11
        System.out.println("\nTest 11: Removing last");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {"a"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 11");
        } else {
            System.out.println("Failed test 11");
        }

        // test 12
        System.out.println("\nTest 12: Removing last");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 12");
        } else {
            System.out.println("Failed test 12");
        }

        // test 13
        System.out.println("\nTest 13: Adding");
        list.add("M");
        actual = toArray(list);
        expected = new Object[] {"M"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 13");
        } else {
            System.out.println("Failed test 13");
        }

        // test 14
        System.out.println("\nTest 14: Adding");
        list.add("N");
        actual = toArray(list);
        expected = new Object[] {"M", "N"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 14");
        } else {
            System.out.println("Failed test 14");
        }

        // test 15
        System.out.println("\nTest 15: Adding");
        list.add("K");
        actual = toArray(list);
        expected = new Object[] {"M", "N", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 15");
        } else {
            System.out.println("Failed test 15");
        }

        // test 16
        System.out.println("\nTest 16: Inserting");
        list.insert(2, "A");
        actual = toArray(list);
        expected = new Object[] {"M", "N", "A", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 16");
        } else {
            System.out.println("Failed test 16");
        }

        // test 17
        System.out.println("\nTest 17: Inserting");
        list.insert(0, "L");
        actual = toArray(list);
        expected = new Object[] {"L", "M", "N", "A", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 17");
        } else {
            System.out.println("Failed test 17");
        }

        // test 18
        System.out.println("\nTest 18: Inserting");
        list.insert(2, "O");
        actual = toArray(list);
        expected = new Object[] {"L", "M", "O", "N", "A", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 18");
        } else {
            System.out.println("Failed test 18");
        }

        // test 19
        System.out.println("\nTest 19: Setting");
        String oldValue = list.set(2, "R");
        actual = toArray(list);
        expected = new Object[] {"L", "M", "R", "N", "A", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 19.1");
        } else {
            System.out.println("Failed test 19.1");
        }
        if (oldValue.equals("O")) {
            System.out.println("Passed test 19.2");
        } else {
            System.out.println("Failed test 19.2");
        }

        // test 20
        System.out.println("\nTest 20: Setting");
        oldValue = list.set(0, "E");
        actual = toArray(list);
        expected = new Object[] {"E", "M", "R", "N", "A", "K"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 20.1");
        } else {
            System.out.println("Failed test 20.1");
        }
        if (oldValue.equals("L")) {
            System.out.println("Passed test 20.2");
        } else {
            System.out.println("Failed test 20.2");
        }

        // test 21
        System.out.println("\nTest 21: Setting");
        oldValue = list.set(5, "Q");
        actual = toArray(list);
        expected = new Object[] {"E", "M", "R", "N", "A", "Q"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 21.1");
        } else {
            System.out.println("Failed test 21.1");
        }
        if (oldValue.equals("K")) {
            System.out.println("Passed test 21.2");
        } else {
            System.out.println("Failed test 21.2");
        }

        // test 22
        System.out.println("\nTest 22: Getting");
        String actualValue = list.get(5);
        String value = "Q";
        System.out.println("Expected result: " + value);
        System.out.println("Actual result: " + actualValue);
        if (actualValue.equals(value)) {
            System.out.println("Passed test 22");
        } else {
            System.out.println("Failed test 22");
        }

        // test 23
        System.out.println("\nTest 23: Getting");
        actualValue = list.get(0);
        value = "E";
        System.out.println("Expected result: " + value);
        System.out.println("Actual result: " + actualValue);
        if (actualValue.equals(value)) {
            System.out.println("Passed test 23");
        } else {
            System.out.println("Failed test 23");
        }

        // test 24
        System.out.println("\nTest 24: Getting");
        actualValue = list.get(3);
        value = "N";
        System.out.println("Expected result: " + value);
        System.out.println("Actual result: " + actualValue);
        if (actualValue.equals(value)) {
            System.out.println("Passed test 24");
        } else {
            System.out.println("Failed test 24");
        }

        // test 25
        System.out.println("\nTest 25: Removing with Index");
        list.remove(5);
        actual = toArray(list);
        expected = new Object[] {"E", "M", "R", "N", "A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 25");
        } else {
            System.out.println("Failed test 25");
        }

        // test 26
        System.out.println("\nTest 26: Removing with Index");
        list.remove(2);
        actual = toArray(list);
        expected = new Object[] {"E", "M", "N", "A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 26");
        } else {
            System.out.println("Failed test 26");
        }

        // test 27
        System.out.println("\nTest 27: Removing with Index");
        list.remove(0);
        actual = toArray(list);
        expected = new Object[] {"M", "N", "A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 27");
        } else {
            System.out.println("Failed test 27");
        }

        // test 28
        System.out.println("\nTest 28: Removing with Objects");
        list.remove("A");
        actual = toArray(list);
        expected = new Object[] {"M", "N"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 28");
        } else {
            System.out.println("Failed test 28");
        }

        // test 29
        System.out.println("\nTest 29: Removing with Objects");
        list.remove("M");
        actual = toArray(list);
        expected = new Object[] {"N"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 29");
        } else {
            System.out.println("Failed test 29");
        }

        // test 30
        System.out.println("\nTest 30: Removing with Objects");
        list.remove("N");
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 30");
        } else {
            System.out.println("Failed test 30");
        }

        list.makeEmpty();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");

        // test 31
        System.out.println("\nTest 31: GetSubList");
        ArrayList<String> toCompare = linkedListToArrayList(list);

        int start = 2;
        int stop = 5;
        System.out.println(list);

        IList<String> actualA = list.getSubList(start, stop);
        System.out.println(list);
        System.out.println(list.size());
        List<String> expectedB = toCompare.subList(start, stop);
        expected = expectedB.toArray(new String[expectedB.size()]);
        actual = toArray2(actualA);
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 31");
        } else {
            System.out.println("Failed test 31");
        }
        System.out.println(list);
        System.out.println(list.size());


        // test 32
        System.out.println("\nTest 32: GetSubList");
        start = 0;
        stop = 3;
        actualA = list.getSubList(start, stop);
        expectedB = toCompare.subList(start, stop);
        expected = expectedB.toArray(new String[expectedB.size()]);
        actual = toArray2(actualA);
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 32");
        } else {
            System.out.println("Failed test 32");
        }

        // test 33
        System.out.println("\nTest 33: GetSubList");
        start = 0;
        stop = 6;
        actualA = list.getSubList(start, stop);
        expectedB = toCompare.subList(start, stop);
        expected = expectedB.toArray(new String[expectedB.size()]);
        actual = toArray2(actualA);
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 33");
        } else {
            System.out.println("Failed test 33");
        }

        // test 34
        System.out.println("\nTest 34: Size");
        if (list.size() == 7) {
            System.out.println("Passed test 34");
        } else {
            System.out.println("Failed test 34");
        }

        list.removeLast();
        list.removeLast();

        // test 35
        System.out.println("\nTest 35: Size");
        if (list.size() == 5) {
            System.out.println("Passed test 35");
        } else {
            System.out.println("Failed test 35");
        }

        list.makeEmpty();

        // test 36
        System.out.println("\nTest 36: Size");
        if (list.size() == 0) {
            System.out.println("Passed test 36");
        } else {
            System.out.println("Failed test 36");
        }

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");

        // test 37
        System.out.println("\nTest 37: IndexOf(object)");
        if (list.indexOf("E") == 4) {
            System.out.println("Passed test 37");
        } else {
            System.out.println("Failed test 37");
        }

        // test 38
        System.out.println("\nTest 38: IndexOf(object)");
        if (list.indexOf("B") == 1) {
            System.out.println("Passed test 38");
        } else {
            System.out.println("Failed test 38");
        }

        // test 39
        System.out.println("\nTest 39: IndexOf(object)");
        if (list.indexOf("H") == -1) {
            System.out.println("Passed test 39");
        } else {
            System.out.println("Failed test 39");
        }

        // test 40
        System.out.println("\nTest 40: IndexOf(object, position)");
        if (list.indexOf("A", 2) == -1) {
            System.out.println("Passed test 40");
        } else {
            System.out.println("Failed test 40");
        }

        // test 41
        System.out.println("\nTest 41: IndexOf(object, position)");
        if (list.indexOf("C", 2) == 2) {
            System.out.println("Passed test 41");
        } else {
            System.out.println("Failed test 41");
        }

        // test 42
        System.out.println("\nTest 42: IndexOf(size, position)");
        if (list.indexOf("E", 1) == 4) {
            System.out.println("Passed test 42");
        } else {
            System.out.println("Failed test 42");
        }

        // test 43
        System.out.println("\nTest 43: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 43");
        } else {
            System.out.println("Failed test 43");
        }

        list.add("M");

        // test 44
        System.out.println("\nTest 44: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 44");
        } else {
            System.out.println("Failed test 44");
        }

        list.add("N");
        list.add("K");

        // test 45
        System.out.println("\nTest 45: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 45");
        } else {
            System.out.println("Failed test 45");
        }

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");

        // test 46
        System.out.println("\nTest 46: Removing range");
        list.removeRange(5, 8);
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C", "D", "E"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 46");
        } else {
            System.out.println("Failed test 46");
        }

        // test 47
        System.out.println("\nTest 47: Removing range");
        list.removeRange(0, 3);
        actual = toArray(list);
        expected = new Object[] {"D", "E"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 47");
        } else {
            System.out.println("Failed test 47");
        }

        // test 48
        System.out.println("\nTest 48: Removing range");
        list.removeRange(0, 2);
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 48");
        } else {
            System.out.println("Failed test 48");
        }

        list.makeEmpty();
        list.add("M");
        list.add("N");
        list.add("K");

        // test 49
        System.out.println("\nTest 49: To String");
        toCompare = linkedListToArrayList(list);
        String expectedStr = toCompare.toString();
        String actualStr = list.toString();
        if (expectedStr.equals(actualStr)) {
            System.out.println("Passed test 49");
        } else {
            System.out.println("Failed test 49");
        }

        list.add("Y");
        list.add("R");

        // test 50
        System.out.println("\nTest 50: To String");
        toCompare = linkedListToArrayList(list);
        expectedStr = toCompare.toString();
        actualStr = list.toString();
        if (expectedStr.equals(actualStr)) {
            System.out.println("Passed test 50");
        } else {
            System.out.println("Failed test 50");
        }

        list.makeEmpty();

        // test 51
        System.out.println("\nTest 51: To String");
        toCompare = linkedListToArrayList(list);
        expectedStr = toCompare.toString();
        actualStr = list.toString();
        if (expectedStr.equals(actualStr)) {
            System.out.println("Passed test 51");
        } else {
            System.out.println("Failed test 51");
        }

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
        list2.add("D");

        // test 52
        System.out.println("\nTest 52: Equals");
        if (list.equals(list2)) {
            System.out.println("Passed test 51");
        } else {
            System.out.println("Failed test 51");
        }

        list.remove("A");

        // test 53
        System.out.println("\nTest 53: Equals");
        if (!list.equals(list2)) {
            System.out.println("Passed test 53");
        } else {
            System.out.println("Failed test 53");
        }

        list2.remove("A");

        // test 54
        System.out.println("\nTest 54: Equals");
        if (list.equals(list2)) {
            System.out.println("Passed test 54");
        } else {
            System.out.println("Failed test 54");
        }

        // test 55
        System.out.println("\nTest 55: Iterator Creation");
        toCompare = linkedListToArrayList(list);
        if (list.iterator().hasNext() && list.iterator().next().equals(toCompare.get(0))) {
            System.out.println("Passed test 55");
        }
        else {
            System.out.println("Failed test 55");
        }

        list.removeLast();
        list.removeLast();

        // test 56
        System.out.println("\nTest 56: Iterator Creation");
        toCompare = linkedListToArrayList(list);
        if (list.iterator().hasNext() && list.iterator().next().equals(toCompare.get(0))) {
            System.out.println("Passed test 56");
        }
        else {
            System.out.println("Failed test 56");
        }

        list.add("E");

        // test 57
        System.out.println("\nTest 57: Iterator Creation");
        toCompare = linkedListToArrayList(list);
        if (list.iterator().hasNext() && list.iterator().next().equals(toCompare.get(0))) {
            System.out.println("Passed test 57");
        }
        else {
            System.out.println("Failed test 57");
        }

        // test 58
        System.out.println("\nTest 58: Iterator hasNext");
        if (list.iterator().hasNext()) {
            System.out.println("Passed test 58");
        }
        else {
            System.out.println("Failed test 58");
        }

        list.makeEmpty();

        // test 59
        System.out.println("\nTest 59: Iterator hasNext");
        if (!list.iterator().hasNext()) {
            System.out.println("Passed test 59");
        }
        else {
            System.out.println("Failed test 59");
        }

        // test 60
        System.out.println("\nTest 60: Iterator hasNext");
        if (list2.iterator().hasNext()) {
            System.out.println("Passed test 60");
        }
        else {
            System.out.println("Failed test 60");
        }

        list.add("A");
        list.add("B");
        list.add("C");

        // test 61
        Iterator<String> iterator = list.iterator();
        System.out.println("\nTest 61: Iterator next");
        if (iterator.next() == "A") {
            System.out.println("Passed test 61");
        }
        else {
            System.out.println("Failed test 61");
        }

        // test 62
        System.out.println("\nTest 62: Iterator next");
        list.iterator().next();
        if (iterator.next() == "B") {
            System.out.println("Passed test 62");
        }
        else {
            System.out.println("Failed test 62");
        }

        // test 63
        System.out.println("\nTest 63: Iterator next");
        if (iterator.next() == "C") {
            System.out.println("Passed test 63");
        }
        else {
            System.out.println("Failed test 63");
        }

        // test 64
        System.out.println("\nTest 64: Iterator remove");
        iterator = list.iterator();
        iterator.next();
        iterator.remove();
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 64");
        } else {
            System.out.println("Failed test 64");
        }

        // test 65
        System.out.println("\nTest 65: Iterator remove");
        iterator.next();
        iterator.remove();
        actual = toArray(list);
        expected = new Object[] {"C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 65");
        } else {
            System.out.println("Failed test 65");
        }

        // test 66
        System.out.println("\nTest 66: Iterator remove");
        iterator.next();
        iterator.remove();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 66");
        } else {
            System.out.println("Failed test 66");
        }

    }

    // Convert elements of list to an array. Uses the list
    // size method and iterator.
    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    private static String[] toArray2(IList<String> actualA) {
        String[] result = new String[actualA.size()];
        Iterator<String> it = actualA.iterator();
        int index = 0;
        while (it.hasNext()) {
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }

    private static ArrayList<String> linkedListToArrayList(LinkedList<String> testList) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> s = testList.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }
}
