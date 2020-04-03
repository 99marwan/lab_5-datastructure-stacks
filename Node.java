package eg.edu.alexu.csd.datastructure.stack;

public class Node {
	private Object element;
	private Node next;
	
	public Node() {
		this(null,null);
	}
	public Node(Object obj,Node n) {
		element=obj;
		next=n;
	}
	/** 
	 * Returns the element of this node.
	 */
	public Object getElement() {
		return element; 
	}
	/** 
	 * Returns the next node of this node.
	 */
	public Node getNext() {
		return next; 
	}
	// Modifier methods:
	/**
	 * Sets the element of this node. 
	 * @param newElem
	 */
	public void setElement(Object newElem) {
		element = newElem;
	}
	/**
	 * Sets the next node of this node
	 * @param newNext
	 */
	public void setNext(Node newNext) { 
		next = newNext;
	}

}
