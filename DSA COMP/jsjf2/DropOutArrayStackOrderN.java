package jsjf2;


public class DropOutArrayStackOrderN<T> extends ArrayStack<T> {

    public DropOutArrayStackOrderN() {
        super();
    }

    public DropOutArrayStackOrderN(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void push(T element) {
        if (size() == stack.length) {
            // Shift all elements down by 1 when stack is full
            for (int i = 1; i < stack.length; i++) {
                stack[i - 1] = stack[i];
            }
            // Put the new element at the top
            stack[stack.length - 1] = element;
        } else {
            stack[top] = element;
            top++;
        }
    }

    
}
