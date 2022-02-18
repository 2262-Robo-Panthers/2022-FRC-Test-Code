package frc.robot.other.hardware;

import edu.wpi.first.wpilibj.PWM;

public class PWMFunctions {
    HardwareFunction<PWM, Double, Void> setPWMSpeed = (hardware, input) -> {
        for(PWM divice : hardware)
            divice.setSpeed(input);
        return null;
    };

    HardwareFunction<PWM, Double[], Void> setPWMSpeeds = (hardware, input) -> {
        for(int i = 0; i < hardware.size(); i++)
            hardware.get(i).setSpeed(input[i]);
        return null;
    };
}
