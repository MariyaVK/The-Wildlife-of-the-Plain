package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  
 * @author Mariya Karasseva
 *
 */

public class EmptyTest {

	@Test
	public void testWho() {
		Plain p = new Plain(1);
		Empty e = new Empty(p,0,0);
		assertEquals(e.who(),State.EMPTY);
	}
	
	@Test
	public void testRow() {
		Plain p = new Plain(5);
		Empty e = new Empty(p,1,0);
		assertEquals(e.row,1);}
	
	@Test
	public void testColumn() {
		Plain p = new Plain(5);
		Empty e = new Empty(p,1,4);
		assertEquals(e.column,4);
	}
	
	@Test
	public void testNext() throws FileNotFoundException {
		
		Plain p = new Plain("testExample.txt");
		assertEquals(p.grid[0][4].next(p).who(),State.RABBIT);
	}

}
