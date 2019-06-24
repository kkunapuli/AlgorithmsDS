
public class BSTTree {
	private BSTNode root;
	
	//constructor
	BSTTree(){
		root = null;
	}
	
	BSTNode root() {
		return root;
	}
	
	//print in order
	void printInOrder() {
		System.out.print("[ ");
		printTraverse(root);
		System.out.println("]");
	}
	
	int count(BSTNode node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + count(node.left) + count(node.right);
	}
	
	//insert a node
	boolean insert(int val) {
		if(this.root == null) {
			this.root = new BSTNode(val);
		}
		else {
			insertRecurse(root, val);
		}
		return true;
	}
	
	//find parent
	BSTNode parent(BSTNode node, int val) {
		//not in this subtree
		if(node == null) {
			return null;
		}
		
		//leaf node, not a parent
		if(node.left == null && node.right == null){
			return null;
		}
		
		//check left side
		if(node.left == null) {
			return null;
		}
		if(node.left.value == val) {
			return node;
		}
		BSTNode lhs = parent(node.left, val);
		
		//check right
		if(node.right == null) {
			return null;
		}
		if(node.right.value == val) {
			return node;
		}
		BSTNode rhs = parent(node.right, val);
		
		if(lhs != null) {
			return lhs;
		}
		if(rhs != null) {
			return rhs;
		}
		
		return null;
	}
	
	//***** HELPERS ***********************************************************
	private static void printTraverse(BSTNode node) {
			if(node == null) {
				return;
			}
			
			printTraverse(node.left);
			System.out.print(node.value + ", ");
			printTraverse(node.right);
	}

	private static void insertRecurse(BSTNode node, int val) {
		if(val > node.value) {
			if(node.right == null) {
				node.right = new BSTNode(val);
			}
			else {
				insertRecurse(node.right, val);
			}
		}
		else {
			if(node.left == null) {
				node.left = new BSTNode(val);
			}
			else {
				insertRecurse(node.left, val);
			}
		}
	}
		
	
}
