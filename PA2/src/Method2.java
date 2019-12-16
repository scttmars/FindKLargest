import java.util.Arrays;

/**
 * CSC 331 Programming Assignment 2
 * Method 2
 *
 * @author Scott Spurlock
 * @version 9/9/19
 * 
 * @author Scott Marsden
 * @version 10/6/19
 */
public class Method2 {

	/**
	 * This method finds the k largest elements in an integer array
	 * by first sorting the array and then selecting the last K elements.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];

		Arrays.sort(arr);
		int largestNum = arr.length - 1;
		int currIndex = 0;
		while(k != currIndex) {
			results[currIndex] = arr[largestNum];
			largestNum = largestNum - 1;
			currIndex++;
		}
		
		return results;
	}
} // Method2
