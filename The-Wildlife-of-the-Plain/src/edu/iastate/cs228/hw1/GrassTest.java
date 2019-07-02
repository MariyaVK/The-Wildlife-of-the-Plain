package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  
 * @author Mariya Karasseva
 *
 */

public class GrassTest {

	@Test
	public void testWho() {
		Plain p = new Plain(1);
		Grass g = new Grass(p,0,0);
		assertEquals(g.who(),State.GRASS);
	}
	
	@Test
	public void testNext() throws FileNotFoundException {
		Plain p = new Plain("testExample.txt");
		assertEquals(p.grid[1][4].next(p).who(),State.GRASS);
	}


}
