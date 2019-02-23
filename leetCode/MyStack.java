package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	Queue<Integer> first, second;

	public MyStack() {
		first = new LinkedList<Integer>();
		second = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		first.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		second.clear();
		Integer removedElement = first.poll();
		while(true){
			if(first.isEmpty())
				break;
			second.add(removedElement);
			removedElement = first.poll();
		}
		while (second.isEmpty() == false) {
			Integer element = second.poll();
			first.add(element);
		}
		return removedElement;
	}

	/** Get the top element. */
	public int top() {
		second.clear();
		int top = 0;
		while (first.isEmpty() == false) {
			Integer element = first.poll();
			top = element;
			second.add(element);
		}
		while (second.isEmpty() == false) {
			Integer element = second.poll();
			first.add(element);
		}
		return top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return first.isEmpty();
	}
	
	public static void main(String []args){
		MyStack st = new MyStack();
		st.push(1);
		st.push(2);
		System.out.println( st.top() );
		System.out.println( st.pop() );
		System.out.println(st.empty());
	}
}
