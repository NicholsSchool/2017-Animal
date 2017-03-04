package org.usfirst.frc.team4930.robot.command.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class NearGear extends CommandGroup
{

  public NearGear() {
    addSequential(new EncoderMove(-0.3, -36));
    addSequential(new GyroTurn(45, 0.3, true));
    addSequential(new EncoderMove(-0.3, -12));
    // addSequential(new NearReplay());

    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
