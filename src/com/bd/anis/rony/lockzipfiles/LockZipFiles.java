package com.bd.anis.rony.lockzipfiles;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.bd.anis.rony.assets.Assets;
import com.bd.anis.rony.encryptfiles.FileEncryption;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import org.omg.CORBA.Bounds;
import java.awt.Color;
import java.awt.SystemColor;

public class LockZipFiles extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	String[] columnNames = {"Files/Folders", "Path", "Format", "Status"};
	private String password = Assets.password;
	JLabel countItems;
	ImageIcon removeButtonIcon = new ImageIcon("raw/removebutton.png");
	ImageIcon removeButtonIcon1 = new ImageIcon("raw/removebutton1.png");
	ImageIcon selectallButtonIcon = new ImageIcon("raw/selectallbutton.png");
	ImageIcon selectallButtonIcon1 = new ImageIcon("raw/selectallbutton1.png");	
	ImageIcon lockButtonIcon = new ImageIcon("raw/lockbutton.png");
	ImageIcon lockButtonIcon1 = new ImageIcon("raw/lockbutton1.png");
	ImageIcon unlockButtonIcon = new ImageIcon("raw/unlockbutton.png");
	ImageIcon unlockButtonIcon1 = new ImageIcon("raw/unlockbutton1.png");
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/bg.png");
	final Component[] com; 
	JLabel lblOk;
	JPanel footer;
	   
	/**
	 * Create the panel.
	 */
	
	public LockZipFiles() {
		setLayout(null);
		
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 93, 638, 347);
		add(scrollPane);
		
		JButton removeButton = new JButton("<html><body>Add<br>Folders</body></html>");
		removeButton.setBounds(126, 11, 96, 68);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder To Encrypt");
				//FileFilter filter = new FileNameExtensionFilter("FOLDERS","mp3");
				//fileChooser.addChoosableFileFilter(filter);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
				fileChooser.setAcceptAllFileFilterUsed(false);
