package frc.robot.parts.drive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.base.RobotContainer;
import frc.robot.base.part.RobotPartSettings;
import frc.robot.other.input.InputSupplierEx;
import frc.robot.parts.general.General;

public class DriveSettings extends RobotPartSettings{
    //general
    double driveSpeedMultiplier = 1;

    //inputs/controls
    XboxController controller;
    InputSupplierEx<XboxController> driveXSupplier = new InputSupplierEx<>(xbox -> (
        (xbox.getTriggerAxis(Hand.kLeft) - xbox.getTriggerAxis(Hand.kRight)) * driveSpeedMultiplier
        ), 0.075);
    InputSupplierEx<XboxController> driveRSupplier = new InputSupplierEx<>(xbox -> (
        xbox.getX(Hand.kLeft) * driveSpeedMultiplier
        ), 0.075);
    InputSupplierEx<XboxController> driveFineRSupplier = new InputSupplierEx<>(xbox -> (
        xbox.getX(Hand.kRight) * 0.3
        ), 0.075 * 0.3);

    @Override
    public void onInit(RobotContainer robot){
        controller = ((General)robot.getPartByName("general")).controller;
        driveXSupplier.setDivice(controller);
        driveRSupplier.setDivice(controller);
        driveFineRSupplier.setDivice(controller);
    }
}