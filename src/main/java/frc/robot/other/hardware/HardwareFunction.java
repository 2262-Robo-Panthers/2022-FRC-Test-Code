package frc.robot.other.hardware;

import java.util.List;

public interface HardwareFunction<HARDWARE, INPUT, OUT> {
    OUT run(List<HARDWARE> hardware, INPUT input);
}
