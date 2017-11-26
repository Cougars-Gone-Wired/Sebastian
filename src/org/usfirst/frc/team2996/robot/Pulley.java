package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;

public class Pulley {
	// declare private variables and objects to be used only in this class
	private Talon pulleyMotor;
	private Joystick stick;
	private int pulleyAxis;

	public Pulley(Robot robot) { // have the constructor take a robot class as a parameter so this class can use its variables
		// assign declared variables as the values of variables in the robot class
		this.pulleyMotor = robot.getPulleyMotor();
		this.stick = robot.getStick();
		this.pulleyAxis = Robot.PULLEY_AXIS;
	}

	public void pulley() {
		if (Threshold.triggerThreshold(stick.getRawAxis(pulleyAxis))) { // if the pulley trigger is being pushed past the threshold
			pulleyMotor.set(Robot.PULLEY_INVERT); // make the pulley motor spin by setting it to the pulley invert
		} else {
			pulleyMotor.set(0); // set the pulley motor speed to 0
		}
	}
}
