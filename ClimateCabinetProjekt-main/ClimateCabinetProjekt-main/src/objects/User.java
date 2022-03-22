package objects;

import java.util.List;

public class User {
	private String name;
	private String surname;
	private String password;
	private int personnelNumber;

	private enum role {
		admin, tester
	}

	private enum status {
		active, inactive
	}

	public User(String name, String surname, int personnelNumber) {
		this.name = name;
		this.surname = surname;
		this.personnelNumber = personnelNumber;
	}

	public User(int personnelNumber, String password, String name, String surname) {
		this.personnelNumber = personnelNumber;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.personnelNumber = personnelNumber;
	}

	public boolean climateCabinetSelect(ClimateCabinet selectedClimate) {
		// Is there selectedClimate in
		return true;
	}

	/*
	 * !! Kayit kismi yaparsak aktiflestirilebilir //Creating an object User and
	 * save database public boolean signIn(int personnelNumber, String password){ //
	 * Comparing the personnel information with the database return true; }
	 */

	public void testOperationStart(int climateCabinetId, int trackingNumber) {
		// Check the ClimateCabinetList
		// if climateCabinetId == id
		// Check the functionalStatus
		// if true:
		// ??
	}

	// Research the connection between exit and backend
	public void exitProgram() {
		// This method provides to exit from the system
		// I think that this method needs to link backend
	}

	public void exit() {
		// This method provides to exit from the page
		// I think that this method needs to link frontend
	}

	public void initiationStart() {
		// This method provides to start the test and to prepare the climateCabinet
		// I think that this method needs to link backend
		// call the method testOperationStart()
	}

	public void orderAdd(int trackingNumber, int slotNumber) {
		// This method should create an order with TrackingNumber to Slot with
		// slotNumber
	}

	public void removeDutByTrackingNumber(int trackingNumber) {
		// This method should remove a Dut by trackingNumber
		// Dut will be removed from the testList
	}

	public void removeDutBySlotNumber(int slotNumber) {
		// This method should remove a Dut by trackingNumber
		// Dut will be removed from the testList
	}

	public void burnInTest(List<Dut> dutList) {
		// Test should be started here
		// Test(List<Dut> ... )
		// ???????????????????????
		// Here should the relationship between our DutList and database be thought
		// It is related to backend
	}

	// Backend ?
	public void pause() {
		// If the Test is continued, then it should be paused (functionalStatus=false)
		// It is related to backend
	}

	public void testingContinue() {
		// If the Test was paused, then it is gotten their functionalStatus true
	}

	public void outOfOrderSwitchesCheck(int slotNumber) {
		// According to programming of Slot and Test Classes
		// out of order switches should be removed from testList
	}

	public void activeSwitchesCheck(int slotNumber) {
		// According to programming of Slot and Test Classes
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPersonnelNumber() {
		return personnelNumber;
	}

	public void setPersonnelNumber(int personnelNumber) {
		this.personnelNumber = personnelNumber;
	}

}
