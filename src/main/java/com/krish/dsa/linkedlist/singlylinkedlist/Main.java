package com.krish.dsa.linkedlist.singlylinkedlist;

/**
* <pre>
* Author: venkat
* Created Date: 21-Oct-2023
* </pre>
*/
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CustomSinglyLinkedList<Integer> customList = new CustomSinglyLinkedListImpl<Integer>();
		
		System.out.println(customList.size());
		
		customList.addFirst(5);
		customList.addLast(1);
		customList.addFirst(0);
		customList.add(2, 10);
		customList.add(1, 11);
		System.out.println(customList.size());
		
		customList.remove(0);
		System.out.println(customList.size());
		customList.display();
	}

}
