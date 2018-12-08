import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

import backend.User;
import backend.UserManagement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn {

	public JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Login");
					SignIn window = new SignIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignIn() {
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
		lblUsername.setBounds(111, 79, 78, 16);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(111, 128, 78, 16);
		panel.add(lblPassword);
		
		username = new JTextField();
		username.setToolTipText("Email");
		username.setBounds(219, 74, 163, 26);
		panel.add(username);
		username.setColumns(50);
		
		password = new JTextField();
		password.setBounds(219, 123, 163, 26);
		panel.add(password);
		password.setColumns(30);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnSignUp.setBounds(93, 192, 117, 29);
		panel.add(btnSignUp);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = username.getText();
				String pad = password.getText();
				
				if(UserManagement.login(new User(uname, pad)))
				{
					System.out.println("Login successful");
					new PlaceOrder().frame.setVisible(true);
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Incorrect username/password");
				}
			}
		});
		btnSignIn.setBounds(265, 192, 117, 29);
		panel.add(btnSignIn);
	}
}
