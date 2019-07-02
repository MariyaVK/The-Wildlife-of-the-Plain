package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * 
 * @author Mariya Karasseva
 *
 */

public class FoxTest {

	@Test
	public void testWho() {
		Plain p = new Plain(1);
		Fox f = new Fox(p,0,0,0);
		assertEquals(f.who(),State.FOX);
	}
	@Test
	public void testAge() {
		Plain p = new Plain(1);
		Fox f = new Fox(p,0,0,3);
		assertEquals(f.myAge(),3);
	}
	
	@Test
	public void testRow() {
		Plain p = new Plain(5);
		Fox f = new Fox(p,2,0,3);
		assertEquals(f.row,2);
	}
	
	@Test
	public void testColumn() {
		Plain p = new Plain(5);
		Fox f = new Fox(p,2,4,3);
		assertEquals(f.column,4);
	}
	
	@Test
	public void testNext() throws FileNotFoundException {
		
		Plain p = new Plain("testExample.txt");
		assertEquals(p.grid[1][1].next(p).who(),State.EMPTY);
	}
	
}
