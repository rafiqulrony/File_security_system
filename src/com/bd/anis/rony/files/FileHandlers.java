/**
 * 
 */
package com.bd.anis.rony.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author ANIS
 *
 */
public class FileHandlers {

	/**
	 * 
	 */
	public FileHandlers() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	public static boolean isPasswordSet(){
		File file = new File("files/status.ini");
		
		if(file.exists()){
			return true;
		}
		return false;
	}
	public static boolean passWordCreate(){
		File file = new File("files/status.ini");
		try {
			return file.createNewFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return false;
	}
	public static void passWordSave(String username, String password) {

		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("files/status.ini"));
			bw.append(username+"\n"+password);
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String[] getAuthenticationInformations(){
		String[] auth = new String[2];
		BufferedReader br;
		try {
			
			br = new BufferedReader(new FileReader("files/status.ini"));
			String line = "";
			auth[0] = line=br.readLine();
			auth[1] = line=br.readLine();
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auth;
	}
	
//	public static void main(String[] args) {
//
//		while(!isPasswordSet()){
//			passWordCreate();
//			passWordSave();
//		}
//		
//		
//		String[] userpass = getAuthenticationInformations();
//		System.out.println(userpass[0]+" "+userpass[1]);
//	}



}
