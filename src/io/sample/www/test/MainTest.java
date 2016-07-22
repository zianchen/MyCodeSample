package io.sample.www.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import io.sample.www.solution.PunEvaluator;
import io.sample.www.solution.PunGenerator;

/**
 * This test class is used for the whole project testing
 * 
 * @author Arthur
 *
 */

public class MainTest {
	@Before
	public void setUp() throws Exception {
		
	}
	
	/*
	 * test whether we can generate puns for one target string
	 */
	@Test(timeout = 1000)
	public void test1(){
		String fileName = "DICTIONARY";
		String target = "DOG";
		int maxPuns = 1000;
		PunEvaluator pg = new PunEvaluator(target,maxPuns);
		
		pg.parseQueue(PunGenerator.parseWords(target,fileName));
		
		assertNotNull(pg.getResult());
		assertNotEquals(pg.getResult().size(),0);
		
		for(String pun : pg.getResult()){
			assertTrue(pun.contains(target));
		}
		
		
		//uncomment the annotation below to show the result;

//		print(pg.getResult(), target);
		
	}
	
	/*
	 * test whether we can generate puns for several target strings
	 */
	@Test
	public void test2(){
		String fileName = "DICTIONARY";
		List<String> list = readList(fileName);
		int maxPuns = 10;
		
		for(String target : list){
			target = target.toUpperCase();
			PunEvaluator pg = new PunEvaluator(target,maxPuns);
			
			pg.parseQueue(PunGenerator.parseWords(target,fileName));
			
			assertNotNull(pg.getResult());
			
			for(String pun : pg.getResult()){
				assertTrue(pun.contains(target));
			}
			
			//uncomment the annotation below to show the result;
			
			//print(pg.getResult(), target);
		}
	}
	
	/**
	 * read all words with length smaller than 4 to a list;
	 * @param fileName: dictionary
	 * @return a list of expected words
	 */
	private List<String> readList(String fileName) {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String word = null;
			while((word = reader.readLine()) != null) {
				if(word.length() > 4) continue;
				list.add(word);
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * print the result
	 */
	private void print(List<String> list, String target) {
		System.out.print(target.toUpperCase()+": ");
		for(String pun:list)
			System.out.print(pun+" ");
		System.out.println();
	}
}
