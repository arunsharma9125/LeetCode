package leetCode;

import java.util.Stack;

public class MyQueue {

	/** Initialize your data structure here. */
	Stack<Integer> first, second;

	public MyQueue() {
		first = new Stack<Integer>();
		second = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		first.push(x);

	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		int removedElement = first.pop();
		while (true) {
			if (first.isEmpty()) {
				break;
			}
			
			second.push(removedElement);
			removedElement = first.pop();

		}
		while (second.isEmpty() == false) {
			first.push(second.pop());
		}

		return removedElement;

	}

	/** Get the front element. */
	public int peek() {
		int removedElement = first.pop();
		while (true) {
			if (first.isEmpty()) {
				break;
			}
			
			second.push(removedElement);
			removedElement = first.pop();

		}
		second.push(removedElement);
		while (second.isEmpty() == false) {
			first.push(second.pop());
		}

		return removedElement;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return first.isEmpty();
	}
	
	public static void main(String []args){
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		System.out.println(myQueue.peek());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.empty());
	}
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
