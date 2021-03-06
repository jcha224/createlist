package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mylistpackage.ArrayListSorted;
import mylistpackage.MyList;

public class ArrayListSortedTest {

	private MyList<String> al;//array list
	@Before
	public final void setup() {
		//al = new ArrayListSorted<String>();
		al = new ArrayListSorted<String>(1);
	}
	
	/**
	 * test constructor with illegal 0 input
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void zeroCapacity() {
		al = new ArrayListSorted<String>(0);
	}
	
	/**
	 * test constructor with illegal negative input
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void negativeCapacity() {
		al = new ArrayListSorted<String>(-1);
	}
	
	/**
	 * test contains with empty list
	 */
	@Test
	public final void containEmpty() {
		assertFalse("contain empty fail", al.contains("aaa"));
	}

	/**
	 * test contains with 1 element and it exists in the list
	 */
	@Test
	public final void contain1TN() {
		al.insert("aaa");
		assertTrue("contain 1 true fail", al.contains("aaa"));
	}
	
	/**
	 * test contains with 1 element and it does NOT exist in the list
	 */
	@Test
	public final void contain1FN() {
		al.insert("aaa");
		assertFalse("contain 1 false fail", al.contains("bbb"));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the head of the list
	 */
	@Test
	public final void arrayContain2HT() {
		al.insert("aaa");
		al.insert("bbb");
		assertTrue("contain 2 head true fail", al.contains("aaa"));
	}
	
	/**
	 * test contains with 2 elements list and element exist at the tail of the list
	 */
	@Test
	public final void arrayContain2TT() {
		al.insert("aaa");
		al.insert("bbb");
		assertTrue("contain 2 tail true fail", al.contains("bbb"));
	}
	
	/**
	 * test contains with 2 elements list and element does NOT exist
	 */
	@Test
	public final void arrayContain2F() {
		al.insert("aaa");
		al.insert("bbb");
		assertFalse("contain 2 false fail", al.contains("ccc"));
	}
	/**
	 * test clear by clear an empty list
	 */
	@Test
	public final void clear0() {
		al.clear();
		assertEquals("clear 0 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 1 element list
	 */
	@Test
	public final void clear1() {
		al.insert("aaa");
		al.clear();
		assertEquals("clear 1 fail", "[]", al.toString());
	}
	
	/**
	 * test clear by clear a 3 elements list
	 */
	@Test
	public final void clear3N() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.clear();
		assertEquals("clear 3 fail", "[]", al.toString());
	}
	/**
	 * test remove by remove exist element from 1 element list
	 */
	@Test
	public final void remove0True() {
		
		al.insert("aaa");
		al.remove("aaa");
		assertEquals("remove 0 True fail", "[]", al.toString());
		
	}
	
	/**
	 * test remove by remove not exist element from 1 element list
	 */
	@Test
	public final void remove0False() {		
		al.insert("aaa");
		al.remove("bbb");
		assertEquals("remove 0 False fail", "[aaa]", al.toString());	
	}
	
	/**
	 * test remove by remove exist element from 5 elements list
	 */
	@Test
	public final void remove5TrueN() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("ccc");
		assertEquals("remove 5 True fail", "[aaa, bbb, ddd, eee]", al.toString());	
	}
	
	/**
	 * test remove by remove NOT exist element from 5 elements list
	 */
	@Test
	public final void remove5False() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("fff");
		assertEquals("remove 5 False fail", "[aaa, bbb, ccc, ddd, eee]", al.toString());	
	}
	
	/**
	 * test remove by remove head element from 5 elements list
	 */
	@Test
	public final void remove5HeadNext() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("bbb");
		assertEquals("remove 5 head next fail", "[aaa, ccc, ddd, eee]", al.toString());	
	}
	
	/**
	 * test remove by remove tail element from 5 elements list
	 */
	@Test
	public final void remove5TailNext() {		
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.remove("ddd");
		assertEquals("remove 5 tail next fail", "[aaa, bbb, ccc, eee]", al.toString());	
	}
	/**
	 * test set by set negative index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void setNegative() {
		al.set(-1, "aaa");
	}
	
	/**
	 * test set by set 0 index in an empty list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set0False() {
		al.set(0, "aaa");
	}
	
	/**
	 * test set by set out of bound index in a 1 element list
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public final void set1False() {
		al.insert("aaa");
		al.set(1, "bbb");
	}
	
	/**
	 * test set by set 0 index in a 1 element list
	 */
	@Test
	public final void set1() {
		al.insert("aaa");
		al.set(0, "bbb");
		assertEquals("set 1 fail", "[bbb]", al.toString());
	}
	
	/**
	 * test set by set one next to head index in a 5 elements list
	 */
	@Test
	public final void set5HeadNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.set(4, "fff");
		assertEquals("set 5 head next fail", "[aaa, bbb, ccc, ddd, fff]", al.toString());
	}
	
	/**
	 * test set by set one next to tail index in a 5 elements list
	 */
	@Test
	public final void set5TailNextN() {
		al.insert("aaa");
		al.insert("bbb");
		al.insert("ccc");
		al.insert("ddd");
		al.insert("eee");
		al.set(3, "ccc");
		assertEquals("set 5 tail next fail", "[aaa, bbb, ccc, ccc, eee]", al.toString());
	}
}
