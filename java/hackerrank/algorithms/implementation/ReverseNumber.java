package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Calculate reverse numbers
 *
 */
public class ReverseNumber {
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int j = s.nextInt();
        int k = s.nextInt();
        
        int cont = 0;
        int auxInterval = 0;
        int lastNumber = 0;
        int reverse = 0;
        for(int interval = i; interval <= j; interval++){
        	auxInterval = interval;
        	reverse = 0;
        	// In this part, we calculate reverse number
        	while(auxInterval != 0) {
        		lastNumber = auxInterval%10;
        		reverse = (reverse * 10) + lastNumber;
        		auxInterval = auxInterval/10;
        	}
        	
            if(Math.abs(interval - reverse) % k == 0){
            	cont++;
            }
        }
        System.out.println(cont);
	}
}
