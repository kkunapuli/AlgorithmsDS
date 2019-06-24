
public class BSTActions {

	public static void main(String[] args) {
		BSTree myTree = new BSTree();

		//2. fill with values
		int v[] = {40, 60, 20, 80, 50, 10, 30, 15, 5, 35, 25, 45, 55, 70, 90, 32, 33, 48, 46};
		for(int i = 0; i < v.length; i++) {
			myTree.insert(v[i]);
		}

		//3. inspect tree
		System.out.println("Original BST (" + myTree.count(myTree.root()) + " nodes):");
		myTree.printInOrder();
		
		//4. delete 40
		myTree.delete(40);
		System.out.println("Have " + myTree.count(myTree.root()) + " nodes left after deleting 40:");
		myTree.printInOrder();

		//5. delete 20
		myTree.delete(20);
		System.out.println("Have " + myTree.count(myTree.root()) + " nodes left after deleting 20:");
		myTree.printInOrder();

	}

}
