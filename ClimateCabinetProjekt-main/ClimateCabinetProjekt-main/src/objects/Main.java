package objects;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.DbConnection;
import loginregister.Login;
import loginregister.CabinetSelection;

public class Main {

	public static PrintStream toCabinet;
	public static BufferedReader fromCabinet;
	public static Socket socket;

	public static void main(String[] args) throws HeadlessException, InstantiationException, IllegalAccessException,
			SQLException, InterruptedException {
		connect2Cabinet();
		Login login = new Login();

		DbConnection connection = new DbConnection();
		if (connection.controlClimateCabinet() > 1) {
			CabinetSelection scrankAuswahl = new CabinetSelection();
			scrankAuswahl.Auswahl();
			scrankAuswahl.setVisible(true);
		} else if (connection.controlClimateCabinet() == 1) {
			login.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "There is no climatecabinet");
		}
	}

	private static void connect2Cabinet() {
		try {
			int port = 3141;
			socket = new Socket("localhost", port);
			toCabinet = new PrintStream(socket.getOutputStream(), true);
			fromCabinet = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}