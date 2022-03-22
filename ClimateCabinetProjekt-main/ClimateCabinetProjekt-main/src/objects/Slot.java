package objects;

import java.util.HashMap;

public class Slot {
	private int slotNumber;
	private int dutId;
	private HashMap<String, String> orderOfSlots = new HashMap<String, String>();

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getDutId() {
		return dutId;
	}

	public void setDutId(int dutId) {
		this.dutId = dutId;
	}

	public HashMap<String, String> getOrderOfSlots() {
		return orderOfSlots;
	}

	public void setOrderOfSlots(String slot, String order) {
		this.orderOfSlots.put(slot, order);
	}

}
