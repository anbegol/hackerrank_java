package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * 
 * Find digits that are divisible by N
 * 
 * Sample Input 
 * 1 
 * 1012
 * 
 * Sample Output 
 * 3
 *
 * Explanation The number 1012 is broken into four digits 1, 0, 1 and 2. is evenly
 * divisible by its digits 1, 1 and 2, but it is not divisible by 0 as division by
 * zero is undefined; thus, our count of evenly divisible digits is 3.
 *
 */
public class FindDigits {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i = 0; i < t; i++){
			int count = 0;
			int n = s.nextInt();
			Integer nAux = new Integer(n);
			while(nAux != 0){
				// We get only the last number
				// i.e. if the number is 1245 the last number is 5
				int lastNumber = nAux%10;
				if(lastNumber!= 0 && n%lastNumber == 0){
					count++;
				}
				// With this we can get the number less the last number
				// i.e. if the number was 1245 we can get 124
				nAux /= 10;
			}
			System.out.println(count);
		}
	}
}
