package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import model.IModel;

/**
 * <h1>Frame class.</h1>
 *
 * @author kevinbourdeau
 * @version 1.0
 */
public class Frame extends JFrame implements KeyListener, IView {

    /**
	 * Serial version.
	 */
	private static final long serialVersionUID = 7283040297256191355L;

	/**
     * Width of the frame
     */
	private int width;
	
	/**
     * Height of the frame
     */
	
    private int height;
    
    private Display display;
    
    private IModel model;
    
    
    /**
     * Instantiate a new frame
     * 
     * @param model
     * 			the model
     */
    
    public Frame (IModel model)
    {
    	this.model = model;
    	this.width = model.getGrid().getWidth();
    	this.height = model.getGrid().getHeight();
    	
    	this.display = new Display(this.model);
    	
    	this.setTitle("Tron");
    	this.setContentPane(this.display);
	    this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.addKeyListener(this);
		this.setVisible(true);
		
		
		
    	
    	
    	
    }

    

	

	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		switch(keyEvent.getKeyCode())
		{
	case KeyEvent.VK_RIGHT: model.getGrid().getLightcycle1().turnRight();
				System.out.println("1r");
				break;
				
	case KeyEvent.VK_LEFT: model.getGrid().getLightcycle1().turnLeft();
				System.out.println("1l");
				break;
				
	case KeyEvent.VK_Q: model.getGrid().getLightcycle2().turnRight();
				System.out.println("2r");
				break;
				
	case KeyEvent.VK_D: model.getGrid().getLightcycle2().turnLeft();
				System.out.println("2l");
				break;
		default : break;
		
		}	
	}

	
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	/*
	 * Repaint the components
	 */
	
	public void repaint()
	{
		this.display.repaint();
	}
	
	/**
	 * Get the display
	 * @return the display
	 */
	
	public Display getDisplay()
	{
		return display;
	}
	
	/**
	 * Set the display.
	 * 
	 * @param Display
	 * 			the display to set
	 */
	
	public void setDisplay(Display Display) 
	{
		this.display = Display;
	}
	
	/**
	 * Get the width
	 * 
	 * @return the width
	 */
	
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Set the width
	 * 
	 * @param width
	 * 			set the width
	 * 
	 */
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * Get the height.
	 * 
	 * @return the height
	 */
	public int getHeight() 
	{
		return height;
		
	}
	
	/**
	 * Set the height.
	 * 
	 * @param height
	 * 			set the height
	 * 			
	 */
	public void setHeight(int height) 
	{
		this.height = height;
		
	}
	
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    @Override
	public void keyReleased(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		
	}

}
