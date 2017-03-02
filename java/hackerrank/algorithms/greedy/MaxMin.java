package hackerrank.algorithms.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Max Min
 * 
 * Sample Input
 * 7
 * 3
 * 10
 * 100
 * 300
 * 200
 * 1000
 * 20
 * 30
 *
 * Sample Output
 * 20
 * 
 * Explanation
 * Here k = 3; selecting the 3 integers such that k = 10 20 30
 * where 10 is min and 30 is max. The result is max - min = unfairness.
 * To do this you have to do groups of k elements and calculate the unfaierness
 * (max - min) and choose the smaller.
 */
public class MaxMin {
    
   public static void main(String[] args) throws NumberFormatException, IOException {

      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int k = in.nextInt();
      int[] list = new int[n];

      for(int i = 0; i < n; i ++)
         list[i] = in.nextInt();
      
      int unfairness = Integer.MAX_VALUE;
      
      // Sort the array
      Arrays.sort(list);
      
      // Find the unfairness
      for(int i = 0; i+(k-1) < n; i++){
    	 int diff = list[i+(k-1)] - list[i];
    	 if(diff < unfairness){
    		 unfairness = diff;
    	 }
      }
      
      // Print result
      System.out.println(unfairness);
   }

}
