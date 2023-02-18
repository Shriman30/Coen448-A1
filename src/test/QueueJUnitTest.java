
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.queue.*;

class QueueJUnitTest {

	private ADTQueue<Integer> Q1;
	private ADTQueue<Integer> Q2;

	@BeforeEach
	void setUp() throws Exception {
		Q1 = new DQueue<Integer>();
		Q2 = new DQueue<Integer>();
	}

	@Test
	public void testGeneral() {
		int temp;

		Q2.enqueue(10);
		Q2.enqueue(20);
		Q2.enqueue(15);
		assertEquals("< 10 20 15 >", Q2.toString());

		while (Q2.length() > 0) {
			temp = Q2.dequeue();
			Q1.enqueue(temp);
		}
		assertEquals("< >", Q2.toString());
		assertEquals("< 10 20 15 >", Q1.toString());

	}

	// New test iteration 1million

	// Test AET1
	@Test
	public void testForNullInputEnqueue() {
		ADTQueue<Integer> AQ = new AQueue<Integer>();
		AQ.enqueue(null);
		assertEquals(null, AQ.frontValue());
	}

	// Test AET2
	@Test
	public void testForNotNullInputEnqueue() {
		ADTQueue<Integer> AQ = new AQueue<Integer>();
		int expected = 22;
		AQ.enqueue(expected);
		assertEquals("< 22 >", AQ.toString());
	}

	// Test AET3
	@Test
	public void testCurrentPositionInsert() {
		Q1 = new AQueue<Integer>();
		// Enqueuing front element to queue
		Q1.enqueue(0);
		assertEquals(0, Q1.frontValue());
	}

	// Test AET4
	@Test
	public void enqueueToTheRearOfAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(0);
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.enqueue(4);
		Q1.enqueue(5);
		Q1.enqueue(6);
		Q1.enqueue(7);
		Q1.enqueue(8);
		String expected = "< 0 1 2 3 4 5 6 7 8 >";
		String actual = Q1.toString();
		assertEquals(expected, actual);
	}

	// Test AET5
	@Test
	public void enqueueAnAQueueWithSpace() {
		int size = 15;
		Q1 = new AQueue<Integer>(size);
		for (int i = 0; i < size - 2; i++) {
			Q1.enqueue(i);
		}

		// There is still space in queue
		Q1.enqueue(99);
		assertEquals("< 0 1 2 3 4 5 6 7 8 9 10 11 12 99 >", Q1.toString());
	}

	// Test AET6
	@Test
	public void enqueueAnAQueueWithNoSpace() {
		int size = 15;
		Q1 = new AQueue<Integer>(size);
		for (int i = 0; i < size; i++) {
			Q1.enqueue(i);
		}
		// Saving assertion
		AssertionError exception = Assertions.assertThrows(AssertionError.class, () -> Q1.enqueue(1));
		// Converting assertion to string to compare with expected message
		String actualMessage = exception.getMessage();
		String expectedMessage = "Queue is full";
		assertEquals(expectedMessage, actualMessage);
	}

	// Test AET6
	@Test
	public void enqueueAnAQueueWithNotNullArray() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertNotEquals(null, Q1.toString());
	}

	// Test AET7
	@Test
	public void enqueueAnAQueueWithNullArray() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(null);
		Q1.enqueue(null);
		assertEquals("< null null >", Q1.toString());
	}

	// Test AET8
	@Test 
	public void enqueueLessElementsThanMaxSizeAQueue(){
		int maxSize = 5;
		Q1 = new AQueue<Integer>(maxSize);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.enqueue(1);
		assertTrue(Q1.length() < maxSize);
	}

	// Test AET9
	@Test 
	public void enqueueEqualElementsToMaxSizeAQueue(){
		int maxSize = 5;
		Q1 = new AQueue<Integer>(maxSize);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.enqueue(1);
		Q1.enqueue(4);
		Q1.enqueue(7);
		assertTrue(Q1.length() == maxSize);
	}

	// Test ADT1
	@Test
	public void dequeueANullElementAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(null);
		assertEquals(null, Q1.dequeue());
	}

	// Test ADT2
	@Test
	public void dequeueANonNullElementAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(22);
		assertEquals(22, Q1.dequeue());
	}

	// Test ADT3
	@Test
	public void dequeueFromEmptyAQueue() {
		Q1 = new AQueue<Integer>();
		// Saving assertion
		AssertionError exception = Assertions.assertThrows(AssertionError.class, () -> Q1.dequeue());
		// Converting assertion to string to compare with expected message
		String actualMessage = exception.getMessage();
		String expectedMessage = "Queue is empty";

		assertEquals(expectedMessage, actualMessage);
	}

	// Test ADT4
	@Test 
	public void dequeueANonEmptyAQueue(){
		Q1 = new AQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertEquals(1, Q1.dequeue());
	}

	// Test LET1
	@Test
	public void testForNullInputLEnqueue(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(null);
		Q1.enqueue(2);
		assertEquals(null, Q1.frontValue());
	}

	// Test LET2 
	@Test 
	public void testForNotNullInputLEnqueue(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(55);
		Q1.enqueue(2);
		assertEquals(55, Q1.frontValue());
	}

	// Test LET3
	@Test 
	public void LEnqueueNotAtRearOfQueue(){
		Q1 = new LQueue<Integer>();
		// Enqueuing front element to queue
		Q1.enqueue(22);
		assertEquals(22, Q1.frontValue());
	}

	// Test LET4
	@Test 
	public void LEnqueueAtRearOfQueue(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.enqueue(3);
		String expected = "< 1 2 3 >";
		String actual = Q1.toString();
		assertEquals(expected, actual);
	}


	// Test LET5
	@Test 
	public void LEnqueueAnLQueueWithSize0(){
		Q1 = new LQueue<Integer>();
		assertEquals(0,Q1.length());
		// Enqueuing front element to queue
		Q1.enqueue(22);
		assertEquals(22, Q1.frontValue());
	}

	// Test LET6
	@Test 
	public void LEnqueueAnLQueueWithSizeGreaterThanQueue(){
		Q1 = new LQueue<Integer>();

		for (int i = 0; i < 10; i++) {
			Q1.enqueue(1);
		}
		
		Q1.enqueue(2);
		
		assertEquals("< 1 1 1 1 1 1 1 1 1 1 2 >", Q1.toString());
	}

	// Test LET7
	@Test 
	public void LEnqueueQueueisNotNull(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(1);
		assertNotEquals("< null null >", Q1.toString());
	}

	// Test LET8
	@Test 
	public void LEnqueueQueueisNull(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(null);
		Q1.enqueue(null);
		assertEquals("< null null >", Q1.toString());
	}
	

	// Test LDT1
	@Test 
	public void LDequeueLength0(){
		Q1 = new LQueue<Integer>();
		AssertionError exception = Assertions.assertThrows(AssertionError.class, () -> Q1.dequeue());
		assertEquals("Queue is empty",exception.getMessage());
		assertEquals(0,Q1.length());
	}

	// Test LDT2
	@Test 
	public void LDequeueAnElementSize(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.dequeue();
		assertEquals(1,Q1.length());
	}

	// Test LDT3
	@Test 
	public void LDequeueQueueSize0(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.dequeue();
		assertEquals(0,Q1.length());
	}

	// Test LDT4
	@Test 
	public void LDequeueSizeAsManyAsElements(){
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.dequeue();
		assertEquals(2,Q1.length());
	}

}
