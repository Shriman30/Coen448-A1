package org.example.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class QueueJUnitTest {
	
	private ADTQueue<Integer> Q1;
	private ADTQueue<Integer> Q2;
	
	

	@BeforeEach
	void setUp() throws Exception {
		
		Q1 = new DQueue<Integer>();
		Q2 = new DQueue<Integer>();
		
		
	}

	@Test
	public void testEmptyAQueue(){
		// Checks the return value of an empty Aqueue
		ADTQueue<Integer> AQ = new AQueue<Integer>();
		assertEquals(AQ.length(),0);
	}

	@Test
	public void testAQueueWithMaxSizeOfElements(){
		// Test makes a new Aqueue from size 0 all the way to size 10 and checks its size every time.
		// The domain we want to test is between 0 and 10 for Aqueue
		int k = 10; // This is the max size an Aqueue
		for (int j = 0; j < k + 1; j++) {
			ADTQueue<Integer> AQ = new AQueue<Integer>();
			for (int i = 0; i < j; i++) {
				AQ.enqueue(1);
			}
			assertEquals(j,AQ.length());
		}
	}

	@Test
	public void testGeneral() {
		int temp;
		
		Q2.enqueue(10);
		Q2.enqueue(20);
		Q2.enqueue(15);
		assertEquals("< 10 20 15 >", Q2.toString());
		
		while(Q2.length() > 0) {
		  temp = Q2.dequeue();
		  Q1.enqueue(temp);
		}
		assertEquals("< >", Q2.toString());
		assertEquals("< 10 20 15 >", Q1.toString());

	}
	
	

		
}
