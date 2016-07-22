package io.sample.www.solution;

/**
 * This class is used for storing basic pun properties.
 * 
 * @param oriWord: a original word in dictionary
 * @param punWord: a transformed pun word
 * @param distance: levenshtein distance between pun and the target word.
 * 
 * @author Arthur
 *
 */

public class Pun {
	private String oriWord;	
	private String punWord;
	private int distance;
	
	public Pun(String oriWord, String punWord, int distance) {
		this.oriWord = oriWord;
		this.punWord = punWord;
		this.distance = distance;
	}
	
	public String getOriWord() {
		return oriWord;
	}
	
	public String getPunWord() {
		return punWord;
	}
	
	public int getDistance() {
		return distance;
	}
}
