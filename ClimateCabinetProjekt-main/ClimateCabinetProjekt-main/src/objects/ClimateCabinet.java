package objects;

import java.util.HashMap;
import java.util.List;

public class ClimateCabinet {
	private int climateCabinetId;
	private boolean functionalStatus;
	private HashMap<String, String> slots = new HashMap<>();
	public double currentTemp = 0;

	// Controlling the functional Status
	public boolean isFunctional() {
		return this.functionalStatus;
	}

	public int getClimateCabinetId(ClimateCabinet selectedClimate) {
		this.climateCabinetId = selectedClimate.climateCabinetId;
		return this.climateCabinetId;
	}

	public int getClimateCabinetId() {
		return climateCabinetId;
	}

	public void setClimateCabinetId(int climateCabinetId) {
		this.climateCabinetId = climateCabinetId;
	}

	public boolean isFunctionalStatus() {
		return functionalStatus;
	}

	public void setFunctionalStatus(boolean functionalStatus) {
		this.functionalStatus = functionalStatus;
	}

	public HashMap<String, String> getSlots() {
		return slots;
	}

	public void setSlots(String text, String text2) {

		this.slots.put(text, text2);

	}

}
