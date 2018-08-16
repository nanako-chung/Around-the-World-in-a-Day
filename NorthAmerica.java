import java.util.*;

/**
 * This class contains a list of North American countries, a sub-class of Nodes, another sub-class that implements a 
 * hashtable, and finally a main method that actually stores the countries into an instance of the implemented hashtable. 
 * The key is the country name (String) and the value is a fun fact about that country (also a String).
 *
 * @author Nanako Chung
 */
public class NorthAmerica {

	// array of countries (listed by memory! :) )
	public static String[] countries = {
		"United States of America",
		"Canada",
		"Mexico",

		// Central America
		"Belize",
		"Honduras",
		"Guatemala",
		"Nicaragua",
		"El Salvador",
		"Panama",
		"Costa Rica",

		// Caribbean
		"Cuba",
		"Jamaica",
		"St. Lucia",
		"Antigua & Barbuda",
		"Dominica",
		"Grenada",
		"Barbados",
		"Trinidad & Tobago",
		"St. Kitts & Nevis",
		"St. Vincent & the Grenadines",
		"Haiti",
		"Dominican Republic",
		"The Bahamas"
	};

	// array of fun facts attained from different websites
	public static String[] funFacts = {
		"The tallest mountain in the world (when measured from the sea floor) is Mauna Kea, which is in Hawaii.",
		"Canada is the second largest country in the world.",
		"When the Spanish invaded modern-day Mexico during the 16th century, 99% of the Native American population died due to disease.",

		// Central America
		"Belize is the only Central American country where English is the official language.",
		"Honduras' literal meaning is 'Great Depths.'",
		"The national anthem of Guatemala was written by a Cuban.",
		"Lake Nicaragua is the largest lake in Central America.",
		"In El Salvador, men wait for the women to extend hands for shaking (instead of them extending it first) as a sign of respect.",
		"Panama is the only place in the world where you can see the sun rise in the Pacific and set in the Atlantic.",
		"Costa Rican maless refer to themselves as Ticos and females as Ticas.",

		// Caribbean
		"Cuba has a 99.8% literacy rate, which is one of the highest in the world.",
		"Obeahism, a form of religion brought over by African slaves in which people can bring good or bad luck upon others, is punishable by death in Jamaica.",
		"St. Lucia is the world's only country named after a woman.",
		"Antigua & Barbuda has one beach for every day of the year and is nicknamed the 'Land of 365 Beaches.'",
		"Dominica's Boiling Lake is the second largest hot spring in the world.",
		"Grenada has only three traffic lights on the entire island.",
		"Barbados has the world's third oldest parliament, which has been around since 1639.",
		"Trinidad & Tobago has the biggest brain coral in the world.",
		"St. Kitts & Nevis is a mere two miles wide.",
		"There are 32 islands and cays that make up St. Vincent & the Grenadines, but only nine of them are inhabited.",
		"More than 70 dictators ruled Haiti during the 19th century and into the 20th century.",
		"Dominican Republic is the only country in the world to have the Holy Bible on its flag.",
		"When Columbus sailed the ocean blue in the year 1492, he first landed in the Bahamas."
	};

	/**
	 * This class is responsible for allowing the programmers to create Nodes, a critical way of representing our 
	 * elements in a Linked List. This class is static because for every instance of Node the nodes of the 
	 * Linked List should be the same (i.e. the head element is the head element of every instance of Node).
	 * The class is also private because there is no need for changes/access of the Node class in other classes.
	 */
	private static class Node<K, V> {

		// establishes data fields of Node class
		private K key;
		private V value;
		private Node<K, V> next;

		/**
		 * Creates an instance of Node
		 *
		 * @param K key
		 * @param V value
		 */
		public Node(K key, V value) {
			this.key=key;
			this.value=value;
		}

		/**
		 * Retrieves the key of a Node
		 *
		 * @return key
		 */
		public K getKey() {
			return this.key;
		}

		/**
		 * Retrieves the value of a Node
		 *
		 * @return value
		 */
		public V getValue() {
			return this.value;
		}

		/**
		 * Sets the value of a Node
		 *
		 * @param V value
		 */
		public void setValue(V value) {
			this.value=value;
		}

		/**
		 * Retrieves the next Node
		 *
		 * @return node next to current
		 */
		public Node<K, V> getNext() {
			return this.next;
		}

		/**
		 * Sets the next Node
		 *
		 * @param Node<K, V> node to set to
		 */
		public void setNext(Node<K, V> n) {
			this.next=n;
		}
	}

	/*
	 * This class is responsible for implementing a hashtable to store the countries and their fun facts.
	 */
	private static class Table {

		// private data fields in the Table class
		private ArrayList<Node<String, String>> countriesData=new ArrayList<Node<String, String>>();
		private int capacity=26;
		private int size=0;

		/**
		 * Default constructor (no parameters) for Table class.
		 *
		 * Runtime: O(N)
		 */
		public Table() {

			// initializes countriesData with null values
			for (int i=0; i<capacity; i++) {
				countriesData.add(null);
			}
		}

		/**
		 * Computes the index of a key using Java's hashCode() method.
		 *
		 * @param String key
		 * @return int index
		 * 
		 * Runtime: O(1)
		 */
		public int getIndex(String country) {
			return Math.abs(country.hashCode()%capacity);
		}

