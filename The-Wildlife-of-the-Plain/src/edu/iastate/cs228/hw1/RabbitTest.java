package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  
 * @author Mariya Karasseva
 *
 */

public class RabbitTest {

	@Test
	public void testWho() {
		Plain p = new Plain(1);
		Rabbit r = new Rabbit(p,0,0,0);
		assertEquals(r.who(),State.RABBIT);
	}
	
	@Test
	public void testAge() {
		Plain p = new Plain(1);
		Rabbit r = new Rabbit(p,0,0,1);
		assertEquals(r.myAge(),1);
	}
	
	@Test
	public void testNext() throws FileNotFoundException {
		Plain p = new Plain("testExample.txt");
		assertEquals(p.grid[1][1].next(p).who(),State.EMPTY);
	}

}
