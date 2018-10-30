package model;
/**
* <h1>LightcycleTest Class</h1>
* 
* @author kevinbourdeau
* @version 1.0
*
*/

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class LightcycleTest {
	
	private Lightcycle lighcyclePlayer;
	private Grid gridTest;

	/**
	 * Set the test before
	 * 
	 * @throws Exception indicate a specific error
	 */
	@Before
	public void setUp() throws Exception 
	{
		gridTest = new Grid();
		lighcyclePlayer = new Lightcycle(10, 12, Color.red,Direction.EST,gridTest);
	}

	/**
	 * Test turn right
	 */
	@Test
	public void testturnRight() 
	{
		Direction expected = Direction.SUD;
		lighcyclePlayer.turnRight();
		assertEquals(expected,lighcyclePlayer.getDirection());
	}
	
	/**
	 * Test turn left
	 */
	@Test
	public void testturnLeft() 
	{
		lighcyclePlayer.setDirection(Direction.EST);;
		Direction expected = Direction.NORD;
		lighcyclePlayer.turnLeft();
		assertEquals(expected,lighcyclePlayer.getDirection());
	}
	
	/**
	 * Test for the setting color
	 */
	@Test
	public void testsetColor() 
	{
		//Check if x has been incremented
			int expected = 11;
			lighcyclePlayer.setDirection(Direction.EST);
			lighcyclePlayer.move();
			assertEquals(expected,lighcyclePlayer.getX());
		
		//Check that the numbers of particles has been increased too
			expected = 1;
			assertEquals(expected,lighcyclePlayer.getParticles().size());
		
	}
	
	

}
