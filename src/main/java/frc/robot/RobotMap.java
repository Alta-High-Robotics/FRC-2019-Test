/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int
        XBOX_PORT = 1,

        //drive train
        TALON_RIGHT1 = 0,
        TALON_RIGHT2 = 1,
        VICTOR_LEFT1 = 4,
        VICTOR_LEFT2 = 5,
        
        DRIVE_STICK_Y_AXIS = 1,
        DRIVE_STICK_X_AXIS = 0;
}
