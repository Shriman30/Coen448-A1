
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

	// Test enq_T1
	@Test
	public void testForNullInputEnqueue() {
		ADTQueue<Integer> AQ = new AQueue<Integer>();
		AQ.enqueue(null);
		assertEquals(null, AQ.frontValue());
	}

	// Test enq_T2
	@Test
	public void testForNotNullInputEnqueue() {
		ADTQueue<Integer> AQ = new AQueue<Integer>();
		int expected = 22;
		AQ.enqueue(expected);
		assertEquals("< 22 >", AQ.toString());
	}

	// Test enq_T3
	@Test
	public void testCurrentPositionInsert() {
		Q1 = new AQueue<Integer>();
		// Enqueuing front element to queue
		Q1.enqueue(22);
		assertEquals(22, Q1.frontValue());
	}

	// Test enq_T4
	@Test
	public void enqueueToTheRearOfAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.enqueue(3);
		String expected = "< 1 2 3 >";
		String actual = Q1.toString();
		assertEquals(expected, actual);
	}

	// Test enq_T5
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

	// Test enq_T6
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

	// Test deq_T1
	@Test
	public void dequeueANullElementAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(null);
		assertEquals(null, Q1.dequeue());
	}

	// Test deq_T2
	@Test
	public void dequeueANonNullElementAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(22);
		assertEquals(22, Q1.dequeue());
	}

	// Test deq_T3
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

	// Test deq_T4
	@Test 
	public void dequeueANonEmptyAQueue(){
		Q1 = new AQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertEquals(1, Q1.dequeue());
	}



}