//		    //  
				int returnVal = fileChooser.showOpenDialog((Component)e.getSource());
			    if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = fileChooser.getSelectedFile();
			        try {
		        	String  filePath = file.toString();
		        	String status = "NO Password";
					if(filePath.endsWith(".f.enc")){
						status = "password";
					}
					int index = table.getRowCount();
					Object[][] data = new Object[index+1][4];
		        	for(int i=0 ; i<index ; i++){
		        		data[i][0] = table.getValueAt(i, 0).toString();
		        		data[i][1] = table.getValueAt(i, 1).toString();
		        		data[i][2] = table.getValueAt(i, 2).toString();
		        		data[i][3] = table.getValueAt(i, 3).toString();
		        	}
	        		data[index][0] = "Folder";
	        		data[index][1] = filePath;
	        		data[index][2] = "Directory";
	        		data[index][3] = status;
							
					table = new JTable(data, columnNames){  
						  /**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column){  
							    return false;  
							  }  
							}; 
					table.setFillsViewportHeight(true);
					scrollPane.setViewportView(table);
			        } catch (Exception ex) {
			          System.out.println("problem accessing file"+file.getAbsolutePath());
			        }
			    } 
			    else {
			        System.out.println("File access cancelled by user.");
			    }
			
			
			
			}
		});
		add(removeButton);
		
		JButton selectallButton = new JButton("Select All");
		selectallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (table.getRowCount()>0) {
		        	table.selectAll();
		        }
		        else{
		        	JOptionPane.showMessageDialog(null, " You haven't no files/folders import");
		        }
			}
		});
		selectallButton.setBounds(232, 11, 101, 68);
		add(selectallButton);
		

		JButton lockButton = new JButton("<html><body>Deselect<br>All</body></html>");
		lockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        if (table.getRowCount()>0) {
		        	table.getSelectionModel().clearSelection();
		        }
		        else{
		        	JOptionPane.showMessageDialog(null, " You haven't no files/folders import");
		        }
			}
		});
		lockButton.setBounds(340, 11, 96, 68);
		add(lockButton);
;
		final JButton unlockButton = new JButton("Zip Lock");
		unlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOk.setText("Wait ... ( Because some protective actions are runing on the system )");
				footer.setBackground(SystemColor.CYAN);
		        if (table.getSelectedRow() > -1) {
			        
					//Custom button text
					Object[] options = {"Yes",
					                    "No",
					                    "Clear Field"};
					int n = JOptionPane.showOptionDialog(null,
					    "Are you sure to locking all selected files/folders",
					    "Files/Folders Locking confirmation",
					    JOptionPane.YES_NO_CANCEL_OPTION,
					    JOptionPane.INFORMATION_MESSAGE,
					    null,
					    options,
					    options[0]);
					if(n == 0){
						int index[] = table.getSelectedRows();
			        	for(int i=0 ; i<index.length ; i++){
			        		try {
			        			Thread.sleep(300);
			        			File file = new File(table.getValueAt(i, 1).toString());
			        			if(file.isDirectory()){
			        				ZipWithPassword.ZipFolderWithPaasword( table.getValueAt(i, 1).toString(),password);
								}
			        			else if(file.isFile()){
			        				ZipWithPassword.ZipFile( table.getValueAt(i, 1).toString(),password);
			        			}
			        		} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Problem occured ... !!!");
							}
			        	}

			    		Object[][] data = {};
			    		table = new JTable(data, columnNames){  
			    			  /**
			    			 * 
			    			 */
			    			private static final long serialVersionUID = 1L;

			    			public boolean isCellEditable(int row, int column){  
			    				    return false;  
			    				  }  
			    				};
			    				table.setFillsViewportHeight(true);
			    				scrollPane.setViewportView(table);
			    				JOptionPane.showMessageDialog(null, "Zip Locking Successfull");
					}
					else if(n == 1){
						//
					}
					else if(n == 2){
			    		Object[][] data = {};
			    		table = new JTable(data, columnNames){  
			    			  /**
			    			 * 
			    			 */
			    			private static final long serialVersionUID = 1L;

			    			public boolean isCellEditable(int row, int column){  
			    				    return false;  
			    				  }  
			    				};
			    				table.setFillsViewportHeight(true);
			    				scrollPane.setViewportView(table);
					}
		        }
		        else{
		        	JOptionPane.showMessageDialog(null, " You haven't no files/folders selected");
		        }
		        lblOk.setText("File Security System is a power encrpytion/decryption and zip locker software");
		        footer.setBackground(SystemColor.inactiveCaption);
		        
			}
		});
		unlockButton.setBounds(446, 11, 101, 68);
		add(unlockButton);
		
		
		Object[][] data = {};
		table = new JTable(data, columnNames){  
			  /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				    return false;  
				  }  
				}; 
				
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {

		    }
		});
		
		JButton btnZipUnlock = new JButton((Icon) null);
		btnZipUnlock.setText("Zip Unlock");
		btnZipUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblOk.setText("Wait ... ( Because some protective actions are runing on the system )");
				footer.setBackground(SystemColor.CYAN);
				if (table.getSelectedRow() > -1) {
				//Custom button text
				Object[] options = {"Yes",
				                    "No",
				                    "Clear Field"};
				int n = JOptionPane.showOptionDialog(null,
				    "Are you sure to unlocking all selected files/folders",
				    "Files/Folders Unlocking confirmation",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.INFORMATION_MESSAGE,
				    null,
				    options,
				    options[0]);
				if(n == 0){
					int index[] = table.getSelectedRows();
		        	for(int i=0 ; i<index.length ; i++){
		        		try {
		        			File file = new File(table.getValueAt(i, 1).toString());
		        			if(file.isFile()){
		        				ZipWithPassword.unzipToFolderWithPassword(table.getValueAt(i, 1).toString(),password);
		        			}
							
		        		} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Problem occured ... !!!");
						}
		        	}
		    		Object[][] data = {};
		    		table = new JTable(data, columnNames){  
		    			  /**
		    			 * 
		    			 */
		    			private static final long serialVersionUID = 1L;

		    			public boolean isCellEditable(int row, int column){  
		    				    return false;  
		    				  }  
		    				};
		    				table.setFillsViewportHeight(true);
		    				scrollPane.setViewportView(table);
		    				JOptionPane.showMessageDialog(null, "Zip Unlocking Successfull");
				}
				else if(n == 1){
					
				}
				else if(n == 2){
					Object[][] data = {};
		    		table = new JTable(data, columnNames){  
		    			  /**
		    			 * 
		    			 */
		    			private static final long serialVersionUID = 1L;

		    			public boolean isCellEditable(int row, int column){  
		    				    return false;  
		    				  }  
		    				};
		    				table.setFillsViewportHeight(true);
		    				scrollPane.setViewportView(table);
				}
				} 
			    else {
			    	JOptionPane.showMessageDialog(null, " You haven't no files/folders selected");
			    }
		        lblOk.setText("File Security System is a power encrpytion/decryption and zip locker software");
		        footer.setBackground(SystemColor.inactiveCaption);
			}
		});
		btnZipUnlock.setBounds(557, 11, 101, 68);
		add(btnZipUnlock);
		
		JPanel rigthBarLockFiles = new RigthBarLockZipFiles();
		rigthBarLockFiles.setBounds(668, 11, 212, 429);
		add(rigthBarLockFiles);
		GroupLayout gl_rigthBarLockFiles = new GroupLayout(rigthBarLockFiles);
		gl_rigthBarLockFiles.setHorizontalGroup(
			gl_rigthBarLockFiles.createParallelGroup(Alignment.LEADING)
				.addGap(0, 179, Short.MAX_VALUE)
		);
		gl_rigthBarLockFiles.setVerticalGroup(
			gl_rigthBarLockFiles.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 429, Short.MAX_VALUE)
		);
		rigthBarLockFiles.setLayout(gl_rigthBarLockFiles);
		
		JButton button_1 = new JButton("Add Files");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Any File to Encrypt");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    //
			    // disable the "All files" option.
			    //
				fileChooser.setAcceptAllFileFilterUsed(false);
