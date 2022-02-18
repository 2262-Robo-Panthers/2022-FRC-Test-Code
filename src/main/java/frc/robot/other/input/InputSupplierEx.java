package frc.robot.other.input;

import java.util.function.Function;

public class InputSupplierEx<INPUT> extends InputSupplier<INPUT, Float>{
	private float minRegisterVal;
	//private int multiPressMaxTime; //add in later
	private boolean wasButtonPressed = false;
	private long lastButtonRelease = System.currentTimeMillis();
	//private int numTimesPressed = 0; //add in later

	public InputSupplierEx(Function<INPUT, Float> supplyFunction, INPUT divice, float minRegisterVal) {
		super(supplyFunction, divice);
		this.minRegisterVal = minRegisterVal;
	}

	public InputSupplierEx(Function<INPUT, Float> supplyFunction) {
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
}
