package com.bhushan.expedia.linkedlist;

import java.io.Serializable;

/**
 * The class acts as a backing bean for the nodes in MyLinkedList.java.
 * @author Bhushan Karayilthekkoot.
 *
 * @param <T>
 */
public class MyNode<T> implements Serializable {

	private static final long serialVersionUID = -2976403251303020096L;
	private T value;
	private MyNode<T> nextNode;
	
	/**
	 * Default no argument constructor.
	 */
	MyNode() {}
	
	/**
	 * Constructor.
	 * @param value
	 * @param nextNode
	 */
	MyNode(T value, MyNode<T> nextNode) {
		setValue(value);
		setNextNode(nextNode);
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * @return the nextNode
	 */
	public MyNode<T> getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(MyNode<T> nextNode) {
		this.nextNode = nextNode;
	}

	

}
