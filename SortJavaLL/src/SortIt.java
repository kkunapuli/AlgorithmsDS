
public class SortIt {


	public static void main(String[] args) {
		//1. create a linked list (in descending order)
		NodeLinkList myList = new NodeLinkList();
		for(int i = 1; i <= 17; i++) {
			//add node to beginning of list
			if(i%2 == 0) {
				myList.addNode(i);
			}
			else {
				myList.addNode((i*i)%33);
			}
		}

		//2. examine our list by printing it
		System.out.println("Original List (" + myList.countNodes() + " nodes):");
		myList.print();

		//3. sort the list
		myList.sort();

		//4. print updated list
		System.out.println("Sorted List (" + myList.countNodes() + " nodes):");
		myList.print();

	}

}
