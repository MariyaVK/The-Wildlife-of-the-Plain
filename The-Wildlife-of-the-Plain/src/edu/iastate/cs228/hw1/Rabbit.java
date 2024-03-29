package edu.iastate.cs228.hw1;

/**
 *  
 * @author Mariya Karasseva
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 

		Living l;
		int[] population = new int[NUM_LIFE_FORMS];
		this.census(population);
		if (this.myAge() >= 3) l = new Empty(pNew, row, column);
		else if (population[GRASS] <= 0) l = new Empty(pNew, row, column);
		else if (population[BADGER] + population[FOX] >= population[RABBIT] && population[BADGER] < population[FOX]) l = new Fox(pNew, row, column, 0);
		else if (population[BADGER] > population[RABBIT]) l = new Badger(pNew, row, column, 0);
		else l = new Rabbit(pNew, row, column, this.myAge()+1); 
		return l; 
	}
}
