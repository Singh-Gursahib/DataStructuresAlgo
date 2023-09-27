package jsjf;

import jsjf.exceptions.EmptyCollectionException;

public class Driver {

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        // Push five elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("After pushing 1 through 5: ");
        System.out.println(stack);

        // Peek the top of the stack
        try {
            System.out.println("Top of the stack: " + stack.peek());
        } catch (EmptyCollectionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Pop two elements from the stack
        try {
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
            System.out.println("After popping two elements: ");
            System.out.println(stack);
        } catch (EmptyCollectionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Check if the stack is empty and its size
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Size of the stack: " + stack.size());

        // Push two more elements onto the stack
        stack.push(6);
        stack.push(7);
        System.out.println("After pushing 6 and 7: ");
        System.out.println(stack);

        // Pop all elements from the stack until it's empty
        while (!stack.isEmpty()) {
            try {
                System.out.println("Popped: " + stack.pop());
            } catch (EmptyCollectionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Check if the stack is empty and its size after popping all elements
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("Size of the stack: " + stack.size());

        // Try to peek the top of the empty stack to catch the exception
        try {
            System.out.println("Top of the stack: " + stack.peek());
        } catch (EmptyCollectionException e) {
            System.out.println("Error while peeking: " + e.getMessage());
        }
    }
}
