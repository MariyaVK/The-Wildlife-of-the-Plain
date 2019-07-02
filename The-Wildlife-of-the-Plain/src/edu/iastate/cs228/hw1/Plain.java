package edu.iastate.cs228.hw1;

/**
 *  
 * @author Mariya Karasseva
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * The plain is represented as a square grid of size width x width.
 *
 */
public class Plain {
	private int width; // grid size: width X width

	public Living[][] grid;

	/**
	 * Default constructor reads from a file
	 */
	public Plain(String inputFileName) throws FileNotFoundException {
		// Assumption: The input file is in correct format.
		//
		// You may create the grid plain in the following steps:
		//
		// 1) Reads the first line to determine the width of the grid.
		//
		// 2) Creates a grid object.
		//
		// 3) Fills in the grid according to the input file.
		//
		// Be sure to close the input file when you are done.

		File file = new File(inputFileName);
		Scanner sc = new Scanner(file);
		String line = sc.nextLine();
		int width = calculateWidth(line);
		this.width = width;
		grid = new Living[this.width][this.width];
		int row = 0;
		int column = 0;
		Scanner scLine;

		do {// while not EOF
			scLine = new Scanner(line); // Scan through the line
			line = sc.nextLine();
			while (scLine.hasNext()) { // While there is another Living
				String living = scLine.next();
				fillSpot(living, row, column); // Add the Living to the grid
				column++;
			}
			row++;
			column = 0;

		} while (sc.hasNextLine());

		// Process the last line
		scLine = new Scanner(line);
		while (scLine.hasNext()) {
			String living = scLine.next();
			fillSpot(living, row, column);
			column++;
		}
		sc.close();
		scLine.close();

	}

	/**
	 * Constructor that builds a w x w grid without initializing it.
	 * 
	 * @param width
	 *            the grid
	 */
	public Plain(int w) {
		width = w;
		grid = new Living[width][width];
	}

	public int getWidth() {
		return width;
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		Random generator = new Random();

		for (int i = 0; i < width; i++)
			for (int j = 0; j < width; j++) {
				int index = generator.nextInt(5);
				if (index == Living.BADGER)
					grid[i][j] = new Badger(this, i, j, 0);
				else if (index == Living.FOX)
					grid[i][j] = new Fox(this, i, j, 0);
				else if (index == Living.GRASS)
					grid[i][j] = new Grass(this, i, j);
				else if (index == Living.RABBIT)
					grid[i][j] = new Fox(this, i, j, 0);
				else
					grid[i][j] = new Empty(this, i, j);

			}
	}

	/**
	 * Output the plain grid. For each square, output the first letter of the
	 * living form occupying the square. If the living form is an animal, then
	 * output the age of the animal followed by a blank space; otherwise, output
	 * two blanks.
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j].who() == State.BADGER)
					str = str + "B" + ((Animal) grid[i][j]).myAge() + " ";
				else if (grid[i][j].who() == State.FOX)
					str = str + "F" + ((Animal) grid[i][j]).myAge() + " ";
				else if (grid[i][j].who() == State.RABBIT)
					str = str + "R" + ((Animal) grid[i][j]).myAge() + " ";
				else if (grid[i][j].who() == State.GRASS)
					str = str + "G  ";
				else if (grid[i][j].who() == State.EMPTY)
					str = str + "E  ";
			}
			if (i < width - 1)
				str += System.getProperty( "line.separator" ); // Go to the next line only if more fill be added
		}
		return str;
	}

	/**
	 * Write the plain grid to an output file. Also useful for saving a randomly
	 * generated plain for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(outputFileName);
		/*for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j].who() == State.BADGER)
					writer.write("B" + ((Animal) grid[i][j]).myAge() + " ");
				else if (grid[i][j].who() == State.FOX)
					writer.write("F" + ((Animal) grid[i][j]).myAge() + " ");
				else if (grid[i][j].who() == State.RABBIT)
					writer.write("R" + ((Animal) grid[i][j]).myAge() + " ");
				else if (grid[i][j].who() == State.GRASS)
					writer.write("G  ");
				else if (grid[i][j].who() == State.EMPTY)
					writer.write("E  ");
			}
			writer.write(System.getProperty( "line.separator" ));
		}*/
		writer.write(toString());
		writer.close();

		// 1. Open the file.
		//
		// 2. Write to the file. The five life forms are represented by
		// characters
		// B, E, F, G, R. Leave one blank space in between. Examples are given
		// in
		// the project description.
		//
		// 3. Close the file.
	}

	/**
	 * The method calculates the width of the grid by dividing the length of the
	 * string by 3 (since each Living is represented in max 2 char plus a
	 * blank), takes a whole part and adds 1 for the last Living
	 * 
	 * @param str
	 *            First string of the file
	 * @return width of the grid
	 */
	private int calculateWidth(String str) {
		if (str == null || str.isEmpty())
			return 0;
		int width = (int) (str.length() / 3);
		return width;
	}

	private void fillSpot(String living, int row, int column) {
		
		String typeOfLiving = living.substring(0, 1);
		if (typeOfLiving.equals("B")) {
			int age = Integer.parseInt(living.substring(1, 2));
			grid[row][column] = new Badger(this, row, column, age);
		} else if (typeOfLiving.equals("F")) {
			int age = Integer.parseInt(living.substring(1, 2));
			grid[row][column] = new Fox(this, row, column, age);
		} else if (typeOfLiving.equals("R")) {
			int age = Integer.parseInt(living.substring(1, 2));
			grid[row][column] = new Rabbit(this, row, column, age);
		} else if (typeOfLiving.equals("G"))
			grid[row][column] = new Grass(this, row, column);
		else
			grid[row][column] = new Empty(this, row, column);
	}
}
