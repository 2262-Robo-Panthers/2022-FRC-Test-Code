package frc.robot.base.part;

import frc.robot.base.RobotContainer;

public class RobotPartSettings {
    public boolean makeTaskRunner = true;
    public boolean makeTeleOpTask = true;

    boolean initialized = false;
    boolean running = false;
    boolean teleOpRunning = false;


    public void onInit(RobotContainer robot){}

    public boolean canUse(){return initialized;}

    public boolean isRunning(){return canUse() && makeTaskRunner && running;}

    public boolean isTeleOpRunning(){return isRunning() && teleOpRunning;}
}
