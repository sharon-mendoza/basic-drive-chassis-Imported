// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;


public class TankDrive extends CommandBase {
  /** Creates a new TankDrive. 
   * @param m_driveTrain*/

  public TankDrive(DriveTrain m_driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickY = RobotContainer.GetDriverRawAxis(Constants.leftStickY); //axis number found in USB page of DS
    double rightStickY = RobotContainer.GetDriverRawAxis(Constants.rightStickY);

    DriveTrain.driveTrain.setLeftMotors(leftStickY); //If needed, can scale speed by adjusting to leftStickY*0.5 or leftStickY*leftStickY
    DriveTrain.driveTrain.setRightMotors(rightStickY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Preventative measure- Motor controllers preserve last input value
    DriveTrain.driveTrain.setLeftMotors(0);
    DriveTrain.driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
