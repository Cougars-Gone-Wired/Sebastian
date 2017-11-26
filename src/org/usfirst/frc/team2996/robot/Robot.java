package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	// Declaring constant variables
	// Id of each motor port on roborio
	static int FRONT_LEFT_MOTOR_ID;
	static int FRONT_RIGHT_MOTOR_ID;
	static int BACK_LEFT_MOTOR_ID;
	static int BACK_RIGHT_MOTOR_ID;
	static int SHOOTER_MOTOR_ID;
	static int PULLEY_MOTOR_ID;

	// Id of each button on controller
	static int STICK; // object of joystick port
	static int DRIVE_FORWARD;
	static int DRIVE_TURN;
	static int SHOOTER_BUTTON;
	static int PULLEY_AXIS;

	// Variables to invert motors
	static int DRIVE_YAXIS_INVERT;
	static int DRIVE_XAXIS_INVERT;
	static int PULLEY_INVERT;

	// Declaring objects
	Joystick stick; // object of joystick

	// object for each motor controller
	Talon frontLeftMotor; 
	Talon frontRightMotor;
	Talon backLeftMotor;
	Talon backRightMotor;
	Talon shooterMotor;
	Talon pulleyMotor;

	// object for each major class
	Drive drive;
	Pulley pulley;
	Shooter shooter;
	
	// object of robotdrive
	RobotDrive robotDrive;

	@Override
	public void robotInit() { // runs once when robot is turned on
		setConstants(); // set constants to assigned values
		
		// instantiate declared objects
		// instantiate motor controller objects, put ports as their parameters
		frontLeftMotor = new Talon(FRONT_LEFT_MOTOR_ID);
		frontLeftMotor = new Talon(FRONT_RIGHT_MOTOR_ID);
		backLeftMotor = new Talon(BACK_LEFT_MOTOR_ID);
		backLeftMotor = new Talon(BACK_RIGHT_MOTOR_ID);
		shooterMotor = new Talon(SHOOTER_MOTOR_ID);
		pulleyMotor = new Talon(PULLEY_MOTOR_ID);
		
		stick = new Joystick(STICK); // instantiate joystick

		robotDrive = new RobotDrive(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor); // instantiate robotdrive, put motor controller objects as parameters  
	}

	/*
	@Override
	public void teleopInit() { // runs once when teleop starts
		drive.sebastianDrive(); // call sebastianDrive in the drive class
	}
	*/
	
	@Override
	public void teleopPeriodic() { // runs continuously during teleop
		drive.sebastianDrive(); // call sebastianDrive in the drive class
		shooter.shooter(); // call shooter in the shooter class
		pulley.pulley(); // call pulley in the pulley class
	}

	public void displaySettings() { // put variables on the SmartDashboard
		SmartDashboard.putNumber("shooter voltage", 0); // put a number shooter voltage and set its default to 0
	}

	public static void setConstants() { // assign values to the constant variables

		// assign motor ports to port numbers
		FRONT_LEFT_MOTOR_ID = 5;
		FRONT_RIGHT_MOTOR_ID = 4;
		BACK_LEFT_MOTOR_ID = 3;
		BACK_RIGHT_MOTOR_ID = 2;
		SHOOTER_MOTOR_ID = 0;
		PULLEY_MOTOR_ID = 1;
		
		// assign button and axis
		STICK = 0; // assign joystick port
		DRIVE_FORWARD = 1;
		DRIVE_TURN = 4;
		SHOOTER_BUTTON = 1;
		PULLEY_AXIS = 3;

		// assign whether a motor should be inverted (-1 = yes, 1 = no)
		DRIVE_YAXIS_INVERT = 1;
		DRIVE_XAXIS_INVERT = 1;
		PULLEY_INVERT = 1;
	}

	// Getters so classes can used the variables and objects declared in this class
	public Joystick getStick() {
		return stick;
	}

	public Talon getFrontLeftMotor() {
		return frontLeftMotor;
	}

	public Talon getFrontRightMotor() {
		return frontRightMotor;
	}

	public Talon getBackLeftMotor() {
		return backLeftMotor;
	}

	public Talon getBackRightMotor() {
		return backRightMotor;
	}

	public Talon getShooterMotor() {
		return shooterMotor;
	}

	public Talon getPulleyMotor() {
		return pulleyMotor;
	}

	public Drive getDrive() {
		return drive;
	}

	public RobotDrive getRobotDrive() {
		return robotDrive;
	}

}
