package eg.edu.alexu.csd.datastructure.stack;

/**
 * this class has all properties of node
 * @author smart
 *
 */
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
	 * @return the element of this node
	 */
	public Object getElement() {
		return element; 
	}
	
	/**
	 * @return  the next node of this node.
	 */
	public Node getNext() {
		return next; 
	}
	// Modifier methods:
	/**
	 * Sets the element of this node. 
	 * @param newElem
	 * to be set
	 */
	public void setElement(Object newElem) {
		element = newElem;
	}
	/**
	 * Sets the next node of this node
	 * @param newNext
	 * to be set
	 */
	public void setNext(Node newNext) { 
		next = newNext;
	}

}
