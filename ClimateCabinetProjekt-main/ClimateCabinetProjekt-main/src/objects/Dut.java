package objects;

import java.util.List;

public class Dut {
	private int dutId;
	private List<Test> testsOfDut;
	private boolean functionalStatus;
	private String errorReason;

	// How can a Dut created
	public Dut(int dutId) {
		this.dutId = dutId;
	}

	public boolean checkDut() {
		// What did we think for this method
		return true;
	}
}
