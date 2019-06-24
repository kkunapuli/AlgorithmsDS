
public class BSTActions {

	public static void main(String[] args) {
		//1. make a BST
		BSTTree myTree = new BSTTree();
		
		//2. fill with values
		int v[] = {40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46};
		for(int i = 0; i < v.length; i++) {
			myTree.insert(v[i]);
		}
		
		//3. inspect tree
		System.out.println("BST has " + myTree.count(myTree.root()) + " nodes:");
		myTree.printInOrder();
		
		//4. delete 40
		
		//5. inspect tree
		
		//6. delete 20
		
		//7. inspect tree

	}

}
