package model;
/**
* <h1>GridTest Class</h1>
* 
* @author kevinbourdeau
* @version 1.0
*
*/

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class GridTest {

	private Grid grid;
	
	@Before
	public void setUp() throws Exception {
		this.grid = new Grid();
	}

	
	/**
	 * Test for check the collision
	 */
	@Test
	public void testcheckCollision() {
		// At first, there is no collision
		
				Boolean expected = false;
				assertEquals(expected,grid.checkCollision((Lightcycle) grid.getLightcycle1()));
				
				// After hundred steps there is inevitably a collision because the lightcycle is out of screen range
				expected = true;
				for (int i=0;i<100;i++) 
				{
					grid.getLightcycle1().move();
				}
				
				assertEquals(expected,grid.checkCollision((Lightcycle) grid.getLightcycle1()));;
	}

}
