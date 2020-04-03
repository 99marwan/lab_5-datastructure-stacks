package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
public class Stack implements IStack{
	private Node top;
	private int size;
	public Stack() {
		top=null;
		size=0;
	}

	@Override
	public Object pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		
		Object temp=top.getElement();
		
		top=top.getNext();
		size--;
		return temp;
	}

	@Override
	public Object peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getElement();
	}

	@Override
	public void push(Object element) {
		Node v=new Node(element,top);
		top=v;
		size++;
	}

	@Override
	public boolean isEmpty() {
		if(top==null)
			return true;
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}
	

}
