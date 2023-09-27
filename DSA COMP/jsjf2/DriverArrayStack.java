package jsjf2;

import jsjf.exceptions.EmptyCollectionException;

/**
 * This driver class is used to test the ArrayStack implementation.
 * The tests cover stack operations like push, pop, and peek.
 */
public class DriverArrayStack {
    public static void main(String[] args) {

        // Display the header to indicate which stack is being tested.
        System.out.println("--- Testing ArrayStack ---");

        // Initialize an ArrayStack instance with an initial capacity of 5.
        ArrayStack<Integer> stack = new ArrayStack<>(5);

        // Push integers 1 through 5 onto the stack.
        // The stack should now contain [1, 2, 3, 4, 5].
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Display the state of the stack after the push operations.
        System.out.println("\nState after pushing elements 1 through 5:");
        System.out.println(stack.toString());

        // Test the pop operation which should remove and return 5.
        System.out.println("\nRemoved element: " + stack.pop());

        // Display the state of the stack after the pop operation.
        System.out.println("\nState after popping:");
        System.out.println(stack.toString());

        // Test the peek operation, which should return 4 without removing it.
        System.out.println("\nTop element: " + stack.peek());

        // Display the stack after peeking. The stack should remain unchanged.
        System.out.println("\nStack after peek operation:");
        System.out.println(stack.toString());

        // Testing exception-handling: Pop elements until the stack is empty.
        System.out.println("\nAttempting to empty the stack...");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Attempt to pop from an empty stack to trigger an exception.
        try {
            System.out.println("\nAttempting to pop from an empty stack...");
            stack.pop();
        } catch (EmptyCollectionException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Attempt to peek at an empty stack to trigger an exception.
        try {
            System.out.println("\nAttempting to peek at an empty stack...");
            stack.peek();
        } catch (EmptyCollectionException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test the isEmpty method, should return false as the stack is not empty.
        System.out.println("\nIs the stack empty? " + stack.isEmpty());

        
        // Additional test: Expanding the capacity
        // Pushing additional elements to test capacity expansion.
        for (int i = 6; i < 13; i++) {
            stack.push(i);
        }
        // This will trigger an expansion of capacity.
        System.out.println("\nPushing additional elements to test capacity expansion (from 6 - 12).");

        // Display the state of the stack after capacity expansion.
        System.out.println("\nState after capacity expansion:");
        System.out.println(stack.toString());

        // Test the size method, should return the current size of the stack.
        System.out.println("\nSize of the stack: " + stack.size());

    }
}