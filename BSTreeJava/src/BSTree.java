
public class BSTree {
	private BSTNode root;
	
	//constructor
	BSTree(){
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
	
	//delete a node
	boolean delete(int val) {
		//1. find the node
		BSTNode delNode = findNode(root, val);
		if(delNode == null) {
			//node does not exist
			return false;
		}
		
		//2. get parent
		BSTNode delParent = parent(root, val);

		//3. if node is root, delete root
		if(delParent == null) {
			deleteRoot();
			return true;
		}
		
		//4. check for an easy case
		if(easyDelete(delParent, delNode)) {
			return true;
		}
		
		//5. general case, replace with predecessor
		BSTNode predecessor = findLargest(delNode.left);
		BSTNode predParent = parent(root, predecessor.value);
		predecessor.right = delNode.right; //predecessor won't have a right
		predParent.right = predecessor.left; //move predecessor's left child in
		predecessor.left = delNode.left;
		if(delParent.left == delNode) { //finish replacement
			delParent.left = predecessor;
		}
		else {
			delParent.right = predecessor;
		}
		
		return true;
	}
	
	boolean deleteRoot() {
		//if root is a leaf, nothing to do really
		if(root.isLeaf()) {
			root = null;
		}
		//root doesn't have a left child, simply replace with right
		else if(root.left == null) {
			root = root.right;
		}
		//root's left child is a leaf, simply replace with left
		else if(root.left.isLeaf()) {
			root = root.left;
		}
		//general case, replace with predecessor
		else {
			BSTNode predecessor = findLargest(root.left);
			BSTNode predParent = parent(root, predecessor.value);
			predecessor.right = root.right; //predecessor won't have a right
			predParent.right = predecessor.left; //move predecessor's left child in
			predecessor.left = root.left;
			root = predecessor; //finish replacement
		}
		
		return true;
	}
	
	//search for value
	BSTNode findNode(BSTNode node, int val) {
		if(node == null) {
			//not in this tree
			return null;
		}
		
		if(node.value == val) {
			return node;
		}
		if(val > node.value) {
			return findNode(node.right, val);
		}
		else {
			return findNode(node.left, val);
		}
	}
	
	//find successor
	BSTNode findLargest(BSTNode node) {
		if(node.right == null) {
			return node;
		}
		
		return findLargest(node.right);
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
		if(node.left != null && node.left.value == val) {
			return node;
		}
		BSTNode lhs = parent(node.left, val);
		
		//check right
		if(node.right != null && node.right.value == val) {
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
	
	private static boolean easyDelete(BSTNode parNode, BSTNode delNode) {
		//if node is a leaf or left is null, simply move right node in its place
		if(delNode.left == null){
			if(parNode.left == delNode) {
				parNode.left = delNode.right;
			}
			else {
				parNode.right = delNode.right;
			}
			return true;
		}
		
		//left node is leaf
		if(delNode.left.isLeaf()) {
			//keep delete's right child
			delNode.left.right = delNode.right;
			
			//slot left child into delete's spot
			if(parNode.left == delNode) {
				parNode.left = delNode.left;
			}
			else {
				parNode.right = delNode.left;
			}
			return true;
		}
		return false;	
	}
}
