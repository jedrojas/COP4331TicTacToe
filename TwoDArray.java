package tictactoe;

import java.util.Arrays;
import java.util.*;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	private int[][]a;
	int defaultVal;
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		a = new int[rows][cols];
		this.defaultVal = defaultVal;
		initArray(defaultVal);
	}
		
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		for (int r=0; r<a.length; r++) {
			for (int c=0; c< a[0].length; c++) {
				a[r][c] = defaultVal;
			}
		}
		
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		if (a[row][col] == defaultVal) {
			a[row][col] = val;
			return "Success! (val) was inserted.";
		} else if (a[row][col] != defaultVal) {
			return "Failure: (row), (col) is not empty.";
		} else if (val == defaultVal) {
			return "Failure: (val) is not allowed.";
		}
		return "insertInt String";
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		return a[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		for (int r=0; r<a.length; r++) {
			for (int c=0; c<a[0].length; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
		return "implemented";
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		System.out.println("# rows: " + a.length);
		System.out.println("# columns: " + a[0].length);
		System.out.println("How many unique values: " + numUniqueVals());
		System.out.println("Value and count of each:");
		getOccurrences();
		return "implemented";
	}		
	
	public int numUniqueVals() {
		Set<Integer> hash_set = new HashSet<Integer>(); 
		for (int r=0; r<a.length; r++) {
			for (int c=0; c<a[0].length; c++) {
				hash_set.add(a[r][c]);
			}
		}
		return hash_set.size();
	}
	
	public void getOccurrences() {
		HashMap<Integer,Integer> hash_map = new HashMap<Integer,Integer>(); 
		for (int r=0; r<a.length; r++) {
			for (int c=0; c<a[0].length; c++) {
				if (hash_map.containsKey(a[r][c])) {
					hash_map.put(a[r][c], hash_map.get(a[r][c]) + 1);
				} else {
					hash_map.put(a[r][c], 1);
				}
			}
		}
		// print
		for (Map.Entry entry: hash_map.entrySet()) {
			System.out.println("\tvalue:" + entry.getKey() + " count:" + entry.getValue());
		}
	}

}