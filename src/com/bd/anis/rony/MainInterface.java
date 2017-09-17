package com.bd.anis.rony;

import com.bd.anis.rony.files.FileHandlers;

public class MainInterface {

	public MainInterface()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (!FileHandlers.isPasswordSet())
			SignUp.signUpMethod();
		else
			Login.loginMethod();
	}
}
