package edu.iastate.cs228.hw1;

/**
 *  
 * @author Mariya Karasseva
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 */
	public Empty (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{	// 
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
		Living l;
		int[] population = new int[NUM_LIFE_FORMS];
		this.census(population);
		if (population[RABBIT]>1) l = new Rabbit(pNew, row, column, 0);
		else if (population[FOX]>1) l = new Fox(pNew, row, column, 0);
		else if (population[BADGER]>1) l = new Badger(pNew, row, column, 0);
		else if (population[GRASS]>1) l = new Grass(pNew, row, column);
		else l = new Empty(pNew, row, column);
		
		return l; 
	}
}
