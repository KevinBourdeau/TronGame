package model;
/**
 * <h1> Lightcycle Interface</h1>
 * 
 * @author kevinbourdeau
 * @version 1.0
 *
 */

import java.util.ArrayList;

public interface ILightcycle extends IElements {

	/**
	 *  Move the lightcycle
	 */
	
	public void move();
	
	/**
	 * Get lightcycle's particles
	 * @return return lightcycle's particles
	 */
	
	public ArrayList<IElements> getParticles();
	
	/**
	 * Turn lightcycle left
	 */
	
	public void turnLeft();
	
	
	/**
	 * Turn lightcycle right
	 */
	
	public void turnRight();
	
	/**
	 * Check if the lightcycle isAlive
	 * @return return if the lightcycle isAlive or not
	 */
	
	public boolean isAlive();
}
