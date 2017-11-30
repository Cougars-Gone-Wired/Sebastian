package org.usfirst.frc.team2996.robot;

public class Threshold {
	// makes dead zones for the sticks so that the robot doesn't move if the driver accidently hits a stick a little bit
	public static double stickThreshold(double x) { // method to be used for the raw value of a stick axis
		if (Math.abs(x) > 0.15) { // if the absolute value of the axis value is over .15, not too close to the center
			return x; // return the given value
		} else {
			return 0; // if the stick axis is too close to the center, don't return its value, just return zero
		}
	}
	
	// makes it so that drivers have to push triggers in a certain distance before anything happens
	public static boolean triggerThreshold(double x) { // method to be used for the raw value of a trigger axis
		if (Math.abs(x) > 0.2) { // if the absolute value of the axis value is over .2, not too close to completely out 
			return true;
		} else {
			return false; // if trigger axis is too close to not actually being pushed, say its not being pushed
		}
	}
}
