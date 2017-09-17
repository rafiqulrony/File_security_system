package com.bd.anis.rony.securebackup;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JTable;

import com.bd.anis.rony.files.OnlineBataBaseHandlers;

public class SecureBackup extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField loginUserTextField;
	private JPasswordField loginPassTextField;
	
	JButton button_1;
	JButton button;
	Image bgImage = Toolkit.getDefaultToolkit().getImage("raw/bg.png");
	
	String[] columnNames = {"User", "url"};
	
	Object[][] data = {
		    {"Rony", "https://www.rony.com"},
		    {"John", "https://www.rony.com/passing.php"},
		    {"Sue", "https://www.rony.com/notl.htm"},
		    {"Jane", "https://www.rony.com/ph"},
		    {"Joe", "https://www.rony.com/cse.php"}
		};
	
	JTable table = new JTable(data, columnNames){
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };

	/**
	 * Create the panel.
	 */
	public SecureBackup() {
		setLayout(null);


		table.setFillsViewportHeight(true);
		table.setVisible(false);

		
		JPanel loginWiget = new LoginWiget();
		loginWiget.setBackground(SystemColor.controlHighlight);
		loginWiget.setBounds(10, 281, 294, 195);
		add(loginWiget);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Existing User?\nPlease login to access data kept in your Lockers \nonline.");
		textPane_1.setEditable(false);
		textPane_1.setBackground(new Color(0,0,0,0));
		
		JLabel label = new JLabel("LOGIN-");
		
		JLabel label_1 = new JLabel("Enter User ID:");
		
		loginUserTextField = new JTextField();
		loginUserTextField.setColumns(10);
		
		loginPassTextField = new JPasswordField();
		
		JLabel label_2 = new JLabel("Account Password:");
		
		button = new JButton("LOGIN");
		button.addActionListener(new ActionListener() {
			private String[] columnNames = {"1", "2", "3", "4"};

			public void actionPerformed(ActionEvent arg0) {
				
				String username = loginUserTextField.getText().trim();
				String password = loginPassTextField.getText().trim();
				
				boolean isLoginSucess = OnlineBataBaseHandlers.isUserLoginSuccess(username, password);
				if(isLoginSucess){
					JOptionPane.showMessageDialog(null, "Login Successfull ... ");		
					table.setVisible(true);
					button.setEnabled(false);
					button_1.setEnabled(false);
					loginPassTextField.setEnabled(false);
					loginUserTextField.setEnabled(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "username or password incorrect !!!");
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(loginWiget);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(loginUserTextField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(loginPassTextField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addComponent(button)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(label)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(loginUserTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(loginPassTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addComponent(button)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		loginWiget.setLayout(gl_panel);
		
		JPanel signUpWiget = new SignUpWiget();
		signUpWiget.setBackground(SystemColor.controlHighlight);
		signUpWiget.setBounds(314, 281, 294, 195);
		add(signUpWiget);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBackground(SystemColor.inactiveCaption);
		textPane_2.setText("New User?\nPlease Signup to create a new Secure Backup account.\n\nSignup:\nCreate an account and keep your encrypted files you keep in Lockers, backed up.");
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(0,0,0,0));
		
		button_1 = new JButton("SIGNUP");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUpForm form = new SignUpForm();
				form.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(signUpWiget);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(button_1)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		signUpWiget.setLayout(gl_panel_1);
		
		JPanel headerContentSecureBackup = new HeaderContentSecureBackup();
		headerContentSecureBackup.setBounds(10, 11, 599, 259);
		add(headerContentSecureBackup);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(0,0,0,0));
		textPane.setText("This application offers end-to-end encryption, real-time syncing and automatic backup of files you encrypt in Lockers using 'Encrypt Files' feature.");
		GroupLayout gl_panel_2 = new GroupLayout(headerContentSecureBackup);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		headerContentSecureBackup.setLayout(gl_panel_2);
		
		JPanel rightBarSecureBackup = new RightBarSecureBackup();
		rightBarSecureBackup.setBackground(new Color(255, 255, 204));
		rightBarSecureBackup.setBounds(619, 11, 271, 465);
		add(rightBarSecureBackup);
		
//		table = new JTable();
		GroupLayout gl_panel_3 = new GroupLayout(rightBarSecureBackup);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		rightBarSecureBackup.setLayout(gl_panel_3);
//		table.setVisible(false);

	}
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    Dimension d = getSize();
	    if (bgImage != null)
	        g.drawImage(bgImage, 0, 0, d.width, d.height, this);
	}
}
