package frc.robot.parts.drive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import frc.robot.base.RobotContainer;
import frc.robot.base.part.RobotPartHardware;

public class DriveHardware extends RobotPartHardware{
    
    //hardware settings
    private final int frontLeftMotorNumber = 0;
    private final int backLeftMotorNumber = 1;
    private final int frontRightMotorNumber = 2;
    private final int backRightMotorNumber = 3;

    WPI_TalonFX backRightMotor;
    WPI_TalonFX backLeftMotor;
    WPI_TalonFX frontRightMotor;
    WPI_TalonFX frontLeftMotor;
    
    @Override
    public void onInit(RobotContainer robot){
        backRightMotor = new WPI_TalonFX(backRightMotorNumber);
        frontRightMotor = new WPI_TalonFX(frontRightMotorNumber);
        backLeftMotor = new WPI_TalonFX(backLeftMotorNumber);
        frontLeftMotor = new WPI_TalonFX(frontLeftMotorNumber);

        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);
        frontRightMotor.setInverted(true);
        backRightMotor.setInverted(true);
        frontRightMotor.setNeutralMode(NeutralMode.Coast);
        frontLeftMotor.setNeutralMode(NeutralMode.Coast);
    }
}
