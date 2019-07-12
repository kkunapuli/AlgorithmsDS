
public class SortHeap {
	
	public static void main(String args[]) {
		//declare heap
		Heap myHeap = new Heap(20);
		
		//add 15 items in random order
		for(int i = 0; i < 15; i++) {
			int addVal = 0;
			if(i%2 == 0) {
				addVal = (i*2)%21;
			}
			else {
				addVal = ((i+1)*3)%7;
				if(addVal == 0) {
					addVal = i;
				}
			}
			myHeap.addElement(addVal);
		}
		
		//print results
		System.out.println("Original array:");
		myHeap.print();
		
		//heapify!
		myHeap.heapify();
		System.out.println("Heapified array:");
		myHeap.print();
		
		//sort
		myHeap.sort();
		System.out.println("Sorted array:");
		myHeap.print();
	}

}
