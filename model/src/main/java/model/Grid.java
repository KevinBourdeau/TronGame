package model;
/**
 * <h1>Grid class</h1>
 * 
 * @author kevinbourdeau
 *@version 1.0
 */

import java.awt.Color;

import model.dao.Database;

public class Grid implements IGrid, ITimer {

	private ILightcycle lightcycle1;
	private ILightcycle lightcycle2;

	// Define the measures
	private int width = 800;
	private int height = 600;
	private int nbCelsHeight = 60;
	private int nbCelsWidth = 80;
	private Database db = new Database();
	private ITimer timer;

	/**
	 * Constructor of grid class Set the 2 lightcycle on the grid
	 */

	public Grid() {
		this.lightcycle1 = new Lightcycle(2, 2, Color.red, Direction.EST, this);
		this.lightcycle2 = new Lightcycle(30, 30, Color.cyan, Direction.OUEST, this);
		this.timer = new timer();
		timer.start();
	}

	/**
	 * Check collision for a lightcycle Check if a lightcycle is in collision
	 * 
	 * @param lightcycle
	 *            check collision between lightcycle
	 * 
	 * @return return if there is a collision or not
	 */

	public boolean checkCollision(Lightcycle lightcycle) {
		if (lightcycle.getX() > this.nbCelsWidth || lightcycle.getX() <= 0 || lightcycle.getY() <= 0
				|| lightcycle.getY() > this.nbCelsHeight) {
			lightcycle.setAlive(false);
			return true;
		}

		for (IElements particle : lightcycle1.getParticles()) {
			if (lightcycle.getX() == particle.getX() && lightcycle.getY() == particle.getY()) {
				lightcycle.setAlive(false);
				return true;
			}

		}

		for (IElements particle : lightcycle2.getParticles()) {
			if (lightcycle.getX() == particle.getX() && lightcycle.getY() == particle.getY()) {
				lightcycle.setAlive(false);
				return true;
			}
		}

		return false;
	}

	/**
	 * @see model.IGrid#getLightcycle1()
	 */
	@Override
	public ILightcycle getLightcycle1() {
		// TODO Auto-generated method stub
		return lightcycle1;
	}

	/**
	 * Set the lightcycle 1
	 * 
	 * @param lightcycle1
	 *            set the lightcycle 1
	 */

	public void setLightcycle1(Lightcycle lightcycle1) {
		this.lightcycle1 = lightcycle1;
	}

	/**
	 * @see model.IGrid#getLightcycle2()
	 */
	@Override
	public ILightcycle getLightcycle2() {
		// TODO Auto-generated method stub
		return lightcycle2;
	}

	/**
	 * Set the lightcycle 2
	 * 
	 * @param lightcycle2
	 *            set the lightcycle 2
	 */

	public void setLightcycle2(Lightcycle lightcycle2) {
		this.lightcycle2 = lightcycle2;
	}

	/**
	 * @see model.IGrid#getWidth()
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	/**
	 * Set the width
	 * 
	 * @param width
	 *            set the width
	 */

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @see model.IGrid#getHeight()
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	/**
	 * Set the height
	 * 
	 * @param height
	 *            set the height
	 */

	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @see model.IGrid#getNbCelsHeight()
	 */
	@Override
	public int getNbCelsHeight() {
		// TODO Auto-generated method stub
		return nbCelsHeight;
	}

	/**
	 * Set the height in Cels of the grid
	 * 
	 * @param nbCelsHeight
	 *            set the height in Cels of the grid
	 */

	public void setNbCelsHeight(int nbCelsHeight) {
		this.nbCelsHeight = nbCelsHeight;
	}

	/**
	 * @see model.IGrid#getNbCelsWidth()
	 */
	@Override
	public int getNbCelsWidth() {
		// TODO Auto-generated method stub
		return nbCelsWidth;
	}

	/**
	 * Set the width in Cels of the grid
	 * 
	 * @param nbCelsWidth
	 *            set the width in Cels of the grid
	 */

	public void setNbCelsWidth(int nbCelsWidth) {
		this.nbCelsWidth = nbCelsWidth;
	}

	@Override
	public ITimer getTimer() {

		return timer;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(String name1, String name2) {

		// Timer which saves the time of players
		if (lightcycle1.isAlive()) {
			db.save(name1, (int) timer.getTime()/1000000);
		} else {
			db.save(name2, (int) timer.getTime()/1000000);
		}
	}
	
	@Override
	public String[] getPodium() {
		return db.getPodium();
	}

}
