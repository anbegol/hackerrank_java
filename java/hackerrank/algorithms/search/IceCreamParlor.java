package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 * Ice Cream Parlor
 * 
 * This problem consist in to find two values of array where the total of their sum is m. For example,
 * 
 * Sample Input
 * 2 -> Number of test
 * 4 -> m. It is the sum total
 * 5 -> Number of values of array
 * 1 4 5 3 2 -> array
 * 4-> m. It is the sum total
 * 4 -> m. It is the sum total
 * 2 2 4 3 -> array
 * 
 * Sample Output
 * 1 4
 * 1 2
 *
 *  - Run a nested loop where the first (outer) loop corresponds to the first flavor and the second (inner) 
 * loop corresponds to the second flavor.
 * - Once the first valid solution is found (i.e., ci + cj = m), break the loop and print your answer.
 *
 */
public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int test = 0; test < t; test++) {

			// Read the input values
			int m = s.nextInt();
			int n = s.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}

			// Calculate the ice creams
			boolean found = false;
			int i = 0;
			int result = 0;
			while (i < n && !found) {
				for (int j = i + 1; j < n; j++) {
					result = arr[i] + arr[j];
					if (m == result) {
						System.out.println((i + 1) + " " + (j + 1));
						found = true;
						break;
					}
				}
				i++;
			}
		}
	}
}
