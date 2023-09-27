package jsjf2;

public class DriverOrder1 {
    public static void main(String[] args) {
        // Display the header to indicate which stack is being tested. 
        System.out.println("--- Testing DropOutArrayStackOrder1 ---\n");
        // Initialize a DropOutArrayStackOrder1 object with a capacity of 5 elements.
        DropOutArrayStackOrder1<Integer> stack = new DropOutArrayStackOrder1<>(5);

        // Demonstrating push operation: pushing elements 1 through 5 onto the stack.
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        // Display the stack after initial pushes. Expected output: 5, 4, 3, 2, 1
        System.out.println("Stack after pushing elements 1 through 5:");
        System.out.println(stack.toString());

        // Push an additional element (6) to trigger the 'drop-out' mechanism.
        stack.push(6);

        // Display the stack after pushing 6. Expected output: 6, 5, 4, 3, 2
        System.out.println("\nStack after pushing element 6:");
        System.out.println(stack.toString());

        // Push element 7, causing the stack to evict the second-oldest element.
        stack.push(7);

        // Display the stack after pushing 7. Expected output: 7, 6, 5, 4, 3
        System.out.println("\nStack after pushing element 7:");
        System.out.println(stack.toString());

        // Demonstrating pop operation: removing and displaying the top element.
        System.out.println("\nElement popped from the stack: " + stack.pop());

        // Display the stack after popping. Expected output: 6, 5, 4, 3
        System.out.println("\nStack after popping an element:");
        System.out.println(stack.toString());

        // Demonstrating peek operation: viewing the top element without removing it.
        System.out.println("\nElement at the top of the stack: " + stack.peek());

        // Display the stack after peeking. The stack should remain unchanged.
        System.out.println("\nStack after peek operation:");
        System.out.println(stack.toString());
    }
}
