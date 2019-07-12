class Heap{
	int data[];
	//constructor
	Heap(int size){
		data = new int[size];
		data[0] = 0;
	}
	//add element
	void addElement(int elem) {
		data[0] = data[0] + 1;
		data[data[0]] = elem;
	}
	void percDown(int p) {
		while(p>1)
	}
	void heapify() {
		int p = data[0]/2;
		while(p > 0) {
			percDown(p);
			p = p-1;
		}
	}
	
	void sort() {
		while(data[0] > 1) {
			//swap items
			int tmp = data[data[0]];
			data[data[0]] = data[1];
			data[1] = tmp;
			data[0] = data[0] -1;
			//percolate down
			percDown(1);
		}
	}
	
	void print() {
		System.out.print("]");
		for(int i = 0; i <= 15; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println("]");
	}
}