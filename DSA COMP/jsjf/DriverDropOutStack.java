package jsjf;

public class DriverDropOutStack{
    public static void main(String[] args) {
        // Initialize a new LinkedDropOutStack with a max size of 3
        LinkedDropOutStack<Integer> stack = new LinkedDropOutStack<>(3);

        System.out.println("\nInitializing a new LinkedDropOutStack with a max size of 3.");
        
        // Test pushing elements into the stack
        System.out.println("\nPushing elements 1, 2, and 3 to the stack...");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Current Stack: \n" + stack.toString());  // Expected: 3 -> 2 -> 1

        // Push another element. The bottommost element (1) should be dropped out
        System.out.println("\nPushing element 4 to the stack...");
        stack.push(4);
        System.out.println("Current Stack: \n" + stack.toString());  // Expected: 4 -> 3 -> 2

        // Push another element. The bottommost element (2) should be dropped out
        System.out.println("\nPushing element 5 to the stack...");
        stack.push(5);
        System.out.println("Current Stack: \n" + stack.toString());  // Expected: 5 -> 4 -> 3
    }
}
