package com.bd.anis.rony.encryptfiles;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import java.awt.SystemColor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import com.bd.anis.rony.lockzipfiles.ZipWithPassword;
import com.bd.anis.rony.methods.ProjectMethods;

public class EncryptFiles extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	String[] columnNames = { "Files/Folders", "Path", "Format", "Status" };
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/bg.png");
	ImageIcon createlockerButtonIcon = new ImageIcon("raw/createlockerbutton.png");
	ImageIcon createlockerButtonIcon1 = new ImageIcon("raw/createlockerbutton1.png");
	ImageIcon openlockerButtonIcon = new ImageIcon("raw//openlockerbutton.png");
	ImageIcon openlockerButtonIcon1 = new ImageIcon("raw/openlockerbutton1.png");
	JPanel footer;
	JLabel lblOK;

	/**
	 * Create the panel.
	 */
	public EncryptFiles()
	{
		setLayout(null);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 610, 348);
		add(scrollPane);

		JButton createlockerButton = new JButton("Add Files");
		createlockerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Any File to Encrypt");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				//
				// disable the "All files" option.
				//
				fileChooser.setAcceptAllFileFilterUsed(false);
				// //
				int returnVal = fileChooser.showOpenDialog((Component) e.getSource());
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					try
					{
						String filePath = file.toString();
						String fileType = "File";
						String status = "Not Encrypted";
						String extension = file.getAbsolutePath().replaceAll("^.*\\.([^.]+)$", "$1");
						if (!file.getAbsolutePath().equals(extension))
						{
							fileType = extension;
						}
						if (filePath.endsWith(".enc"))
						{
							status = "Encrypted";
						}
						int index = table.getRowCount();
						Object[][] data = new Object[index + 1][4];
						for (int i = 0; i < index; i++)
						{
							data[i][0] = table.getValueAt(i, 0).toString();
							data[i][1] = table.getValueAt(i, 1).toString();
							data[i][2] = table.getValueAt(i, 2).toString();
							data[i][3] = table.getValueAt(i, 3).toString();
						}
						data[index][0] = "File";
						data[index][1] = filePath;
						data[index][2] = fileType;
						data[index][3] = status;

						table = new JTable(data, columnNames) {
							/**
							* 
							*/
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column)
							{
								return false;
							}
						};
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
					}
					catch (Exception ex)
					{
						System.out.println("problem accessing file" + file.getAbsolutePath());
					}
				}
				else
				{
					System.out.println("File access cancelled by user.");
				}
			}
		});
		createlockerButton.setBounds(10, 11, 95, 60);
		add(createlockerButton);

		JButton openlockerButton = new JButton("<html><body>Add<br>Folders</body></html>");
		openlockerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder To Encrypt");
				// FileFilter filter = new
				// FileNameExtensionFilter("FOLDERS","mp3");
				// fileChooser.addChoosableFileFilter(filter);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//
				// disable the "All files" option.
				//
				fileChooser.setAcceptAllFileFilterUsed(false);
				// //
				int returnVal = fileChooser.showOpenDialog((Component) e.getSource());
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					try
					{
						String filePath = file.toString();
						String status = "Not Encrypted";
						if (filePath.endsWith(".f.enc"))
						{
							status = "Encrypted";
						}
						int index = table.getRowCount();
						Object[][] data = new Object[index + 1][4];
						for (int i = 0; i < index; i++)
						{
							data[i][0] = table.getValueAt(i, 0).toString();
							data[i][1] = table.getValueAt(i, 1).toString();
							data[i][2] = table.getValueAt(i, 2).toString();
							data[i][3] = table.getValueAt(i, 3).toString();
						}
						data[index][0] = "Directory";
						data[index][1] = filePath;
						data[index][2] = "Directory";
						data[index][3] = status;

						table = new JTable(data, columnNames) {
							/**
							* 
							*/
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column)
							{
								return false;
							}
						};
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
					}
					catch (Exception ex)
					{
						System.out.println("problem accessing file" + file.getAbsolutePath());
					}
				}
				else
				{
					System.out.println("File access cancelled by user.");
				}

			}
		});
		openlockerButton.setBounds(109, 11, 95, 60);
		add(openlockerButton);

		String[] comboItems = { "Edit", "Option2", "Option3", "Option4", "Option5", "Option6", "Option7" };

		String[] comboItems1 = { "Close Locker", "Option2", "Option3", "Option4", "Option5", "Option6", "Option7" };

		ImageIcon backuplockerButtonIcon = new ImageIcon("raw/backuplockerbutton.png");
		ImageIcon backuplockerButtonIcon1 = new ImageIcon("raw/backuplockerbutton1.png");
		JButton backuplockerButton = new JButton("Delect All");
		backuplockerButton.setRolloverIcon(backuplockerButtonIcon1);
		backuplockerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (table.getRowCount() > 0)
				{
					table.getSelectionModel().clearSelection();
				}
				else
				{
					JOptionPane.showMessageDialog(null, " You haven't no files/folders import");
				}
			}
		});
		backuplockerButton.setBounds(315, 11, 95, 60);
		add(backuplockerButton);

		Object[][] data = {};
		table = new JTable(data, columnNames) {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event)
			{
				if (table.getSelectedRow() > -1)
				{
					System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
			}
		});

		JButton button = new JButton("Select All");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if (table.getRowCount() > 0)
				{
					table.selectAll();
				}
				else
				{
					JOptionPane.showMessageDialog(null, " You haven't no files/folders import");
				}
			}
		});
		button.setBounds(210, 11, 95, 60);
		add(button);

		JButton button_1 = new JButton("Decrypt");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				lblOK.setText("Wait ... ( Because some protective actions are runing on the system )");
				footer.setBackground(SystemColor.CYAN);
				if (table.getSelectedRow() > -1)
				{
					// Custom button text
					Object[] options = { "Yes", "No", "Clear Field" };
					int n = JOptionPane.showOptionDialog(null, "Are you sure to Decrypt all selected files/folders",
							"Files/Folders Decryption confirmation", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if (n == 0)
					{

						int index[] = table.getSelectedRows();
						for (int i = 0; i < index.length; i++)
						{
							try
							{
								if (new File(table.getValueAt(i, 1).toString()).isFile())
								{
									new FileEncryption("DES/ECB/PKCS5Padding", table.getValueAt(i, 1).toString(), false)
											.decrypt();
								}
								else if (new File(table.getValueAt(i, 1).toString()).isDirectory())
								{
									new FileEncryption("DES/ECB/PKCS5Padding", table.getValueAt(i, 1).toString(), true)
											.decrypt();
								}
							}
							catch (Exception e1)
							{
								JOptionPane.showMessageDialog(null, "Problem occured ... !!!");
							}
						}
						Object[][] data = {};
						table = new JTable(data, columnNames) {
							/**
							* 
							*/
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column)
							{
								return false;
							}
						};
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
						JOptionPane.showMessageDialog(null, "Decryption Successfull");
					}
					else if (n == 1)
					{

					}
					else if (n == 2)
					{
						Object[][] data = {};
						table = new JTable(data, columnNames)
						{
							/**
							* 
							*/
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column)
							{
								return false;
							}
						};
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, " You haven't no files/folders selected");
				}
				lblOK.setText("File Security System is a power encrpytion/decryption and zip locker software");
				footer.setBackground(SystemColor.inactiveCaption);

			}
		});
		button_1.setBounds(525, 11, 95, 60);
		add(button_1);

		JButton button_2 = new JButton("Encrypt");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				lblOK.setText("Wait ... ( Because some protective actions are runing on the system )");
				footer.setBackground(SystemColor.CYAN);
				if (table.getSelectedRow() > -1)
				{

					// Custom button text
					Object[] options = { "Yes", "No", "Clear Field" };
					int n = JOptionPane.showOptionDialog(null, "Are you sure to Encrypt all selected files/folders",
							"Files/Folders Encryption confirmation", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if (n == 0)
					{
						int index[] = table.getSelectedRows();
						for (int i = 0; i < index.length; i++)
						{
							try
							{
								Thread.sleep(300);
								if (new File(table.getValueAt(i, 1).toString()).isFile())
								{
									new FileEncryption("DES/ECB/PKCS5Padding", table.getValueAt(i, 1).toString(), false)
											.encrypt();
									ProjectMethods.shred(table.getValueAt(i, 1).toString());
								}
								else if (new File(table.getValueAt(i, 1).toString()).isDirectory())
								{
									new FileEncryption("DES/ECB/PKCS5Padding", table.getValueAt(i, 1).toString(), true)
											.encrypt();
									ProjectMethods.shred(table.getValueAt(i, 1).toString());
								}

							}
							catch (Exception e1)
							{
								JOptionPane.showMessageDialog(null, "Problem occured ... !!!");
							}
						}

						Object[][] data = {};
						table = new JTable(data, columnNames) {
							/**
							* 
							*/
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column)
							{
								return false;
							}
						};
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
						JOptionPane.showMessageDialog(null, "Encryption Successfull");
					}
					else if (n == 1)
					{
						//
					}
					else if (n == 2)
					{
						Object[][] data = {};
						table = new JTable(data, columnNames)
						{
							/**
							* 
							*/
							private static final long serialVersionUID = 1L;

							public boolean isCellEditable(int row, int column)
							{
								return false;
							}
						};
						table.setFillsViewportHeight(true);
						scrollPane.setViewportView(table);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, " You haven't no files/folders selected");
				}
				lblOK.setText("File Security System is a power encrpytion/decryption and zip locker software");
				footer.setBackground(SystemColor.inactiveCaption);

			}
		});
		button_2.setBounds(420, 11, 95, 60);
		add(button_2);

		JPanel rightBar = new RightBarEncryptFiles();
		rightBar.setBackground(SystemColor.inactiveCaptionText);
		rightBar.setBounds(630, 11, 260, 429);
		add(rightBar);

		footer = new JPanel();
		footer.setBackground(SystemColor.inactiveCaption);
		footer.setBounds(10, 442, 880, 30);
		add(footer);

		lblOK = new JLabel("File Security System is a power encrpytion/decryption and zip locker software");
		GroupLayout gl_footer = new GroupLayout(footer);
		gl_footer.setHorizontalGroup(
				gl_footer.createParallelGroup(Alignment.LEADING).addGroup(gl_footer.createSequentialGroup().addGap(33)
						.addComponent(lblOK, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE).addContainerGap()));
		gl_footer.setVerticalGroup(gl_footer.createParallelGroup(Alignment.TRAILING).addComponent(lblOK,
				Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE));
		footer.setLayout(gl_footer);

	}

	@Override
	public void paintComponent(final Graphics g)
	{
		super.paintComponent(g);
		Dimension d = getSize();
		if (bgImage != null)
			g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}
