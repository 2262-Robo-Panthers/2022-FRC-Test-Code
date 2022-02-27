package frc.robot.base;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import frc.robot.other.task.TaskManager;

import frc.robot.base.part.RobotPart;
import frc.robot.base.part.RobotPartHardware;
import frc.robot.base.part.RobotPartSettings;

public class RobotContainer {
    //parts
    private List<RobotPart> parts = new ArrayList<>();

    //other


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
    public static void initParts(List<RobotPart> parts){
        for (RobotPart part: parts)
            part.init();
    }
    public void initParts(){
        initParts(parts);
    }

    public static void stopParts(List<RobotPart> parts){
        for (RobotPart part: parts)
            part.stop();
    }
    public void stopParts(){
        stopParts(parts);
    }

    //pause and unpause
    public static void pauseParts(List<RobotPart> parts){
        for(RobotPart part: parts)
            part.pause();
    }
    public void pauseParts(){
        pauseParts(parts);
    }

    public static void unpauseParts(List<RobotPart> parts){
        for(RobotPart part: parts)
            part.unpause();
    }
    public void unpauseParts(){
        unpauseParts(parts);
    }

    public static void unpauseTeleOp(List<RobotPart> parts){
        for(RobotPart part : parts)
            part.unpauseTeleOp();
    }

    public void unpauseTeleOp(){
        unpauseTeleOp(parts);
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

    /**
     * 
     * @param partClass
     * @return
     * @deprecated use getPartByName() to allow for mutiple parts of same type
     */
    @Deprecated
    public RobotPart<RobotPartHardware, RobotPartSettings> getPartByClass(Class partClass){
        for(RobotPart part: parts)
            if (part.getClass().equals(partClass))
                return part;
        return null;
    }

    public RobotPart getPartByName(String name){
        for(RobotPart part: parts)
            if (part.getName().equals(name))
                return part;
        return null;
    }
}
