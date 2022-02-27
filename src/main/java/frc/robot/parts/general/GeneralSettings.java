package frc.robot.parts.general;

import frc.robot.base.RobotContainer;
import frc.robot.base.part.RobotPartSettings;


public class GeneralSettings extends RobotPartSettings{
    
    final int controllerPort = 0;
    final int PCMPort = 11;

    @Override
    public void onInit(RobotContainer robot){
        makeTaskRunner = false;
    }
}
