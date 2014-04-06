
public class IntDNode {
	
	private int value;
	private IntDNode next;
	private IntDNode prev;
	
	IntDNode(){
		
		value = 0;
		next = prev = null;
		
	}
	
	IntDNode(int value){
		
		this.value = value;
		next = prev = null;
	}
	
	public int getValue(){
		
		return value;
	}
	
	public IntDNode getNext(){
		
		return next;
	}
	
	public IntDNode getPrev(){
		
		return prev;
	}
	
	public void setValue(int val){
		
		 value = val;
	}
	
	public void setNext(IntDNode node){
		
		next = node;
	}
	
	public void setPrev(IntDNode node){
		
		prev = node;
	}
}
