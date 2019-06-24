
public class BSTNode {
	public int value;
	public BSTNode left;
	public BSTNode right;
	
	//constructor
	BSTNode(int val){
		value = val;
		left = null;
		right = null;
	}
	
	//is it a leaf node?
	boolean isLeaf() {
		return left == null && right == null;
	}
}