//		    //  
				int returnVal = fileChooser.showOpenDialog((Component)e.getSource());
			    if (returnVal == JFileChooser.APPROVE_OPTION) {
			        File file = fileChooser.getSelectedFile();
			        try {
			        	String filePath = file.toString();
			        	String fileType = "File";
			        	String status = "Not Zip/Protected";
				   		String extension = file.getAbsolutePath().replaceAll("^.*\\.([^.]+)$", "$1");
						if(!file.getAbsolutePath().equals(extension)){
							fileType = extension; 
						}
						if(filePath.endsWith(".zip")){
							status = "Zip Protected";
						}
						int index = table.getRowCount();
						Object[][] data = new Object[index+1][4];
			        	for(int i=0 ; i<index ; i++){
			        		data[i][0] = table.getValueAt(i, 0).toString();
			        		data[i][1] = table.getValueAt(i, 1).toString();
			        		data[i][2] = table.getValueAt(i, 2).toString();
			        		data[i][3] = table.getValueAt(i, 3).toString();
			        	}
		        		data[index][0] = "File";
		        		data[index][1] = filePath;
		        		data[index][2] = fileType;
		        		data[index][3] = status;
										  
						table = new JTable(data, columnNames){  
							  /**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column){  
								    return false;  
								  }  
								}; 
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
			        } catch (Exception ex) {
			          System.out.println("problem accessing file"+file.getAbsolutePath());
			        }
			    } 
			    else {
			        System.out.println("File access cancelled by user.");
			    }
			
				
			}
		});
		button_1.setBounds(20, 11, 96, 68);
		add(button_1);
		
		countItems = new JLabel("");
		countItems.setBounds(30, 471, 46, 14);
		add(countItems);
		
		footer = new JPanel();
		footer.setBackground(SystemColor.inactiveCaption);
		footer.setBounds(20, 444, 860, 27);
		add(footer);
		
		lblOk = new JLabel("File Security System is a power encrpytion/decryption and zip locker software");
		GroupLayout gl_panel = new GroupLayout(footer);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(lblOk, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblOk, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
		);
		footer.setLayout(gl_panel);
		com = this.getComponents(); 
	}
	
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}