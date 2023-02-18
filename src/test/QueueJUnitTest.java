
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.queue.*;

class QueueJUnitTest {

	private ADTQueue<Integer> Q1;
	private ADTQueue<Integer> Q2;
	private ADTQueue<String> Q3;

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
	// ECC combinations

	/*
	 * Test case ECCAE1
	 * Tester's name: Jason Hillinger
	 * Test input data: null , 0, 2, 3, 1
	 * Test type: functional & interface, whitebox
	 * Test case description: Tests all types of inserts using enqueue for the
	 * AQueue() class.
	 * Expected output: null, 0, True
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAE1() {
		// AET1
		testForNullInputEnqueue();
		// AET3
		testCurrentPositionInsert();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	/*
	 * Test case ECCAE2
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 22 , 0, 2, 3, 1
	 * Test type: functional & interface, whitebox
	 * Test case description: Tests non null inserts using enqueue for the AQueue()
	 * class.
	 * Expected output: 22, 0, True
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAE2() {
		// AET2
		testForNotNullInputEnqueue();
		// AET3
		testCurrentPositionInsert();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	/*
	 * Test case ECCAE3
	 * Tester's name: Jason Hillinger
	 * Test input data: null , 0,1,2,3,4,5,6,7,8 , 2,3,1
	 * Test type: functional & interface, blackbox
	 * Test case description: Tests inserts using enqueue for the AQueue() class to
	 * verify proper size of queue.
	 * Expected output: null, "< 0 1 2 3 4 5 6 7 8 >" , True
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAE3() {
		// AET1
		testForNullInputEnqueue();
		// AET4
		enqueueToTheRearOfAQueue();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	/*
	 * Test case ECCAE4
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: null , 0,1,2,3,4,5,6,7,8,9,10,11,12,99, 2,3,1,4,7
	 * Test type: functional & interface, blackbox
	 * Test case description: Tests null inserts using enqueue for the AQueue()
	 * class to verify proper size of queue.
	 * Expected output: null, "< 0 1 2 3 4 5 6 7 8 9 10 11 12 99 >" , True
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAE4() {
		// AET1
		testForNullInputEnqueue();
		// AET5
		enqueueAnAQueueWithSpace();
		// AET9
		enqueueEqualElementsToMaxSizeAQueue();

	}

	/*
	 * Test case ECCAE5
	 * Tester's name: Jason Hillinger
	 * Test input data: 0, null,null, 2,3,1
	 * Test type: functional & interface, blackbox
	 * Test case description: Tests null inserts using enqueue for the AQueue()
	 * class to verify proper size of queue with proper indexing of queue.
	 * Expected output: 0, "< null null >", true
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAE5() {
		// AET3
		testCurrentPositionInsert();
		// AET7
		enqueueAnAQueueWithNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	/*
	 * Test case ECCAE6
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 0, null,null,null 2,3,1
	 * Test type: functional & interface, blackbox
	 * Test case description: Tests null inserts for String & Integer type using
	 * enqueue for the AQueue() class to verify proper size of queue with proper
	 * indexing of queue.
	 * Expected output: 0, "< null null null >", true
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAE6() {
		// AET3
		testCurrentPositionInsert();
		// AET6
		enqueueAnAQueueNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	/*
	 * Test case ECCAD1
	 * Tester's name: Jason Hillinger
	 * Test input data: null, none
	 * Test type: functional, blackbox
	 * Test case description: Test for proper behaviour of dequeuing a null element
	 * or dequeing when there is nothing to dequeue.
	 * Expected output: null, "Queue is empty"
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAD1() {
		// ADT1
		dequeueANullElementAQueue();
		// ADT3
		dequeueFromEmptyAQueue();
	}

	/*
	 * Test case ECCAD2
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 22, 1,2
	 * Test type: functional, blackbox
	 * Test case description: Test for proper behaviour of dequeuing a non null
	 * element or dequeing when there is an element to dequeue.
	 * Expected output: 22, 1
	 * Bug Report: N\A
	 */
	@Test
	public void ECCAD2() {
		// ADT2
		dequeueANonNullElementAQueue();
		// ADT4
		dequeueANonEmptyAQueue();
	}

