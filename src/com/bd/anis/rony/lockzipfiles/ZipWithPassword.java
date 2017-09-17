package com.bd.anis.rony.lockzipfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.bd.anis.rony.methods.ProjectMethods;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 * <p>
 * we depend on the <code>zip4j</code> to implement the zip and unzip with specific password.
 * <pre>http://www.lingala.net/zip4j/download.php</pre>
 * </p>
 * @author dan
 * @version 1.0
 */
public class ZipWithPassword {
    public static boolean ZipFolderWithPaasword(String folderName,String password) {      
    	String zipFileName = folderName;
    	
        try {
        	
            // Initiate ZipFile object with the path/name of the zip file.
        	ZipFile zipFile = new ZipFile(zipFileName+".zip");
        	int index = 0;
        	File ff = new File(zipFileName+".zip");
            while(ff.exists()) {
            	index++;
            	ff = new File(zipFileName+"_"+index+".zip");
            }
            if(index != 0){
            	zipFile = new ZipFile(zipFileName+"_"+index+".zip");
            }
            
           
            // Initiate Zip Parameters which define various properties such
            // as compression method, etc.
            ZipParameters parameters = new ZipParameters();
           
            // set compression method to store compression
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
           
            // Set the compression level
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
           
            if (password!=null) {  
                parameters.setEncryptFiles(true);  
                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
                parameters.setPassword(password);  
            }
            /**
             * whether the root folder need to zip
             */
            parameters.setIncludeRootFolder(false);
            // Add folder to the zip file
            zipFile.addFolder(new File(folderName), parameters);
            ProjectMethods.shred(folderName);
           
        } catch (ZipException e) {
            return false;
        }
        return true;
    }
   
  
    public static boolean unzipToFolderWithPassword(String zipFile, String password) throws ZipException, IOException {
    	String dest = ProjectMethods.getFilePathWithOutExtension(new File(zipFile));
    	int index = 0;
	  try {
	        ZipFile zFile = new ZipFile(zipFile);
	        if (!zFile.isValidZipFile()) {  
	            throw new ZipException("this is an broken zip file.");  
	        }  
	        File destDir = new File(dest);  
	        while(destDir.exists()){
	        	index++;
	        	destDir = new File(dest+"_"+index); 
	        }
	        if(index != 0){
	        	dest = dest+"_"+index;
	        	destDir = new File(dest);  
	        }
	        else {
	        	destDir = new File(dest);
	        }
	        if (zFile.isEncrypted()) {  
	        	zFile.setPassword(password);
	        }  
	        zFile.extractAll(dest);
	        ProjectMethods.shred(zipFile);
	        return true;
		} catch (Exception e) {
			System.out.println("no pass");
			return false;
		}
    }


	public static boolean ZipFile(String FilePath, String password) throws IOException {

		int index = 0;
		String FileName = new File(FilePath).getName();
		String FilepathMain = FilePath;
		FilePath = ProjectMethods.getFilePathWithOutExtension(new File(FilePath));
		File Dir = new File(FilePath);
        while (Dir.isDirectory() && Dir.exists()) { 
        	index++;
        	Dir = new File(FilePath+"_"+index);
        }
        Dir.mkdir();
        new File(FilepathMain).renameTo(new File(Dir+"/"+FileName));
        ZipFolderWithPaasword(Dir.getAbsolutePath(), password);
		return true;
	}
}