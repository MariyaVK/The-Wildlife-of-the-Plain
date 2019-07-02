package edu.iastate.cs228.hw1;

/**
 *  
 * @author Mariya Karasseva
 *
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal {
	/**
	 * Constructor
	 * 
	 * @param p:
	 *            plain
	 * @param r:
	 *            row position
	 * @param c:
	 *            column position
	 * @param a:
	 *            age
	 */
	public Badger(Plain p, int r, int c, int a) {
		// super();
		plain = p;
		row = r;
		column = c;
		age = a;
	}

	/**
	 * A badger occupies the square.
	 */
	public State who() {

		return State.BADGER;
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a
	 * group of foxes.
	 * 
	 * @param pNew
	 *            plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	public Living next(Plain pNew) {
		
		// See Living.java for an outline of the function.
		// See the project description for the survival rules for a badger.
		
		Living l;
		int[] population = new int[NUM_LIFE_FORMS];
		this.census(population);
		if (this.myAge() >= 4) l = new Empty(pNew, row, column);
		else if (population[FOX] >1 && population[BADGER] ==1) l = new Fox(pNew, row, column, 0);
		else if (population[BADGER] + population[FOX] > population[RABBIT]) l = new Empty(pNew, row, column);
		else l = new Badger(pNew, row, column, this.myAge()+1); 
		return l; 
	}
}
