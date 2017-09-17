package com.bd.anis.rony.shredfiles;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.util.Random;

public class ShredDelete {

	public static void secureDelete(File file) throws IOException
	{
		if (file.exists())
		{
			long length = file.length(); //Returns the length, in bytes, of the file denoted by this abstract pathname.
			SecureRandom random = new SecureRandom();
			RandomAccessFile raf = new RandomAccessFile(file, "rws");
			raf.seek(0); //Sets the file-pointer offset, measured in bytes from the beginning of this file, at which the next read or write occurs.

			int size = 99999999;
			if (length < size)
			{
				size = (int) length;
			}
			byte[] data = new byte[size];
			
			for(int pos=0; pos < length; pos += data.length)
			{
				random.nextBytes(data); //Generates random bytes to fill the byte-array supplied as parameter. 
				raf.write(data); //Writes all bytes from the specified byte-array to this file, starting at the current file pointer.
			}
			raf.close();
			file.delete();
		}
	}

	private static boolean wipeDir(File file)
	{
		try
		{

			File[] listOfFiles = file.listFiles();

			for (int i = 0; i < listOfFiles.length; i++)
			{
				if (listOfFiles[i].isFile())
				{
					secureDelete(listOfFiles[i]);
				}
				else if (listOfFiles[i].isDirectory())
				{
					wipeDir(listOfFiles[i]);
					listOfFiles[i].delete();
				}
			}
			file.delete();

		}
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public static boolean shred(String path)
	{
		File file = new File(path);
		if (file.isFile())
		{
			try
			{
				secureDelete(file);
			}
			catch (IOException e)
			{
				return false;
			}
			return true;
		}
		else
		{
			return wipeDir(file);
		}
	}

}
