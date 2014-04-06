import java.util.Random;

public class SLinkedList {

	public static void main(String[] args) {
		
		 SLList sll = new SLList();
		 sll.add( 4 );
		 sll.add( 3 );
		 sll.add( 2 );
		 sll.add( 1 );
		 SLinkedList my_app = new SLinkedList();
		 my_app.printArray( sll.getArray(), 0, 100 );
		 
		 sll.addFirst( 5 );
		 my_app.printArray( sll.getArray(), 0, 100 );
		 sll.add( 2,0 );
		 my_app.printArray( sll.getArray(), 0, 100 );
		 sll.remove(2);
		 my_app.printArray( sll.getArray(), 0, 100 );
		 
		 while (!sll.isEmpty() ){
			 sll.removeFirst();
			 my_app.printArray( sll.getArray(), 0, 100 );
		 }
	}
	
	public void printArray( int[] array, int startIdx, int endIdx ) {
		if( startIdx < 0 ) { startIdx = 0; }
		if( endIdx >= array.length ) {endIdx = array.length - 1; }
		for( int idx = startIdx; idx <= endIdx; idx++ ) {
			System.out.print( array[ idx ] + " ");
		}
		System.out.println(); 
	}
	
	public int getRandomBetween( int minVal, int maxVal, Random rnd ) {
		if( maxVal < minVal ) { // just in case the numbers were accidently switched
			int temp = maxVal;
			maxVal = minVal;
			minVal = temp;
		}
		return rnd.nextInt( maxVal - minVal + 1 ) + minVal;
	}

}
