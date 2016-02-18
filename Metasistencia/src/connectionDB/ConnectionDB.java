package connectionDB;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {	

	public static Connection getConnection() {
		try {
			Properties props = new Properties();
			FileInputStream fis = null;
			Connection con = null;

			fis = new FileInputStream("db.properties");
			props.load(fis);

			String DRIVER_NAME = props.getProperty("DB_DRIVER_CLASS");
			String DB_URL = props.getProperty("DB_URL");
			String DB_NAME = props.getProperty("DB_NAME");
			String DB_USERNAME = props.getProperty("DB_USERNAME");
			String DB_PASSWORD = props.getProperty("DB_PASSWORD");
			
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DB_URL+DB_NAME, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}

