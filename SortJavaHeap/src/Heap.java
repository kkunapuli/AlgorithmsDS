

//simple heap implementation to demonstrate heap sort
public class Heap {

	//a heap is an array
	int data[];
	
	//constructor
	Heap(int maxSize){
		//use an initial max size
		data = new int[maxSize];
		//no items in heap initially
		data[0] = 0;
		for(int i = 1; i < maxSize; i++) {
			data[i] = -1;
		}
	}
	
	//add element - without maintaining heap property
	boolean addElement(int el) {
		if(data[0] >= data.length) {
			//no more room in heap
			return false;
		}
		
		data[0]++;
		data[data[0]] = el;
		return true;
	}
	
	int size() {
		return data[0];
	}
	
	void percolateUp(int p) {
		if(p == 0) {
			//we're done
			return;
		}
		
		int lhs = left(p);
		int rhs = right(p);
		
		//are children in range?
		//are children in range?
		if(lhs > size()) {
			return;
		}
		
		//put rhs in range
		if(rhs > size()) {
			rhs = lhs;
		}
		
		//do we need to swap?
		int minChild = minVal(lhs, rhs);
		if(data[minChild] > data[p]) {
			swap(minChild, p);
		}

		//keep going
		percolateUp(p/2);
	}
	
	//starting at parent index p
	void percolateDown(int p) {
		
		int lhs = left(p);
		int rhs = right(p);
		
		//are children in range?
		if(lhs > size()) {
			return;
		}
		
		//put rhs in range
		if(rhs > size()) {
			rhs = lhs;
		}
		
		//do we need to swap?
		int maxChild = maxVal(lhs, rhs);
		if(data[maxChild] > data[p]) {
			swap(maxChild, p);
		}
		
		//keep going
		percolateDown(maxChild);
	}
	
	//returns index with larger value
	int maxVal(int idx1, int idx2) {
		if(data[idx1] > data[idx2]) {
			return idx1;
		}
		return idx2;
	}
	
	//returns index with larger value
	int minVal(int idx1, int idx2) {
		if(data[idx1] <= data[idx2]) {
			return idx1;
		}
		return idx2;
	}
	
	//assuming max heap
	//use min heap to sort descending
	void heapify() {
		//ensure all elements are smaller than their children
		//start at first parent, percolateDown
		//move on to next parent and continue
		int idx = size()/2;
		while(idx >= 1) {
			percolateDown(idx);
			idx--;
		}
	}
	
	//assuming increasing order
	void sort() {
		//swap first element with last until none left
		while(data[0] > 1) {
			swap(1, data[0]);
			data[0]--;
			percolateDown(1);
		}
	}
	
	//swap elements at index i and j
	void swap(int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	//make it easy to identify parent, and L/R children
	int parent(int i) {
		//return parent index
		return i/2;
	}
	
	int left(int i) {
		//return left child index
		return i*2;
	}
	
	int right(int i) {
		//return right child index
		return i*2 + 1;
	}
	
	//print heap including number of elements
	void print() {
		System.out.print("[ ");
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		
		//print last element
		System.out.println("]");
	}
}
