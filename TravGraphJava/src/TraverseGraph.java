
public class TraverseGraph {
	/*
1. Implement the DFS traversal of a graph.
    a. Make an undirected graph with at least 10 vertices and 15 edges.  
    b. Pick a vertex to start DFS.  Print the nodes visited during the DFS.
    c. Repeat the step b using a directed graph.
    d. Repeat step b with undirected but disconnected graph.

2. Do BFS traversal for a graph with t least 10 vertices and 15 edges. 
   You may use a queue library.
    Repeat steps a,b,c,d from part 1 above.*/

	public static void main(String[] args) {
		
		//1. make an undirected graph with room for 10 vertices
		Graph uGraph = new Graph(10, false); //undirected graph
		
		//a1. add 10 vertices
		for(int i = 0; i < 10; i++) {
			uGraph.addVertex(i);
		}
		//System.out.println(uGraph.size() + " nodes in graph.");
		
		//a2. add 15 edges
		for(int i = 0; i < 5; i++){
			uGraph.addEdge(i, i+5);
			uGraph.addEdge(i, i+1);
			uGraph.addEdge(i, i+2);
		}
		//System.out.println(uGraph.numEdges() + " edges in graph.");
		
		//b. do depth-first search
		System.out.println("DFS of undirected graph:");
		uGraph.DFS(uGraph.getVertex(0));
		
		//c. make a directed grap and repeat DFS TODO
		Graph dGraph = new Graph(10, true);
		for(int i = 0; i < 10; i++) {
			dGraph.addVertex(i);
		}
		//System.out.println(dGraph.size() + " nodes in graph.");
		
		//a2. add 15 edges
		for(int i = 0; i < 5; i++){
			dGraph.addEdge(i, i+5);
			dGraph.addEdge(i, i+1);
			dGraph.addEdge(i, i+2);
		}
		//System.out.println(dGraph.numEdges() + " edges in graph.");
		System.out.println("DFS of directed graph:");
		dGraph.DFS(dGraph.getVertex(0));
		
		//d. make a disconnected undirected graph and repeat DFS TODO
		
		//2. BFS 
		
		//b. BFS on undirected graph
		System.out.println("BFS of undirected graph:");
		uGraph.BFS(uGraph.getVertex(0));
		
		//c. BFS on directed graph
		System.out.println("BFS of directed graph:");
		dGraph.BFS(dGraph.getVertex(0));
		
		//d. BFS on disconnected undirected graph TODO
		
		

	}

}
