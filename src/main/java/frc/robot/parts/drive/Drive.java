package frc.robot.parts.drive;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.base.RobotContainer;
import frc.robot.base.part.RobotPart;

public class Drive extends RobotPart<DriveHardware, DriveSettings> {

    DifferentialDrive drive;

    public Drive(String name, RobotContainer robot, DriveHardware hardware, DriveSettings settings) {
        super(name, robot, hardware, settings);
    }

    public Drive(RobotContainer robot) {
        super("drive", robot, new DriveHardware(), new DriveSettings());
    }

    @Override
    public void onConstruct() {
        drive = new DifferentialDrive(hardware.frontLeftMotor, hardware.frontRightMotor);    
    }
    
    @Override
    public void onTeleOp(){
        drive.arcadeDrive(settings.driveXSupplier.getFiltered(), settings.driveRSupplier.getFiltered() + settings.driveFineRSupplier.getFiltered());
    }

    @Override
    public void onTeleOpPause(){
        drive.arcadeDrive(0, 0);
    }
}
