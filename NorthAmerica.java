import java.util.*;

public class NorthAmerica {

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

	// HASH TABLE
	private static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> next;

		public Node(K key, V value) {
			this.key=key;
			this.value=value;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public Node<K, V> getNext() {
			return this.next;
		}

		public void setNext(Node<K, V> n) {
			this.next=n;
		}
	}

	private Node<K, V> head=null;
	private int size=0;

	private static class HashTable {
		private ArrayList<Node<K, V>> array=new ArrayList<Node<K, V>>();
		private int capacity=50;
		private int size=0;

		public HashTable() {
			for (int i=0; i<capacity; i++) {
				array.add(null);
			}
		}

		public boolean contains(K key) {
			int index=hash(key)%array.length;
			
		}

		public V getValue(K key) {

		}

		public K getKey(V value) {

		}

		public void add(K key, V value) {

		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return size==0;
		}

		public void clear() {
			array.clear();
		}

		public V remove(K key) {

		}

		private int hash(K key) {

		}
	}

	public static void main(String[] args) {
		System.out.println(countries.length);
	}
}