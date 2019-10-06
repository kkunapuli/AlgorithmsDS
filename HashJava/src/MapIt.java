
public class MapIt {
	/* Implement hash table. Your hash table will consist of English language words 
	 * - 8 characters or less. Start with a table size of 19 and insert words one 
	 * at a time.  When you have inserted 10 words, your program must give a message 
	 * "load factor > .5" Then the program automatically increases the table size to 
	 * double the current size and round up to the next higher prime number. Insert 
	 * a few more words after that. You may select a library hash function.  But you 
	 * must implement your own collision resolution scheme (quadratic probing).*/
	
	/* Keep track of number of collisions for a given word. So if you try to insert a 
	 * word and there is a collision then you select the next location based on 
	 * quadratic probing. If this second location also gives a collision then you have 
	 * 2 collisions and so on.  Keep track of the highest collision for a given word 
	 * and print it.*/
	
	/* Run your program to insert words and then show a screen shot of its execution to
	 * 	1. find a word that has been added.
	 * 	2. Try to find a word that is not in the table 
	 * 		- your program should print a message saying it is not in the dictionary.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//0. list of words to keep in our dictionary
		String[] foods = {"mango", "apple", "banana", "orange", "grape", "carrot", "broccoli", 
				"papaya", "guava", "kale", "custard", "bread", "yogurt", "coffee", "rice"};
		
		//make a map and add all of our foods
		HashMap dict = new HashMap(19);
		for(String f: foods) {
			dict.addWord(f, true);
		}
		
		//1. find one of our foods in the dictionary
		System.out.println("papaya can be found at index = " + dict.getWord("papaya", false));
		
		//2. find a food not in our dictionary
		dict.getWord("forest", false);
	}

}
