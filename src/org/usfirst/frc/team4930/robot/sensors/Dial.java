package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.autonomous.Auto0;
import org.usfirst.frc.team4930.robot.autonomous.Auto3;
import org.usfirst.frc.team4930.robot.autonomous.Auto2;
import org.usfirst.frc.team4930.robot.autonomous.Auto1;
import org.usfirst.frc.team4930.robot.autonomous.AutoReplay;
import org.usfirst.frc.team4930.robot.autonomous.Auto10;

public class Dial
{

  // return 0-10 dial number after normalizing to nearest 11th point
  static public int getDialNumber() {
    double autoSwitch = RobotMap.dial.get();
    double dialNum = (autoSwitch + 7) / (360 / 11);
    double floor = Math.floor(dialNum);
    if ((dialNum - floor) >= 0.5) {
      dialNum = Math.ceil(dialNum);
    } else {
      dialNum = floor;
    }
    return (int) dialNum;
  }

  // setup autonomous modes based on dial input
  public void setSelectedReplay() {
    Integer getDialNum = getDialNumber();
    if (getDialNum != Robot.dialNumber) {
      Robot.dialNumber = getDialNum;
      switch (Robot.dialNumber) {
        case 1:
          Robot.autoDescription = "(1) Place Left Gear";
          Robot.replayFilePath = "/home/lvuser/CSVs/NearGear.csv";
          Robot.autoCommand = new Auto1();
          break;
        case 2:
          Robot.autoDescription = "(2) Place Middle Gear";
          Robot.replayFilePath = "/home/lvuser/CSVs/MiddleGear.csv";
          Robot.autoCommand = new Auto2();
          break;
        case 3:
          Robot.autoDescription = "(3) Place Right Gear";
          Robot.replayFilePath = "/home/lvuser/CSVs/FarGear.csv";
          Robot.autoCommand = new Auto3();
          break;
        case 4:
          Robot.autoDescription = "(4) Near Replay";
          Robot.replayFilePath = "/home/lvuser/CSVs/NearGear.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 5:
          Robot.autoDescription = "(5) Middle Replay";
          Robot.replayFilePath = "/home/lvuser/CSVs/MiddleGear.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 6:
          Robot.autoDescription = "(6) Far Replay";
          Robot.replayFilePath = "/home/lvuser/CSVs/FarGear.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 7:
          Robot.autoDescription = "(7) Open Replay Seven";
          Robot.replayFilePath = "/home/lvuser/CSVs/Open7.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 8:
          Robot.autoDescription = "(8) Open Replay Eight";
          Robot.replayFilePath = "/home/lvuser/CSVs/Open8.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 9:
          Robot.autoDescription = "(9) Open Replay Nine";
          Robot.replayFilePath = "/home/lvuser/CSVs/Open9.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 10:
          Robot.autoDescription = "(10) Drive Straight to Line";
          Robot.replayFilePath = "/home/lvuser/CSVs/Practice.csv";
          Robot.autoCommand = new Auto10();
          break;
        default:
          Robot.dialNumber = 0;
          Robot.autoDescription = "(0) Do Nothing";
          Robot.replayFilePath = "";
          Robot.autoCommand = new Auto0();
      }
      System.out.println("AutoDial: " + Robot.autoDescription);
    }
  }
}
