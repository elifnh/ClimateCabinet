package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DbConnection {
	static Connection conn;
	String dburl = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11414578";
	String user = "sql11414578";
	String pass = "p9wR8la6t4";

	public static void main(String args[]) throws InstantiationException, IllegalAccessException, SQLException {
		DbConnection dbConn = new DbConnection();
		dbConn.connect();
	}

	public Connection connect() throws InstantiationException, IllegalAccessException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Database is connected");
			conn = DriverManager
					.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/?user=sql11414578&password=p9wR8la6t4");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return conn;
	}

	public static final int MYSQL_DUPLICATE_PK = 1062;

	public String addUser(String name, String surname, String password, int personalNumber, String role, String status)
			throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			String sorgu = String.format("insert into user values( '%s', '%s','%s', '%s', '%s', '%s')", name, surname,
					password, personalNumber, role, status);
			int ekleme = stmt.executeUpdate(sorgu);

		} catch (SQLException e) {
			if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {

				String error = "Duplikate";
				return error;
			}
			System.out.println(e);
		}
		return "ist angemeldet";

	}

	public boolean controlInformation(String userPersonalNumber, String userPass)
			throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt
					.executeQuery("select password from user where personalNumber = '" + userPersonalNumber + "'");
			rs.next();
			return userPass.equals(rs.getString(1));
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	String[] infos = new String[5];

	public String[] autoComplete(int personalnumber)
			throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt
					.executeQuery("select name,surname,password,role,status from user where personalNumber = '"
							+ personalnumber + "'");
			rs.next();
			if (rs.getString(1) != null) {
				infos[0] = rs.getString("name");
				infos[1] = rs.getString("surname");
				infos[2] = rs.getString("password");
				infos[3] = rs.getString("role");
				infos[4] = rs.getString("status");

				return infos;

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return infos;

	}

	public void changeInfos(String name, String surname, int personalnumber, String password, String role,
			String status) throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			int rs = stmt.executeUpdate(
					"update user set name='" + name + "',surname='" + surname + "',password='" + password + "',role='"
							+ role + "',status='" + status + "'  where personalNumber = '" + personalnumber + "'");

			if (rs == 0) {
				JOptionPane.showMessageDialog(null, "Es veraenderte sich nicht");
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public boolean isRegistered(int personalnumber)
			throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt
					.executeQuery("select personalNumber from user where personalNumber = '" + personalnumber + "'");
			rs.next();

			if (rs.getString(1) == null) {
				return false;
			}
			System.out.println(String.valueOf(personalnumber).equals((rs.getString(1))));
			return String.valueOf(personalnumber).equals((rs.getString(1)));
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;

	}

	public boolean isAdmin(String acceptedPersonalNumber, String acceptedPass)
			throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select role from user where personalNumber ='" + acceptedPersonalNumber + "'");
			rs.next();
			return "admin".equals(rs.getString(1));
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	public int controlClimateCabinet() throws InstantiationException, IllegalAccessException, SQLException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt.executeQuery("select count(id) from climateCabinet where functionalStatus= 'active' ");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return 0;
	}

	public ArrayList<Integer> schrankAuswahl() throws InstantiationException, IllegalAccessException, SQLException {
		ArrayList<Integer> climateCab = new ArrayList<Integer>();
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt.executeQuery("select id from climateCabinet where functionalStatus= 'active' ");

			while (rs.next()) {
				climateCab.add(rs.getInt("id"));
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return climateCab;
	}

	public boolean controlSetup(String dutId, String orderNumberr)
			throws InstantiationException, IllegalAccessException, SQLException {

		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}
		String a = "";
		String b = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt.executeQuery("select dutId from dut where dutId= '" + dutId + "'");
			if (rs.next()) {
				a = rs.getString(1);
			}

			ResultSet rset = stmt
					.executeQuery("select orderNumber from orderOfSlots where orderNumber= '" + orderNumberr + "'");
			if (rset.next()) {
				b = rset.getString(1);

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return a.equals(dutId) && b.equals(orderNumberr);
	}

	public String istGeprüft(String slotNumber)
			throws SQLException, InterruptedException, InstantiationException, IllegalAccessException {
		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("use sql11414578");
			PreparedStatement ps = null;
			ps = (PreparedStatement) conn.prepareStatement("SELECT * FROM slot WHERE slotNumber = ?");
			ps.setString(1, slotNumber);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return "OK";
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return "NOK";
	}

	public boolean isRegisteredSlot(String slotNumber)
			throws InstantiationException, IllegalAccessException, SQLException {

		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt.executeQuery("select slotNumber from slot where slotNumber = '" + slotNumber + "'");
			rs.next();
			if (rs.getString(1) == null) {
				return false;
			}

			return slotNumber.equals(rs.getString(1));
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean isRegisteredDut(String dutId) throws InstantiationException, IllegalAccessException, SQLException {

		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			ResultSet rs = stmt.executeQuery("select dutId from dut where dutId = '" + dutId + "'");
			rs.next();
			if (rs.getString(1) == null) {
				return false;
			}

			return dutId.equals(rs.getString(1));
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean addDutToDb(String pruflingNummer)
			throws InstantiationException, IllegalAccessException, SQLException {

		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			PreparedStatement pstmt = (PreparedStatement) conn
					.prepareStatement("insert into dut values( ?,'active',NULL)");
			pstmt.setString(1, pruflingNummer);
			int rs = pstmt.executeUpdate();

			if (rs == 0) {
				return false;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return true;

	}

	public boolean addOrderToDb(String auftragsnummer)
			throws InstantiationException, IllegalAccessException, SQLException {

		if (conn == null) {
			System.out.println("Database isn't connected, is connecting... Wait!");
			connect();
		}

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("use sql11414578");
			PreparedStatement pstmt = (PreparedStatement) conn
					.prepareStatement("insert into orderOfSlots values( ?,DEFAULT,NULL)");
			pstmt.setString(1, auftragsnummer);
			int rs = pstmt.executeUpdate();

			if (rs == 0) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return true;

	}

}
