package io.sample.www.solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is used for generating a queue which stores potential puns 
 * 
 * Potential puns in this queue will be evaluated in PunEvaluator class
 * 
 * @author Arthur
 *
 */

public class PunGenerator {
	
	/**
	 * this method read from local dictionary file and put potential puns in a queue;
	 * @param fileName: dictionary name
	 * @param target: target string
	 * @return a queue of potential puns
	 */
	
	public static Queue<String> parseWords(String target, String fileName){
		Queue<String> potential = new LinkedList<String>();
		if(target == null || target.length() == 0) return potential;
		String first = target.substring(0,1).toLowerCase();
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String word = null;
			while((word = reader.readLine()) != null) {
				//ignore words if its length is smaller than target's;
				if(word.length() <= target.length()) continue;
				//ignore words if it does not have the first character of target;
				if(!word.contains(first)) continue;
				potential.offer(word);
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return potential;		
	}
}
