
public class DLList {
	
	private IntDNode head;
	private IntDNode tail;
	private int list_length;
	
	DLList() {
		
		head = tail = null;
		
		list_length = 0;
	}
	
	public void add(int value){
		
		IntDNode node = new IntDNode( value );
		if ( !isEmpty() ){
			
			IntDNode temp = tail;
			tail.setNext(node);
			tail = node;
			tail.setPrev(temp);
		}else{
			
			head = tail = node;
		}
		list_length ++;
	}
	
	public void addFirst(int value){
		
		IntDNode node = new IntDNode( value );
		if( !isEmpty() ){
			
			IntDNode temp = head;
			head.setPrev(node);
			head = node;
			head.setNext(temp);		
		}else{
			
			head = tail = node;
		}
		list_length ++;
	}
	
	public void add(int pos, int value){
		
		if( pos == 0 ){
			
			addFirst(value);
		}else if( pos == list_length ){
			
			add(value);
		}else if( (pos > 0) && (pos < list_length) ){
			
			IntDNode n = head;
			IntDNode new_node = new IntDNode( value );
			int idx = 0;
			while ( idx < (pos-1) ){
				
				n = n.getNext();
				idx++;
			}
			
			IntDNode temp = n.getNext();
			n.setNext( new_node );
			new_node.setPrev( temp.getPrev() );
			new_node.setNext(temp);
		}
		list_length ++;
	}
	
	public void removeFirst(){
		
		if ( !isEmpty() ){
			if ( list_length == 1 ){ head = tail = null; 
			}else{
			
				head = head.getNext();
				head.setPrev(null);
				list_length --;
				System.out.println("A"+list_length);}
			
		}else{
			
			System.out.println("List is already empty");
		}
	}
	
	public void removeLast(){
		
		if ( !isEmpty() ){
			
			tail.setPrev(tail);
			tail.setNext(null);
			list_length --;
		}else{
			
			System.out.println("List is already empty");
		}
	}
	
	public void remove(int pos){
		
		if( pos == 0 ){
			
			removeFirst();
		}else if( pos == list_length ){
			
			removeLast();
		}else if( (pos > 0) && (pos < list_length) ){
			
			IntDNode n = tail;
			int idx = list_length;
			while ( idx > (pos+2) ){
				
				n = n.getPrev();
				idx --;
			}
			IntDNode temp = n;
			n.setPrev( temp.getPrev());
			n.getPrev().setNext(temp);
			list_length --;
		}
	}
	
	public int size() {
		return list_length;
	}
	
	public int[] getArray() {
		if( !isEmpty() ){
			int[] temp = new int[list_length];
			IntDNode n = head;
			for( int idx = 0; idx < list_length; idx++ ) {
				temp[ idx ] = n.getValue();
				n = n.getNext();
			}
			return temp;
		}
		return null;
	}
	
	public int[] getReverseArray() {
		if( !isEmpty() ){
			
			int[] temp = new int[list_length];
			IntDNode n = head;
			for( int idx = list_length - 1; idx >= 0; idx-- ) {
				
				temp[ idx ] = n.getValue();
				n = n.getNext();
			}
			return temp;
		}
		return null;
	}

	public int getFirst(){
		
		return head.getValue();
	}
	
	public int getLast (){
		
		return tail.getValue();
	}
	
	public int get( int pos ) {
		
		if ( pos == 0){
			
			return getFirst();
		}else if( pos == list_length ){
			
			return getLast();
		}else if( pos < 0 || pos >= list_length ){
			
			return Integer.MAX_VALUE;
		}else{
			
			IntDNode n = tail;
			int idx = list_length;
			while( idx > pos ) {
				
				n = n.getPrev();
				idx --;
			}
			return n.getValue();
		}
	}
	
	public void set( int pos, int value ) {
		
		if( (pos >=0) && (pos< list_length) ) {
			IntDNode n = head;
			int idx = 0;
			while( idx < pos ) {
				
				n = n.getNext();
				idx++;
			}
			n.setValue( value );
		}
	}
	
	public void clear(){
		
		head = null;
		tail = null;
		list_length = 0;
	}
	
	public boolean isEmpty() {
		
		return (head == null);
	}
	
	public boolean contains(int value){
		
		IntDNode n = head;
		if( n == null ) { return false; }
		
		while( n != null ) { // while n is not the null reference
			if( n.getValue() == value ) {
				
				return true;
			}
			n = n.getNext();		
		}
		return false;			
	}
	
	public int indexOf( int val ) {
		
		int idx = -1;
		IntDNode n = head;
		if( n == null ) { return idx; }
		
		while( n != null ) {
			
			idx++;
			if( n.getValue() == val ) { return idx; }
			n = n.getNext();
		}
		return -1;
	}
}
