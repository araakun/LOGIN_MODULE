package PACKAGE2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class SignUp {

	private JFrame frame;
	private JTextField txtLogin;
	private JTextField textFullName;
	private JTextField textMobile;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Paul Danga\\Downloads\\logo.png"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 260, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign up to see photos and videos ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 37, 229, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFromYourFriends = new JLabel("from your friends.");
		lblFromYourFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblFromYourFriends.setForeground(new Color(255, 255, 255));
		lblFromYourFriends.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFromYourFriends.setBounds(10, 65, 229, 39);
		frame.getContentPane().add(lblFromYourFriends);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setForeground(new Color(255, 255, 255));
		txtLogin.setBackground(new Color(0, 128, 255));
		txtLogin.setText("       Log In with Facebook");
		txtLogin.setBounds(20, 101, 203, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("____________");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 115, 89, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("___________");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(145, 115, 89, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(101, 115, 30, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("By signing up, you agree to our");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(30, 290, 162, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Terms,");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_5.setForeground(new Color(0, 0, 160));
		lblNewLabel_5.setBounds(177, 290, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Policy, and Cookies Policy");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4_1.setBounds(61, 302, 162, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mobile = textMobile.getText();
				String FullName = textFullName.getText();
				String Username = textUsername.getText();
				String Password = textPassword.getText();
				
				
				if (mobile.equals("09123456789") && FullName.equals("NU Manila") 
					&& Username.equals("COM221") && Password.equals("comsci")) {
					
					JOptionPane.showMessageDialog(frame, "Created Account Successfully");
					
					Welcome window = new Welcome();
					window.frame.setVisible(true);
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(frame, "Fields must not be left unanswered");
				}
				
				
			}
		
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(20, 327, 203, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\output-onlinepngtools.png"));
		lblNewLabel_6.setBounds(57, 11, 136, 56);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblMobile = new JLabel("   Phone Number");
		lblMobile.setForeground(new Color(128, 128, 128));
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMobile.setBounds(20, 148, 106, 27);
		frame.getContentPane().add(lblMobile);
		
		JLabel lblNewLabel_3 = new JLabel("   Full Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setBounds(20, 182, 203, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFullName = new JTextField();
		textFullName.setColumns(10);
		textFullName.setBounds(20, 182, 203, 27);
		frame.getContentPane().add(textFullName);
		
		textMobile = new JTextField();
		textMobile.setColumns(10);
		textMobile.setBounds(20, 148, 203, 27);
		frame.getContentPane().add(textMobile);
		
		JLabel lblUsername = new JLabel("   Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setForeground(Color.GRAY);
		lblUsername.setBounds(20, 214, 203, 27);
		frame.getContentPane().add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(20, 214, 203, 27);
		frame.getContentPane().add(textUsername);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("   Password");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1_1.setForeground(Color.GRAY);
		lblNewLabel_3_1_1.setBounds(20, 245, 203, 27);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(20, 245, 203, 27);
		frame.getContentPane().add(textPassword);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\272200857_4686664818095300_1242704759968710139_n.png"));
		lblNewLabel_8.setBounds(-64, 0, 308, 361);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\download.jpg"));
		lblNewLabel_9.setBounds(30, 103, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
	}
}
