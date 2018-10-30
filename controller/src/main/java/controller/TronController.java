package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.IModel;
import view.IView;

/**
 * <h1>The Class Controller.</h1>
 *
 * @author kevinbourdeau
 * @version 1.0
 */
public class TronController implements IController {

    /** The view. */
     IView  view;

    /** The model. */
     IModel model;

    /**
     * Constructor of TronController.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     */
    public TronController(IModel model , IView view) {
     
        this.view = view;
        this.model = model;
    }

	

    /**
     * Play.
     *
     * @see controller.IController#play()
     *            
     */
   
	public void play() {
		String player1 = "";
		String player2 = "";
		
		//Player names
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(player1.length() != 3) {
			System.out.println("Player 1 Name: (max 3 characters)");
			try {
				player1 = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		while(player2.length() != 3) {
			System.out.println("Player 2 Name: (max 3 characters)");
			try {
				player2 = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//While players are not dead
		while(model.getGrid().getLightcycle1().isAlive() && model.getGrid().getLightcycle2().isAlive()) {
			
				// Move the lightcycle 1
				model.getGrid().getLightcycle1().move();
				
				//If is dead
				if(model.getGrid().getLightcycle1().isAlive() == false) {
					//Display the message
					//model.getGrid().
					this.view.displayMessage("Player " + player2 + " Win (Blue)");
					model.getGrid().save(player1, player2);
					String[] podium = model.getGrid().getPodium();
					System.out.println("Podium:");
					for(int i = 0; i<podium.length; i++) {
						System.out.println(i + ": "+podium[i]);
					}
				}
				
				//Move the lightcycle 2
				model.getGrid().getLightcycle2().move();
				
				//If is dead
				if(model.getGrid().getLightcycle2().isAlive() == false) {
					this.view.displayMessage("Player " + player1 + " Win (Red)");
					model.getGrid().save(player1, player2);
					String[] podium = model.getGrid().getPodium();
					System.out.println("Podium:");
					for(int i = 0; i<podium.length; i++) {
						System.out.println(i + ": "+podium[i]);
					}
				}
				try{
					
					// Loop game time
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		
			}
	}	
}
