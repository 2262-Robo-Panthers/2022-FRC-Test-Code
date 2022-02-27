package frc.robot.other.input;

import java.util.function.Function;

public class InputSupplierEx<INPUT> extends InputSupplier<INPUT, Double>{
	private double minRegisterVal;
	//private int multiPressMaxTime; //add in later
	private boolean wasButtonPressed = false;
	private long lastButtonRelease = System.currentTimeMillis();
	//private int numTimesPressed = 0; //add in later

	public InputSupplierEx(Function<INPUT, Double> supplyFunction, INPUT divice, double minRegisterVal) {
		super(supplyFunction, divice);
		this.minRegisterVal = minRegisterVal;
	}

	public InputSupplierEx(Function<INPUT, Double> supplyFunction, double minRegisterVal) {
		super(supplyFunction);
		this.minRegisterVal = minRegisterVal;
	}

	public InputSupplierEx(Function<INPUT, Double> supplyFunction) {
		super(supplyFunction);
		minRegisterVal = 0.1f;
	}

	boolean getButtonHeld(INPUT divice){
		return get(divice) > minRegisterVal;
	}

	boolean getButtonHeld(){
		return getButtonHeld(divice);
	}

	boolean getButtonHeld(INPUT divice, int time)
	{
		if(getButtonHeld(divice))
		{
			return System.currentTimeMillis() - lastButtonRelease > time;
		}
		else lastButtonRelease = System.currentTimeMillis();
		return false;
	}
	boolean getButtonHeld(int time){return getButtonHeld(divice, time);}

	boolean getButtonPressed(INPUT divice)
	{
		if(getButtonHeld(divice))
		{
			if(!wasButtonPressed)
			{
				wasButtonPressed = true;
				return true;
			}
		}
		else wasButtonPressed = false;
		return false;
	}
	boolean getButtonPressed(){return getButtonPressed(divice);}

	boolean getButtonReleased(INPUT divice)
	{
		if(getButtonHeld(divice)) wasButtonPressed = true;
		else if(wasButtonPressed)
		{
			wasButtonPressed = false;
			return true;
		}
		return false;
	}
	boolean getButtonReleased(){return getButtonReleased(divice);}

	public double getFiltered(INPUT device){
		double val = get(divice);
		return (Math.abs(val) < minRegisterVal) ? 0 : val;
	}

	public double getFiltered(){
		return getFiltered(divice);
	}
}
