package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 02r: Place gear (g) on left side.
 * 
 *     g
 *    / 
 *   |
 *   | 
 *  [v]
 *  ___________
 *  
 */
public class Auto02 extends CommandGroup
{
  public Auto02() {

    // if !isRed and isReplaySet then run ReplayCode

    if (Robot.isReplaySet) {
      System.out.println("REPLAY 02: Initializing");
      addSequential(new ReplayPlayback());
    } else {
      System.out.println("AUTO 02: Initializing");
      addSequential(new GoStraightBB(-0.7, 66));
      addSequential(new Timer(0.5));
      addSequential(new PlaceGear());
      addSequential(new GoStraightBB(0.3, 12));
    }
  }
}