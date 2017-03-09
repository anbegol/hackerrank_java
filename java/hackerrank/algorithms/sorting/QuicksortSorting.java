package hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Second. Sorting.
 * 
 * It required copying the numbers into other arrays, which takes up
 * space and time
 * 
 * {@link QuicksortPartition}
 * {@link QuicksortSorting}
 * {@link QuickSortInPlace}
 *
 */
public class QuicksortSorting {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// Read arr
		List<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i < n; i++){
			arr.add(s.nextInt());
		}
		
		sorting(arr, 0, n);
	}

	private static void printResult(List<Integer> sorting) {
		String result = "";
		for (Integer value : sorting) {
			result += value + " ";
		}
		System.out.println(result.trim());
	}

	private static List<Integer> sorting(List<Integer> arr, int leftIndex, int rightIndex) {
		List<Integer> result = new ArrayList<>();
		
		// Pivot
		int pivot = arr.get(0);
		
		int middle = rightIndex%2 == 0? rightIndex/2: (rightIndex/2)+1;
		List<Integer> left = new ArrayList<>(middle);
    	List<Integer> rigth = new ArrayList<>(middle);
    	List<Integer> equal = new ArrayList<>(middle);
    	
    	// Separate values based on p
    	for(int i = leftIndex; i < rightIndex; i++){
    		int value = arr.get(i);
    		if(value == pivot){
    			equal.add(value);
    		} else if(value < pivot){
    			left.add(value);
    		} else if(value > pivot){
    			rigth.add(value);
    		}
    	}
    	
    	// If there are more than 1 elements into the array 
    	if(left.size() > 1) {
    		result.addAll(sorting(left, 0, left.size()));
    	} else {
    		result.addAll(left);
    	}
    	
    	result.addAll(equal);
    	
    	// If there are more than 1 elements into the array
    	if(rigth.size() > 1) {
    		result.addAll(sorting(rigth, 0, rigth.size()));
    	} else {
    		result.addAll(rigth);
    	}
    	
    	printResult(result);
		return result;
	}
}
