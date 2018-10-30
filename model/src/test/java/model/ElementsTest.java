package model;
/**
* <h1>ElementsTest Class</h1>
* 
* @author kevinbourdeau
* @version 1.0
*
*/

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class ElementsTest {
	
	private Elements element;

	/**
	 * Set up the test
	 * @throws Exception
	 * 				Signals that an exception has occurred
	 */
	@Before
	public void setUp() throws Exception {
		element = new Elements(10, 12, Color.red);
	}

	/**
	 * Test for getting the color
	 */
	@Test
	public void testgetColor() {
		Color expected = Color.red;
		assertEquals(expected,element.getColor());
	}
	
	/**
	 * Test for setting the color
	 */
	@Test
	public void testsetColor() {
		Color expected = Color.blue;
		element.setColor(Color.blue);
		assertEquals(expected,element.getColor());
		
	} 

}
