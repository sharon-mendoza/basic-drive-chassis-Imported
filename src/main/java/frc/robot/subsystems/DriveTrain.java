// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

public class DriveTrain extends SubsystemBase {

  /** Creates a new DriveTrain. */
  public static DriveTrain driveTrain = new DriveTrain();

  private TalonSRX motorLeft1 = new TalonSRX(Constants.leftMotorId1); //substites device number, placed in our constants file for easier CAN ID reconfiguration if needed
  private TalonSRX motorLeft2 = new TalonSRX(Constants.leftMotorId2); 
  private TalonSRX motorRight1 = new TalonSRX(Constants.rightMotorId1);
  private TalonSRX motorRight2 = new TalonSRX(Constants.rightMotorId2);


  public DriveTrain() {
    //place methods for controlling this subsystem here. Call these from Commands.
    

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setLeftMotors( double speed){
    motorLeft1.set(ControlMode.PercentOutput, speed);
    motorLeft2.set(ControlMode.PercentOutput, speed);
  }

  //motors are pointed in opposite directions, so orientation would lead to a turn if one set is not reversed.
  //Solutions: (1) Invert one set of motors or (2) Make speed neg. for one set
  public void setRightMotors( double speed){
    motorRight1.set(ControlMode.PercentOutput, -speed);
    motorRight2.set(ControlMode.PercentOutput, -speed);
  }

}
