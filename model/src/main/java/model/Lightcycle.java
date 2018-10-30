package model;
/**
 * <h1>Lightcycle class</h1>
 * 
 * @author kevinbourdeau
 *@version 1.0
 */

import java.awt.Color;
import java.util.ArrayList;

public class Lightcycle extends Elements implements ILightcycle, IElements {
	
	private Direction direction;
	public ArrayList<IElements> particles = new ArrayList<IElements>();
	boolean alive = true;
	public Grid grid;
	
	/**
	 * Constructor of the lightcycle class
	 * @param x the x
	 * @param y the y
	 * @param color the color of the lightcycle
	 * @param direction the direction
	 * @param grid the grid
	 * 
	 */

	public Lightcycle(int x, int y, Color color, Direction direction, Grid grid) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
		
		this.direction = direction;
		this.grid = grid;
	}
	
	/**
	 * @see model.ILightcycle#move()
	 */
	
	public void move()
	{
		this.particles.add(0, new Particles(this.x, this.y, this.color));
		
		switch (this.direction)
		{
		case EST: this.x=x+1;
				break;
			
		case NORD: this.y=y-1;
				break;
				
		case OUEST: this.x=x-1;
				break;
				
		case SUD: this.y=y+1;
				break;
				
		default:
				break;
				
		}
		
		grid.checkCollision(this);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * @see model.ILightcycle#isAlive()
	 */

	public boolean isAlive()
	{
		return alive;
	}
	
	/**
	 * Set the status of the lightcycle
	 * @param alive
	 * 				set the status
	 */
	
	public void setAlive(boolean alive)
	{
		this.alive =alive;
	}

	/**
	 * @see model.ILightcycle#getParticles()
	 */
	@Override
	public ArrayList<IElements> getParticles() {
		// TODO Auto-generated method stub
		return particles;
	}

	/**
	 * @see model.ILightcycle#turnRight()
	 */
	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		switch(this.direction) 
		{
			case NORD: direction = Direction.EST;
							break;
							
			case EST: direction = Direction.SUD;
							break;
							
			case SUD: direction = Direction.OUEST;
							break;
							
			case OUEST: direction = Direction.NORD;
							break;
		}
	}

	/**
	 * @see model.ILightcycle#turnLeft()
	 */
	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		switch(this.direction) 
		{
		
			case NORD: direction = Direction.OUEST;
							break;
							
			case EST: direction = Direction.NORD;
							break;
							
			case SUD: direction = Direction.EST;
							break;
							
			case OUEST: direction = Direction.SUD;
							break;
		
		}
		
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	
	
}
