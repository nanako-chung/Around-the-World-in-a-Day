import java.util.*;

/**
 * This class contains a list of South American countries, a sub-class of Nodes, another sub-class that implements a 
 * binary search tree, and finally a main method that actually stores the countries into an instance of the implemented binary tree. 
 * The key is the country name (String) and the value is a fun fact about that country (also a String).
 *
 * @author Nanako Chung
 */
public class SouthAmerica {
	
	// array of countries (listed by memory! :) ) with their respective fun facts
	public static String[] countries = {
		"Brazil: Brazil has the fifth largest population in the world, estimating about 200 million people.",
		"Argentina: Argentina comes from the Latin word for silver: argentum.",
		"Suriname: Tropical rain forests make up 80% of Suriname.",
		"Peru: Peru has only 3% arable land due to the presence of the Andes mountains.",
		"Chile: Chile is home to the world's biggest swimming pool.",
		"Guyana: Guyana has one of the largest single-drop waterfalls in the world, called Kaieteur Falls.",
		"Venezuela: Venezuela means 'Little Venice' by Amergio Vespucci, who claimed that Venezuela reminded him of Venice.",
		"Colombia: Colombia is part of the Ring of Fire.",
		"Ecuador: Ecuador is the only country in the world that is named after a geographical feature: the equator.",
		"Bolivia: Bolivia has 37 official languages.",
		"Paraguay: Paraguay is a bilingual nation (Guarani and Spanish), and Guarani is an onomatopoeic language.",
		"Uruguay: Cows outnumber people four to one in Uruguay."
	};

	/**
	 * This class is responsible for allowing the programmers to create Nodes, a critical way of representing our 
	 * elements in a Linked List. This class is static because for every instance of Node the nodes of the 
	 * Linked List should be the same (i.e. the head element is the head element of every instance of Node).
	 * The class is also private because there is no need for changes/access of the Node class in other classes.
	 */
	private static class Node<E> {

		// establishes data fields of Node class
		private Node<E> left;
		private Node<E> right;
		private E data;
		private int height;

		/**
		 * Creates an instance of a Node
		 *
		 * @param E data
		 */
		public Node(E data) {
			this.data=data;
			left=null;
			right=null;
			height=0;
		}
	}


	/*
	 * This class is responsible for implementing a binary search tree to store the countries and their fun facts.
	 */

}

// BIG O

// SORT

// /**
//  * Method to implement bubble sort
//  *
//  * @param String[] array
//  *
//  * Runtime: O(n^2)
//  */
// public static void bubbleSort(String[] array) {
// 	for (int i=0; i<array.length-1; i++) {
// 		for (int j=0; j<array.length-i-1; j++) {
// 			if (array[j].compare(array[j+1])>0) {
// 				String temp=array[j];
// 				array[j]=array[j+1];
// 				array[j+1]=temp;
// 			}
// 		}
// 	}
// }

// // countries sorted by alphabetical order using bubble sort
// bubbleSort(countries);