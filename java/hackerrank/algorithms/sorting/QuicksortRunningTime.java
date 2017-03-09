package hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Swap vs. shifts
 * 
 * {@link InsertionSort} 
 * {@link QuickSortInPlace}
 *
 */
public class QuicksortRunningTime {
	
	static int swap = 0;
	static int shifts = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		
		// First insertionSort
		insertionSort(Arrays.copyOf(ar, n));
		
		// Second quickSort
		sorting(Arrays.copyOf(ar, n), 0, n-1);

		System.out.println(shifts-swap);
	}

	/**
	 * InsertionSort
	 */
	public static void insertionSort(int[] ar) {
		int aux = 0;
		for (int i = 1; i < ar.length; i++) {
			int j = i;
			while (j > 0 && ar[j] < ar[j - 1]) {
				aux = ar[j];
				ar[j] = ar[j - 1];
				ar[j - 1] = aux;
				j--;
				shifts++;
			}
		}
	}
	

	/**
	 * QuickSort.Lomuto Partition.
	 */
	private static void sorting(int[] arr, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int index = partition(arr, leftIndex, rightIndex);
			sorting(arr, leftIndex, index-1);
			sorting(arr, index+1, rightIndex);
		}
	}

	private static int partition(int[] arr, int leftIndex, int rightIndex) {
		int pivot = arr[rightIndex];
		int i = leftIndex - 1;
		for(int j = leftIndex; j < rightIndex; j++){
			if(arr[j] <= pivot){
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, rightIndex);
		
		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {
		int aux = arr[j];
		arr[j] = arr[i];
		arr[i] = aux;
		swap++;
	}

}
