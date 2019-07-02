package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  
 * @author Mariya Karasseva
 *
 */

public class LivingTest {

	@Test
	public void testCensus() throws FileNotFoundException {
		Plain p = new Plain("testExample.txt");
		int[] arr  = new int[Living.NUM_LIFE_FORMS];
		p.grid[0][0].census(arr);
		assertEquals(arr[Living.BADGER], 1);
		assertEquals(arr[Living.FOX], 2);
		assertEquals(arr[Living.EMPTY], 1);
		assertEquals(arr[Living.GRASS], 0);
		assertEquals(arr[Living.RABBIT], 0);
	}
	
	

}
