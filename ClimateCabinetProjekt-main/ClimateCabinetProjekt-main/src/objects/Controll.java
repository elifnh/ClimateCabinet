package objects;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author bikem
 */
public class Controll {

	boolean isOkey = true;

	public boolean lengthControl(String tracking) {

		if (tracking.length() == 29) {

			for (int i = 0; i < 29; i++) {
				if (i == 2 || i == 6 || i == 10 || i == 14 || i == 18 || i == 21 || i == 25) {
					if (tracking.charAt(2) != '.' || tracking.charAt(6) != '.' || tracking.charAt(10) != '.'
							|| tracking.charAt(14) != '.' || tracking.charAt(18) != ' ' || tracking.charAt(21) != '.'
							|| tracking.charAt(25) != '.') {

						JOptionPane.showMessageDialog(null, "falsche Eingabe (**.***.***.***.*** **.***.***)");
						isOkey = false;
					}
				} else {
					if (Character.isDigit(tracking.charAt(i)) == false) {
						JOptionPane.showMessageDialog(null, "falsche Eingabe (Bitte geben Sie nur Zahlen ein)");
						isOkey = false;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "falsche Eingabe (Laenge muss 29 sein!)");
			isOkey = false;
		}

		return isOkey;
	}

	public boolean slotLengthControl(String slot, String rowTh) {

		if (slot.length() == 8) {
			rowTh = Character.toString(slot.charAt(6)) + Character.toString(slot.charAt(7));
			if (!(Integer.parseInt(rowTh) <= 20 && Integer.parseInt(rowTh) > 0)) {
				JOptionPane.showMessageDialog(null, "Sie haben das Slot-Limit überschritten!", "fail",
						JOptionPane.ERROR_MESSAGE);
				isOkey = false;
			}

		} else {
			JOptionPane.showMessageDialog(null, "falsche Eingabe (Slot_0**)", "fail", JOptionPane.ERROR_MESSAGE);
			isOkey = false;
		}

		return isOkey;
	}

	public boolean dutLengthControl(String dut) {

		dut = dut.trim();

		if (dut.length() == 18) {

			for (int i = 0; i < 18; i++) {
				if (i == 2 || i == 6 || i == 10 || i == 14 || i == 18) {
					if (dut.charAt(2) != '.' || dut.charAt(6) != '.' || dut.charAt(10) != '.'
							|| dut.charAt(14) != '.') {

						JOptionPane.showMessageDialog(null, "falsche Eingabe (**.***.***.***.***)");
						isOkey = false;
					}
				} else {
					if (Character.isDigit(dut.charAt(i)) == false) {
						JOptionPane.showMessageDialog(null, "falsche Eingabe (Bitte geben Sie nur Zahlen ein)");
						isOkey = false;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "falsche Eingabe (Laenge muss 18 sein!)");
			isOkey = false;
		}

		return isOkey;

	}

	public boolean auftragControl(String auftrag) {
		auftrag = auftrag.trim();

		if (auftrag.length() == 10) {

			for (int i = 0; i < 10; i++) {
				if (i == 2 || i == 6) {
					if (auftrag.charAt(2) != '.' || auftrag.charAt(6) != '.') {

						JOptionPane.showMessageDialog(null, "falsche Eingabe (**.***.***)");
						isOkey = false;
					}
				} else {
					if (Character.isDigit(auftrag.charAt(i)) == false) {
						JOptionPane.showMessageDialog(null, "falsche Eingabe (Bitte geben Sie nur Zahlen ein)");
						isOkey = false;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "falsche Eingabe (Laenge muss 10 sein!)");
			isOkey = false;
		}

		return isOkey;
	}

}
