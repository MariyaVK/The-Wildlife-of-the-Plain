package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  
 * @author Mariya Karasseva
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with squares
 * inhabited by badgers, foxes, rabbits, grass, or none.
 *
 */
public class Wildlife {
	/**
	 * Update the new plain from the old plain in one cycle.
	 * 
	 * @param pOld
	 *            old plain
	 * @param pNew
	 *            new plain
	 */
	public static void updatePlain(Plain pOld, Plain pNew) {
		//
		// For every life form (i.e., a Living object) in the grid pOld,
		// generate
		// a Living object in the grid pNew at the corresponding location such
		// that
		// the former life form changes into the latter life form.
		//
		// Employ the method next() of the Living class.

		for (int i = 0; i < pOld.getWidth(); i++)
			for (int j = 0; j < pOld.getWidth(); j++)
				pNew.grid[i][j] = pOld.grid[i][j].next(pNew);
	}

	/**
	 * Repeatedly generates plains either randomly or from reading files. Over
	 * each plain, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String key = "1"; // Variable to read user input for a menu choice
		int trial = 1; // Variable to count number of trials
		Scanner sc = new Scanner(System.in);
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain)  2 (file input)  3 (exit)");
		System.out.print("\nTrial " + trial + ": ");
		key = sc.next();

		while (key.equals("1") || key.equals("2")) { // Exit if the user input
														// is not 1 or 2
			Plain even = null;
			Plain odd = null;
			trial++; // A new trial has started
			int cycle = 0; // Stores number of cycles
			int width = 0;
			String fileName = "";

			if (key.equals("1")) {
				// Prompt input from the user. Repeat until correct input.
				System.out.println("Random plain");
				do {
					System.out.print("Enter grid width: ");
					width = sc.nextInt();
				} while (width <= 0);

				// Create a plain with a given width
				even = new Plain(width);
				odd = new Plain(width);
				even.randomInit();

			} else {
				System.out.println("Plain input from a file");
				System.out.print("File name: ");
				fileName = sc.next();
				// Create a plain from a given file name
				even = new Plain(fileName + ".txt");
				odd = new Plain(even.getWidth());
			}
			do {
				// Prompt user for a number of cycles
				System.out.print("Enter the number of cycles: ");
				cycle = sc.nextInt();
			} while (cycle <= 0);

			// Output to the console
			System.out.println("\nInitial plain:\n");

			System.out.println(even.toString());
			// Perform update to the plain
			for (int countCycle = 0; countCycle < cycle; countCycle++) {
				if (countCycle % 2 == 0)
					updatePlain(even, odd);
				else
					updatePlain(odd, even);
				
			/*	System.out.println("Cycle: " + countCycle);
				if (cycle % 2 == 0)
					System.out.println(even.toString());
				else
					System.out.println(odd.toString());*/
			}
			// Output final plain
			System.out.println("\nFinal plain:\n");
			if (cycle % 2 == 0)
				System.out.println(even.toString());
			else
				System.out.println(odd.toString());

			// If read from a file, output to a new file with the same name and
			// "Output_" in front
			if (key.equals("2")) {
				if (cycle % 2 == 0)
					even.write("Output_" + fileName + "-" + cycle + "s.txt");
				else
					odd.write("Output_" + fileName + "-" + cycle + "s.txt");
			}
			System.out.print("\nTrial " + trial + ": ");
			key = sc.next();
		}

		//
		// Generate wildlife simulations repeatedly like shown in the
		// sample run in the project description.
		//
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an
		// input
		// file, and 3 to end the simulation. (An input file always ends with
		// the suffix .txt.)
		//
		// 2. Print out standard messages as given in the project description.
		//
		// 3. For convenience, you may define two plains even and odd as below.
		// In an even numbered cycle (starting at zero), generate the plain
		// odd from the plain even; in an odd numbered cycle, generate even
		// from odd.

		// Plain even; // the plain after an even number of cycles
		// Plain odd; // the plain after an odd number of cycles

		// 4. Print out initial and final plains only. No intermediate plains
		// should
		// appear in the standard output. (When debugging your program, you can
		// print intermediate plains.)
		//
		// 5. You may save some randomly generated plains as your own test
		// cases.
		//
		// 6. It is not necessary to handle file input & output exceptions for
		// this
		// project. Assume data in an input file to be correctly formated.
	}
}
