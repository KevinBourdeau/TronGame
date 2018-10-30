package model;

/**
 * <h1 Element Interface</h1>
 * @author kevinbourdeau
 * @version 1.0
 *
 */

import java.awt.Color;
import java.util.Observer;

public interface IElements {
	
	/**
	 * Get Element's X
	 * @return x
	 */

	public int getX();
	
	/**
	 * Get Element's Y
	 * @return y
	 */

	public int getY();
	
	/**
	 * Get Element's Color
	 * @return color
	 */
	
	public Color getColor();
	
	/**
	 * Add observer
	 * 
	 * @param o
	 * 		param Observer
	 */
	
	void addObserver(Observer o);
}
