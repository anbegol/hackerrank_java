package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Give the total number of pairs
 * 
 * Sample Input
 * 9
 * 10 20 20 10 10 30 50 10 20
 * 
 * Sample Output
 * 3
 */
public class SockMerchant {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       
        // Use a map to count the pairs
        Map<Integer, Integer> map = new HashMap<>(n);
        int result = 0;
        
        for(int c_i=0; c_i < n; c_i++){
            int value = in.nextInt();
            
            Integer count = map.get(value);
            if(count == null) {
            	map.put(value, 1);
            } else {
            	count++;
            	if(count.equals(2)) {
            		result++;
            		map.remove(value);
            	} else {
            		map.put(value, count);
            	}
            }
        }
        
        // Print result
        System.out.println(result);
    }
}
