package com.krish.dsa.linkedlist.singlylinkedlist;

/**
* <pre>
* Author: venkat
* Created Date: 20-Oct-2023
* </pre>
*/
public interface CustomSinglyLinkedList<E> {

	boolean addFirst(E value);
	
	boolean addLast(E value);
	
	boolean add(int pos, E value);
	
	E removeFirst();
	
	E removeLast();
	
	E remove(E value);
	
	void display();
	
	int size();
}
