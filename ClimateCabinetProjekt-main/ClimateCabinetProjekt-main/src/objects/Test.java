package objects;

import java.time.LocalTime;
import java.util.List;

public class Test {
	private int testNumber;
	private LocalTime testStartTime;
	private LocalTime testFinishTime;
	private boolean functionalStatus;
	private float isTemperature;
	private float shouldTemperature;
	private LocalTime estimatedTimeDuration;
	private List<Dut> dutList;
	// This list should test steps kept
	public List<Test> testSteps;

	// How we create a test
	public Test(int testNumber) {

	}

	// Here we said that the parameter should be LocalTime estimatedTime.. but
	public void timeOut(Test controlledTest) {
		// Get the current time and Subtract the testStartTime from the current time
		// if the subtract is bigger than estimatedTimeDuration give an exception
	}
}
