//import packages for file handling.
package com.bd.anis.rony.encryptfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//import package for the cryptography
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import com.bd.anis.rony.methods.ProjectMethods;
/*
steps: Encryption
* 1.Get the file from user and create a file for putting the encrypted data. let the name be .enc extension
* 2.Generate a key to encrypt. I use My name as key here.Key must be in bytes so use getBytes() and store in Byte variable k.
* 3.SecretKeySpec is a predefined class that construct the key which we geneated in above step. We use DES algorithm here. It is Data Encryption Standard
* 4.Create a variable for Cipher class . Inorder to do we must get the getInstance to specigy for wch algorithm we create the Cipher Obj
* 5.Then initialise the cipher with the method variable_u_used.init(Cipher.ENCRYPT_MODE,Key). ENCRYPT_MODE is a static const used to initialise cipher to encryption mode.
* 6.A CipherOutputStream is composed of an OutputStream and a Cipher so that write() methods first process the data before writing them out to the underlying OutputStream. 
    The cipher must be fully initialised before being used by a CipherOutputStream.
* 7.Read the data in file as bytes and CipherOutputStream will process it before writing it into file.

* Decryption is the Reserve Process.
*/

import net.lingala.zip4j.exception.ZipException;

public class FileEncryption {

	private String algorithm;
	private File file;

	public FileEncryption(String algorithm, String path, boolean directory) throws ZipException
	{
		this.algorithm = algorithm;
		if (directory)
			path = ProjectMethods.ZipFolderWithOutPassword(path);
		file = new File(path);

	}

	public void encrypt() throws Exception
	{

		FileInputStream fis = new FileInputStream(file); // A FileInputStream
															// obtains input
															// bytes from a
															// file.
		file = new File(file.getAbsolutePath() + ".enc");
		FileOutputStream fos = new FileOutputStream(file); // A file output
															// stream is an
															// output stream for
															// writing data to a
															// File or to a
															// FileDescriptor.

		// generating key
		byte k[] = "Aparajit".getBytes(); // Encodes this String into a sequence
											// of bytes using the platform's
											// default charset, storing the
											// result into a new byte array.
		SecretKeySpec key = new SecretKeySpec(k, "DES"); // Constructs a secret
															// key from the
															// given byte array.

		// creating and initialising cipher and cipher streams
		Cipher encrypt = Cipher.getInstance(algorithm); // Returns a Cipher
														// object that
														// implements the
														// specified
														// transformation
														// parameter.
		encrypt.init(Cipher.ENCRYPT_MODE, key); // Initialises this cipher with
												// a key.
		CipherOutputStream cout = new CipherOutputStream(fos, encrypt); //Constructs a CipherOutputStream from an OutputStream and a Cipher.

		byte[] buf = new byte[1024]; // the buffer into which the data is read.
		int read;

		while ((read = fis.read(buf)) != -1) // Reads up to buf.length bytes of
												// data from this input stream
												// into an array of bytes. Returns the
												// total number of bytes read
												// into the buffer buf, or -1 if
												// there is no more data because
												// the EOF has been reached.
			cout.write(buf, 0, read); // Writes 'read' number of bytes from the
										// specified byte array starting at
										// specified offset (here, 0) to this output stream.
		// closing streams
		fis.close();
		cout.flush();
		cout.close();
	}

	public void decrypt() throws Exception
	{
		// opening streams
		FileInputStream fis = new FileInputStream(file);
		file = new File(file.getAbsolutePath() + ".dec");
		FileOutputStream fos = new FileOutputStream(file);

		// generating same key
		byte k[] = "Aparajit".getBytes();
		SecretKeySpec key = new SecretKeySpec(k, "DES");

		// creating and initialising cipher and cipher streams
		Cipher decrypt = Cipher.getInstance(algorithm);
		decrypt.init(Cipher.DECRYPT_MODE, key);
		CipherInputStream cin = new CipherInputStream(fis, decrypt);

		byte[] buf = new byte[1024];
		int read = 0;

		while ((read = cin.read(buf)) != -1) // reading encrypted data
			fos.write(buf, 0, read); // writing decrypted data

		// closing streams
		cin.close();
		fos.flush();
		fos.close();
	}

}

/*
 * This program provides the following cryptographic functionalities along file
 * handling 1. Encryption using DES 2. Decryption using DES
 * 
 * The following modes of DES encryption are supported by SUNJce provider 1. ECB
 * (Electronic code Book) - Every plaintext block is encrypted separately 2. CBC
 * (Cipher Block Chaining) - Every plaintext block is XORed with the previous
 * ciphertext block 3. PCBC (Propogating Cipher Block Chaining) - 4. CFB (Cipher
 * Feedback Mode) - The previous ciphertext block is encrypted and this
 * enciphered block is XORed with the plaintext block to produce the
 * corresponding ciphertext block 5. OFB (Output Feedback Mode) -
 *
 * High Level Algorithm : 1. Generate a DES key 2. Create the Cipher (Specify
 * the Mode and Padding) 3. To Encrypt : Initialize the Cipher for Encryption 4.
 * To Decrypt : Initialize the Cipher for Decryption
 * 
 * Need for Padding : Block ciphers operates on data blocks on fixed size n.
 * Since the data to be encrypted might not always be a multiple of n, the
 * remainder of the bits are padded. PKCS#5 Padding is what will be used in this
 * program
 *
 * Needed for CryptoFileHandling 1.CipherInputStream 2.CipherOutputStream
 */
// (c)www.papervisions.com
