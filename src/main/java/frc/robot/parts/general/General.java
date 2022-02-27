package frc.robot.parts.general;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.base.RobotContainer;
import frc.robot.base.part.RobotPart;
import frc.robot.base.part.RobotPartHardware;

public class General extends RobotPart<RobotPartHardware, GeneralSettings> {

    public XboxController controller;
    public Compressor PCM;

    public General(String name, RobotContainer robot, GeneralSettings settings) {
        super(name, robot, null, settings);
    }

    public General(RobotContainer robot) {
        super("general", robot, null, new GeneralSettings());
    }

    @Override
    public void onConstruct(){
        controller = new XboxController(settings.controllerPort);
        PCM = new Compressor(settings.PCMPort);
    }
}
