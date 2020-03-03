package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Pairs
 * 
 * Given N integers, count the number of pairs of integers whose difference is K.
 * 
 * Sample Input
 * 5 2  
 * 1 5 3 4 2  
 * 
 * Sample Output
 * 3
 * 
 * https://www.hackerrank.com/challenges/pairs/topics/two-pointer-technique
 * 
 */
public class Pairs {

    public static void main(String[] args) {
    	
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int k = s.nextInt();
    	
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++){
    		arr[i] = s.nextInt();
    	}
    	
    	// Sort array
    	Arrays.sort(arr);
    	
    	int count = 0;
    	// Give the number of pairs of integers whose difference is k
    	for(int i = 0; i < n-1; i++){
    		int j = i+1;
    		while(j < n-1 && (arr[j] - arr[i]) != k){
    			j++;
    		}
    		if(arr[j] - arr[i] == k){
    			count++;
    		}
    	}
    	
    	// Show the result
    	System.out.println(count);
    }

}
