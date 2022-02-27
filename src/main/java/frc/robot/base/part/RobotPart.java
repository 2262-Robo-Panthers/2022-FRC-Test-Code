package frc.robot.base.part;

import frc.robot.other.task.TaskRunner;
import frc.robot.other.task.Task;

import frc.robot.base.RobotContainer;

public class RobotPart<HARDWARE extends RobotPartHardware, SETTINGS extends RobotPartSettings> {
    private String name;
    public RobotContainer robot;
    public HARDWARE hardware;
    public SETTINGS settings;
    private TaskRunner taskRunner;

    public RobotPart(String name, RobotContainer robot, HARDWARE hardware, SETTINGS settings){
        this.name = name;
        this.robot = robot;
        this.hardware = hardware;
        this.settings = settings;
        onConstruct();
        robot.addPart(this);
    }

    public String getName(){
        return name;
    }

    public void makeTaskRunner(){
        taskRunner = new TaskRunner(name, robot.taskManager);
    }

    public TaskRunner getTaskRunner(){
        return taskRunner;
    }

    public void makeTeleOpTask(){
        Task t = new Task("teleOp");
        t.addStep(() -> {
            onTeleOp();
        }, () -> (!settings.teleOpRunning));
        taskRunner.addTask(t, true, false);
    }

    public Task getTeleOpTask(boolean getBackgroundTask){       
        if(getBackgroundTask)
            return taskRunner.getBackgroundTask("teleOp");
        return taskRunner.getTask("teleOp");
    }

    public void init(){
        if(hardware != null) hardware.onInit(robot);
        settings.onInit(robot);
        if(settings.makeTaskRunner){
            makeTaskRunner();
            if(settings.makeTeleOpTask)
                makeTeleOpTask();
        }
        onInit();
        settings.initialized = true;
    }

    public void pause(){
        if(taskRunner != null) taskRunner.stop();
        onPause();
        settings.running = false;
    }

    public void pauseTeleOp(){
        onTeleOpPause();
        settings.teleOpRunning = false;
    }

    public void unpause(){
        if(taskRunner != null) taskRunner.start();
        onUnpause();
        settings.running = true;
    }

    public void unpauseTeleOp(){
        onTeleOpUnpause();
        getTeleOpTask(true).start();
        settings.teleOpRunning = true;
    }

    public void stop(){
        onStop();
        settings.initialized = false;
    }

    ////////////////////
    //abstract methods//
    ////////////////////
    public void onConstruct(){}

    public void onInit(){}

    public void onPause(){}

    public void onUnpause(){}

    public void onStop(){}

    public void onTeleOp(){}

    public void onTeleOpPause(){}

    public void onTeleOpUnpause(){}
}
