package jsjf;

/**
 * A variation of the LinkedStack where the stack has a maximum size.
 * If the stack is full and a new element is pushed onto it, 
 * the bottom-most element will be dropped out.
 *
 * @param <T> the type of elements held in this stack
 */
public class LinkedDropOutStack<T> extends LinkedStack<T>{
    
    // Maximum size for the stack
    private int maxSize;

    /**
     * Creates a new LinkedDropOutStack with the specified maximum size.
     *
     * @param maxSize the maximum number of elements the stack can hold
     */
    public LinkedDropOutStack(int maxSize){
        super();
        this.maxSize = maxSize;
    }

    /**
     * Pushes a new element onto the stack. If the stack is already full, 
     * the bottom-most element is removed to make space.
     *
     * @param element the element to be pushed onto the stack
     */
    public void push(T element){
        
        // If stack is already at its max size
        if (size() == maxSize){
            
            // Traverse until the second last node
            LinearNode<T> current = top;
            for(int i = 0; i < count - 2; i++){
                current = current.getNext();
            }
            
            // Remove the last node
            current.setNext(null);
            count--;
        }
        
        // Push the new element onto the stack using the superclass' push method
        super.push(element);
    }
}