	/*
	 * Test case ECCLE1
	 * Tester's name: Jason Hillinger
	 * Test input data: null,2, 22
	 * Test type: interface, blackbox
	 * Test case description: Checks for null inputs and position of element in
	 * queue for an LQueue()
	 * Expected output: null, 22
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLE1() {
		// LET1
		testForNullInputLEnqueue();
		// LET3
		LEnqueueNotAtRearOfQueue();
	}

	/*
	 * Test case ECCLE2
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 22, 22
	 * Test type: interface, blackbox
	 * Test case description: Test for proper behaviour enqueueing an element to an
	 * queue with size 0. Checks if element is in proper position.
	 * Expected output: 22, 0,22
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLE2() {
		// LET3
		LEnqueueNotAtRearOfQueue();
		// LET5
		LEnqueueAnLQueueWithSize0();
	}

	/*
	 * Test case ECCLE3
	 * Tester's name: Jason Hillinger
	 * Test input data: null,2, 1,1
	 * Test type: interface, blackbox
	 * Test case description: Test for proper behaviour of enqueuing a null and non
	 * null element to LQueue()
	 * Expected output: null, "< 1 1 >"
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLE3() {
		// LET1
		testForNullInputLEnqueue();
		// LET7
		LEnqueueQueueisNotNull();
	}

	/*
	 * Test case ECCLE4
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 22, 1,2
	 * Test type: interface, blackbox
	 * Test case description: Test for proper behaviour of dequeuing a non null
	 * element or dequeing when there is an element to dequeue.
	 * Expected output: 22, 1
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLE4() {
		// LET4
		LEnqueueAtRearOfQueue();
		// LET6
		LEnqueueAnLQueueWithSizeGreaterThanQueue();
	}

	/*
	 * Test case ECCLE5
	 * Tester's name: Jason Hillinger
	 * Test input data: 55,2, null,null
	 * Test type: interface, blackbox
	 * Test case description: Test for proper behaviour of the actual queue when
	 * enqueing null and non null elements
	 * Expected output: 55, "< null null >"
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLE5() {
		// LET2
		testForNotNullInputLEnqueue();
		// LET8
		LEnqueueQueueisNull();
	}

	/*
	 * Test case ECCLD1
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: none, 1
	 * Test type: functional & interface, blackbox
	 * Test case description: Checks for LQueue() dequeing an element when there is
	 * no element to dequeue, while verifying the size of the queue. Then enqueues
	 * element then dequeus element and verifies size of queue to be 0
	 * Expected output: "Queue is empty",0, 0
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLD1() {
		// LDT1
		LDequeueLength0();
		// LDT3
		LDequeueQueueSize0();
	}

	/*
	 * Test case ECCLD2
	 * Tester's name: Jason Hillinger
	 * Test input data: 1,2, 1,2,3
	 * Test type: functional & interface, blackbox
	 * Test case description: Verifies the length of a LQueue after dequeueing an
	 * element with different sizes of length of elements
	 * Expected output: 1, 2
	 * Bug Report: N\A
	 */
	@Test
	public void ECCLD2() {
		// LDT2
		LDequeueAnElementSize();
		// LDT4
		LDequeueSizeAsManyAsElements();
	}

