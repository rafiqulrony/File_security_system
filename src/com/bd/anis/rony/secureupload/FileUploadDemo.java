package com.bd.anis.rony.secureupload;

import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;
import java.io.IOException;
 
public class FileUploadDemo {
    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;
 
        try {
            client.connect("ftp.byethost15.com");
            client.login("b15_15403403", "25122512");
           
 
            //
            // Create an InputStream of the file to be uploaded
            //
            String filename = "D:/a.b";
            
            fis = new FileInputStream(filename);
 
            //
            // Store file to server
            //
            client.storeFile(filename, fis);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
