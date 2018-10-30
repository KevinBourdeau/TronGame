package view;
/**
 * <h1> Display Class>/h1>
 * 
 * @author kevinbourdeau
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.IElements;
import model.IModel;

public class Display extends JPanel implements Observer {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	
	/*
	 * The Model
	 */
	
	private IModel model;
	
	JLabel scoreLabel = new JLabel("Score: 0");
	
	
	
	
	/*
	 * 
	 * The constructor of the display class 
	 * 	 
	 */
	
	public Display(IModel model)
		{
			this.setBackground(Color.BLACK);
			this.setVisible(true);
			System.out.println("Affichage");
			this.model = model;
			
			model.getGrid().getLightcycle1().addObserver(this);
			model.getGrid().getLightcycle2().addObserver(this);
		
		}
	
	
	/**
	 * Draw the grid
	 * 
	 * @param g
	 * 			graphics g
	 * 
	 * @throws IOException indicate a specific error
	 * @throws InterruptedException same 
	 * 			
	 * 
	 */
	
	public void drawGrid(Graphics g) throws IOException, InterruptedException
		{
			
			//Lightcycle 1
			g.setColor(model.getGrid().getLightcycle1().getColor());
			
			g.fillRect(
					
						model.getGrid().getLightcycle1().getX()*model.getGrid().getWidth()/model.getGrid().getNbCelsWidth(),
						model.getGrid().getLightcycle1().getY()*model.getGrid().getHeight()/model.getGrid().getNbCelsHeight(),
						model.getGrid().getWidth()/model.getGrid().getNbCelsWidth(),
						model.getGrid().getHeight()/model.getGrid().getNbCelsHeight()
	
					
					);
			
			// Same for the lightcycle 2
			g.setColor(model.getGrid().getLightcycle2().getColor());
			
			g.fillRect(
					
						model.getGrid().getLightcycle2().getX()*model.getGrid().getWidth()/model.getGrid().getNbCelsWidth(),
						model.getGrid().getLightcycle2().getY()*model.getGrid().getHeight()/model.getGrid().getNbCelsHeight(),
						model.getGrid().getWidth()/model.getGrid().getNbCelsWidth(),
						model.getGrid().getHeight()/model.getGrid().getNbCelsHeight()
	
					
					);
			
			
			//Lightcycle 1 particles
			for (IElements element : model.getGrid().getLightcycle1().getParticles())
				{
					g.setColor(model.getGrid().getLightcycle1().getColor());
					g.fillRect(element.getX()*10, element.getY()*10, 10, 10);
				}
			
			//Same for the lightcycle 2 particles
			for (IElements element : model.getGrid().getLightcycle2().getParticles())
				{
					g.setColor(model.getGrid().getLightcycle2().getColor());
					g.fillRect(element.getX()*10, element.getY()*10, 10, 10);
				}
		
		
		}
	
		
		public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				try {
					
						drawGrid(g);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}	
	
	
	
	
	
	

	@Override
	public void update(Observable o, Object arg) 
	{
		// TODO Auto-generated method stub
		this.repaint();
		
	}

}