	    /**
	     * Returns the fun fact about the country.
	     *
	     * @param String country 
	     * @return String fun fact about that country
	     * @throws NullPointerException if key is null
		 *
		 * Runtime: best case O(1), worst case O(N)
		 */
		public String get(String country) throws NullPointerException {

			// checks if country entered is null
			if (country==null) {
				throw new NullPointerException("Country cannot be null.");
			}

			// retrieve the head of the list
			Node<String, String> current=countriesData.get(getIndex(country));

			// iterate through list to retrieve country's fun fact
			while (current!=null) {
				if (current.getKey().equals(country)) {
					return current.getValue();
				}

				current=current.getNext();
			}

			// if country is not found
			return null;
		}

	    /**
	     * Adds data into hash table.
	     *
	     * @param String country
	     * @param String fun fact about that country
	     * @throws NullPointerException if country is null
		 *
		 * Runtime: best case O(1), worst case O(N)
		 */
		public void add(String country, String funFact) throws NullPointerException {

			// checks if country or fun fact entered is null
			if (country==null || funFact==null) {
				throw new NullPointerException("Country or fun fact cannot be null.");
			}

			// creates new node with relevant data
			Node<String, String> newNode=new Node<String, String>(country, funFact);
			
			// retrieves head of linked list
			Node<String, String> current=countriesData.get(getIndex(country));

			// if there is no list at that index
			if (current==null) {
				countriesData.set(getIndex(country), newNode);
				size++;
				return;
			}
			
			// iterates through linked list
			while (current!=null) {

				// if that country is already there, replace the funfact
				if (current.getKey().equals(country)) {
					current.setValue(funFact);
				}

				current=current.getNext();
			}

			// add new node to the beginning of the list
			current=countriesData.get(getIndex(country));
			newNode.setNext(current);
			size++;
			countriesData.set(getIndex(country), newNode);

			// handle load factor
			if ((1.0*size)/capacity>=0.7) {

				// temporary ArrayList to hold previous data
				ArrayList<Node<String, String>> temp=countriesData;

				// new countriesData that is double the previous capacity
				countriesData=new ArrayList<Node<String, String>>();
				capacity=2*capacity;
				size=0;
				for (int i=0; i<capacity; i++) {
					countriesData.add(null);
				}

				// reenter all the data into bigger hashtable
				for (int i=0; i<temp.size(); i++) {
					Node<String, String> currentOldTable=temp.get(i);
					while (currentOldTable!=null) {
						add(currentOldTable.getKey(), currentOldTable.getValue());
						currentOldTable=currentOldTable.getNext();
					}
				}
			}
		}

	    /**
	     * Removes country's data from hashtable.
	     *
	     * @param String country 
	     * @return boolean indicating whether country has been safely removed or not
	     * @throws NullPointerException if country is null
		 *
		 * Runtime: best case O(1), worst case O(N)
		 */
		public boolean remove(String country) throws NullPointerException {

			// checks if country to be removed is null
			if (country==null) {
				throw new NullPointerException("Country cannot be null.");
			}

			// retrieve head of linked list
			Node<String, String> current=countriesData.get(getIndex(country));

			// if there is no list at that index
			if (current==null) {
				return false;
			}

			// if the country to be removed is at the head of the linked list
			if (current.getNext()==null) {
				countriesData.set(0, current.getNext());
				size--;
				return true;
			}

			// looks for country in linked list
			while (current!=null) {

				// if the next node's country is the country we are looking for
				if (current.getNext().getKey().equals(country)) {				
					current.setNext(current.getNext().getNext());
					size--;
					return true;
				}

				current=current.getNext();
			}

			// if country isn't found
			return false;
		}

	    /**
	     * Returns the number of elements in this list.
	     *
	     * @return the number of elements in this list
	     *
	     * Runtime: O(1)
	     */
		public int size() {
			return size;
		}

	    /**
	     * Indicates whether list is empty or not
	     *
	     * @return boolean
	     *
	     * Runtime: O(1)
	     */
		public boolean isEmpty() {
			return size==0;
		}

	    /**
	     * Clears all elements in this list.
	     *
	     * Runtime: O(N)
	     */
		public void clear() {
			countriesData.clear();
			size=0;
		}
	}

	// main method to add countries' data into hashtable
	public static void main(String[] args) {

		Table hashtable=new Table();

		// test to see if initial size should be 0
		// System.out.println(hashtable.size());

		// should be true
		// System.out.println(hashtable.isEmpty());

		for (int i=0; i<countries.length; i++) {
			hashtable.add(countries[i], funFacts[i]);
			System.out.println(countries[i]+": "+hashtable.get(countries[i])+"\n");
		}

		// System.out.println(hashtable.size());

		// test if added correctly
		// if (countries.length==hashtable.size()) {
		// 	System.out.println("All countries and fun facts are added to the hashtable.");
		// } else {
		// 	System.out.println("All countries and fun facts were not added to the hashtable.");
		// }

		// should return false
		// System.out.println(hashtable.isEmpty());

		// should return true
		// System.out.println(hashtable.remove(countries[0]));

		// should be one less than previous size
		// System.out.println(hashtable.size());

		// hashtable.clear();

		// should be true
		// System.out.println(hashtable.isEmpty());
	}
}