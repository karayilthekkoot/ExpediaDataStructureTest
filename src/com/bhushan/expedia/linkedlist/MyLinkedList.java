package com.bhushan.expedia.linkedlist;

import java.io.Serializable;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>, Serializable {

	private static final long serialVersionUID = -6984778005936600010L;
	protected MyNode<T> head;
	protected MyNode<T> tail;
	protected int size;

	/**
	 * Default Constructor.
	 */
	public MyLinkedList() {
		head = tail = null;
		size = 0;
	}

	/**
	 * Gets the size of the Linked List.
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method adds element to the end of the linked list iteratively.
	 * Time Complexity = O(n)
	 * @param value
	 */
	public void add(T value) {
		if (head == null) {
			head = tail = new MyNode<T>(value, null);
		} else {
			MyNode<T> node = this.head;
			tail = new MyNode<T>(value, null);

			while (node.getNextNode() != null) {
				node = node.getNextNode();
			}
			node.setNextNode(tail);
		}
		size++;
	}
	
	/**
	 * Method adds element to the end of the linked list.
	 * Time Complexity = O(1)
	 * @param value
	 */
	public void addToEnd(T value) {
		if (size == 0) {
			head = tail = new MyNode<T>(value, null);	
		} else {
			MyNode<T> tempNode = new MyNode<>(value, null);
			tail.setNextNode(tempNode);
			tail = tempNode;
		}
		size++;
	}
	
/**
 * Method adds element to the specified index of the LinkedList.
 * Time Complexity = O(n)
 * @param value
 * @param index
 */
	public void insert(T value, int index) {
		if ((index < 0) || (index >= this.size)) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			if (index == 0) {
				tail = new MyNode<T>(value , head);
				head = tail;
			} else {
				
				MyNode<T> node = head;
				for (int i = 1; i < index; i++) {
					node = node.getNextNode();
				}
				MyNode<T> tempNode = new MyNode<>(value , node.getNextNode());
				node.setNextNode(tempNode);
			}
			size++;
		}
		
	}
	

/**
 * Method removes the element from the head of the linked list.
 * Time Complexity = O(1); 	
 */
	public void removeFromStart() {
		if (size == 0) {
			throw new NullPointerException();
		} else {
			head = head.getNextNode();
		}
	}

	/**
	 * Method removes element from a given index in the Linked List.
	 * Time Complexity = O(n).
	 * @param index
	 */
	public void remove(int index) {
		if ((index < 0) || (index >= this.size)) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			if (index == 0) {
				head = head.getNextNode();
			} else {
				MyNode<T> node = head;
				for (int i = 1; i < index; i++) {
					node = node.getNextNode();
				}
				node.setNextNode(node.getNextNode().getNextNode());
			}
			size--;
		}
	}

	/**
	 * Method retrieves the value at a given index.
	 * @param index
	 * @return T value
	 */
	public T getValue(int index) {
		MyNode<T> node = new MyNode<T>();
		if ((index < 0) || (index >= this.size)) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			if (index == 0) {
				node = head;
			} else {
				node = head.getNextNode();
				for (int i = 1; i < index; i++) {
					node = node.getNextNode();
				}
			}
		}
		return node.getValue();
	}
	
	
	/**
	 * Method converts the linked list to a readable string.
	 */
	@Override
	public String toString() {
		return toString(head);
	}

	private String toString(MyNode<T> node) {
		if (node == null) {
			return null;
		} else {
			return node.getValue() + " => " + toString(node.getNextNode());
		}
	}

	/**
	 * Overridden method allows the Linked List to have a iterator 
	 * and perform Iterative operations on the linked list.
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			private int index = 0;

			/**
			 * Method gives a boolean value on the existence of the next node.
			 */
			@Override
			public boolean hasNext() {
				if (index < getSize()) {
					return true;
				}
				return false;
			}

			/**
			 * Method return the next value in the iteration.
			 */
			@Override
			public T next() {
				T data = getValue(index);
				index++;
				return data;
			}

			/**
			 * Method removes the value on the current iteration.
			 */
			@Override
			public void remove() {
				MyLinkedList.this.remove(index-1);
			}

		};
		return iterator;
	}

}