	/*
	 * Test case ECCDE1
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: null,null, 1,2
	 * Test type: interface, blackbox
	 * Test case description: Verifies if DQueue enqueues null and non null elements
	 * Expected output: "< null null >", "< 1 2 >"
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDE1() {
		// DET1
		DQueueCheckNullQueue();
		// DET6
		DQueueNotNullInput();
	}

	/*
	 * Test case ECCDE2
	 * Tester's name: Jason Hillinger
	 * Test input data: 1,2, null,null
	 * Test type: interface, whitebox
	 * Test case description: Verifies proper behaviour for null and null elements
	 * are in proper position in DQueue
	 * Expected output: not "< null null >", "< null null >"
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDE2() {
		// DET2
		DQueueCheckNotNullQueue();
		// DET3
		DQueueSizeOfQueue0();
	}

	/*
	 * Test case ECCDE3
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 1,2, null
	 * Test type: interface, blackbox
	 * Test case description: Enqueues a null element and also verifies size of
	 * queue is of proper size for DQueue
	 * Expected output: 2, null
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDE3() {
		// DET4
		DQueueSizeOfQueue();
		// DET5
		DQueueNullInput();
	}

	/*
	 * Test case ECCDE4
	 * Tester's name: Jason Hillinger
	 * Test input data: 1,2, 1,99
	 * Test type: functional & interface, whitebox
	 * Test case description: Verifies position and if enqueuing a non null element
	 * behaves properly
	 * Expected output: "< 1 2 >", 1
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDE4() {
		// DET6
		DQueueNotNullInput();
		// DET7
		positionOfInputStart();
	}

	/*
	 * Test case ECCDE5
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 1,99, 1,99
	 * Test type: functional, whitebox
	 * Test case description: Verifies if an element is in the front or rear of
	 * queue for DQueue
	 * Expected output: 1, 99
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDE5() {
		// DET7
		positionOfInputStart();
		// DET8
		positionOfInputRear();
	}

	/*
	 * Test case ECCDD1
	 * Tester's name: Jason Hillinger
	 * Test input data: 1, null
	 * Test type: functional & interface, blackbox
	 * Test case description: Verifies size of queue when size is 0 after dequeing a
	 * null element.
	 * Expected output: 0, null
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDD1() {
		// DDT1
		sizeOfQueueEqual0DQueue();
		// DDT3
		dequeueANullelementDQueue();
	}

	/*
	 * Test case ECCDD2
	 * Tester's name: Shriman Vinayagamoorthy
	 * Test input data: 0,1,2,3,4,5,6,7,8, 1
	 * Test type: functional & interface, blackbox
	 * Test case description: Verifies size of queue when size is greater 0 after
	 * dequeing a non element.
	 * Expected output: 8, 1
	 * Bug Report: N\A
	 */
	@Test
	public void ECCDD2() {
		// DDT2
		sizeOfQueueGreaterThan0DQueue();
		// DDT4
		dequeueANonNullelementDQueue();
	}

