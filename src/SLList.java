
public class SLList {
	private IntNode head;
	private IntNode tail;
	private int list_length;
	
	SLList() {
		head = null;
		tail = null;
		list_length = 0;
	}
	
	public void add( int value ) {  //adds new value at the end of the list
		IntNode node = new IntNode( value );
		list_length++;
		if( head == null ) {  //empty list
			head = tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}	
	}
	
	public void addFirst( int value ) {
		//adds the new value at the head of the list
		IntNode node = new IntNode( value );
		list_length++;
		if( head == null ) { //empty list
			head = tail = node;
		} else {  //head is not null
			node.setNext( head );
			head = node;
		}			
	}
	
	public void add( int pos, int value ) {
		//same as the corresponding add in the Lists assignment
		if( pos == 0 ) { addFirst( value ); } //add to first of list
		else if( pos == list_length ) { add( value ); } //add to end of list
		else if( (pos > 0) && (pos < list_length) ) {  //only if pos is meaningful
			int idx = 0;
			IntNode n = head;
			IntNode new_node = new IntNode( value );
			while( idx < pos-1 ) { 
				n = n.getNext();
				idx++;
			}
			//n should be in the correct position ( one to the left of where it goes in )
			new_node.setNext( n.getNext());
			n.setNext( new_node );
			list_length++;
		}
			
	}
	
	public void removeFirst() {
		//removes the value at the head of the list
		if( head != null ) {
			list_length--;
			if( head == tail ) { head = tail = null; }
			else { head = head.getNext(); }
		}	
	}
	
	public void removeLast() {
		//removes the value at the tail of the list
		if( head != null ) {  //only remove if the list is not empty!!
			if( head == tail ) { //if there is only one thing in the list
				head = null;
				tail = null;
			}
			else { //two or more things in the list
				IntNode n = head;
				while( n.getNext() != tail ) { n = n.getNext(); }
				n.setNext(null);
				tail = n;
			}
			list_length--;
		}
	}
	
	public void remove( int pos ) {
		//removes the value at index 'pos' if 'pos' is meaningful
		if( pos == 0 ) { removeFirst(); }
		else if( pos == list_length-1 ) { removeLast(); }
		else if( (pos > 0) && (pos < list_length - 1) ) {
			int idx = 0;
			IntNode n = head;
			while( idx < pos - 1 ) { 
				n = n.getNext(); 
				idx++;
			}
			//n is the node to the left of the one to remove (in pos - 1 position)
			n.setNext(n.getNext().getNext() ); //gotta jump from node left of pos to node at pos to the next node
			list_length--;
		}
	}
	
	public int size() {
		return list_length;
	}
	
	public int[] getArray() {
		int[] temp = new int[list_length];
		IntNode n = head;
		for( int idx = 0; idx < list_length; idx++ ) {
			temp[ idx ] = n.getValue();
			n = n.getNext();
		}
		return temp;
	}
	
	public int getFirst() {
		return head.getValue();
	}
	
	public int getLast() {
		return tail.getValue();
	}
	
	public int get( int pos ) {
		//returns the value in the list at position pos
		if( pos == 0 ) { return getFirst(); }
		else if( pos == list_length - 1 ) { return getLast(); }
		else if ( pos < 0 || pos >= list_length ) { return Integer.MAX_VALUE; }
		else {  // is a meaningful position within the linked list
			IntNode n = head;
			int idx = 0;
			while( idx < pos ) {
				n = n.getNext();
				idx++;
			}
			return n.getValue();
		}
	}
	
	
	public void set( int pos, int value ) {
		//sets the value in index 'pos' to 'value' if "pos" is meaningful
		if( (pos >=0) && (pos< list_length) ) {
			IntNode n = head;
			int idx = 0;
			while( idx < pos ) {
				n = n.getNext();
				idx++;
			}
			n.setValue( value );
		}
	}
	
	public void clear() {
		head = null;
		tail = null;
		list_length = 0;
	}
	
	public boolean isEmpty() {
		return list_length == 0;
	}
	
	public boolean contains( int val ) {
		IntNode n = head;
		if( n == null ) { return false; }
		while( n != null ) { // while n is not the null reference
			if( n.getValue() == val ) {
				return true;
			}
			n = n.getNext();			
		}
		return false;			
	}
	
	public int indexOf( int val ) {
		//same as in the DArray assignment
		int idx = -1;
		IntNode n = head;
		if( n == null ) { return idx; }
		//iterate through the list, looking for 'value' and keeping up with the value of 'idx'
		// should look similar to "contains" in the Lists implementation
		while( n != null ) {
			idx++;
			if( n.getValue() == val ) { return idx; }
			n = n.getNext();
		}
		return -1;
	}
	
}
