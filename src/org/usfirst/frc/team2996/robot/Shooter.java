package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
	// declare private variables and objects to be used only in this class
	private Talon shooterMotor;
	private Joystick stick;
	private int shooterButton;

	public Shooter(Robot robot) { // have the constructor take a robot class as a parameter so this class can use its variables
		// assign declared variables as the values of variables in the robot class
		this.shooterMotor = robot.getShooterMotor();
		this.stick = robot.getStick();
		this.shooterButton = Robot.SHOOTER_BUTTON;
	}

	public void shooter() {
		if (stick.getRawButton(shooterButton)) { // if the shooter button is being pressed
			shooterMotor.set(SmartDashboard.getNumber("shooter voltage", 0)); // set the speed of the shooter motor to the shooter voltage specified on the SmartDashboard
		}
	}
}
