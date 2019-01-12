/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Add your docs here.
 */
public class DriveTrainSubsystem extends Subsystem {
  Victor left1 = new Victor(RobotMap.VICTOR_LEFT1);
	Victor left2 = new Victor(RobotMap.VICTOR_LEFT2);
	Talon right1 = new Talon(RobotMap.TALON_RIGHT1);
	Talon right2 = new Talon(RobotMap.TALON_RIGHT2);

	//groups both motors as one drive, both motors required for movement
	public SpeedControllerGroup leftSideDrive = new SpeedControllerGroup(left1, left2);
	public SpeedControllerGroup rightSideDrive = new SpeedControllerGroup(right1, right2);
  public DifferentialDrive drive = new DifferentialDrive(leftSideDrive, rightSideDrive);

  public double speed = 0.0;
  public double rotation = 0.0;

  public void arcadeDrive() {
    drive.arcadeDrive(speed, rotation);
  }

  public void curveDrive() {
    drive.curvatureDrive(speed, rotation, Robot.oi.getController().getAButton());
  }

  @Override
  public void initDefaultCommand() {
    this.setDefaultCommand(new DriveCommand());
  }
}
