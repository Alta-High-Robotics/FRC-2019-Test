/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveCommand extends Command {
  public DriveCommand() {
    requires(Robot.driveTrainSubsystem);
    requires(Robot.cameraDataSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {;

    Robot.driveTrainSubsystem.speed = Robot.oi.getController().getRawAxis(RobotMap.DRIVE_STICK_Y_AXIS);
    Robot.driveTrainSubsystem.rotation = -1.0 * Robot.oi.getController().getRawAxis(RobotMap.DRIVE_STICK_X_AXIS);
    // Robot.driveTrainSubsystem.arcadeDrive();
    Robot.driveTrainSubsystem.curveDrive();
    SmartDashboard.putNumber("LimelightX", Robot.cameraDataSubsystem.getCameraData().xOffset);
    SmartDashboard.putNumber("LimelightY", Robot.cameraDataSubsystem.getCameraData().yOffset);
    SmartDashboard.putNumber("LimelightArea", Robot.cameraDataSubsystem.getCameraData().area);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
