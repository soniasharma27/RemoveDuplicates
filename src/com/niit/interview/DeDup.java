package com.niit.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DeDup {

	public static void main(String[] args) {
		int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18,
				4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
				19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

		String choice = null;
		String answer = null;
		Scanner reader = new Scanner(System.in);
		/**
		 * below code is giving choice to the user to select the particular
		 * implementation
		 */
		System.out.println("Please enter your choice 1,2,3 " 
		                    + "\n" + "1 Using Hashset" 
				            + "\n" + "2 Using LinkedHashSet"
				            + "\n" + "3 Using Array");

		// try/finally block is added so that reader should close in all cases

		try {
			choice = reader.next();
			// This will validate if user has entered the correct choice 1 , 2
			// or 3
			choice = validateChoice(choice, reader);

			// Based on the choice made by the user it will call the specific
			// implementation
			callMethod(randomIntegers, choice);

			// This will give the user option to exit from the program or make
			// another choice
			System.out.println("Do you want to continue? Y/N");

			answer = reader.next();
			//this will check if user entered Y or N
			validateAns(answer, reader);
			
			// This process will repeat until the user selects to exit the
			// system
			while (!"N".equalsIgnoreCase(answer)) {
				System.out.println("Please enter your choice 1,2,3 " + "\n" + "1 Using Hashset" + "\n"
						+ "2 Using LinkedHashSet" + "\n" + "3 Using Array");
				choice = reader.next();
				choice = validateChoice(choice, reader);
				callMethod(randomIntegers, choice);
				
				System.out.println("Do you want to continue? Y/N");
				answer = reader.next();
				answer = validateAns(answer, reader);

			}
			//once user will enter 'N' program will terminate
			System.out.println("System exiting");
			return;

		} finally {
			reader.close();
		}

	}

	/**
	 * This method will use linkedHashset to remove duplicates. Also it
	 * maintains the insertion order
	 * 
	 * @param randomIntegers
	 * @return
	 */
	public static int[] removeDupUsingLinkedHashSet(int[] randomIntegers) {
		long startTime = System.nanoTime();
		Set<Integer> targetSet = null;
		int[] uniqueIntegers = null;
		int i = 0;
		if (null != randomIntegers && randomIntegers.length > 0) {
			targetSet = new LinkedHashSet<Integer>();
			for (int numbers : randomIntegers) {
				targetSet.add(numbers);
			}
			uniqueIntegers = new int[targetSet.size()];
			Iterator<Integer> iterator = targetSet.iterator();
			while (iterator.hasNext()) {
				uniqueIntegers[i++] = iterator.next();
			}
		}
		long endTime = System.nanoTime();

		System.out.println(
				"Execution time in nano seconds for removing duplicates using LinkedHashSet " + (endTime - startTime));
		return uniqueIntegers;
	}

	/**
	 * Use this implementation if insertion order is not important after
	 * removing the duplicates.
	 * This will use the hashSet
	 * @param randomIntegers
	 * @return
	 */
	public static int[] removeDupUsingHashSet(int[] randomIntegers) {
		long startTime = System.nanoTime();
		Set<Integer> targetSet = null;
		int[] uniqueIntegers = null;
		int i = 0;
		
		if (null != randomIntegers && randomIntegers.length > 0) {
			targetSet = new HashSet<Integer>();
			for (int numbers : randomIntegers) {
				targetSet.add(numbers);
			}
			uniqueIntegers = new int[targetSet.size()];
			Iterator<Integer> iterator = targetSet.iterator();
			while (iterator.hasNext()) {
				uniqueIntegers[i++] = iterator.next();
			}
		}
		long endTime = System.nanoTime();
		System.out.println(
				"Execution time in nano seconds for removing duplicates using HashSet " + (endTime - startTime));
		return uniqueIntegers;
	}

	/**
	 * This method will remove the duplicates without using any collection. It
	 * will first sort the array and will then remove the duplicates
	 * 
	 * @param randomIntegers
	 * @return
	 */
	public static int[] removeDupUsingSortedAray(int[] randomIntegers) {
		// Sort the array to remove duplicates
		long startTime = System.nanoTime();
		int j = 0;
		int i = 1;
		int[] uniqueIntegers = null;
		
		if (null != randomIntegers && randomIntegers.length > 0) {
			Arrays.sort(randomIntegers);

			while (i < randomIntegers.length) {
				if (randomIntegers[i] == randomIntegers[j]) {
					i++;
				} else {

					randomIntegers[++j] = randomIntegers[i++];

				}
			}

			uniqueIntegers = Arrays.copyOf(randomIntegers, j + 1);
		}
		long endTime = System.nanoTime();
		System.out.println(
				"Execution time in nano seconds for removing duplicates with sorted array " + (endTime - startTime));
		return uniqueIntegers;
	}

	/**
	 * 
	 * @param randomIntegers
	 * @param type
	 */
	private static void printArray(int[] randomIntegers, String type) {
		System.out.println("Array " + type);
		for (int i : randomIntegers) {
			System.out.println(i);
		}
	}

	/**
	 * 
	 * @param choice
	 * @param reader
	 * @return
	 */
	private static String validateChoice(String choice, Scanner reader) {
		while (!"1".equals(choice) && !"2".equals(choice) && !"3".equals(choice)) {
			System.out.println("Print enter valid choice");
			choice = reader.next();
		}
		return choice;
	}

	/**
	 * 
	 * @param randomIntegers
	 * @param choice
	 */
	private static void callMethod(int[] randomIntegers, String choice) {
		int[] uniqueIntegers = null;
		// print array before removing duplicates
		printArray(randomIntegers, "Before removing duplicates");

		switch (choice) {
		case "1":
			uniqueIntegers = removeDupUsingHashSet(randomIntegers);
			// print array after removing duplicates
			printArray(uniqueIntegers, "After removing duplicates");
			break;
		case "2":
			uniqueIntegers = removeDupUsingLinkedHashSet(randomIntegers);
			// print array after removing duplicates
			printArray(uniqueIntegers, "After removing duplicates");
			break;
		case "3":
			uniqueIntegers = removeDupUsingSortedAray(randomIntegers);
			// print array after removing duplicates
			printArray(uniqueIntegers, "After removing duplicates");
			break;

		}

	}

	/**
	 * 
	 * @param answer
	 * @param reader
	 * @return
	 */
	private static String validateAns(String answer, Scanner reader) {
		while (!"Y".equalsIgnoreCase(answer) && !"N".equalsIgnoreCase(answer)) {
			System.out.println("Please enter Y/N");
			answer = reader.next();
		}
		return answer;
	}
}
