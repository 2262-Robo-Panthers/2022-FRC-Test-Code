package frc.robot.base;

import java.util.ArrayList;
import java.util.List;

import frc.robot.other.task.TaskManager;

import frc.robot.base.part.RobotPart;

public class RobotContainer {
    private List<RobotPart> parts = new ArrayList<>();

    //Manager
    public TaskManager taskManager = new TaskManager();


    //////////////////
    //init and start//
    //////////////////
    public void init(){
        initParts();
        taskManager.start();
    }

    public void run() {
        taskManager.run();
    }

    public void stop(){
        stopParts();
        taskManager.stop();
    }

    ////////////////
    //part methods//
    ////////////////
    //init and start
    public void initParts(List<RobotPart> parts){
        for (RobotPart part: parts)
            part.init();
    }
    public void initParts(){
        initParts(parts);
    }

    public void stopParts(List<RobotPart> parts){
        for (RobotPart part: parts)
            part.stop();
    }
    public void stopParts(){
        stopParts(parts);
    }

    //pause and unpause
    public void pauseParts(List<RobotPart> parts){
        for(RobotPart part: parts)
            part.pause();
    }
    public void pauseParts(){
        pauseParts(parts);
    }

    public void unpauseParts(List<RobotPart> parts){
        for(RobotPart part: parts)
            part.unpause();
    }
    public void unpauseParts(){
        unpauseParts(parts);
    }

    //other
    public void addPart(RobotPart part){
        parts.add(part);
    }

    public void removePart(RobotPart part){
        parts.remove(part);
    }

    public void removePart(int index){
        parts.remove(index);
    }

    public RobotPart getPartByClass(Class partClass){
        for(RobotPart part: parts)
            if (part.getClass().equals(partClass))
                return part;
        return null;
    }
}
