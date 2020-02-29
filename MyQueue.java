public class MyQueue<T> implements QueueInterface<T> {

	private T myQueue[];
	private int size = 10;
	private int queueNum = 0;
	private int frontVal = 0;
	private int backVal = 0;
	
	@SuppressWarnings("unchecked")
	public MyQueue() {
		myQueue = (T[]) new Object[size];
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue(int i) {
		
		size = i;
		myQueue = (T[]) new Object[i];
	}
	
	public boolean isEmpty() {
		
		return queueNum == 0;
	}

	public boolean isFull() {
		
		if(queueNum >= myQueue.length) {
			return true;
		}
		
		else
			return false;
	}

	public T dequeue() {
		
		T front;
		
		if(isEmpty()) {
			
			front = null;
		}
		
		else {
		
			front = myQueue[frontVal];
			frontVal = (frontVal + 1) % size;
			queueNum--;
		}
		return front;
	}

	public int size() {
		return queueNum;
	}

	
	public boolean enqueue(T j) {
		
		if(isFull()) {
			
			return false;
		}
		
		else {
		
			myQueue[backVal] = j;
			
			backVal = (backVal + 1) % size;
			
			queueNum++;
		}
		
		return true;
	}

	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		
		int e = frontVal;
		
		T[] copy = (T[]) new Object[queueNum];
		
		for(int i = 0; i < queueNum; i++) {
			
			copy[i] = myQueue[e];
			
			e = (e + 1) % queueNum;
		}
		
		return copy; 
	}
}
