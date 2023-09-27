package jsjf2;

/**
 * This driver class is used to test the DropOutArrayStackOrderN implementation.
 * The test involves basic stack operations like push, pop, and peek.
 */
public class DriverOrderN {
    public static void main(String[] args) {
        
        // Display the header to indicate which stack is being tested.
        System.out.println("--- Testing DropOutArrayStackOrderN ---");

        // Initialize a DropOutArrayStackOrderN with an initial capacity of 5.
        DropOutArrayStackOrderN<Integer> stackN = new DropOutArrayStackOrderN<>(5);

        // Push integers 1 through 5 onto the stack.
        // The stack should now contain [1, 2, 3, 4, 5].
        stackN.push(1);
        stackN.push(2);
        stackN.push(3);
        stackN.push(4);
        stackN.push(5);
        
        // Display the state of the stack after the push operations.
        System.out.println("\nState after pushing elements 1 through 5:");
        System.out.println(stackN.toString());

        // Push integer 6 to test the drop-out behavior.
        // The oldest element will be removed and the stack should now contain [2, 3, 4, 5, 6].
        stackN.push(6);
        System.out.println("\nState after pushing 6:");
        System.out.println(stackN.toString());

        // Push integer 7 to test the drop-out behavior again.
        // The oldest element will be removed and the stack should now contain [3, 4, 5, 6, 7].
        stackN.push(7);
        System.out.println("\nState after pushing 7:");
        System.out.println(stackN.toString());

        // Test the pop operation which should remove and return 7.
        System.out.println("\nRemoved element: " + stackN.pop());
        
        // Display the state of the stack after the pop operation.
        System.out.println("\nState after popping:");
        System.out.println(stackN.toString());

        // Test the peek operation, which should return 6 without removing it.
        System.out.println("\nTop element: " + stackN.peek());

        // Display the state of the stack after the peek operation.
        // The state should remain unchanged.
        System.out.println("\nState after peeking:");
        System.out.println(stackN.toString());
    }
}
