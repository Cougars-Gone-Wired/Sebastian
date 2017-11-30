package org.usfirst.frc.team2996.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;

public class Pulley {
	// declare private variables and objects to be used in this class
	private Talon pulleyMotor;
	private Joystick stick;

	public Pulley(Robot robot) { // have the constructor take a robot class as a parameter so this class can use its variables
		// assign declared variables as the values of variables in the robot class by calling the getters of those variables on the robot class
		this.pulleyMotor = robot.getPulleyMotor();
		this.stick = robot.getStick();
	}

	public void pulley() {
		if (Threshold.triggerThreshold(stick.getRawAxis(Robot.PULLEY_AXIS))) { // if the pulley trigger is being pushed past the threshold
			pulleyMotor.set(Robot.PULLEY_INVERT); // setting puller motor controller to the pulley invert so that it turns at full speed in the right direction
		} else {
			pulleyMotor.set(0); // set the pulley motor speed to 0
		}
	}
}
