package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
/**
 *  
 * @author Mariya Karasseva
 *
 */

public class PlainTest {

	@Test
	public void testGetWidth() {
		Plain p = new Plain(1);
		assertEquals(p.getWidth(),1);
	}
	
	
	

}
