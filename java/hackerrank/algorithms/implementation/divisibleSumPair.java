package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * 
 * Calculate the divisible sum pair
 * 
 * Sample Input
 * 6 3
 * 1 3 2 6 1 2
 * 
 * Sample Output
 * 5
 *
 */
public class DivisibleSumPair {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int cont = 0;
        // Calculate the pairs
        for(int i = 0; i < n; i++){
        	for(int j = i+1; j < n; j++){
        		if((a[i] + a[j])%k == 0){
        			cont++;
        		}
        	}
        }
        
        // Print result
        System.out.println(cont);
    }
}
