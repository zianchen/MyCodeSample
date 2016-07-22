package io.sample.www.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class is used for evaluate potential puns generated from
 * PunGenerator and producing the real puns in a sorted order;
 * 
 * Result list can be retrieved by method getResult();
 * 
 * @author Arthur
 *
 */

public class PunEvaluator {
	private String target;
	private int maxPuns;
	
	private List<String> result = new ArrayList<String>();
	
	/**
	 * Construct with parameters for PunEvaluator
	 * @param target: target string
	 * @param maxPuns: maximum number of puns
	 */
	public PunEvaluator(String target, int maxPuns) {
		this.target = target;
		this.maxPuns = maxPuns;
	}
	
	
	/**
	 * This method fetch the result list;
	 * @return a list of pun result
	 */
	public List<String> getResult() {
		return result;
	}
	
	/**
	 * this method parse the potential queue, send them to PunFilter
	 * to filter the potential puns. Then a list of puns is generated;
	 * @param candidates: a queue of potential pun candidates
	 */
	public void parseQueue(Queue<String> candidates) {
		
		PunFilter pf = new PunFilter(target ,maxPuns);
		while(!candidates.isEmpty()) {
			String candidate = candidates.poll();
			int[] punInfo = pf.findPun(candidate);
			pf.storePun(candidate, punInfo);
		}
		generateList(pf);
	}
	
	
	/**
	 * this method transform priority pun queue to a pun list;
	 * @param pf: a PunFilter stores puns;
	 */
	private void generateList(PunFilter pf) {
		result = new LinkedList<String>();
		Queue<Pun> puns = pf.getPuns();
		while(!puns.isEmpty()) {
			Pun pun = puns.poll();
			result.add(0, pun.getPunWord()+"("+pun.getOriWord()+")");
		}
	}
}
