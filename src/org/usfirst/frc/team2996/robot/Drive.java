package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class Drive {
	// declare private variables to be used in this class
	private Joystick stick;
	private RobotDrive robotDrive;

	private Talon frontLeftMotor;
	private Talon frontRightMotor;
	private Talon backLeftMotor;
	private Talon backRightMotor;

	Drive(Robot robot) { // have the constructor take a robot class as a parameter so this class can use its variables
		// assign declared variables as the values of variables in the robot class by calling the getters of those variables on the robot class
		this.stick = robot.getStick();
		this.robotDrive = robot.getRobotDrive();
		this.frontLeftMotor = robot.getFrontLeftMotor();
		this.frontRightMotor = robot.getFrontRightMotor();
		this.backLeftMotor = robot.getBackLeftMotor();
		this.backRightMotor = robot.getBackRightMotor();
	}

	public void invertMotors(boolean frontLeftMotorInvert, boolean frontRightMotorInvert, 
			boolean backLeftMotorInvert, boolean backRightMotorInvert) { // method to invert drive motors if needed - takes booleans of the four drive motor controllers as parameters 
		// each motor controller is inverted if their given boolean is true
		frontLeftMotor.setInverted(frontLeftMotorInvert);
		frontRightMotor.setInverted(frontRightMotorInvert);
		backLeftMotor.setInverted(backLeftMotorInvert);
		backRightMotor.setInverted(backRightMotorInvert);
	}

	public void sebastianDrive() {
		invertMotors(false, false, false, false); // calling invertMotors and setting whether each drive motor controller should be inverted
		robotDrive.arcadeDrive( // robotDrive calls the method arcadeDrive from RobotDrive that takes a forward speed and a turning speed
		Threshold.stickThreshold((Robot.DRIVE_YAXIS_INVERT) * stick.getRawAxis(Robot.DRIVE_FORWARD)), // uses the value of the left stick y-axis from -1 to 1 times the possible axis invert if this values is past the threshold
		Threshold.stickThreshold((Robot.DRIVE_XAXIS_INVERT) * stick.getRawAxis(Robot.DRIVE_TURN))); // uses the value of the right stick x-axis from -1 to 1 times the possible axis invert if this value is past the threshold
	}
	
}
