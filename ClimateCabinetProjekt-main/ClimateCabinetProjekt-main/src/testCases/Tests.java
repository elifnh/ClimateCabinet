package testCases;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import database.DbConnection;
import loginregister.Login;
import objects.Controll;

public class Tests {

	@Test
	public void NotadminTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		boolean test = db.isAdmin("1234567890", "1234");
		assertFalse(test);

		boolean test2 = db.isAdmin("1805030390", "pelinI1");
		assertTrue(test2);

	}

	@Test
	public void addUserTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		String test = db.addUser("Ece", "Toprak", "12345", 2005030390, "active", "tester");
		assertEquals(test, "ist angemeldet");

	}

	@Test
	public void controlInfosTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		boolean test = db.controlInformation("1805030391", "123456");
		assertFalse(test);

	}

	@Test
	public void autoCompleteTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		String[] test = db.autoComplete(1805030130);
		String[] expected = { "Berna Zehra", "Ural", "bernaU1", "admin", "active" };
		assertArrayEquals(test, expected);
	}

	@Test
	public void isRegisteredTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		boolean test = db.isRegistered(1805030591);
		assertFalse(test);
	}

	@Test
	public void climateCabinetTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		int test = db.controlClimateCabinet();
		assertEquals(1, test);
	}

	@Test
	public void schrankAuswahlTest() throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection db = new DbConnection();
		ArrayList<Integer> test = db.schrankAuswahl();
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1234);
		assertEquals(test, expected);
	}

	@Test
	public void controllTest() throws InstantiationException, IllegalAccessException, SQLException {
		Controll controll = new Controll();
		boolean test = controll.lengthControl("72.001.110.260.014 45.678.932");
		assertTrue(test);
		boolean test2 = controll.lengthControl("72.001.110.260.014 45");
		assertFalse(test2);
	}

	@Test
	public void slotLengthControllTest() throws InstantiationException, IllegalAccessException, SQLException {
		Controll controll = new Controll();
		boolean test = controll.slotLengthControl("Slot_001", "01");
		assertTrue(test);

		boolean test2 = controll.slotLengthControl("Slot_0011", "23");
		assertFalse(test2);

		boolean test3 = controll.slotLengthControl("Slot_001", "23");
		assertFalse(test3);

	}

	@Test
	public void dutLengthcontrollTest() throws InstantiationException, IllegalAccessException, SQLException {
		Controll controll = new Controll();
		boolean test = controll.dutLengthControl("72.001.110.260.014");
		assertTrue(test);

		boolean test2 = controll.dutLengthControl("72.001.110.260.014 45");
		assertFalse(test2);

		boolean test3 = controll.dutLengthControl("72.001.110.2600145");
		assertFalse(test3);

		boolean test4 = controll.dutLengthControl("72.001.110.a60.014");
		assertFalse(test4);

	}

	@Test
	public void auftragcontrollTest() throws InstantiationException, IllegalAccessException, SQLException {
		Controll controll = new Controll();
		boolean test = controll.auftragControl("45.678.932");
		assertTrue(test);

		boolean test2 = controll.auftragControl("014 45.678.932");
		assertFalse(test2);

		boolean test3 = controll.auftragControl("45.6781932");
		assertFalse(test3);

		boolean test4 = controll.auftragControl("45.67a.932");
		assertFalse(test4);

	}

}
