package model;
/**
 * <h1> Grid Interface</h1>
 * 
 * @author kevinbourdeau
 *@version 1.0
 */

public interface IGrid {

	/**
	 * get number Pixels height
	 * @return return nb Pixels height
	 */
	
	public int getNbCelsHeight();
	
	/**
	 * get number Pixels width
	 * @return return nb Pixels width
	 */
	
	public int getNbCelsWidth();
	
	/**
	 * get width
	 * @return return the width
	 */
	
	public int getWidth();
	
	/**
	 * get height
	 * @return return the height
	 */
	
	public int getHeight();
	
	/**
	 * get lightcycle 1
	 * @return return the lightcycle 1
	 */
	
	public ILightcycle getLightcycle1();
	
	/**
	 * get lightcycle 2
	 * @return return the lightcycle 2
	 */
	
	public ILightcycle getLightcycle2();
	
	public void save(String name1, String name2);

	String[] getPodium();
}
