
/**
 * CSC 331 Programming Assignment 2
 * Method 1
 *
 * @author Scott Spurlock
 * @version 9/9/19
 * 
 * @author Scott Marsden
 * @version 10/6/19
 */
public class Method1 {

	/**
	 * This method finds the k largest elements in an integer array
	 * by looping through the array k times, each time picking the largest.
	 * 
	 * @param arr: input array to be searched
	 * @param k: how many elements to select
	 * @return an array of size k holding the largest k elements of A
	 */
	public int[] findTopK(int[] arr, int k) {
		int[] results = new int[k];
		int currIndex = 0;
		while(k != currIndex) {
			
			int largestIndex = 0;
			for(int i = 1; i < arr.length; i++) {
				if (arr[i] > arr[largestIndex]) {
					largestIndex = i;
				}
			}
			results[currIndex] = arr[largestIndex];
			arr[largestIndex] = 0;
			currIndex++;
		}
		
		return results;
	}


} // Method1
