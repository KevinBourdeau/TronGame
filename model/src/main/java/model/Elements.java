package model;
/**
* <h1>Element Class</h1>
* 
* @author kevinbourdeau
* @version 1.0
*
*/
import java.awt.Color;
import java.util.Observable;

public class Elements extends Observable implements IElements {
	
	/**
	 * Constructor of the element class
	 * 
	 * @param x the x
	 * @param y the y 
	 * @param color the color
	 */
	
	public Elements(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	protected int x;
	protected int y;
	protected Color color;
	
	/**
	 * @see model.IElements#getX()
	 */
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	/**
	 * Set the x of the element
	 * 
	 * @param x
	 * 			set the x
	 */
	
	public void setX(int x)
	{
		 this.x = x;
	}

	
	/**
	 * @see model.IElements#getY()
	 */
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	/**
	 * Set the y of the element
	 * @param y
	 * 			set the y
	 */
	
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * @see model.IElements#getColor()
	 */
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	
	/**
	 * Set the color of the element
	 * 
	 * @param color
	 * 				set the color
	 */
	
	public void setColor( Color color)
	{
		this.color = color;
	}

}
