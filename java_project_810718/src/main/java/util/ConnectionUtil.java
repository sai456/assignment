package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/reno_db", "root", "R$e$n$O/222");
		return con;
	}

	public static Boolean closeConAndStatmnt(Connection con, PreparedStatement stmnt) {
		boolean confirmation = true;
		try {
			con.close();
			stmnt.close();
		} catch (SQLException e) {
			confirmation = false;
		}
		return confirmation;
	}

	public static Boolean closeConAndStatmntAndResultset(Connection con, PreparedStatement stmnt, ResultSet rs) {
		boolean confirmation = true;
		try {
			con.close();
			stmnt.close();
			rs.close();
		} catch (SQLException e) {
			confirmation = false;
		}
		return confirmation;
	}
}
