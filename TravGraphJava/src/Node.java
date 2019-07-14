
public class Node {
	private int name;
	private Node next;
	
	//constructor
	Node(int name){
		this.name = name;
		next = null;
	}
	
	int getName() {
		return name;
	}
	
	Node next(){
		return next;
	}
	
	void setNext(Node next) {
		this.next = next;
	}

}
