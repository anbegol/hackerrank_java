package hackerrank.algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Calculate the missingNumbers
 * 
 * Sample Input 
 * 10 
 * 203 204 205 206 207 208 203 204 205 206 
 * 13 
 * 203 204 204 205 206 207 205 208 203 206 205 206 204
 * 
 * Sample Output 
 * 204 205 206
 * 
 * Explanation 
 * 204 is present in both arrays. Its frequency in A is 2 , while
 * its frequency in B is 3 . Similarly, 205 and 206 occur twice in A, but thrice
 * in B. So, these three numbers are our output. The rest of the numbers have
 * the same frequency in both lists.
 *
 */
public class missingNumbers {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		Map<Integer, Values> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		int item = 0;
		
		// Array A
		int aLength = s.nextInt();
		for(int i = 0; i < aLength; i++){
			 item = s.nextInt();
			 Values value = map.get(item);
			 if(value == null) {
				 value = new Values();
			 } 
			 value.addCountA();
			 map.put(item, value);
		}
		
		// Array B
		int bLength = s.nextInt();
		for(int i = 0; i < bLength; i++){
			 item = s.nextInt();
			 Values value = map.get(item);
			 if(value == null) {
				 value = new Values();
			 } 
			 value.addCountB();
			 map.put(item, value);
		}
		
		// Check the numbers
		for (Entry<Integer, Values> itemMap : map.entrySet()) {
			Values value = itemMap.getValue();
			if(value.getCountA() != value.getCountB()){
				list.add(itemMap.getKey());
			}
		}
		
		// Sort and show the result
		Collections.sort(list);
		
		String result = "";
		for (Integer integer : list) {
			result += integer + " ";
		}
		
		System.out.println(result.trim());
	}
	
	/**
	 * Class to save the value into the map
	 *
	 */
	static class Values {
		
		/** Count to array A */
		private int countA;
		/** Count to array B */
		private int countB;
		
		/**
		 * Increment A
		 */
		public void addCountA(){
			countA++;
		}
		
		/**
		 * Increment B
		 */
		public void addCountB(){
			countB++;
		}

		public int getCountA() {
			return countA;
		}

		public int getCountB() {
			return countB;
		}
	}
}