	// BCC combinations
	@Test
	public void BCC_B_AE() {
		// AET1
		testForNullInputEnqueue();
		// AET4
		enqueueToTheRearOfAQueue();
		// AET6
		enqueueAnAQueueNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	@Test
	public void BCC_AE1() {
		// AET2
		testForNotNullInputEnqueue();
		// AET4
		enqueueToTheRearOfAQueue();
		// AET6
		enqueueAnAQueueNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	@Test
	public void BCC_AE2() {
		// AET1
		testForNullInputEnqueue();
		// AET3
		testCurrentPositionInsert();
		// AET6
		enqueueAnAQueueNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	@Test
	public void BCC_AE3() {
		// AET1
		testForNullInputEnqueue();
		// AET5
		enqueueAnAQueueWithSpace();
		// AET6
		enqueueAnAQueueNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	@Test
	public void BCC_AE4() {
		// AET1
		testForNullInputEnqueue();
		// AET4
		enqueueToTheRearOfAQueue();
		// AET7
		enqueueAnAQueueWithNullArray();
		// AET8
		enqueueLessElementsThanMaxSizeAQueue();
	}

	@Test
	public void BCC_AE5() {
		// AET1
		testForNullInputEnqueue();
		// AET4
		enqueueToTheRearOfAQueue();
		// AET6
		enqueueAnAQueueNullArray();
		// AET9
		enqueueEqualElementsToMaxSizeAQueue();
	}

	@Test
	public void BCC_B_AD() {
		// ADT1
		dequeueANullElementAQueue();
		// ADT3
		dequeueFromEmptyAQueue();
	}

	@Test
	public void BCC_AD1() {
		// ADT2
		dequeueANonNullElementAQueue();
		// ADT3
		dequeueFromEmptyAQueue();
	}

	@Test
	public void BCC_AD2() {
		// ADT1
		dequeueANullElementAQueue();
		// ADT4
		dequeueANonEmptyAQueue();
	}

	@Test
	public void BCC_B_LE() {
		// LET1
		testForNullInputLEnqueue();
		// LET3
		LEnqueueNotAtRearOfQueue();
		// LET5
		LEnqueueAnLQueueWithSize0();
		// LET7
		LEnqueueQueueisNotNull();
	}

	@Test
	public void BCC_LE1() {
		// LET2
		testForNotNullInputLEnqueue();
		// LET3
		LEnqueueNotAtRearOfQueue();
		// LET5
		LEnqueueAnLQueueWithSize0();
		// LET7
		LEnqueueQueueisNotNull();
	}

	@Test
	public void BCC_LE2() {
		// LET1
		testForNullInputLEnqueue();
		// LET4
		LEnqueueAtRearOfQueue();
		// LET5
		LEnqueueAnLQueueWithSize0();
		// LET7
		LEnqueueQueueisNotNull();
	}

	@Test
	public void BCC_LE3() {
		// LET1
		testForNullInputLEnqueue();
		// LET3
		LEnqueueNotAtRearOfQueue();
		// LET6
		LEnqueueAnLQueueWithSizeGreaterThanQueue();
		// LET7
		LEnqueueQueueisNotNull();
	}

	@Test
	public void BCC_LE4() {
		// LET1
		testForNullInputLEnqueue();
		// LET3
		LEnqueueNotAtRearOfQueue();
		// LET5
		LEnqueueAnLQueueWithSize0();
		// LET8
		LEnqueueQueueisNull();
	}

	@Test
	public void BCC_B_LD() {
		// LDT2
		LDequeueAnElementSize();
		// LDT4
		LDequeueSizeAsManyAsElements();
		// LDT6
	}

	@Test
	public void BCC_LD1() {
		// LDT1
		LDequeueLength0();
		// LDT4
		LDequeueSizeAsManyAsElements();
		// LDT6
	}

	@Test
	public void BCC_LD2() {
		// LDT2
		LDequeueAnElementSize();
		// LDT3
		LDequeueQueueSize0();
		// LDT6
	}

	@Test
	public void BCC_LD3() {
		// LDT2
		LDequeueAnElementSize();
		// LDT4
		LDequeueSizeAsManyAsElements();
		// LDT5
	}

	@Test
	public void BCC_B_DE() {
		// DET2
		DQueueCheckNotNullQueue();
		// DET4
		DQueueSizeOfQueue();
		// DET6
		DQueueNotNullInput();
		// DET8
		positionOfInputRear();
	}

	@Test
	public void BCC_DE1() {
		// DET1
		DQueueCheckNullQueue();
		// DET4
		DQueueSizeOfQueue();
		// DET6
		DQueueNotNullInput();
		// DET8
		positionOfInputRear();
	}

	@Test
	public void BCC_DE2() {
		// DET2
		DQueueCheckNotNullQueue();
		// DET3
		DQueueSizeOfQueue0();
		// DET6
		DQueueNotNullInput();
		// DET8
		positionOfInputRear();
	}

	@Test
	public void BCC_DE3() {
		// DET2
		DQueueCheckNotNullQueue();
		// DET4
		DQueueSizeOfQueue();
		// DET5
		DQueueNullInput();
		// DET8
		positionOfInputRear();
	}

	@Test
	public void BCC_DE4() {
		// DET2
		DQueueCheckNotNullQueue();
		// DET4
		DQueueSizeOfQueue();
		// DET6
		DQueueNotNullInput();
		// DET7
		positionOfInputStart();
	}

	@Test
	public void BCC_B_DD() {
		// DDT2
		sizeOfQueueGreaterThan0DQueue();
		// DDT3
		dequeueANullelementDQueue();
	}

	@Test
	public void BCC_DD1() {
		// DDT1
		sizeOfQueueEqual0DQueue();
		// DDT3
		dequeueANullelementDQueue();
	}

	@Test
	public void BCC_DD2() {
		// DDT2
		sizeOfQueueGreaterThan0DQueue();
		// DDT4
		dequeueANonNullelementDQueue();
	}
	// Aqueue starts here

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
	public void enqueueAnAQueueNullArray() {
		Q3 = new AQueue<String>();
		Q3.enqueue(null);
		Q3.enqueue(null);
		Q3.enqueue(null);
		assertEquals("< null null null >", Q3.toString());
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
	public void enqueueLessElementsThanMaxSizeAQueue() {
		int maxSize = 5;
		Q1 = new AQueue<Integer>(maxSize);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.enqueue(1);
		assertTrue(Q1.length() < maxSize);
	}

	// Test AET9
	@Test
	public void enqueueEqualElementsToMaxSizeAQueue() {
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
	public void dequeueANonEmptyAQueue() {
		Q1 = new AQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertEquals(1, Q1.dequeue());
	}

	/// Lqueue class starts here

	// Test LET1
	@Test
	public void testForNullInputLEnqueue() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(null);
		Q1.enqueue(2);
		assertEquals(null, Q1.frontValue());
	}

	// Test LET2
	@Test
	public void testForNotNullInputLEnqueue() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(55);
		Q1.enqueue(2);
		assertEquals(55, Q1.frontValue());
	}

	// Test LET3
	@Test
	public void LEnqueueNotAtRearOfQueue() {
		Q1 = new LQueue<Integer>();
		// Enqueuing front element to queue
		Q1.enqueue(22);
		assertEquals(22, Q1.frontValue());
	}

	// Test LET4
	@Test
	public void LEnqueueAtRearOfQueue() {
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
	public void LEnqueueAnLQueueWithSize0() {
		Q1 = new LQueue<Integer>();
		assertEquals(0, Q1.length());
		// Enqueuing front element to queue
		Q1.enqueue(22);
		assertEquals(22, Q1.frontValue());
	}

	// Test LET6
	@Test
	public void LEnqueueAnLQueueWithSizeGreaterThanQueue() {
		Q1 = new LQueue<Integer>();

		for (int i = 0; i < 10; i++) {
			Q1.enqueue(1);
		}

		Q1.enqueue(2);

		assertEquals("< 1 1 1 1 1 1 1 1 1 1 2 >", Q1.toString());
	}

	// Test LET7
	@Test
	public void LEnqueueQueueisNotNull() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(1);
		assertNotEquals("< null null >", Q1.toString());
	}

	// Test LET8
	@Test
	public void LEnqueueQueueisNull() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(null);
		Q1.enqueue(null);
		assertEquals("< null null >", Q1.toString());
	}

	// Test LDT1
	@Test
	public void LDequeueLength0() {
		Q1 = new LQueue<Integer>();
		AssertionError exception = Assertions.assertThrows(AssertionError.class, () -> Q1.dequeue());
		assertEquals("Queue is empty", exception.getMessage());
		assertEquals(0, Q1.length());
	}

	// Test LDT2
	@Test
	public void LDequeueAnElementSize() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.dequeue();
		assertEquals(1, Q1.length());
	}

	// Test LDT3
	@Test
	public void LDequeueQueueSize0() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.dequeue();
		assertEquals(0, Q1.length());
	}

	// Test LDT4
	@Test
	public void LDequeueSizeAsManyAsElements() {
		Q1 = new LQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.dequeue();
		assertEquals(2, Q1.length());
	}

	// Dqueue starts here

	// Test DET1
	@Test
	public void DQueueCheckNullQueue() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(null);
		Q1.enqueue(null);
		assertEquals("< null null >", Q1.toString());
	}

