package frc.robot.other.hardware;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class TalonFXFunctions {
    static HardwareFunction<WPI_TalonFX, Void, double[]> getPositions = (hardware, input) -> {
        double[] out = new double[hardware.size()];
        for(int i = 0; i < hardware.size(); i++)
            out[i] = hardware.get(i).getSensorCollection().getIntegratedSensorPosition();
        return out;
    };

    static HardwareFunction<WPI_TalonFX, Void, double[]> getAbsPositions = (hardware, input) -> {
        double[] out = new double[hardware.size()];
        for(int i = 0; i < hardware.size(); i++)
            out[i] = hardware.get(i).getSensorCollection().getIntegratedSensorAbsolutePosition();
        return out;
    };

    static HardwareFunction<WPI_TalonFX, Void, double[]> getVelocities = (hardware, input) -> {
        double[] out = new double[hardware.size()];
        for(int i = 0; i < hardware.size(); i++)
            out[i] = hardware.get(i).getSensorCollection().getIntegratedSensorVelocity();
        return out;
    };

    static HardwareFunction<WPI_TalonFX, Double, Void> setPower = (hardware, input) -> {
        for(WPI_TalonFX divice : hardware)
            divice.set(input);
        return null;
    };

    static HardwareFunction<WPI_TalonFX, double[], Void> setPowers = (hardware, input) -> {
        for(int i = 0; i < hardware.size(); i++)
            hardware.get(i).set(input[i]);
        return null;
    };
}
