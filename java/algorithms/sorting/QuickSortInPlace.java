package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Third. In Place.
 * 
 * The previous version {@link QuicksortSorting} was easy to understand, but it
 * was not optimal. It required copying the numbers into other arrays, which
 * takes up space and time. To make things faster, one can create an "in-place"
 * version of Quicksort, where the numbers are all sorted within the array
 * itself.
 * 
 * Lomuto Partition
 * https://en.wikipedia.org/wiki/Quicksort#Algorithm
 * 
 * The running time of Quicksort will depend on how balanced the partitions are.
 * If you are unlucky and select the greatest or the smallest element as the
 * pivot, then each partition will separate only one element at a time, so the
 * running time will be similar to Insertion Sort
 * 
 * 
 * {@link InsertionSort} {@link QuicksortPartition} {@link QuicksortSorting} {@link QuickSortInPlace}
 * 
 * http://www.algorithmist.com/index.php/Quicksort
 */
public class QuickSortInPlace {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// Read arr
		List<Integer> arr = new ArrayList<>(n);
		for(int i = 0; i < n; i++){
			arr.add(s.nextInt());
		}
		
		sorting(arr, 0, n-1);
	}

	private static void sorting(List<Integer> arr, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int index = partition(arr, leftIndex, rightIndex);
			sorting(arr, leftIndex, index-1);
			sorting(arr, index+1, rightIndex);
		}
	}

	private static int partition(List<Integer> arr, int leftIndex, int rightIndex) {
		int pivot = arr.get(rightIndex);
		int i = leftIndex - 1;
		for(int j = leftIndex; j < rightIndex; j++){
			if(arr.get(j) <= pivot){
				// The i value only increment when the pivot is less than 
				// the value in position j into the array
				i++;
				swap(arr, i, j);
			}
		}
		// In this way, i indicates values smaller than the pivot and you can change the 
		// pivot with i+1 when the loop finish.
		swap(arr, i+1, rightIndex);
		
		printResult(arr);
		
		return i+1;
	}

	private static void swap(List<Integer> arr, int i, int j) {
		int aux = arr.get(j);
		arr.set(j, arr.get(i));
		arr.set(i, aux);
	}

	private static void printResult(List<Integer> sorting) {
		String result = "";
		for (Integer value : sorting) {
			result += value + " ";
		}
		System.out.println(result.trim());
	}
}
