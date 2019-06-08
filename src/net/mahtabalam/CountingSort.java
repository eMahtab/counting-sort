package net.mahtabalam;

import java.util.*;

class CountingSort {

	public static void main(String[] args) {
		// int[] arr = { 9, 31, 10, 1, 20, 17, 45, 39, 33, 3, 20, 28, 27, 17 };
		 int[] arr = {10, 7, 12, 4, 9, 13};
		// int[] arr = { 4, 0, 0, 1, 0, 2, 4, 5, 1 };
		System.out.println("Input Array  :" + Arrays.toString(arr));
		countSort(arr);
		System.out.println("Sorted Array :" + Arrays.toString(arr));
	}

	public static void countSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt(); // Java 8 - Retrieving Maximum number
		int min = Arrays.stream(arr).min().getAsInt(); // Java 8 - Retrieving Minimum number
		int range = max - min + 1;
		int count[] = new int[range];
		int output[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) { // First Loop
			count[arr[i] - min] = count[arr[i] - min] + 1;
		}
		System.out.println("Initial Count Array :" + Arrays.toString(count));

		for (int i = 1; i < count.length; i++) { // Second Loop
			count[i] = count[i] + count[i - 1];
		}

		System.out.println("Summing the counts :" + Arrays.toString(count));

		for (int i = 0; i < arr.length; i++) { // Third Loop
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min] = count[arr[i] - min] - 1;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
	}

}
