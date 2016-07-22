package io.sample.www.test;

import static org.junit.Assert.*;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import io.sample.www.solution.PunGenerator;


/**
 * This test class is used for PunGenerator testing
 * 
 * @author Arthur
 *
 */
public class PunGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Test parseWords() method, check
	 * if candidate queue is null;
	 * 
	 */
	@Test(timeout = 1000)
	public void testparseWords() {
		Queue<String> queue = PunGenerator.parseWords("PUN", "DICTIONARY");
		assertNotNull(queue);
		
		//uncomment the annotation to show the result;
		/*
		System.out.println("queue size is: "+queue.size());
		System.out.print("potential pun candidates: ");
		while(!queue.isEmpty()){
			String candidates = queue.poll();
			System.out.println(candidates);
		}
  		*/

	}

}
