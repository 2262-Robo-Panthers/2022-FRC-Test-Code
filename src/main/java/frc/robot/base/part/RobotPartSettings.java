package frc.robot.base.part;

import frc.robot.base.Robot;

public class RobotPartSettings {
    public boolean makeTaskRunner = true;

    boolean initialized = false;
    boolean started = false;
    boolean running = false;


    public void init(Robot robot){
        onInit(robot);
    }

    public void onInit(Robot robot){}

    public boolean canStart(){return initialized;}

    public boolean canUse(){return initialized && started;}

    public boolean isRunning(){return canUse() && running;}
}
