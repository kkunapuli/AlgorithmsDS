
public class Graph { //represented by an adjacency matrix
	
	double[][] matrix;
	int max_elem = 0;
	//make visited array
	boolean[] visited;
	double[] dist;
	int[] prev;


	
	//constructor
	Graph(int max_elem){
		this.max_elem = max_elem;
		matrix = new double[max_elem][max_elem];
		visited = new boolean[max_elem];
		dist = new double[max_elem];
		prev = new int[max_elem];

	}
	
	void addEdge(int from, int to, double d) {
		if(from >= max_elem || to >= max_elem) {
			System.out.println("ERROR: vertex out of bounds");
		}
		
		matrix[from][to] = d;
	}
	
	//return the distance between two vertices
	double edgeLen(int from, int to) {
		double d = matrix[from][to];
		if(d == 0) {
			//no edge
			return Double.POSITIVE_INFINITY;
		}
		
		//return value
		return matrix[from][to];
	}
	
	int findClosest(int start) {
		int closest = -1;
		double smallestDist = Double.POSITIVE_INFINITY;
		
		for(int i = 0; i < max_elem; i++) {
			if(visited[i]) {
				//skip me and visited vertices
				continue;
			}
			
			double d = dist[i];
			if(d < smallestDist) {
				//update closest node
				closest = i;
				smallestDist = d;
			}	
		}
		
		return closest;
	}
	
	//find the shortest path starting at a given node
	void dijkstra(int start){
		//make visited array
		for(int i = 0; i < max_elem; i++) {
			visited[i] = false;
		}
		
		//keep track of distances; initialize to infinity
		for(int i = 0; i < max_elem; i ++) {
			dist[i] = Double.POSITIVE_INFINITY;
		}
		
		//mark start
		dist[start] = 0.0;
		
		//track previous node
		for(int i = 0; i < max_elem; i++) {
			prev[i] = -1; //invalid value
		}
		
		//beginning with start, go through all vertices
		for( int i = 0; i < max_elem; i ++) {
			
			//where are we starting?
			int curr = findClosest(start);
			visited[curr] = true;
			
			//update information for each unvisited neighbor
			for(int j = 0; j < max_elem; j++) {
				if(visited[j]) { //skip visited
					continue;
				}
				
				double update = dist[curr] + edgeLen(curr, j);
				if( update < dist[j]) { //does this new path have smaller distance?
					dist[j] = update;
					prev[j] = curr;	
				}
			}
						
			//update start
			start = curr;
		}	
	}
	
	void print() {
		
		//header
		System.out.print("   ");
		for(int i = 0; i < max_elem; i++) {
			System.out.print(" " + i + "  ");
		}
		System.out.println();
		System.out.print("___");
		for(int i = 0; i < max_elem; i++) {
			System.out.print("____");
		}
		System.out.println();
		
		//body
		for(int i = 0; i < max_elem; i++) {
			System.out.print(i + "| ");
			for(int j = 0; j < max_elem; j++) {
				if(matrix[i][j] == 0.0 || matrix[i][j] == Double.POSITIVE_INFINITY) {
					System.out.print("Inf ");
				}
				else {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
