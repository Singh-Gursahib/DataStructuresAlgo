package jsjf2;

import jsjf.exceptions.*;

public class DropOutArrayStackOrder1<T> extends ArrayStack<T> {

    public DropOutArrayStackOrder1() {
        super();
    }

    public DropOutArrayStackOrder1(int initialCapacity){
        super(initialCapacity);
    }

    @Override
    public void push(T element) {
        if (size() == stack.length) {
            top = 0;
        }
        stack[top] = element;
        top++;
    } 

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        T result;
        if (top == 1){
            result = stack[0];
            stack[0] = null;
            top = stack.length;
        }  else {  
            top--;
            result = stack[top];
            stack[top] = null; 
        }
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        return stack[top - 1];
    }

    public String toString() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
            
        String myStack = "";
        int index = top - 1;
        boolean fullRound = false;

        while (!fullRound) {
            if (stack[index] != null) {
                myStack = myStack + "\n" + stack[index].toString();
            }

            //debugging
            // System.out.println("Index is: "+ index);

            index = (index - 1 + stack.length) % stack.length;
            fullRound = (index == (top - 1));
        }

        return myStack.trim();
    }
}
