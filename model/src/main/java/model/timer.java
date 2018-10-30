package model;
/**
* <h1>ITimer class.</h1>
*
* @author kevinbourdeau
* @version 1.0
*/
public class timer implements ITimer{
	private double time;
	
	public timer() {
		time=0;
	}
	
	public void start() {
		this.time=System.currentTimeMillis();
	}
	
	
	public void stop() {
		
		this.time=(System.currentTimeMillis()-time)/1000;
	}
	
	public double getTime() {
		
		return this.time;
	}

	@Override
	public ITimer getTimer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

