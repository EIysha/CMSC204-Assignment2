import java.util.*;


public class MyStack<T> implements StackInterface<T> {

	private static final int capacity = 10;
	private T myStack[];
	private int size = 0;
	private int top = 0;
	private int stackCap = 0;
	
	
	public MyStack() {
		
		stackCap = capacity;
		
		myStack = (T[]) new Object [capacity];
		
	}
	
	public MyStack(int i) {
		
		stackCap = i;
		
		myStack = (T[]) new Object[i];
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	public T pop() {
		
		T topVal;
		
		if(isEmpty()) {
			
			return null;
		}
		
		else {
			
			topVal = myStack[--top];
			
			size--;
		}
		
		return topVal;
	}
	
	public boolean isFull() {
		
		return size == stackCap;
	}

	
	public int size() {
		
		return size;
	}

	
	public boolean push(T j) {
		
		if(isFull()) {
			
			return false;
		}
		
		else {
			
			myStack[top] = j;
			
			top += 1;
			size +=1;
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public T[] toArray() {
		
		int e = size - 1;
		T[] copy = (T[]) new Object[size];
		for(int i = 0; i < size; i++) {
			copy[i] = myStack[e--];
		}
		return copy;
	}
}