import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class LinkedListTest {
	LinkedList list = new LinkedList("first node");

	@Test
	public void testFirstNode() {
		assertEquals("first node", list.head.data);
	}

	@Test
	public void testInsertNode() {
		list.insert("node 1");
		assertEquals("node 1", list.head.next.data);
	}

	@Test
	public void testFindFirstNode() {
		assertEquals("first node", list.find("first node").data);

	}

	@Test
	public void testFindFirstInsertedNode() {
		list.insert("node 1");
		assertEquals("node 1", list.find("node 1").data);
	}

	@Test
	public void testUpdateNode() {
		list.update("first node", "updated node");
		assertEquals("updated node", list.head.data);
	}
	
	@Test
	public void testUpdateNonExistingNode() {
		assertEquals(list.update("xyz node", "updated node"), false);
	}
	
	@Test
	public void testFindParentOfFirstNode() {
		Node node = list.findParent("first node");
		assertEquals(node, null);
	}

	@Test
	public void testFindParent() {
		list.insert("node 1");
		Node node = list.find("node 1");
		assertEquals(list.head, list.findParent(node.data));
	}

	@Test
	public void testDeleteFirstNode() {
		list.insert("node 1");
		list.delete("node 1");
		assertEquals(list.head.next, null);
	}
	
	@Test
	public void testDeleteNonExistingNode() {
		list.insert("node 1");
		
		assertEquals(list.delete("node n"), false);
	}

	@Test
	public void testDeleteSecondNode() {
		list.insert("node 1");
		list.insert("node 2");
		list.delete("node 2");
		assertEquals(list.find("node 2"), null);
	}

	@Test
	public void testPop() {
		list.insert("node 1");
		Node node = list.find("node 1");
		assertEquals(node, list.pop());

		list.insert("node 1");
		list.insert("node 2");
		list.insert("node 3");
		Node nodeThree = list.find("node 3");
		Node nodeTwo = list.find("node 2");
		assertEquals(nodeThree, list.pop());
		assertEquals(nodeTwo, list.pop());
	}

	@Test
	public void testTailOfFirstNode() {
		Node tail = list.tail();
		assertEquals("first node", tail.data);
	}
	
	@Test
	public void testLastNode() {
		list.insert("node 1");
		Node tail = list.tail();
		assertEquals("node 1", tail.data);
	}

	@Test
	public void testListLength() {
		assertEquals(1, list.length());

		list.insert("node 1");

		assertEquals(2, list.length());

		list.insert("node 2");

		assertEquals(3, list.length());
	}
	
	@Test
	public void testPrintFirstNode() {
	    // Prepare to capture output
	    PrintStream originalOut = System.out;        
	    OutputStream os = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(os);
	    System.setOut(ps);
	    
	    // Perform tests
	    list.print();
	    assertEquals("first node\n", os.toString());

	    // Restore normal operation
	    System.setOut(originalOut);
	}
	
	@Test
	public void testPrintTwoNodes() {
	    // Prepare to capture output
	    PrintStream originalOut = System.out;        
	    OutputStream os = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(os);
	    System.setOut(ps);
	    
	    // Perform tests
	    list.insert("node 1");
	    list.print();
	    
	    assertEquals("first node\nnode 1\n", os.toString());

	    // Restore normal operation
	    System.setOut(originalOut);
	}
	
	@Test
	public void testPrintMoreThanTwoNodes() {
	    // Prepare to capture output
	    PrintStream originalOut = System.out;        
	    OutputStream os = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(os);
	    System.setOut(ps);
	    
	    // Perform tests
	    list.insert("node 1");
	    list.insert("node 2");
	    list.print();
	    
	    assertEquals("first node\nnode 1\nnode 2\n", os.toString());

	    // Restore normal operation
	    System.setOut(originalOut);
	}
}