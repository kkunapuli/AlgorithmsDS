import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	//use adjacency lists to represent graph
	private Node vertices[];
	private int size; //number vertices in graph
	private boolean directed;
	private boolean visited[];

	
	//constructor
	Graph(int numNodes, boolean directed){
		vertices = new Node[numNodes];
		visited = new boolean[numNodes];
		size = 0;
		this.directed = directed;
	}
	
	int size() {
		return size;
	}
	
	int numEdges() {
		int sum = 0;
		for(Node n: vertices) {
			sum += countEdges(n.next());
		}
		if(directed) {
			return sum;
		}
		else {
			return sum/2;
		}
	}
	
	void addVertex(int name) {
		Node n = new Node(name);
		vertices[size] = n;
		size++;
	}
	
	Node getVertex(int name) {
		return vertices[name];
	}
	
	boolean addEdge(int node1, int node2) {
		
		//error checking
		if(node1 >= size ) {
			System.out.println("Error: node does not exist:" + node1);
			return false;
		}
		if(node2 >= size ) {
			System.out.println("Error: node does not exist:" + node2);
			return false;
		}
		
		//System.out.println("Adding edge at indices: " + String.valueOf(node1) + " " + String.valueOf(node2));
		
		//add edge 1-2
		add2list(vertices[node1], new Node(vertices[node2].getName()));
		//and edge 2-1
		if(!directed) {
			add2list(vertices[node2], new Node(vertices[node1].getName()));
		}
		
		return true;
	}
	
	void add2list(Node n, Node add) {
		if(n.next() == null) {
			n.setNext(add);
			return;
		}
		add2list(n.next(), add);
		
	}
	
	private static int countEdges(Node n) {
		if(n == null) {
			return 0;
		}
		return 1 + countEdges(n.next());
	}
	
	private void clearVisited() {
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
	
	void DFSRecurse(Node n) {
		visited[n.getName()] = true; //mark visited
		System.out.print(String.valueOf(n.getName()) + ", "); //visit
		
		//visit all connections
		while(n.next() != null) {
			if(!visited[n.next().getName()]) {
				DFSRecurse(vertices[n.next().getName()]);
			}
			n = n.next();
		}
	}
	
	void DFS(Node start) {
		//first, clear visited array
		clearVisited();
		
		//do DFS
		DFSRecurse(start);
		System.out.println("");
	}
	
	void BFS(Node start) {
		//first clear visited array
		clearVisited();
		
		//do BFS
		Queue<Integer> nodeQ = new LinkedList<Integer>();
		visited[start.getName()] = true;
		nodeQ.add(start.getName());
		while(!nodeQ.isEmpty()) {
			//get head of queue and "visit"
			Integer tmp = nodeQ.poll();
			System.out.print(String.valueOf(tmp) + ", ");
			
			//add all connected nodes to queue
			Node v = vertices[tmp];
			while(v.next() != null) {
				if(!visited[v.next().getName()]) {
					//add to queue
					visited[v.next().getName()] = true;
					nodeQ.add(v.next().getName());
				}
				v = v.next();
			}
		}
		
		System.out.println("");
	}
}
