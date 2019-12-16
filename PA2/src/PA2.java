/**
 * CSC 331 Programming Assignment 2
 * This is the driver class that will create instances of
 * the 3 method classes to test them.
 *
 * @author Scott Spurlock
 * @version 9/9/19
 * 
 * @author Scott Marsden
 * @version 10/6/19
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PA2 {

	public static void main(String[] args) {
		Method1 method1 = new Method1();
		Method2 method2 = new Method2();
		Method3 method3 = new Method3();

		// -----------------------------------------------------
		// Functionality Tests
		// Test each method on the provided test data, which consists of
		// 100 integers (one per line). Use k = 10. Include the output from
		// each method in your readme file.
		System.out.println("Functionality Tests...");
		

		
		// A. Read test data from file into array
		File file = new File("pa2_input.txt");
		int[] testData = new int[100];
		try {
			int count = 0;
			Scanner scnr = new Scanner(file);
			while(scnr.hasNextLine()) {
				
				
				testData[count] = Integer.parseInt(scnr.nextLine());
				count = count + 1;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//for(int i = 0; i < testData.length; i++) {
		//	System.out.println(testData[i]);
		//}
		
		
		// B. Test each method with the same test data. 
		// (!! Make sure to clone the array for testing each method so the original isn't changed !!)
		int[] testDataMethod1 = new int[100];
		int[] testDataMethod2 = new int[100];
		int[] testDataMethod3 = new int[100];
		//testDataMethod1 = testData;
		//testDataMethod2 = testDataMethod1;
		//testDataMethod3 = testDataMethod2;
		for (int i = 0; i < testData.length; i++) {
			testDataMethod1[i] = testData[i];
			testDataMethod2[i] = testData[i];
			testDataMethod3[i] = testData[i];
		}
		
		int[] results1 = method1.findTopK(testDataMethod1, 10);
		int[] results2 = method2.findTopK(testDataMethod2, 10);
		int[] results3 = method3.findTopK(testDataMethod3, 10);
		
		System.out.println("Method 1: ");
		for(int i = 0; i < results1.length; i++) {
				System.out.println(results1[i]);
			}
		System.out.println("Method 2: ");
		for(int i = 0; i < results2.length; i++) {
				System.out.println(results2[i]);
			}
		System.out.println("Method 3: ");
		for(int i = 0; i < results3.length; i++) {
				System.out.println(results3[i]);
			}
		
		// -----------------------------------------------------
		// Timing Tests
		// Use a random number generator to generate 10,000 elements and run 
		// the three different algorithms to find the 500 largest elements. 
		// Take the average over 10 experiments for each algorithm and compare the results.
		System.out.println();
		System.out.println("Timing Tests...");
		
		int K = 500;

		// Run tests to time each method on random data
		int[] testData1 = new int[9000];
		int[] testData2 = new int[9000];
		int[] testData3 = new int[9000];
		
		Random rand = new Random();
		for(int i = 0; i < 9000; i++) {
			int random = rand.nextInt(10000);
			testData1[i] = random;
			testData2[i] = random;
			testData3[i] = random;
		}
		// A. For each experiment, create an array of 10,000 random integers
		// !! Make sure to clone the array for testing each method so the original isn't changed !!
		// Use System.nanoTime() to get the runtime for each method.
		// E.g., 	
					System.out.println("Time test 10:");
					//method 1
					System.out.print("Method 1: ");
					int[] output1 = new int[K];
					long start1 = System.nanoTime();
					output1 = method1.findTopK(testData1, K);
					long end1 = System.nanoTime();
					long timeResults1 = end1 - start1;
					System.out.println(timeResults1);
					
					
					//method 2
					System.out.print("Method 2: ");
					int[] output2 = new int[K];
					long start2 = System.nanoTime();
					output2 = method2.findTopK(testData2, K);
					long end2 = System.nanoTime();
					long timeResults2 = end2 - start2;
					System.out.println(timeResults2);
					
					
					//method 3
					System.out.print("Method 3: ");
					int[] output3 = new int[K];
					long start3 = System.nanoTime();
					output3 = method3.findTopK(testData3, K);
					long end3 = System.nanoTime();
					long timeResults3 = end3 - start3;
					System.out.println(timeResults3);

	} // end main
}
