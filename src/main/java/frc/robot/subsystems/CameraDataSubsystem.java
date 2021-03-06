/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.SeekingCommand;
/**
 * Add your docs here.
 */
public class CameraDataSubsystem extends Subsystem {
    public static class CameraData {

      public final double xOffset, yOffset, area, targetExists, skew;


      public CameraData(double xOffset, double yOffset, double area, double targetExists, double skew) {
        this.xOffset = xOffset;    
        this.yOffset = yOffset;
        this.area = area;
        this.targetExists = targetExists;     
        this.skew = skew;
      }
    }

    private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    private NetworkTableEntry tx = table.getEntry("tx"); // X offset of target
    private NetworkTableEntry ty = table.getEntry("ty"); // Y offset of target
    private NetworkTableEntry tv = table.getEntry("tv");
    private NetworkTableEntry ta = table.getEntry("ta"); // Area of target in image (0-100)
    private NetworkTableEntry ts = table.getEntry("ts"); // Skew or rotation of target
    private NetworkTableEntry tl = table.getEntry("tl"); // Camera latency data


    // Gets camera modes and pipelines from Limelight
    private NetworkTableEntry ledMode = table.getEntry("ledMode");
	  private NetworkTableEntry camMode = table.getEntry("camMode");
    private NetworkTableEntry pipeline = table.getEntry("pipeline");
    
    

    public void setTrackingMode() {
        pipeline.setNumber(1);
        camMode.setNumber(0);
        ledMode.setNumber(3);
    }

    public void setDriveCamMode() {
        pipeline.setNumber(0);
        camMode.setNumber(1);
        ledMode.setNumber(1);
    }

    public CameraData getCameraData() {
      double x = tx.getDouble(0.0);
      double y = ty.getDouble(0.0);
      double area = ta.getDouble(0.0);
      double skew = ts.getDouble(0.0);
      double v = tv.getDouble(0.0);
      return new CameraDataSubsystem.CameraData(x, y, area, v, skew);
    }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new SeekingCommand());
  }
}
