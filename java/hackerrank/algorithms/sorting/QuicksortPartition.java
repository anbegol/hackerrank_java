package hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * First. Partition.
 *
 */
public class QuicksortPartition {

    public static void main(String[] args) {
		
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	
    	int middle = n%2 == 0? n/2: (n/2)+1;
    	List<Integer> left = new ArrayList<>(middle);
    	List<Integer> rigth = new ArrayList<>(middle);
    	List<Integer> equal = new ArrayList<>(middle);
    	
    	// Pivot element
    	int p = s.nextInt();
    	equal.add(p);
    	
    	// Separate values based on p
    	for(int i = 1; i < n; i++){
    		int value = s.nextInt();	
    		if(value == p){
    			equal.add(value);
    		} else if(value < p){
    			left.add(value);
    		} else if(value > p){
    			rigth.add(value);
    		}
    	}
    	
    	// Print result
    	String result = "";
    	
    	for (Integer value : left) {
			result += value + " ";
		}
    	
    	for (Integer value : equal) {
			result += value + " ";
		}
    	
    	for (Integer value : rigth) {
			result += value + " ";
		}
    	
    	System.out.println(result.trim());
	}

}
