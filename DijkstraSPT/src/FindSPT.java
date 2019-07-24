//Kristine Kunapuli

/*Implement Dijkstra's algorithm to find the SPT.make a graph with at least 10 nodes and 15 weighted edges.
Print the graph as a Adjacency Matrix.
After you run the program to find SPT. Print the SPT also as adjacency matrix.
Submit the code and the results of execution*/

public class FindSPT {

	public static void main(String[] args) {
		//1. make a graph with space for 10 notes
		Graph myGraph = new Graph(10);
		
		//2. add at least 15 edges
		myGraph.addEdge(0, 1, 3.5);
		myGraph.addEdge(0, 3, 9.0);
		myGraph.addEdge(1, 3, 1.0);
		myGraph.addEdge(1, 2, 6.3);
		myGraph.addEdge(1, 6, 4.2);
		myGraph.addEdge(3, 6, 0.8);
		myGraph.addEdge(2, 6, 3.3);
		myGraph.addEdge(2, 5, 2.5);
		myGraph.addEdge(2, 4, 1.1);
		myGraph.addEdge(6, 5, 1.0);
		myGraph.addEdge(5, 4, 0.3);
		myGraph.addEdge(4, 8, 2.2);
		myGraph.addEdge(8, 5, 5.5);
		myGraph.addEdge(8, 9, 9.9);
		myGraph.addEdge(5, 9, 0.7);
		myGraph.addEdge(6, 7, 3.1);
		myGraph.addEdge(7, 9, 1.2);
		
		//3. print graph
		System.out.println("Directed graph (non-existent edges are 'Inf'):");
		System.out.println("   note: first row and column are indices/labels\n");
		myGraph.print();
		
		//4. find SPT
		myGraph.dijkstra(0);
		
		//5. print SPT
		System.out.println("\nSPT represented as a directed graph (non-existent edges are 'Inf'):");
		System.out.println("   note: first row and column are indices/labels\n");
		Graph spt = new Graph(10);
		for(int i = 0; i < 10; i++) {
			int p = myGraph.prev[i];
			if(p == -1) {
				p = 0;
			}
			spt.addEdge(p, i, myGraph.dist[i]);
		}
		spt.print();

	}

}
