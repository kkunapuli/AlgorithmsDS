
public class HashMap {
	
	private String[] hMap; //our hash map of words
	private int mapSize = 0; //map doesn't exist yet
	private final double loadFactor = 0.5; //use 50%
	private int maxElem = 0; //generally loadFactor * mapSize
	private int numElem; //map currently empty
	
	//constructor
	HashMap(int initialSize){
		hMap = new String[initialSize];
		initializeMap(initialSize);
	}
	
	void initializeMap(int size) {
		mapSize = size;
		maxElem = (int)(loadFactor*mapSize); //take lower bound
		numElem = 0;
		
		//give a default value to our map
		for(int i = 0; i < mapSize; i++) {
			hMap[i] = null;
		}
	}
	
	// add a word to the map
	boolean addWord(String word, boolean debug) {
		int idx = calcIdx(word, debug);
		hMap[idx] = word;
		numElem += 1; //track how many words in map
		
		if(numElem > maxElem) {
			//we've hit our limit
			System.out.println("load factor > .5");
			
			//rehash table
			reHashMap();
		}
		return true;
	}
	
	//get a word from the dictionary
	int getWord(String word, boolean debug) {
		int idx = calcIdx(word, debug);
		if(hMap[idx] != word) {
			System.out.println("ERROR: " + word + " not in dictionary.");
			return -1;
		}
		else {
			return idx;
		}
	}
	
	//double map, increase to nearest prime and rehash everything to new map
	boolean reHashMap() {
		//first, get new length of hash table
		int newSize = findNextPrime(2*mapSize);
		
		//make bigger map
		String[] oldMap = hMap;
		int num2Hash = mapSize;
		hMap = new String[newSize];
		initializeMap(newSize);
		
		//rehash everything
		for(int i = 0; i < num2Hash; i++) {
			String word = oldMap[i];
			if(word != null) {
				addWord(word, false); //don't print information again
			}
		}
		
		return true;
	}
	
	//finds the index to use for this word and hash map
	//also tracks number of collisions
	int calcIdx(String word, boolean debug) {
		
		//try simple hashCode
		int idx = (word.hashCode())%mapSize;
		if(idx < 0) {
			idx += mapSize;
		}
		if(!isCollision(idx, word)) {
			if(debug) {
				System.out.println("Encountered 0 collisions for word: " + word);
			}
			return idx;
		}
		
		//have a collision - try quadratic resolution
		int numCollide = 1;
		boolean found = false;
		while(!found) {
			idx = (idx + 2*numCollide - 1)%mapSize; //new index
			if(isCollision(idx, word)) {
				//keep looking
				numCollide += 1;
			}
			else {
				//got a good index!
				found = true;
			}
		}
		
		//print out number collisions
		if(debug) {
			System.out.println("Encountered " + numCollide + " collisions for word: " + word);
		}
		
		return idx;
	}
	
	//is this index a collision?
	boolean isCollision(int i, String word) {
		if( hMap[i] == null) {
			return false;
		}
		else if( hMap[i] == word) {
			return false;
		}
		return true;
	}
	
	//finds next prime number (larger)
	static int findNextPrime(int n) {
		boolean foundPrime = false;
		while(!foundPrime) {
			n = n + 1;
			foundPrime = isPrime(n);
		}
		return n;
	}
	
	//determines whether or not a number is prime
	static boolean isPrime(int n) {
		boolean isPrime = true;
		int maxFactor = (int)n/2; //should use sqrt but that's in a library...
		for(int i = 2; i < maxFactor; i++) {
			if(n%i == 0) {
				//found a factor that evenly divides our number
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}

}
