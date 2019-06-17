
public class NodeLinkList {
	Node head; //first node in list


	//constructor
	NodeLinkList() {
		head = null;
	}

	//add node to front of list
	void addNode(int value) {
		//first, make the new node
		Node tmp = new Node(value);

		//populate next reference
		tmp.next = head;

		//update head
		head = tmp;
	}

	//remove node from front of list
	void removeNode() {
		head = head.next;
	}

	//how many nodes are in the list?
	int countNodes() {
		int count = 0;
		Node tmp = head;
		while(tmp != null) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}

	//perform selection sort on linked list by swapping nodes
	void sort(){

		Node p1 = head; //pointer 1; tracks sorted portion of list
		Node p1_prev = null; //track previous node

		while(p1 != null) {
			Node min = p1; //placeholder for current smallest node in rest of list
			Node min_prev = p1_prev;
			Node p2 = p1.next; //pointer 2; finds next smallest node in list
			Node p2_prev = p1;

			while(p2 != null) {
				if(p2.value < min.value) {
					//found new smallest node
					min = p2;
					min_prev = p2_prev;
				}
				//keep searching
				p2_prev = p2;
				p2 = p2.next;
			}

			//swap nodes 
			if(p1_prev == null && min_prev  == null) {
				//nothing to swap; simply advance p1 pointers
				p1_prev = head;
				p1 = p1_prev.next;
				continue;
			}	
			else if(p1_prev == null) {
				//swapping head
				head = min;
				min_prev.next = p1;
				//swap next
				Node tmp = p1.next;
				p1.next = min.next;
				min.next = tmp;

				//advance p1
				p1_prev = head;
				p1 = p1_prev.next;
			}
			else {
				//simply swap two nodes, neither being the head
				p1_prev.next = min;
				min_prev.next = p1;
				//swap next 
				//(*** if we set min.next before p1.next, we get an self-loop)
				Node tmp = p1.next;
				p1.next = min.next;
				min.next = tmp;

				//advance p1
				p1_prev = p1_prev.next;
				p1 = p1_prev.next;
			}		
		}
	}


	//print all nodes in list
	void print() {
		Node tmp = head;

		System.out.print("[");
		while(tmp != null) {
			System.out.print(tmp.value);

			//formatting
			if(tmp.next != null) {
				System.out.print(", ");
			}
			tmp = tmp.next;
		}
		System.out.println(" ]");
	}

}
