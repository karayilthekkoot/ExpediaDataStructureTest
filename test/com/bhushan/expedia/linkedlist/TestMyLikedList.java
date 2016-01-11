package com.bhushan.expedia.linkedlist;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
/**
 * Class tests the functionality of MyLinkedList.java.
 * @author Bhushan Karayilthekkoot.
 *
 */
public class TestMyLikedList {
	
	/**
	 * Test for creating a Linked List.
	 */
	@Test
	public void testCreateLinkedList() {
		MyLinkedList<String> stringList = new MyLinkedList<String>();
		assertNotNull(stringList);
	}
	
	/**
	 * Testing add Functionality. 
	 */
	@Test
	public void testAdd() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		assertNotNull(numList);
		int i = 0;
		
		while (i <= 15) {
		 numList.add(i);
		 i++;
		}
		assertTrue(numList.getValue(14).equals(14));
	}
	
	/**
	 * Testing addToEnd Functionality. 
	 */
	@Test
	public void testAddToEnd() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		
		int i = 0;
		while (i <= 15) {
		 numList.addToEnd(i);
		 i++;
		}
		
		assertTrue(numList.getValue(14).equals(14));
	}
	
	/**
	 * Testing insert Functionality. 
	 */
	@Test
	public void testInsert() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		
		int i = 0;
		while (i <= 15) {
		 numList.addToEnd(i);
		 i++;
		}
		
		assertTrue(numList.getValue(14).equals(14));
	
		numList.insert(123, 14);
		
		assertTrue(!numList.getValue(14).equals(14));
		assertTrue(numList.getValue(14).equals(123));
	}
	
	/**
	 * Testing remove Functionality. 
	 */
	@Test
	public void testRemove() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		
		int i = 0;
		while (i <= 15) {
		 numList.addToEnd(i);
		 i++;
		}
		
		assertTrue(numList.getValue(14).equals(14));
		
		numList.remove(14);
		
		assertTrue(!numList.getValue(14).equals(14));
		assertTrue(numList.getValue(14).equals(15));
	}
	
	/**
	 * Testing removeFromStart Functionality. 
	 */
	@Test
	public void testRemoveFromStart() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		
		int i = 0;
		while (i <= 15) {
		 numList.addToEnd(i);
		 i++;
		}
		
		assertTrue(numList.getValue(14).equals(14));
		
		numList.removeFromStart();
		
		assertTrue(!numList.getValue(14).equals(14));
		assertTrue(numList.getValue(14).equals(15));
	
	}
	
	/**
	 * Testing Remove Using Iterator.
	 */
	@Test 
	public void testRemoveUsingIterartor() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		 
		int i = 0;
		while (i <= 15) {
		 numList.addToEnd(i);
		 i++;
		}
		
		assertTrue(numList.getValue(5).equals(5));
		
		Iterator<Integer> itr = numList.iterator();
	      while(itr.hasNext()) {
	    	 Object element = itr.next();
	         if (element.equals(5) ) {
	         itr.remove();
	         }
	      }
	    assertTrue(!numList.getValue(5).equals(5));  
	    assertTrue(numList.getValue(5).equals(6));  
	}
	
	/**
	 * Testing for ArrayIndexOutOfBoundsException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)  
	public void testForArrayIndexOutOfBoundsException() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		 
		int i = 0;
		while (i <= 15) {
		 numList.addToEnd(i);
		 i++;
		}
		
		numList.getValue(20);
	}
	
	/**
	 * Testing for NullPointerException.
	 */
	@Test(expected = NullPointerException.class)  
	public void testForNullPointerException() {
		MyLinkedList<Integer> numList = new MyLinkedList<Integer>();
		
		assertNotNull(numList);
		 
		numList.removeFromStart();
	}

}
