package com.bd.anis.rony.makewallets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EmailForm extends JFrame {
	private JTextField userToTextField;

	/**
	 * Create the panel.
	 */
	public EmailForm(String emailBody) {
		getContentPane().setLayout(null);
		
		setBounds(314, 281, 466, 447);
		setResizable(false);
		
		userToTextField = new JTextField();
		userToTextField.setBounds(92, 34, 338, 20);
		getContentPane().add(userToTextField);
		userToTextField.setColumns(10);
		
		JLabel lblUsername = new JLabel("To");
		lblUsername.setBounds(40, 37, 30, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblUserEmail = new JLabel("Message");
		lblUserEmail.setBounds(40, 62, 64, 14);
		getContentPane().add(lblUserEmail);
		
		JButton btnSendEmail = new JButton("Send");
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userToTextField.getText().trim();
				String pass = userToTextField.getText().trim();
				String email = userToTextField.getText().trim();
				boolean isSend = false;
				if(!isSend){
					JOptionPane.showMessageDialog(null, "Email sending problem. Check your internet settigns");
					setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Send Sucessfull");
				}
			}
		});
		btnSendEmail.setBounds(361, 385, 89, 23);
		getContentPane().add(btnSendEmail);
		
		JTextArea emailBodyTextField = new JTextArea(emailBody);
		emailBodyTextField.setBounds(92, 65, 338, 309);
		getContentPane().add(emailBodyTextField);

	}
}
