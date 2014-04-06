//This is for SINGLY linked lists
//COMPLETE

public class IntNode {
	private int value;
	private IntNode next;
	
	IntNode() {
		value = 0;
		next = null;
	}
	
	IntNode( int value ) {
		this.value = value;
		next = null;
	}
	
	// accessor methods
	public int getValue() {
		return value;
	}
	
	public IntNode getNext() {
		return next;
	}
	
	public void setValue( int val ) {
		value = val;
	}
	
	public void setNext( IntNode node ) {
		next = node;
	}
}
