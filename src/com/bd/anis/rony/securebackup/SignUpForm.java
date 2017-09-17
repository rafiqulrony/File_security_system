package com.bd.anis.rony.securebackup;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.bd.anis.rony.files.OnlineBataBaseHandlers;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpForm extends JFrame {
	private JTextField userTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SignUpForm() {
		getContentPane().setLayout(null);
		
		setBounds(314, 281, 463, 310);
		setResizable(false);
		
		userTextField = new JTextField();
		userTextField.setBounds(239, 34, 170, 20);
		getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(239, 123, 170, 20);
		getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(40, 37, 93, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 79, 70, 14);
		getContentPane().add(lblPassword);
		
		JLabel lblUserEmail = new JLabel("User email");
		lblUserEmail.setBounds(40, 126, 103, 14);
		getContentPane().add(lblUserEmail);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userTextField.getText().trim();
				String pass = passwordField.getText().trim();
				String email = emailTextField.getText().trim();
				boolean isSignUp = OnlineBataBaseHandlers.insertSignUpOnline(user, pass, email);
				if(isSignUp){
					JOptionPane.showMessageDialog(null, "Successfull SignUp ...");
					setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "User exists ???");
				}
			}
		});
		btnSignup.setBounds(239, 179, 89, 23);
		getContentPane().add(btnSignup);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 76, 170, 20);
		getContentPane().add(passwordField);

	}
}
