package com.krish.dsa.linkedlist.singlylinkedlist;

import java.util.Objects;

import org.springframework.util.Assert;

/**
 * <pre>
* Author: venkat
* Created Date: 20-Oct-2023
 * </pre>
 */
public class CustomSinglyLinkedListImpl<E> implements CustomSinglyLinkedList<E> {

	private static class Node<E> {
		E value;
		Node<E> next;

		public Node(E value) {
			this.value = value;
		}
	}

	private int size;
	private Node<E> head;

	@Override
	public boolean addFirst(E value) {
		Assert.notNull(value, "Required a valid value to insert into Linked List");

		// Create a new Node with the provided value
		Node<E> newNode = new Node<>(value);

		/*
		 * If the head is null, it means that we do not have any nodes in the Linked
		 * List We need to point the head as the newly created node
		 */
		if (Objects.isNull(head)) {
			head = newNode;
			size++;
			return true;
		}

		/*
		 * If there are any nodes present, then point the newly created node next as
		 * head and point head to newly created node
		 */
		newNode.next = head;
		head = newNode;
		size++;
		return true;
	}

	@Override
	public boolean addLast(E value) {
		Assert.notNull(value, "Required a valid value to insert into Linked List");

		// Create a new Node with the provided value
		Node<E> newNode = new Node<>(value);

		/*
		 * If the head is null, it means that we do not have any nodes in the Linked
		 * List We need to point the head as the newly created node
		 */
		if (Objects.isNull(head)) {
			head = newNode;
			size++;
			return true;
		}

		/*
		 * If there are any nodes present, then traverse through all the nodes and point the last node next to newly created node
		 */
		Node<E> currentNode = head;
		while(Objects.nonNull(currentNode.next)) {
			currentNode = currentNode.next;
		}
		
		currentNode.next = newNode;
		size++;
		return true;
	}

	@Override
	public boolean add(int pos, E value) {
		Assert.notNull(value, "Required a valid value to insert into Linked List");
		
		if(pos == 1) {
			return addFirst(value);
		}
		if(pos == size + 1) {
			return addLast(value);
		}
		
		Node<E> currentNode = head;
		Node<E> prevNode = null;
		while(--pos > 0) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		Node<E> newNode = new Node<>(value);
		prevNode.next = newNode;
		newNode.next = currentNode;
		size++;
		return true;
	}

	@Override
	public E removeFirst() {
		Assert.state(size == 0, "Unable to remove due to insufficient nodes");
		
		Node<E> firstNode = head;
		head = head.next;
		size--;
		
		return firstNode.value;
	}

	@Override
	public E removeLast() {
		Assert.state(size == 0, "Unable to remove due to insufficient nodes");
		
		Node<E> currentNode = head;
		int pos = size;
		while(--pos > 0) {
			currentNode = currentNode.next;
		}
		
		Node<E> lastNode = currentNode;
		currentNode.next = currentNode.next.next;
		size--;
		
		return lastNode.value;
	}

	@Override
	public E remove(E value) {
		Assert.notNull(value, "Required a valid value to insert into Linked List");
		
		Node<E> currentNode = head;
		Node<E> prevNode = head;
		while(Objects.nonNull(currentNode)) {
			if(value.equals(currentNode.value)) {
				prevNode.next = currentNode.next;
				size--;
				return value;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		return null;
	}
 
	@Override
	public void display() {
		Node<E> currentNode = head;
		while(Objects.nonNull(currentNode.next)) {
			System.out.print(currentNode.value + "->");
			currentNode = currentNode.next;
		}

		System.out.print(currentNode.value);
	}

	@Override
	public int size() {
		return size;
	}

}
