package com.bd.anis.rony.makewallets;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JSeparator;

import com.bd.anis.rony.assets.Assets;
import com.bd.anis.rony.methods.ProjectMethods;

public class MakeWallets extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	ImageIcon createwalletButtonIcon = new ImageIcon("raw/createwalletbutton.png");
	ImageIcon createwalletButtonIcon1 = new ImageIcon("raw/createwalletbutton1.png");
	ImageIcon openwalletButtonIcon = new ImageIcon("raw/openwalletbutton.png");
	ImageIcon openwalletButtonIcon1 = new ImageIcon("raw/openwalletbutton1.png");
	ImageIcon editwalletButtonIcon1 = new ImageIcon("raw/editwalletbutton1.png");
	ImageIcon editwalletButtonIcon = new ImageIcon("raw/editwalletbutton.png");
	ImageIcon copywalletButtonIcon = new ImageIcon("raw/copywalletbutton.png");
	ImageIcon copywalletButtonIcon1 = new ImageIcon("raw/copywalletbutton1.png");
	ImageIcon deletewalletButtonIcon = new ImageIcon("raw/deletewalletbutton.png");
	ImageIcon deletewalletButtonIcon1 = new ImageIcon("raw/deletewalletbutton1.png");
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/bg.png");
	String[] columnNames = {"Wallets"};
	private JTextField textBankName;
	private JTextField textAccNo;
	private JTextField textAccHolder;
	private JTextField textEmail;
	private JTextField textPIN;
	private JTextField textFatherName;
	private JTextField textMotherName;
	private JTextField textNickName;
	private JTextField textRoutingNo;
	private JTextField textSwiftCode;
	private JTextField textSortCode;
	private JTextField textPIN2;
	private JTextField textURL;
	private JTextField textCustom1;
	private JTextField textCustom2;
	
		Wallets wallets[];
		Object[][] data;
	   JPanel headerMakeWallets;
	   JPanel centerMakeWallets;
	   
	   JLabel lblBankName, labelBankName;
	   JLabel lblAccountNo;
	   JLabel labelAccountHolder, lblAccHolder, lblAccountHolder;
	   JLabel lblEmail_1;
	   JLabel lblPin;
	   JLabel lblFatherName;
	   JLabel lblNicename;
	   JLabel lblAddress ;
	   final JTextArea textAddress;
	   JLabel lblAbaroutingNo;
	   JLabel lblPin_1;
	   JLabel lblUrl;
	   JLabel lblCustom;
	   JLabel lblCustom_1 ;
	   JLabel lblCustom_2 ;
	   JLabel lblSwiftCode;
	   JLabel lblSortCode;
	   JTextArea textCustom3;
	   JButton btnSaveWallet;
	   JLabel labelBankNam;
	   JLabel lblBankAccountNo;
	   JLabel labelBankAccName;
	   JLabel lblEmail;
	   JLabel labelEmail;
	   JLabel labelAccHolder;
	   JLabel lblAccType;
	   JLabel lblAccPin;
	   JLabel labelAccType;
	   JLabel LabelAccPIN;
	   JTextPane txtpnSdfs;
		File file ;
	/**
	 * Create the panel.
	 */
	public MakeWallets() {
		setLayout(null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 155, 422);
		add(scrollPane);
		
		JButton createwalletButton = new JButton("C");
		createwalletButton.setToolTipText("Create Wallet");
		createwalletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					int i = 0;

	              	headerMakeWallets.setVisible(true);
	                centerMakeWallets.setVisible(true);
	                
	                String tempString = "";
	                File tempFile = new File("wallets/"+Assets.WALLET_PRIFIX+0+".txt");
	                while(tempFile.exists()){
	                	i++;
	                	tempFile = new File("wallets/"+Assets.WALLET_PRIFIX+i+".txt");
	                }

	                try {
						BufferedReader tempRe = new BufferedReader(new FileReader("demos/demowallet.txt"));
						BufferedWriter tempWr = new BufferedWriter(new FileWriter(tempFile.toString()));
						String line = "";
						tempWr.write("");
						while((line=tempRe.readLine())!=null){
							tempWr.append(line+"\n");
						}
						tempRe.close();
						tempWr.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
	                

	                file = new File("wallets");
	                File[] listOfFiles = file.listFiles();
	        		int len = listOfFiles.length;
	        		wallets = new Wallets[len];
	        		data = new Object[len][1];
	                for (i = 0; i < len; i++) {
	                    if (listOfFiles[i].isFile()) { 
	        				try {
	        	    			BufferedReader re = new BufferedReader(new FileReader(listOfFiles[i].getAbsolutePath()));
	        	    			wallets[i] = new Wallets();
	        	    			wallets[i].bankName = re.readLine();
	        	    			wallets[i].accountNo = re.readLine();
	        	    			wallets[i].accountHolder = re.readLine();
	        	    			wallets[i].accountType = re.readLine();
	        	    			wallets[i].PIN = re.readLine();
	        	    			wallets[i].email = re.readLine();
	        	    			wallets[i].fatherName = re.readLine();
	        	    			wallets[i].motherName = re.readLine();
	        	    			wallets[i].nickName = re.readLine();
	        	    			wallets[i].sortCode = re.readLine();
	        	    			wallets[i].swiftCode = re.readLine();
	        	    			wallets[i].routingNo = re.readLine();
	        	    			wallets[i].PIN2 = re.readLine();
	        	    			wallets[i].uRL = re.readLine();
	        	    			wallets[i].custom1 = re.readLine();
	        	    			wallets[i].custom2 = re.readLine();
	        	    			
	        	    			if(re.readLine().equals(Assets.CUSTOM_DIVIDER)){
	        	    				String tempAddress ="";
	        	    				String address = "";
	        	    				String tempCustom3 ="";
	        	    				String custom3 = "";
	        	    				while((tempCustom3=re.readLine())!=null){
	        	    					if(tempCustom3.equals(Assets.ADDRESS_DIVIDER)){
	        	    						break;
	        	    					}
	        	    					custom3 += tempCustom3+"\n";
	        	    				}
	        	    				wallets[i].custom3 = custom3;
	        	    				
	        	    				while((tempAddress=re.readLine())!=null){
	        	    					address += tempAddress+"\n";
	        	    				}
	        	    				wallets[i].address = address;
	        	    			}
	        	        		data[i][0] = wallets[i].bankName;
	        	        		re.close();
	        				} catch (Exception e1) {
	        					// TODO Auto-generated catch block
	        					e1.printStackTrace();
	        				}
	                    }
	                  }

	        		table = new JTable(data, columnNames){  
	        			  /**
	        			 * 
	        			 */
	        			private static final long serialVersionUID = 1L;

	        			public boolean isCellEditable(int row, int column){  
	        				    return false;  
	        				  }  
	        				}; 
	        		scrollPane.setViewportView(table);
	        		table.setFillsViewportHeight(true);
	        		
	        		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        		    @Override
	        		    public void valueChanged(ListSelectionEvent event) {
	        		        if (table.getSelectedRow() > -1) {
	        		        	int i = table.getSelectedRow();
	        		            labelBankName.setText(wallets[i].bankName);
	        		            labelBankAccName.setText(wallets[i].accountNo);
	        		            labelEmail.setText(wallets[i].email);
	        		            labelAccHolder.setText(wallets[i].accountHolder);
	        		            labelAccType.setText(wallets[i].accountType);
	        		            LabelAccPIN.setText(wallets[i].PIN);
	        		            
	        		            textBankName.setText(wallets[i].bankName);
	        		            textAccNo.setText(wallets[i].accountNo);
	        		            textAccHolder.setText(wallets[i].accountHolder);
	        		            textPIN.setText(wallets[i].PIN);
	        		            textEmail.setText(wallets[i].email);
	        		            textFatherName.setText(wallets[i].fatherName);
	        		            textMotherName.setText(wallets[i].motherName);
	        		            textNickName.setText(wallets[i].nickName);
	        		            textAddress.setText(wallets[i].address);
	        		            textSortCode.setText(wallets[i].sortCode);
	        		            textSwiftCode.setText(wallets[i].swiftCode);
	        		            textRoutingNo.setText(wallets[i].routingNo);
	        		            textPIN2.setText(wallets[i].PIN2);
	        		            textURL.setText(wallets[i].uRL);
	        		            textCustom1.setText(wallets[i].custom1);
	        		            textCustom2.setText(wallets[i].custom2);
	        		            textCustom3.setText(wallets[i].custom3);
	        		            
	        		            headerMakeWallets.setVisible(true);
	        		            centerMakeWallets.setVisible(true);
	        		            
	        		        }
	        		    }
	        		});
	        		
	            
			}
		});
		createwalletButton.setBounds(10, 11, 45, 28);
		add(createwalletButton);
		

		JButton openwalletButton = new JButton("D");
		openwalletButton.setToolTipText("Delete Wallet");
		openwalletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int i;
				int n = table.getSelectedRowCount();
				if(n!=1){
					JOptionPane.showMessageDialog(null, "You must select one wallet to delete");
				}
				else{
					n = table.getSelectedRow();
	              	headerMakeWallets.setVisible(true);
	                centerMakeWallets.setVisible(true);
	                
	                String tempPath = "wallets/anisrony"+n+".txt";
	                File tempFile = new File(tempPath);
	                System.out.println(tempFile);
	                
	                /*
	                String tempPathTo = "trash/anisrony_trash"+n+".txt";
	                File tempFileTo = new File(tempPathTo);
	                System.out.println(tempFileTo);
	                
	                boolean op = tempFile.renameTo(tempFileTo);
	        		System.out.println(op);
	        		tempFileTo.delete();
	        		*/
	        		try {
						Files.delete(Paths.get(tempPath));
					} catch (IOException e2) {
						e2.printStackTrace();
					}
	        		
	        		file = new File("wallets");
	        		File[] files = file.listFiles();
	        		for(i=0 ; i<files.length ;  i++){
	        			if(files[i].isFile()){
	    	                String tempPathToRename = "wallets/anisrony"+i+".txt";
	    	                File tempFileToRename = new File(tempPathToRename);
	    	                System.out.println(tempFileToRename);
	        				files[i].renameTo(tempFileToRename);
	        			}
	        		}

	                file = new File("wallets");
	                File[] listOfFiles = file.listFiles();
	        		int len = listOfFiles.length;
	        		wallets = new Wallets[len];
	        		data = new Object[len][1];
	                for (i = 0; i < len; i++) {
	                    if (listOfFiles[i].isFile()) { 
	        				try {
	        	    			BufferedReader re = new BufferedReader(new FileReader(listOfFiles[i].getAbsolutePath()));
	        	    			wallets[i] = new Wallets();
	        	    			wallets[i].bankName = re.readLine();
	        	    			wallets[i].accountNo = re.readLine();
	        	    			wallets[i].accountHolder = re.readLine();
	        	    			wallets[i].accountType = re.readLine();
	        	    			wallets[i].PIN = re.readLine();
	        	    			wallets[i].email = re.readLine();
	        	    			wallets[i].fatherName = re.readLine();
	        	    			wallets[i].motherName = re.readLine();
	        	    			wallets[i].nickName = re.readLine();
	        	    			wallets[i].sortCode = re.readLine();
	        	    			wallets[i].swiftCode = re.readLine();
	        	    			wallets[i].routingNo = re.readLine();
	        	    			wallets[i].PIN2 = re.readLine();
	        	    			wallets[i].uRL = re.readLine();
	        	    			wallets[i].custom1 = re.readLine();
	        	    			wallets[i].custom2 = re.readLine();
	        	    			
	        	    			if(re.readLine().equals(Assets.CUSTOM_DIVIDER)){
	        	    				String tempAddress ="";
	        	    				String address = "";
	        	    				String tempCustom3 ="";
	        	    				String custom3 = "";
	        	    				while((tempCustom3=re.readLine())!=null){
	        	    					if(tempCustom3.equals(Assets.ADDRESS_DIVIDER)){
	        	    						break;
	        	    					}
	        	    					custom3 += tempCustom3+"\n";
	        	    				}
	        	    				wallets[i].custom3 = custom3;
	        	    				
	        	    				while((tempAddress=re.readLine())!=null){
	        	    					address += tempAddress+"\n";
	        	    				}
	        	    				wallets[i].address = address;
	        	    			}
	        	        		data[i][0] = wallets[i].bankName;
	        	        		re.close();
	        				} catch (Exception e1) {
	        					// TODO Auto-generated catch block
	        					e1.printStackTrace();
	        				}
	                    }
	                  }

	        		table = new JTable(data, columnNames){  
	        			  /**
	        			 * 
	        			 */
	        			private static final long serialVersionUID = 1L;

	        			public boolean isCellEditable(int row, int column){  
	        				    return false;  
	        				  }  
	        				}; 
	        		scrollPane.setViewportView(table);
	        		table.setFillsViewportHeight(true);
	        		
	        		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        		    @Override
	        		    public void valueChanged(ListSelectionEvent event) {
	        		        if (table.getSelectedRow() > -1) {
	        		        	int i = table.getSelectedRow();
	        		            labelBankName.setText(wallets[i].bankName);
	        		            labelBankAccName.setText(wallets[i].accountNo);
	        		            labelEmail.setText(wallets[i].email);
	        		            labelAccHolder.setText(wallets[i].accountHolder);
	        		            labelAccType.setText(wallets[i].accountType);
	        		            LabelAccPIN.setText(wallets[i].PIN);
	        		            
	        		            textBankName.setText(wallets[i].bankName);
	        		            textAccNo.setText(wallets[i].accountNo);
	        		            textAccHolder.setText(wallets[i].accountHolder);
	        		            textPIN.setText(wallets[i].PIN);
	        		            textEmail.setText(wallets[i].email);
	        		            textFatherName.setText(wallets[i].fatherName);
	        		            textMotherName.setText(wallets[i].motherName);
	        		            textNickName.setText(wallets[i].nickName);
	        		            textAddress.setText(wallets[i].address);
	        		            textSortCode.setText(wallets[i].sortCode);
	        		            textSwiftCode.setText(wallets[i].swiftCode);
	        		            textRoutingNo.setText(wallets[i].routingNo);
	        		            textPIN2.setText(wallets[i].PIN2);
	        		            textURL.setText(wallets[i].uRL);
	        		            textCustom1.setText(wallets[i].custom1);
	        		            textCustom2.setText(wallets[i].custom2);
	        		            textCustom3.setText(wallets[i].custom3);
	        		            
	        		            headerMakeWallets.setVisible(true);
	        		            centerMakeWallets.setVisible(true);
	        		            
	        		        }
	        		    }
	        		});
				}

        		
            
		
			}
		});
		openwalletButton.setBounds(65, 11, 45, 28);
		add(openwalletButton);
		
		

		JButton editwalletButton = new JButton("S");
		editwalletButton.setToolTipText("Share");
		editwalletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				int i;
				int n = table.getSelectedRowCount();
				if(n!=1){
					JOptionPane.showMessageDialog(null, "You must select one wallet to delete");
				}
				else{
					n = table.getSelectedRow();
	              	headerMakeWallets.setVisible(true);
	                centerMakeWallets.setVisible(true);
	                String line = "";
	                String details = "";
	                String address = "";
	                String tempPath = "wallets/"+Assets.WALLET_PRIFIX+n+".txt";
	                String walletsText = "";
	               try {
						BufferedReader tempRe = new BufferedReader(new FileReader(tempPath));
		        		walletsText += "Bank Name      : "+tempRe.readLine()+"\n";
		        		walletsText += "Account No     : "+tempRe.readLine()+"\n";
		        		walletsText += "Account Holder : "+tempRe.readLine()+"\n";
		        		walletsText += "Account Type   : "+tempRe.readLine()+"\n";
		        		walletsText += "PIN            : "+tempRe.readLine()+"\n";
		        		walletsText += "Email          : "+tempRe.readLine()+"\n";
		        		walletsText += "Father Name    : "+tempRe.readLine()+"\n";
		        		walletsText += "Mother Name    : "+tempRe.readLine()+"\n";
		        		walletsText += "Nick Name      : "+tempRe.readLine()+"\n";
		        		walletsText += "Sort Code      : "+tempRe.readLine()+"\n";
		        		walletsText += "Swift Code     : "+tempRe.readLine()+"\n";
		        		walletsText += "Routing No     : "+tempRe.readLine()+"\n";
		        		walletsText += "PIN2           : "+tempRe.readLine()+"\n";
		        		walletsText += "URL            : "+tempRe.readLine()+"\n";
		        		walletsText += "\nDetails        : \n----------------\n";
		        		details += tempRe.readLine()+"\n";
		        		details += "---------------------------------------------------------------\n";
		        		details += tempRe.readLine()+"\n";
		        		details += "---------------------------------------------------------------\n";
		        		tempRe.readLine();
		        		while((line=tempRe.readLine())!=null){
		        			if(line.equals(Assets.ADDRESS_DIVIDER)){
		        				break;
		        			}
		        			details += line+"\n";
		        		}
		        		walletsText += details;
		        		
		        		walletsText += "\nAddress        : \n----------------\n";
		        		while((line=tempRe.readLine())!=null){
		        			address += line+"\n";
		        		}
		        		walletsText += address;
		        		
//		        		boolean op =  SendWallet.sendWallet(walletsText);
		        		
		        		tempRe.close();
		        		EmailForm emailForm = new EmailForm(walletsText);
		        		emailForm.setVisible(true);
		        		
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		editwalletButton.setBounds(120, 11, 45, 28);
		add(editwalletButton);
		
		file = new File("wallets");
		File[] listOfFiles = file.listFiles();
		int i=0;
		int len = listOfFiles.length;
		wallets = new Wallets[len];
		data = new Object[len][1];
        for (i = 0; i < len; i++) {
            if (listOfFiles[i].isFile()) { 
				try {
	    			BufferedReader re = new BufferedReader(new FileReader(listOfFiles[i].getAbsolutePath()));
	    			wallets[i] = new Wallets();
	    			wallets[i].bankName = re.readLine();
	    			wallets[i].accountNo = re.readLine();
	    			wallets[i].accountHolder = re.readLine();
	    			wallets[i].accountType = re.readLine();
	    			wallets[i].PIN = re.readLine();
	    			wallets[i].email = re.readLine();
	    			wallets[i].fatherName = re.readLine();
	    			wallets[i].motherName = re.readLine();
	    			wallets[i].nickName = re.readLine();
	    			wallets[i].sortCode = re.readLine();
	    			wallets[i].swiftCode = re.readLine();
	    			wallets[i].routingNo = re.readLine();
	    			wallets[i].PIN2 = re.readLine();
	    			wallets[i].uRL = re.readLine();
	    			wallets[i].custom1 = re.readLine();
	    			wallets[i].custom2 = re.readLine();
	    			
	    			if(re.readLine().equals(Assets.CUSTOM_DIVIDER)){
	    				String tempAddress ="";
	    				String address = "";
	    				String tempCustom3 ="";
	    				String custom3 = "";
	    				while((tempCustom3=re.readLine())!=null){
	    					if(tempCustom3.equals(Assets.ADDRESS_DIVIDER)){
	    						break;
	    					}
	    					custom3 += tempCustom3+"\n";
	    				}
	    				wallets[i].custom3 = custom3;
	    				
	    				while((tempAddress=re.readLine())!=null){
	    					address += tempAddress+"\n";
	    				}
	    				wallets[i].address = address;
	    			}
	        		data[i][0] = wallets[i].bankName;
	        		re.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
          }


		table = new JTable(data, columnNames){  
			  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				    return false;  
				  }  
				}; 
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		JPanel rightBarMakeWallets = new RightBarMakeWallets();
		rightBarMakeWallets.setBackground(SystemColor.textInactiveText);
		rightBarMakeWallets.setBounds(175, 11, 714, 461);
		add(rightBarMakeWallets);
		
		headerMakeWallets = new HeaderMakeWallets();
		headerMakeWallets.setBackground(SystemColor.inactiveCaption);
		//headerMakeWallets.setVisible(false);
		centerMakeWallets = new CenterMakeWallets();
		//centerMakeWallets.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(rightBarMakeWallets);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(headerMakeWallets, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 694, Short.MAX_VALUE)
						.addComponent(centerMakeWallets, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(headerMakeWallets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(centerMakeWallets, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		lblBankName = new JLabel("Bank Name : ");
		lblBankName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textBankName = new JTextField();
		textBankName.setColumns(10);
		
		lblAccountNo = new JLabel("Account No : ");
		lblAccountNo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAccNo = new JTextField();
		textAccNo.setColumns(10);
		
		lblAccountHolder = new JLabel("Acc. Holder : ");
		lblAccountHolder.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAccHolder = new JTextField();
		textAccHolder.setColumns(10);
		
		lblEmail_1 = new JLabel("Email : ");
		lblEmail_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		lblPin = new JLabel("PIN : ");
		lblPin.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPIN = new JTextField();
		textPIN.setColumns(10);
		
		lblFatherName = new JLabel("Father's Name : ");
		lblFatherName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFatherName = new JTextField();
		textFatherName.setColumns(10);
		
		JLabel lblMothersName = new JLabel("Mother's Name : ");
		lblMothersName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textMotherName = new JTextField();
		textMotherName.setColumns(10);
		
		lblNicename = new JLabel("Nick Name : ");
		lblNicename.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNickName = new JTextField();
		textNickName.setColumns(10);
		
		lblAddress = new JLabel("Address : ");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textAddress = new JTextArea();
		textAddress.setLineWrap(true);
		textAddress.setWrapStyleWord(true);
		textAddress.setColumns(30);
		textAddress.setRows(5);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		
		lblAbaroutingNo = new JLabel("Routing No :");
		lblAbaroutingNo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textRoutingNo = new JTextField();
		textRoutingNo.setColumns(10);
		
		lblPin_1 = new JLabel("PIN2 :");
		lblPin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblUrl = new JLabel("URL :");
		lblUrl.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblCustom = new JLabel("Custom 1 :");
		lblCustom.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblCustom_1 = new JLabel("Custom 2 :");
		lblCustom_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblCustom_2 = new JLabel("Custom 3 :");
		lblCustom_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textSwiftCode = new JTextField();
		textSwiftCode.setColumns(10);
		
		textSortCode = new JTextField();
		textSortCode.setColumns(10);
		
		lblSwiftCode = new JLabel("Swift Code :");
		lblSwiftCode.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblSortCode = new JLabel("Sort Code :");
		lblSortCode.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textPIN2 = new JTextField();
		textPIN2.setColumns(10);
		
		textURL = new JTextField();
		textURL.setColumns(10);
		
		textCustom1 = new JTextField();
		textCustom1.setColumns(10);
		
		textCustom2 = new JTextField();
		textCustom2.setColumns(10);
		
		textCustom3 = new JTextArea();
		
		btnSaveWallet = new JButton("Save Wallet");
		btnSaveWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int n = table.getSelectedRowCount();
		            if (n!=1) {
		              JOptionPane.showMessageDialog(null, "You must select one Wallet to save");
		            }
		            else{
		              int i = table.getSelectedRow();
		              
		                String walletName = Assets.WALLET_PRIFIX;
		            BufferedWriter wr;
		          try {
		            
		            wr = new BufferedWriter(new FileWriter("wallets/"+walletName+i+".txt"));
		            wr.write(textBankName.getText()+"\n");
		            wr.append(textAccNo.getText()+"\n");
		            wr.append(textAccHolder.getText()+"\n");
		            wr.append(textAccNo.getText()+"\n");
		            wr.append(textPIN.getText()+"\n");
		            wr.append(textEmail.getText()+"\n");
		            wr.append(textFatherName.getText()+"\n");
		            wr.append(textMotherName.getText()+"\n");
		            wr.append(textNickName.getText()+"\n");
		            wr.append(textSortCode.getText()+"\n");
		            wr.append(textSwiftCode.getText()+"\n");
		            wr.append(textRoutingNo.getText()+"\n");
		            wr.append(textPIN2.getText()+"\n");
		            wr.append(textURL.getText()+"\n");
		            wr.append(textCustom1.getText()+"\n");
		            wr.append(textCustom2.getText()+"\n");
		            wr.append(Assets.CUSTOM_DIVIDER+"\n");
		            wr.append(textCustom3.getText()+"\n");
		            wr.append(Assets.ADDRESS_DIVIDER+"\n");
		            wr.append(textAddress.getText()+"\n");
		            
		                  wr.close();
		                  
		          } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		          }
		          
		                headerMakeWallets.setVisible(true);
		                centerMakeWallets.setVisible(true);
		                file = new File("wallets");
		                File[] listOfFiles = file.listFiles();
		        		int len = listOfFiles.length;
		        		wallets = new Wallets[len];
		        		data = new Object[len][1];
		                for (i = 0; i < len; i++) {
		                    if (listOfFiles[i].isFile()) { 
		        				try {
		        	    			BufferedReader re = new BufferedReader(new FileReader(listOfFiles[i].getAbsolutePath()));
		        	    			wallets[i] = new Wallets();
		        	    			wallets[i].bankName = re.readLine();
		        	    			wallets[i].accountNo = re.readLine();
		        	    			wallets[i].accountHolder = re.readLine();
		        	    			wallets[i].accountType = re.readLine();
		        	    			wallets[i].PIN = re.readLine();
		        	    			wallets[i].email = re.readLine();
		        	    			wallets[i].fatherName = re.readLine();
		        	    			wallets[i].motherName = re.readLine();
		        	    			wallets[i].nickName = re.readLine();
		        	    			wallets[i].sortCode = re.readLine();
		        	    			wallets[i].swiftCode = re.readLine();
		        	    			wallets[i].routingNo = re.readLine();
		        	    			wallets[i].PIN2 = re.readLine();
		        	    			wallets[i].uRL = re.readLine();
		        	    			wallets[i].custom1 = re.readLine();
		        	    			wallets[i].custom2 = re.readLine();
		        	    			
		        	    			if(re.readLine().equals(Assets.CUSTOM_DIVIDER)){
		        	    				String tempAddress ="";
		        	    				String address = "";
		        	    				String tempCustom3 ="";
		        	    				String custom3 = "";
		        	    				while((tempCustom3=re.readLine())!=null){
		        	    					if(tempCustom3.equals(Assets.ADDRESS_DIVIDER)){
		        	    						break;
		        	    					}
		        	    					custom3 += tempCustom3+"\n";
		        	    				}
		        	    				wallets[i].custom3 = custom3;
		        	    				
		        	    				while((tempAddress=re.readLine())!=null){
		        	    					address += tempAddress+"\n";
		        	    				}
		        	    				wallets[i].address = address;
		        	    			}
		        	        		data[i][0] = wallets[i].bankName;
		        	        		re.close();
		        				} catch (Exception e1) {
		        					// TODO Auto-generated catch block
		        					e1.printStackTrace();
		        				}
		                    }
		                  }

		        		table = new JTable(data, columnNames){  
		        			  /**
		        			 * 
		        			 */
		        			private static final long serialVersionUID = 1L;

		        			public boolean isCellEditable(int row, int column){  
		        				    return false;  
		        				  }  
		        				}; 
		        		scrollPane.setViewportView(table);
		        		table.setFillsViewportHeight(true);
		        		
		        		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		        		    @Override
		        		    public void valueChanged(ListSelectionEvent event) {
		        		        if (table.getSelectedRow() > -1) {
		        		        	int i = table.getSelectedRow();
		        		            labelBankName.setText(wallets[i].bankName);
		        		            labelBankAccName.setText(wallets[i].accountNo);
		        		            labelEmail.setText(wallets[i].email);
		        		            labelAccHolder.setText(wallets[i].accountHolder);
		        		            labelAccType.setText(wallets[i].accountType);
		        		            LabelAccPIN.setText(wallets[i].PIN);
		        		            
		        		            textBankName.setText(wallets[i].bankName);
		        		            textAccNo.setText(wallets[i].accountNo);
		        		            textAccHolder.setText(wallets[i].accountHolder);
		        		            textPIN.setText(wallets[i].PIN);
		        		            textEmail.setText(wallets[i].email);
		        		            textFatherName.setText(wallets[i].fatherName);
		        		            textMotherName.setText(wallets[i].motherName);
		        		            textNickName.setText(wallets[i].nickName);
		        		            textAddress.setText(wallets[i].address);
		        		            textSortCode.setText(wallets[i].sortCode);
		        		            textSwiftCode.setText(wallets[i].swiftCode);
		        		            textRoutingNo.setText(wallets[i].routingNo);
		        		            textPIN2.setText(wallets[i].PIN2);
		        		            textURL.setText(wallets[i].uRL);
		        		            textCustom1.setText(wallets[i].custom1);
		        		            textCustom2.setText(wallets[i].custom2);
		        		            textCustom3.setText(wallets[i].custom3);
		        		            
		        		            headerMakeWallets.setVisible(true);
		        		            centerMakeWallets.setVisible(true);
		        		            
		        		        }
		        		    }
		        		});
		        		
		            }
		      
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(centerMakeWallets);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBankName, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblAccountNo, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblMothersName, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblFatherName, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblAccountHolder, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblPin, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblEmail_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblNicename, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textNickName, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textBankName, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textAccNo, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textAccHolder, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textPIN, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textFatherName, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textMotherName, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(textAddress, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblPin_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPIN2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblUrl, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textURL, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblCustom, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCustom1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblCustom_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCustom2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAbaroutingNo, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSwiftCode, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSortCode, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(textSwiftCode, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addComponent(textRoutingNo, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSortCode, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
							.addComponent(lblCustom_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCustom3))
						.addComponent(btnSaveWallet))
					.addGap(15))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 322, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBankName)
								.addComponent(textBankName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textAccNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(9)
									.addComponent(lblAccountNo)))
							.addGap(6)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textAccHolder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAccountHolder))
							.addGap(6)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPIN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPin))
							.addGap(6)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFatherName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFatherName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textMotherName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMothersName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNickName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNicename))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddress)
								.addComponent(textAddress, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textSortCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSortCode))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textSwiftCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSwiftCode))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(3)
									.addComponent(lblAbaroutingNo))
								.addComponent(textRoutingNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPin_1)
								.addComponent(textPIN2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUrl)
								.addComponent(textURL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCustom1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustom))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCustom2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustom_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustom_2)
								.addComponent(textCustom3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSaveWallet)
							.addGap(52)))
					.addContainerGap())
		);
		centerMakeWallets.setLayout(gl_panel_2);
		
		labelBankName = new JLabel("");
		labelBankName.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelBankName.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblBankAccountNo = new JLabel("Bank Account No :");
		lblBankAccountNo.setHorizontalAlignment(SwingConstants.LEFT);
		
		labelBankAccName = new JLabel("");
		labelBankAccName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblEmail = new JLabel("Email :");
		
		labelEmail = new JLabel("");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblAccHolder = new JLabel("Acc. Holder :");
		lblAccHolder.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblAccType = new JLabel("Acc. Type :");
		lblAccType.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblAccPin = new JLabel("Acc. PIN :");
		lblAccPin.setHorizontalAlignment(SwingConstants.RIGHT);
		
		labelAccHolder = new JLabel("");
		labelAccHolder.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelAccHolder.setHorizontalAlignment(SwingConstants.LEFT);
		
		labelAccType = new JLabel("");
		labelAccType.setHorizontalAlignment(SwingConstants.LEFT);
		labelAccType.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		LabelAccPIN = new JLabel("");
		LabelAccPIN.setHorizontalAlignment(SwingConstants.LEFT);
		LabelAccPIN.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtpnSdfs = new JTextPane();
		txtpnSdfs.setFont(new Font("Vijaya", Font.BOLD, 20));
		txtpnSdfs.setText("Secure bamk information \n you are lucky ...");
		txtpnSdfs.setBackground(new Color(0,0,0,0));
		txtpnSdfs.setForeground(Color.blue);
		GroupLayout gl_headerMakeWallets = new GroupLayout(headerMakeWallets);
		gl_headerMakeWallets.setHorizontalGroup(
			gl_headerMakeWallets.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerMakeWallets.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.LEADING, false)
						.addComponent(labelBankName, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(lblBankAccountNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelBankAccName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(labelEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_headerMakeWallets.createSequentialGroup()
							.addComponent(lblAccType, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(lblAccPin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
						.addGroup(gl_headerMakeWallets.createSequentialGroup()
							.addComponent(lblAccHolder, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_headerMakeWallets.createSequentialGroup()
							.addGap(26)
							.addComponent(txtpnSdfs, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_headerMakeWallets.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.LEADING, false)
								.addComponent(labelAccType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(LabelAccPIN, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addGroup(gl_headerMakeWallets.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelAccHolder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_headerMakeWallets.setVerticalGroup(
			gl_headerMakeWallets.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_headerMakeWallets.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_headerMakeWallets.createSequentialGroup()
							.addComponent(labelBankName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBankAccountNo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelBankAccName)
							.addGap(11)
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelEmail))
						.addGroup(gl_headerMakeWallets.createSequentialGroup()
							.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.LEADING)
								.addComponent(labelAccHolder)
								.addGroup(gl_headerMakeWallets.createSequentialGroup()
									.addGap(1)
									.addComponent(lblAccHolder)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelAccType)
								.addComponent(lblAccType))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_headerMakeWallets.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelAccPIN)
								.addComponent(lblAccPin))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtpnSdfs, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		headerMakeWallets.setLayout(gl_headerMakeWallets);
		rightBarMakeWallets.setLayout(gl_panel);
		

        headerMakeWallets.setVisible(false);
        centerMakeWallets.setVisible(false);
        
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (table.getSelectedRow() > -1) {
		        	int i = table.getSelectedRow();
		            labelBankName.setText(wallets[i].bankName);
		            labelBankAccName.setText(wallets[i].accountNo);
		            labelEmail.setText(wallets[i].email);
		            labelAccHolder.setText(wallets[i].accountHolder);
		            labelAccType.setText(wallets[i].accountType);
		            LabelAccPIN.setText(wallets[i].PIN);
		            
		            textBankName.setText(wallets[i].bankName);
		            textAccNo.setText(wallets[i].accountNo);
		            textAccHolder.setText(wallets[i].accountHolder);
		            textPIN.setText(wallets[i].PIN);
		            textEmail.setText(wallets[i].email);
		            textFatherName.setText(wallets[i].fatherName);
		            textMotherName.setText(wallets[i].motherName);
		            textNickName.setText(wallets[i].nickName);
		            textAddress.setText(wallets[i].address);
		            textSortCode.setText(wallets[i].sortCode);
		            textSwiftCode.setText(wallets[i].swiftCode);
		            textRoutingNo.setText(wallets[i].routingNo);
		            textPIN2.setText(wallets[i].PIN2);
		            textURL.setText(wallets[i].uRL);
		            textCustom1.setText(wallets[i].custom1);
		            textCustom2.setText(wallets[i].custom2);
		            textCustom3.setText(wallets[i].custom3);
		            
		            headerMakeWallets.setVisible(true);
		            centerMakeWallets.setVisible(true);
		            
		        }
		    }
		});

	}
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}
