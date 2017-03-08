package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 * Insertion sort
 * 
 * Sample Input
 * 6
 * 1 4 3 5 6 2
 * 
 * Sample Output
 * 1 4 3 5 6 2 
 * 1 3 4 5 6 2 
 * 1 3 4 5 6 2 
 * 1 3 4 5 6 2 
 * 1 2 3 4 5 6 
 *
 */
public class InsertionSort{

	public static void insertionSortPart2(int[] ar) {
		int aux = 0;
		for(int i = 1; i < ar.length; i++){
			int j = i;
			while(j > 0 && ar[j] < ar[j-1]){
				aux = ar[j];
				ar[j] = ar[j-1];
				ar[j-1] = aux;
				j--;
			}
			printArray(ar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
