package PACKAGE3;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import PACKAGE2.SignUp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class ForgotPass {

	private JFrame frame;
	private JTextField txtEmailPhoneUN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPass window = new ForgotPass();
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
	public ForgotPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 260, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trouble logging in?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 68, 183, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your email, phone, or username and");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 111, 224, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("we'll send you a link to get back into");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 124, 224, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("your account.");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(10, 136, 224, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtEmailPhoneUN = new JTextField();
		txtEmailPhoneUN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		txtEmailPhoneUN.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEmailPhoneUN.setForeground(new Color(128, 128, 128));
		txtEmailPhoneUN.setText("Emaill, Phone, or Username");
		txtEmailPhoneUN.setBounds(20, 161, 202, 32);
		frame.getContentPane().add(txtEmailPhoneUN);
		txtEmailPhoneUN.setColumns(10);
		
		JButton btnNewButton = new JButton("Send login link");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EmailPhoneUN = txtEmailPhoneUN.getText();
				
				if (EmailPhoneUN.equals("Admin")) {
					JOptionPane.showMessageDialog(frame, "Link sent!");
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "No account detected with entered credential.");
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(22, 204, 202, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Can't reset your password?");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(51, 249, 146, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("____________");
		lblNewLabel_3.setBounds(21, 265, 92, 24);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("____________");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3_1.setBounds(123, 265, 98, 23);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("OR");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_4.setBounds(112, 275, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Create new account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignUp info = new SignUp();
				SignUp.main(null);
				
				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 64, 64));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 9));
		btnNewButton_1.setBounds(51, 302, 146, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\272200857_4686664818095300_1242704759968710139_n.png"));
		lblNewLabel_6.setBounds(-63, 0, 307, 361);
		frame.getContentPane().add(lblNewLabel_6);
		
		
	}
}
