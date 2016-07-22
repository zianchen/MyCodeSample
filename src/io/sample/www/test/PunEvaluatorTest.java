package io.sample.www.test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import io.sample.www.solution.PunEvaluator;


/**
 * This class is used for PunEvaluator testing
 * 
 * @author Arthur
 *
 */
public class PunEvaluatorTest {
	
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Test parseQueue() method, check
	 * if result list is null;
	 * if result list has the expected number of puns;
	 * 
	 */
	@Test(timeout = 1000)
	public void testParseQueue() {
		PunEvaluator cc = new PunEvaluator("PUN", 100);
		Queue<String> queue = new LinkedList<String>();
		queue.offer("punctual");
		queue.offer("shark");
		queue.offer("punk");
		cc.parseQueue(queue);

		assertNotNull(cc.getResult());
		assertNotEquals(cc.getResult().size(), 0);
		assertEquals(cc.getResult().size(), 2);
	
		//uncomment the annotation to show the result;
		/*
		for(String pun:cc.getResult()){
			System.out.println(pun+" ");
		}
  		*/

	}

}
