package model;
/**
 * <h1> Tron model class</h1>
 * 
 * @author user
 * @version 1.0
 */


public class Tron implements IModel {
	
	private IGrid grid;
	
	/**
	 * @see model.IModel#getGrid()
	 */
	public IGrid getGrid() {
		// TODO Auto-generated method stub
		return grid;
	}

	
	/**
	 * @see model.IModel#setGrid(IGrid)
	 */
	public void setGrid(IGrid grid) {
		// TODO Auto-generated method stub
		this.grid = grid;
	}

}
