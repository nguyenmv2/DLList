import java.util.Random;

public class DLinkedList {

	public static void main(String[] args) {
		
		 DLList dll = new DLList();
		 dll.add( 4 );
		 dll.add( 3 );
		 dll.add( 2 );
		 dll.add( 1 );
		 DLinkedList my_app = new DLinkedList();
		 my_app.printArray( dll.getArray(), 0, 100 );
		 
		 my_app.printArray( dll.getReverseArray(), 0, 100 );
		 dll.addFirst( 5 );
		 my_app.printArray( dll.getArray(), 0, 100 );
		 my_app.printArray( dll.getReverseArray(), 0, 100 );
		 
		 dll.add( 2,0 );
		 my_app.printArray( dll.getArray(), 0, 100 );
		 my_app.printArray( dll.getReverseArray(), 0, 100 );
		 
		 dll.remove(2);
		 my_app.printArray( dll.getArray(), 0, 100 );
		 my_app.printArray( dll.getReverseArray(), 0, 100 );
		 System.out.println(dll.indexOf(1000));
		 dll.set(3, 10000);
		 while (!dll.isEmpty() ){
			 dll.removeFirst();
			 my_app.printArray( dll.getArray(), 0, 100 );
		
		 }
		 
	}
	
	public void printArray( int[] array, int startIdx, int endIdx ) {
		if ( array == null ) { System.out.println("EMPTY");
		}else{
			if( startIdx < 0 ) { startIdx = 0; }
			if( endIdx >= array.length ) {endIdx = array.length - 1; }
			for( int idx = startIdx; idx <= endIdx; idx++ ) {
				System.out.print( array[ idx ] + " ");
			}
		System.out.println();
		}
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
