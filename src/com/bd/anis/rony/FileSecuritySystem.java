package com.bd.anis.rony;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;


import com.bd.anis.rony.encryptfiles.EncryptFiles;
import com.bd.anis.rony.helpandsupport.HelpAndSupport;
import com.bd.anis.rony.lockzipfiles.LockZipFiles;
import com.bd.anis.rony.makewallets.MakeWallets;
import com.bd.anis.rony.makewallets.Wallets;
import com.bd.anis.rony.securebackup.SecureBackup;
import com.bd.anis.rony.shredfiles.ShredFiles;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class FileSecuritySystem extends JFrame {

	private JPanel contentPane;
	JPanel lockFiles;
	JPanel encryptFiles;
	JPanel secureBackup;
	JPanel makeWallet;
	JPanel helpAndSupport;
	JPanel shredFiles;
	Image iconMainImage = Toolkit.getDefaultToolkit().getImage("raw/mainicon.png");
	ImageIcon iconFileLock = new ImageIcon("raw/filelock.png");
	ImageIcon iconEncryptFile = new ImageIcon("raw/encryptfile.png");
	ImageIcon iconSecureBackup = new ImageIcon("raw/securebackup.png");
	ImageIcon iconProtectUSB = new ImageIcon("raw/protectusb.png");
	ImageIcon iconMakeWallet = new ImageIcon("raw/makewallet.png");
	ImageIcon iconShredFile = new ImageIcon("raw/shredfile.png");
	ImageIcon iconCleanHistory = new ImageIcon("raw/cleanhistory.png");
	ImageIcon iconHelpAndSupport = new ImageIcon("raw/helpandsupport.png");
	

	/**
	 * Launch the application.
	 */
	public static void systemRunning() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileSecuritySystem frame = new FileSecuritySystem("anis.rony");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileSecuritySystem(String passKey) {
		if(!passKey.equals("anis.rony")){
			System.exit(0);
		}
		setTitle("File Security System");
		setBackground(Color.GRAY);
		setIconImage(iconMainImage);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 600);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLock = new JMenuItem("Lock Files");
		mntmLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lockFiles.setVisible(true);
			}
		});
		mnFile.add(mntmLock);
		
		JMenuItem mntmEncrypt = new JMenuItem("Encrypt Files");
		mntmEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				encryptFiles.setVisible(true);
			}
		});
		mnFile.add(mntmEncrypt);
		
		JMenuItem mntmBackup = new JMenuItem("Secure Backup");
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secureBackup.setVisible(true);
			}
		});
		mnFile.add(mntmBackup);
		
		JMenuItem mntmWallet = new JMenuItem("Wallet");
		mntmWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeWallet.setVisible(true);
			}
		});
		mnFile.add(mntmWallet);
		
		JMenuItem mntmShred = new JMenuItem("Shred");
		mntmShred.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shredFiles.setVisible(true);
			}
		});
		mnFile.add(mntmShred);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpAndSupport = new JMenuItem("About FSS");
		mntmHelpAndSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				try {
					File file = new File("help/about.doc");
					String filePath = file.getAbsolutePath();
					System.out.println(filePath);
					String cmds[] = new String[] {"cmd", "/c", filePath};
					Process process = Runtime.getRuntime().exec( cmds );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
				
			}
		});
		mnHelp.add(mntmHelpAndSupport);
		
		JMenuItem mntmAbout = new JMenuItem("Help and Support");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					File file = new File("help/manual.doc");
					String filePath = file.getAbsolutePath();
					System.out.println(filePath);
					String cmds[] = new String[] {"cmd", "/c", filePath};
					Process process = Runtime.getRuntime().exec( cmds );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		mnHelp.add(mntmAbout);
		
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
		);
		
		lockFiles = new LockZipFiles();
		tabbedPane.addTab(null, iconFileLock, lockFiles, "File Lock");
		
		
		encryptFiles = new EncryptFiles();
		encryptFiles.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab(null, iconEncryptFile, encryptFiles, "Encrypt Files");
		
		secureBackup = new SecureBackup();
		secureBackup.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab(null, iconSecureBackup, secureBackup, "Security Backup");
		
		makeWallet = new MakeWallets();
		//JPanel makeWallet = new JPanel();
		tabbedPane.addTab(null, iconMakeWallet, makeWallet, "Make Wallets");
		
		shredFiles = new ShredFiles();
		tabbedPane.addTab(null, iconShredFile, shredFiles, "Shred Files");
		helpAndSupport = new HelpAndSupport();
		tabbedPane.addTab(null, iconHelpAndSupport, helpAndSupport, "Help And Support");
		contentPane.setLayout(gl_contentPane);
	}
}
