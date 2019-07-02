package edu.iastate.cs228.hw1;

/**
 *  
 * @author Mariya Karasseva
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		
		Living l;
		int[] population = new int[NUM_LIFE_FORMS];
		this.census(population);
		if (population[RABBIT] >= 3*population[GRASS]) l = new Empty(pNew, row, column);
		else if (population[RABBIT]>=3) l = new Rabbit(pNew, row, column, 0);
		else l = new Grass(pNew, row, column);
		return l; 
	}
}
