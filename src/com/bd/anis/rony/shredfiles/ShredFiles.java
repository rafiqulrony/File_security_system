package com.bd.anis.rony.shredfiles;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import javax.swing.JLabel;

import com.bd.anis.rony.lockzipfiles.ZipWithPassword;
import javax.swing.JProgressBar;

public class ShredFiles extends JPanel {

	ImageIcon lockButtonIcon = new ImageIcon("raw/lockbutton.png");
	ImageIcon lockButtonIcon1 = new ImageIcon("raw/lockbutton1.png");
	ImageIcon unlockButtonIcon = new ImageIcon("raw/unlockbutton.png");
	ImageIcon unlockButtonIcon1 = new ImageIcon("raw/unlockbutton1.png");
	ImageIcon removeButtonIcon = new ImageIcon("raw/removebutton.png");
	ImageIcon removeButtonIcon1 = new ImageIcon("raw/removebutton1.png");
	ImageIcon selectallButtonIcon = new ImageIcon("raw/selectallbutton.png");
	ImageIcon selectallButtonIcon1 = new ImageIcon("raw/selectallbutton1.png");

	JPanel footer;
	JLabel lblOk;
	JProgressBar progressBar;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/bg.png");
	String[] columnNames = { "Files/Folders", "Path", "Format" };

	/**
	 * Create the panel.
	 */
	public ShredFiles()
	{
		setLayout(null);

		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(true);
		progressBar.setStringPainted(!progressBar.isIndeterminate());

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 93, 535, 343);
		add(scrollPane);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton removeButton = new JButton("<html><body>Add<br>Folders</body></html>");
		removeButton.setBounds(126, 11, 96, 68);
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Folder To Encrypt");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnVal = fileChooser.showOpenDialog((Component) arg0.getSource());
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					try
					{
						String filePath = file.toString();
						int index = table.getRowCount();
						Object[][] data = new Object[index + 1][4];
						for (int i = 0; i < index; i++)
						{
							data[i][0] = table.getValueAt(i, 0).toString();
							data[i][1] = table.getValueAt(i, 1).toString();
							data[i][2] = table.getValueAt(i, 2).toString();
						}
						data[index][0] = "Folder";
						data[index][1] = filePath;
						data[index][2] = "Directory";
						table = new JTable(data, columnNames);
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
		add(removeButton);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton selectallButton = new JButton("Select All");
		selectallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
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
		selectallButton.setBounds(232, 11, 101, 68);
		add(selectallButton);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton unlockButton = new JButton("Shred");
		unlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				lblOk.setText("Wait ... ( Because some protective actions are runing on the system )");
				footer.setBackground(SystemColor.CYAN);
				if (table.getSelectedRow() > -1)
				{

					// Custom button text
					Object[] options = { "Yes", "No", "Clear Field" };
					int n = JOptionPane.showOptionDialog(null, "Are you sure to shred all selected files/folders",
							"Files/Folders Locking confirmation", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if (n == 0)
					{
						//boolean isDelete = true;
						int index[] = table.getSelectedRows();
						for (int i = 0; i < index.length; i++)
						{
							try
							{
								Thread.sleep(300);
								ShredDelete.shred(table.getValueAt(i, 1).toString());
								/*
								isDelete = ShredDelete.shred(table.getValueAt(i, 1).toString());
								if (!ShredDelete.shred(table.getValueAt(i, 1).toString()))
								{
									isDelete = false;
								}
								*/
							}
							catch (Exception e1)
							{
								JOptionPane.showMessageDialog(null, "Problem occured ... !!!");
							}
						}

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
						scrollPane.setViewportView(table);
						table.setFillsViewportHeight(true);
						JOptionPane.showMessageDialog(null, "Shred Delete Successfull");

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
				lblOk.setText("File Security System is a power encrpytion/decryption and zip locker software");
				footer.setBackground(SystemColor.inactiveCaption);
			}
		});
		unlockButton.setBounds(454, 11, 101, 68);
		add(unlockButton);

		Object[][] data = {};

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton button = new JButton("Deselect All");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
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
		button.setBounds(343, 11, 101, 68);
		add(button);

		JPanel rigthBarShredFiles = new RigthBarShredFiles();
		rigthBarShredFiles.setBackground(SystemColor.inactiveCaptionText);
		rigthBarShredFiles.setBounds(565, 11, 315, 425);
		add(rigthBarShredFiles);
		GroupLayout gl_panel = new GroupLayout(rigthBarShredFiles);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 282, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGap(0, 461, Short.MAX_VALUE));
		rigthBarShredFiles.setLayout(gl_panel);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton button_1 = new JButton("Add Files");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Choose Any File to Encrypt");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnVal = fileChooser.showOpenDialog((Component) arg0.getSource());
				if (returnVal == JFileChooser.APPROVE_OPTION)
				{
					File file = fileChooser.getSelectedFile();
					try
					{
						String filePath = file.toString();
						String fileType = "File";
						String extension = file.getAbsolutePath().replaceAll("^.*\\.([^.]+)$", "$1");
						if (!file.getAbsolutePath().equals(extension))
						{
							fileType = extension;
						}
						int index = table.getRowCount();
						Object[][] data = new Object[index + 1][4];
						for (int i = 0; i < index; i++)
						{
							data[i][0] = table.getValueAt(i, 0).toString();
							data[i][1] = table.getValueAt(i, 1).toString();
							data[i][2] = table.getValueAt(i, 2).toString();
						}

						data[index][0] = "File";
						data[index][1] = filePath;
						data[index][2] = fileType;

						table = new JTable(data, columnNames);
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
		button_1.setBounds(20, 11, 96, 68);
		add(button_1);

		footer = new JPanel();
		footer.setBackground(SystemColor.inactiveCaption);
		footer.setBounds(20, 439, 860, 33);
		add(footer);

		lblOk = new JLabel("File Security System is a power encrpytion/decryption and zip locker software");
		GroupLayout gl_panel1 = new GroupLayout(footer);
		gl_panel1.setHorizontalGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup().addGap(27)
						.addComponent(lblOk, GroupLayout.PREFERRED_SIZE, 767, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(33, Short.MAX_VALUE)));
		gl_panel1.setVerticalGroup(gl_panel1.createParallelGroup(Alignment.TRAILING).addComponent(lblOk,
				GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE));
		footer.setLayout(gl_panel1);

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