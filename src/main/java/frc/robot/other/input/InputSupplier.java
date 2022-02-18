package frc.robot.other.input;

import java.util.function.Function;

public class InputSupplier<INPUT, OUTPUT> {
    /**
     * the divice that is passed into the supply function when using default methods
     */
    public INPUT divice;

    /**
     * the lambda function that supplies an object output(usually a primitive type) from a gamepad input
     */
    Function<INPUT, OUTPUT> supplyFunction;

    /**
     * constructs a new input supplier using a lambda supply function and a specific gamepad
     * @param supplyFunction the lambda function that is called to supply a new value
     * @param gamepad the gamepad that should be passed into the gamepad parameter of the supply function
     */
    public InputSupplier(Function<INPUT, OUTPUT> supplyFunction, INPUT divice){
        this.divice = divice;
        this.supplyFunction = supplyFunction;
    }

    /**
     * constructs a new input supplier using a lambda supply function with no default gamepad
     * @param supplyFunction the lambda function that is called to supply a new value
     */
    public InputSupplier(Function<INPUT, OUTPUT> supplyFunction){
        this.supplyFunction = supplyFunction;
    }

    /**
     * sets the default divice
     * @param gamepad the new default gamepad
     */
    public void setDivice(INPUT divice){
        this.divice = divice;
    }

    /**
     * gets the current value from the supply function using the passed in gamepad
     * @param gamepad the passed in gamepad
     * @return value of supply function with type OUTPUT
     */
    public OUTPUT get(INPUT divice){
        return supplyFunction.apply(divice);
    }

    /**
     * gets the current value from the supply function using the default gamepad
     * @return value of supply function with type T
     */
    public OUTPUT get(){
        return get(divice);
    }
}
