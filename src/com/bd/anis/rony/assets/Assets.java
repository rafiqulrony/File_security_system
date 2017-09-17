package com.bd.anis.rony.assets;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class Assets {
	public static String password = "ns^&%&^t7g&T^&r^&F67^%";
	public static String CUSTOM_DIVIDER = "---...---...custom3";
	public static String ADDRESS_DIVIDER = "---...---...address";
	public static String WALLET_PRIFIX = "anisrony";
	static
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("files/status.ini"));
			password = reader.readLine();
			reader.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Your security has broken. reinstall this and restore backup file");
			System.exit(0);
		}

	}
}
