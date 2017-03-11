package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NearGear extends CommandGroup
{

  public NearGear() {

    // For RED SIDE
    if (RobotMap.toggleSwitch.get()) {
      addSequential(new EncoderMove(-0.3, -93.25));
      // Degrees, direction, and movement from this point on are estimates NEED TO BE TESTED
      addSequential(new GyroTurn(-45, 0.3, true));
      addSequential(new EncoderMove(-0.3, -12));

      Robot.autoFile = "NearGearReplay";
      Robot.autoFilePath = new String("/home/lvuser/CSVs/" + Robot.autoFile + ".csv");
      addSequential(new Playback());
    }
    // For BLUE SIDE
    else {

      addSequential(new EncoderMove(-0.3, -93.25));
      // Degrees, direction, and movement from this point on are estimates NEED TO BE TESTED
      addSequential(new GyroTurn(45, 0.3, false));
      addSequential(new EncoderMove(-0.3, -12));

      Robot.autoFile = "NearGearReplay";
      Robot.autoFilePath = new String("/home/lvuser/CSVs/" + Robot.autoFile + ".csv");
      addSequential(new Playback());

    }
  }
}