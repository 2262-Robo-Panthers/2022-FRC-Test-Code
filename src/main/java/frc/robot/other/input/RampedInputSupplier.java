package frc.robot.other.input;

import java.util.function.Function;

public class RampedInputSupplier<INPUT> extends InputSupplier<INPUT, Float> {
	float ramp = 0;
	float currentVal = 0;
	boolean brakeAt0 = false;

	public RampedInputSupplier(Function<INPUT, Float> supplyFunction, INPUT divice, float ramp, boolean brakeAt0) {
		super(supplyFunction, divice);
		this.ramp = ramp;
		this.brakeAt0 = brakeAt0;
	}

	public RampedInputSupplier(Function<INPUT, Float> supplyFunction, float ramp, boolean brakeAt0) {
		super(supplyFunction);
		this.ramp = ramp;
		this.brakeAt0 = brakeAt0;
	}

	public RampedInputSupplier(Function<INPUT, Float> supplyFunction) {
		super(supplyFunction);
	}

	public float getRamped(INPUT divice){
		float target = get(divice);

		if(brakeAt0 && target == 0)
			reset();
		else {
			if (currentVal < target) {
				currentVal += ramp;
				if (currentVal > target)
					currentVal = target;
			} else if (currentVal > target) {
				currentVal -= ramp;
				if (currentVal < target)
					currentVal = target;
			}
		}
		return currentVal;
	}

	public float getRamped(){
		return getRamped(divice);
	}

	public void reset(){
		currentVal = 0;
	}
}