package net.mahtabalam;

import java.util.*;

class CountingSort {

	public static void main(String[] args) {
//		int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10}; 
//		int[] arr = { 9, 31, 10, 1, 20, 17, 45, 39, 33, 3, 20, 28, 27, 17 };
		int[] arr = {10, 7, 12, 4, 9, 13}; 
		int output[] = countSort(arr);
		System.out.println("Input Array  :" + Arrays.toString(arr));
		System.out.println("Sorted Array :" + Arrays.toString(output));
	}

	public static int[] countSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;
		int count[] = new int[range];
		int output[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min] = count[arr[i] - min] + 1;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i] - min] - 1] = arr[i];
			count[arr[i] - min] = count[arr[i] - min] - 1;
		}
		
		return output;
	}

}
