package com.bd.anis.rony.methods;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.util.Random;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ProjectMethods {
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    public static String getFilePathWithOutExtension(File file) throws IOException {
        String fileName = file.getAbsolutePath();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
        	String temp = fileName.substring(fileName.lastIndexOf(".")+1);
        	return file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-temp.length()-1);
        }
        else return file.getAbsolutePath();
    }


	
	public static void secureDelete(File file) throws IOException {
		if (file.exists()) {
			long length = file.length();
			SecureRandom random = new SecureRandom();
			RandomAccessFile raf = new RandomAccessFile(file, "rws");
			raf.seek(0);
			raf.getFilePointer();
			int size = 99999999;
			if(length<size){
				size = (int)length;
			}
  		    byte[] data = new byte[size];
			int pos = 0;
			while (pos < length) {
				random.nextBytes(data);
				raf.write(data);
				pos += data.length;
			}
			raf.close();
			file.delete();
		}
	}
	 
    private static boolean wipeDir(File file) {  
        try {  
        	
        	File[] listOfFiles = file.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
              if (listOfFiles[i].isFile()) {
            	  secureDelete(listOfFiles[i]);  
              } else if (listOfFiles[i].isDirectory()) {
                wipeDir(listOfFiles[i]);
                listOfFiles[i].delete();
              }
            }
            file.delete();  
  
        } catch(Exception e) {  
        	return false;
        }  
        return true;
    }
    
	public static boolean shred(String path) {
		File file = new File(path);
		if(file.isFile()){
			try {
				secureDelete(file);
			} catch (IOException e) {
				return false;
			}
			return true;
		}
		else {
			return wipeDir(file);
		}
	}

	  public static String ZipFolderWithOutPassword(String folderName) {  
		  String zipFileName = folderName;
		  int index = 393;
	        try {

	            // Initiate ZipFile object with the path/name of the zip file.
	            
	        	File ff = new File(zipFileName+index+".zip");
	            while(ff.exists()) {
	            	//ff.deleteOnExit();
	            	index++;
	            	ff = new File(zipFileName+index+".zip");
	            }
	            ZipFile zipFile = new ZipFile(zipFileName+index+".zip");
	           
	            // Initiate Zip Parameters which define various properties such
	            // as compression method, etc.
	            ZipParameters parameters = new ZipParameters();
	           
	            // set compression method to store compression
	            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
	           
	            // Set the compression level
	            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
	           
	            /**
	             * whether the root folder need to zip
	             */
	            parameters.setIncludeRootFolder(false);
	            // Add folder to the zip file
	            zipFile.addFolder(new File(folderName), parameters);
	           
	        } catch (ZipException e) {
	            e.printStackTrace();
	        }
			return zipFileName+index+".zip";
	    }
	  
	  
}
