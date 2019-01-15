/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.CameraDataSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.CameraDataSubsystem.CameraData;

public class SeekingCommand extends Command {
  public DriveTrainSubsystem driveOne = Robot.driveTrainSubsystem;

  public SeekingCommand() {
    requires(Robot.driveTrainSubsystem);
    requires(Robot.cameraDataSubsystem);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Running Seeking Command");
    var data = Robot.cameraDataSubsystem.getCameraData();
    if(data.targetExists == 0.0) {
      Robot.driveTrainSubsystem.drive.curvatureDrive(0.0, 0.5, true);
    } else {
      Robot.driveTrainSubsystem.drive.curvatureDrive(-0.5, 0.0, false);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.cameraDataSubsystem.getCameraData().area >= 1.0;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
