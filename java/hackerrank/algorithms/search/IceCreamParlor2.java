package hackerrank.algorithms.search;

import java.util.Arrays;
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
 *
 * Binary search solution. Calculate the cj = ci-m and find cj by binary search into the array.
 */
public class IceCreamParlor2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int test = 0; test < t; test++) {

			// Read the input values
			int m = s.nextInt();
			int n = s.nextInt();
			IceCream arr[] = new IceCream[n];
			for (int i = 0; i < n; i++) {
				int cost = s.nextInt();
				arr[i] = new IceCream(cost, i+1);
			}
			
			// Sort the array
			Arrays.sort(arr);

			// Calculate the ice creams
			for(int i = 0; i < arr.length; i++){
				// Get the element to search
				int cJ = m - arr[i].getC();
				int binarySearch = Arrays.binarySearch(arr, new IceCream(cJ, null));
				if(binarySearch > -1){
					IceCream iceBinary = arr[binarySearch];
					if(iceBinary.equals(arr[i])){
						if(binarySearch-1 >=0 && arr[binarySearch-1].c.equals(cJ)){
							binarySearch = binarySearch-1;
						} else if(binarySearch+1 < arr.length && arr[binarySearch+1].c.equals(cJ)){
							binarySearch = binarySearch+1;
						}
					}
					
					if(arr[binarySearch].getId() > arr[i].getId()) {
						System.out.println(arr[i].getId() + " " + arr[binarySearch].getId());
					} else {
						System.out.println(arr[binarySearch].getId() + " " + arr[i].getId());
					}
					break;
				}
			}
		}
	}
	
	static class IceCream implements Comparable<IceCream> {

		/** Ice cream's cost */
		Integer c;
		/** Unique ID number */
		Integer id;
		
		/**
		 * Constructor
		 */
		public IceCream(Integer c, Integer id) {
			super();
			this.c = c;
			this.id = id;
		}

		public Integer getC() {
			return c;
		}

		public Integer getId() {
			return id;
		}

		@Override
		public int compareTo(IceCream iceCream) {
			return this.c.compareTo(iceCream.c);
		}
		
		@Override
		public boolean equals(Object obj) {
			IceCream iceCream = (IceCream)obj;
			if(iceCream.c.equals(c) && iceCream.id.equals(id)){
				return true;
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			return "IceCream [c=" + c + "]";
		}
	}
}
