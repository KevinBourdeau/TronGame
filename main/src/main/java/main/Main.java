package main;
/**
* <h1>The Class Main.</h1>
*
* @author kevinbourdeau
* @version 1.0
*/


import controller.IController;
import controller.TronController;
import model.Grid;
import model.IModel;
import model.Tron;
import view.IView;
import view.Frame;


public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) 
    
    {
    	//Load the model
        final IModel model = new Tron();
        
        // Set the grid
        model.setGrid(new Grid());
        
        //Load the view with the model
        final IView view = new Frame(model);
        
        //Load the controller
        IController game = new TronController(model, view);
        
        //Start the game
        game.play();

        
    }

}
