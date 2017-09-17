package com.bd.anis.rony.files;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.bd.anis.rony.Login;
import com.bd.anis.rony.SignUp;
import com.bd.anis.rony.secureupload.MultipartUtility;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class OnlineBataBaseHandlers {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fss";

	/**
	 * @param args
	 */

	public static boolean isUserLoginSuccess(String username, String password)
	{

		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection(DB_URL, "root", "");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of
			// using "*"
			String query = "SELECT * FROM fss_online_account";

			// create the java statement
			Statement st = (Statement) conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{

				String passwordOnline = rs.getString("password");
				String usernameOnline = rs.getString("username");

				if (username.equals(usernameOnline) && password.equals(passwordOnline))
				{
					return true;
				}

			}

			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;

	}

	public static boolean isUserExistsOnline(String username2)
	{
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection(DB_URL, "root", "");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of
			// using "*"
			String query = "SELECT * FROM fss_online_account";

			// create the java statement
			Statement st = (Statement) conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next())
			{
				String username = rs.getString("username");
				if (username.equals(username2))
				{
					return true;
				}

			}

			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

	public static boolean insertSignUpOnline(String username, String password, String email)
	{

		if (isUserExistsOnline(username))
		{
			return false;
		}

		Connection conn = null;
		Statement stmt = null;

		String directory = username + "_dir";
		;
		try
		{

			Class.forName("com.mysql.jdbc.Driver");

			conn = (Connection) DriverManager.getConnection(DB_URL, "root", "");

			stmt = (Statement) conn.createStatement();

			String sql = "INSERT INTO `fss_online_account` (`username`, `password`, `email`, `directory`) VALUES ('"
					+ username + "', '" + password + "', '" + email + "', '" + directory + "');";
			stmt.executeUpdate(sql);
			conn.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return true;
	}

	// public static void main(String[] args) {
	//
	//
	// boolean siSignUp = insertSignUpOnline("user2", "pass", "email");
	//
	// System.out.println(siSignUp);
	// }

}
