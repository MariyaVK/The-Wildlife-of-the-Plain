package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 *  
 * @author Mariya Karasseva
 *
 */

public class WildlifeTest {

	@Test
	public void testMain() throws IOException {
	    System.out.println("main");
	    String[] args = {"arg1", "arg2"};
	    final InputStream original = System.in;
	    final FileInputStream fips = new FileInputStream(new File("mainInput.txt"));
	    System.setIn(fips);
	    Wildlife.main(args);
	    System.setIn(original);
	}
	
	

}
