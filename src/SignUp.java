import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import backend.User;
import backend.UserManagement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp {

	public JFrame frame;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phoneNo;
	private JTextField ccNo;

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(51, 30, 137, 16);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 70, 142, 16);
		panel.add(lblPassword);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(51, 110, 137, 16);
		panel.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(51, 151, 137, 16);
		panel.add(lblPhoneNumber);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		lblCreditCardNumber.setBounds(51, 192, 137, 16);
		panel.add(lblCreditCardNumber);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User(username.getText(),password.getText(),address.getText(),phoneNo.getText(),ccNo.getText());
				UserManagement.registerUser(u);
				JOptionPane.showMessageDialog(frame, "Registeration successful");
				new SignIn().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnRegister.setBounds(156, 224, 117, 29);
		panel.add(btnRegister);
		
		username = new JTextField();
		username.setBounds(227, 25, 205, 26);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(227, 65, 205, 26);
		panel.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(227, 105, 205, 26);
		panel.add(address);
		address.setColumns(10);
		
		phoneNo = new JTextField();
		phoneNo.setBounds(227, 146, 205, 26);
		panel.add(phoneNo);
		phoneNo.setColumns(10);
		
		ccNo = new JTextField();
		ccNo.setBounds(227, 187, 205, 26);
		panel.add(ccNo);
		ccNo.setColumns(10);
	}

}