	// Test DET2
	@Test
	public void DQueueCheckNotNullQueue() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertNotEquals("< null null >", Q1.toString());
	}

	// Test DET3
	@Test
	public void DQueueSizeOfQueue0() {
		Q1 = new DQueue<Integer>();
		// Q1.enqueue(1);
		assertEquals(0, Q1.length());
	}

	// Test DET4
	@Test
	public void DQueueSizeOfQueue() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertEquals(2, Q1.length());
	}

	// Test DET5
	@Test
	public void DQueueNullInput() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(null);
		assertEquals(null, Q1.frontValue());
	}

	// Test DET6
	@Test
	public void DQueueNotNullInput() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(2);
		assertEquals("< 1 2 >", Q1.toString());
	}

	// Test DET7
	@Test
	public void positionOfInputStart() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(99);
		String expected = "< 1 99 >";
		String[] exp = expected.split(" ");
		String[] act = Q1.toString().split(" ");
		assertEquals(exp[1], act[1]);
	}

	// Test DET8
	@Test
	public void positionOfInputRear() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		Q1.enqueue(99);
		String expected = "< 1 99 >";
		String[] exp = expected.split(" ");
		String[] act = Q1.toString().split(" ");
		assertEquals(exp[2], act[2]);
	}

	// Test DDT1
	@Test
	public void sizeOfQueueEqual0DQueue() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		Q1.dequeue();
		assertEquals(0, Q1.length());
	}

	// Test DDT2
	@Test
	public void sizeOfQueueGreaterThan0DQueue() {
		Q1 = new DQueue<Integer>();
		for (int i = 0; i < 9; i++) {
			Q1.enqueue(1);
		}

		Q1.dequeue();
		assertEquals(8, Q1.length());
	}

	// Test DDT3
	@Test
	public void dequeueANullelementDQueue() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(null);
		assertEquals(null, Q1.dequeue());
	}

	// Test DDT4
	@Test
	public void dequeueANonNullelementDQueue() {
		Q1 = new DQueue<Integer>();
		Q1.enqueue(1);
		assertEquals(1, Q1.dequeue());
	}

}
