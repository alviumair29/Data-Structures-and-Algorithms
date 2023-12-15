/**********************************************************
This Java program defines a class named ArrayLongestPlateau with a method longestPlateau that finds the longest plateau in an array of integers.
A plateau is a sequence of consecutive equal elements.
**********************************************************/

package A1;

/**
 * The purpose of this class is to find the longest plateau of an array of ints.
 * 
 * The main method runs some tests.
 * 
 * @author andy
 * 
 */

public class ArrayLongestPlateau {

	/**
	 * longestPlateau() returns the longest plateau of an array of ints.
	 * 
	 * @return an array int[3] of the form {value, start, len} representing the longest plateau of
	 *         ints[] as a length len contiguous subarray starting at index start with common
	 *         element values value.
	 * 
	 *         For example, on the input array [2, 3, 3, 3, 3, 6, 6, 1, 1, 1], it returns [6, 5, 2],
	 *         indicating the longest plateau of this array is the subarray [6, 6]; it starts at
	 *         index 5 and has length 2.
	 * 
	 * @param ints
	 *            the input array.
	 */

	public static int[] longestPlateau(int[] ints) {

		// TODO: Replace the following one line stub with your solution. Ours is in-place, takes linear time,
		// and is less than 25 lines long, not counting blank/comment lines or lines already present in this file.

		// Check if the input array is empty
		if (ints.length == 0) {
			return new int[]{0, 0, 0}; // Empty array returns a null plateau
		}

		//Declare and Initialize variables
		int currentPlateauStart = 0; //Store where the current plateau starts
		int longestPlateauStart = 0; //Store where the longest plateau starts
		int LongLength = 1; //Store the lenght of the longest plateau
		int currentLength = 1; //Store length of the current plateau

		//Use for-loop to scan through the array
		//Start from second element
		for (int x = 1; x < ints.length; x++){
			//Check if current element at x already represents a plateau
			//that is, if the current value matches the previous value
			//Or if its at the end of the array
			if (x < ints.length && ints[x] == ints[x - 1]){
				currentLength++; //Current element represents a plateau so we update the length of the plateau

				//Also, we will check to see if the current plateau is longer than the previous longer plateau
				//If it is, we update the longest length and where it starts
				//We will also meet the conditions for it to be a plateau: it must be flat, left-end is a cliff and so is the right-end
				if (currentLength > LongLength && (x == ints.length - 1 || ints[x] > ints[x + 1]) &&
				(currentPlateauStart == 0 || ints[currentPlateauStart - 1] < ints[currentPlateauStart])){
					LongLength = currentLength;
					longestPlateauStart = currentPlateauStart;
				}
			}
			else{ //IF current elements does not represent a plateau, we move on and start a new plateau at x with length 1, 
				  //While also updating the lenghts
				if (currentLength > LongLength && (currentPlateauStart == 0 || ints[currentPlateauStart - 1] < ints[currentPlateauStart]) &&
				(x == ints.length || ints[x - 1] > ints[x])){
					LongLength = currentLength;
					longestPlateauStart = currentPlateauStart;
				}
				currentPlateauStart = x;
				currentLength = 1;
			}
		}

		//Return array in form of {value, start, len}
		return new int[] {ints[longestPlateauStart], longestPlateauStart, LongLength};
	}

	/**
	 * main() runs test cases on your longestPlateau() method. Prints summary information on basic
	 * operations and halts with an error (and a stack trace) if any of the tests fail.
	 */

	public static void main(String[] args) {
		String result;

		System.out.println("Let's find longest plateaus of arrays!\n");

		int[] test1 = { 4, 1, 1, 6, 6, 6, 6, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test1) + ":");
		result = TestHelper.stringInts(longestPlateau(test1));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 3 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test2 = { 3, 3, 1, 2, 4, 2, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test2) + ":");
		result = TestHelper.stringInts(longestPlateau(test2));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 3 , 0 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test3 = { 3, 3, 1, 2, 4, 0, 1, 1, 1, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test3) + ":");
		result = TestHelper.stringInts(longestPlateau(test3));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 1 , 6 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test4 = { 3, 3, 3, 4, 1, 2, 4, 4, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test4) + ":");
		result = TestHelper.stringInts(longestPlateau(test4));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test5 = { 7, 7, 7, 7, 9, 8, 2, 5, 5, 5, 0, 1 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test5) + ":");
		result = TestHelper.stringInts(longestPlateau(test5));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 7 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test6 = { 4 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test6) + ":");
		result = TestHelper.stringInts(longestPlateau(test6));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 4 , 0 , 1 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test7 = { 4, 4, 4, 5, 5, 5, 6, 6 };
		System.out.println("longest plateau of " + TestHelper.stringInts(test7) + ":");
		result = TestHelper.stringInts(longestPlateau(test7));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 6 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		System.out.println("\nAdditional tests done by the student or TA:\n");

		// Insert your additional test cases here.
		int[] test8 = {};
		System.out.println("longest plateau of " + TestHelper.stringInts(test8) + ":");
		result = TestHelper.stringInts(longestPlateau(test8));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 0 , 0 , 0 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

		int[] test9 = { 5, 5, 5, 5, 5};
		System.out.println("longest plateau of " + TestHelper.stringInts(test9) + ":");
		result = TestHelper.stringInts(longestPlateau(test9));
		System.out.println("[ value , start , len ] = " + result + " \n");
		TestHelper.verify(result.equals("[ 5 , 0 , 5 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");
	}
}
