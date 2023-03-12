package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class Main_frame implements ActionListener {
	
	public static ArrayList <Autofiller> autofilled_accounts = new ArrayList <Autofiller>();
	public int counter = 0;
	public JFrame frame;
	public JButton reg_btn;
	public JButton log_btn;
	public JButton forgot_pw;
	public JTextField log_user_or_gmail_tf;
	private JPasswordField passwordField;
	public JButton autofill;
	private JLabel gmail_icon_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public JCheckBox remember;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame window = new Main_frame();
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
	public Main_frame() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 777, 557);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel welcome_label = new JLabel("Sign in to Gmail");
		welcome_label.setFont(new Font("Century Gothic", Font.PLAIN, 40));
		welcome_label.setBounds(238, 114, 325, 62);
		frame.getContentPane().add(welcome_label);
		
		reg_btn = new JButton("<HTML><U>Create Account</U></HTML>");
		reg_btn.setForeground(new Color(0, 0, 255));
		reg_btn.setBackground(Color.WHITE);
		reg_btn.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		reg_btn.setBounds(116, 426, 161, 28);
		frame.getContentPane().add(reg_btn);
		reg_btn.setBorder(null);
		reg_btn.addActionListener(this);
		
		log_btn = new JButton("LOGIN");
		log_btn.setForeground(Color.WHITE);
		log_btn.setBackground(new Color(0, 128, 255));
		log_btn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		log_btn.setBounds(519, 426, 161, 28);
		frame.getContentPane().add(log_btn);
		log_btn.addActionListener(this);
		
		log_user_or_gmail_tf = new JTextField();
		log_user_or_gmail_tf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		log_user_or_gmail_tf.setColumns(10);
		log_user_or_gmail_tf.setBounds(297, 245, 180, 28);
		frame.getContentPane().add(log_user_or_gmail_tf);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 297, 179, 17);
		frame.getContentPane().add(passwordField);
		
		JLabel log_pw_lbl = new JLabel("Password:");
		log_pw_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		log_pw_lbl.setBounds(210, 281, 80, 44);
		frame.getContentPane().add(log_pw_lbl);
		
		JLabel user_or_email_lbl = new JLabel("Username or email address: ");
		user_or_email_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user_or_email_lbl.setBounds(81, 236, 222, 44);
		frame.getContentPane().add(user_or_email_lbl);
		
		autofill = new JButton("<HTML><U>Autofill</U></HTML>");
		autofill.setBackground(UIManager.getColor("ComboBox.background"));
		autofill.setForeground(new Color(0, 0, 255));
		autofill.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		autofill.setBorderPainted(false);
		autofill.setContentAreaFilled(false);
		autofill.setBounds(477, 251, 58, 19);
		frame.getContentPane().add(autofill);
		autofill.addActionListener(this);
		
		forgot_pw = new JButton("Forgot Password?");
		forgot_pw.setForeground(new Color(0, 0, 255));
		forgot_pw.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		forgot_pw.setBorderPainted(false);
		forgot_pw.setContentAreaFilled(false);
		forgot_pw.setBounds(185, 326, 120, 19);
		frame.getContentPane().add(forgot_pw);
		forgot_pw.addActionListener(this);
		
		gmail_icon_1 = new JLabel("");
		gmail_icon_1.setIcon(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\gmail (1).png"));
		gmail_icon_1.setBounds(340, 24, 101, 78);
		frame.getContentPane().add(gmail_icon_1);
		
		lblNewLabel = new JLabel("To register:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel.setBounds(39, 426, 80, 28);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\google-logo-png-suite-everything-you-need-know-about-google-newest-0 (1).png"));
		lblNewLabel_1.setBounds(8, 8, 60, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		remember = new JCheckBox("Remember me");
		remember.setForeground(Color.BLACK);
		remember.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		remember.setBackground(Color.WHITE);
		remember.setBounds(325, 319, 116, 24);
		frame.getContentPane().add(remember);
		remember.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// AUTOFILLS THE TEXTFIELD AND PASSWORD FIELD BASED ON PREVIOUSLY LOGGED IN ACCOUNT
		if (e.getSource() == autofill) {
			if (counter > autofilled_accounts.size()) {
				counter = 0;
			}
				Autofiller autofilled_user = autofilled_accounts.get(counter);
				log_user_or_gmail_tf.setText(autofilled_user.username);
				passwordField.setText(autofilled_user.password);
				counter++;
			
		}
		// REGISTER FRAME 
		if (e.getSource() == reg_btn) {
			Register_frame reg = new Register_frame();
			reg.frame.setVisible(true);
			this.frame.setVisible(false);
		}
		// VERIFIES THE LOGIN INPUT
		else if (e.getSource() == log_btn) { 
			// VARIABLE DECLARATION
			String log_pass = new String(passwordField.getPassword());
			String log_user = log_user_or_gmail_tf.getText();
			boolean found = false;
			
			// INPUT OF USERNAME COULD BE WITH OR WITHOUT GMAIL ADDRESS
			if (log_user.endsWith("@gmail.com")) {
				log_user = log_user.substring(0, log_user.length() - 10);
			}
			
			// FIND LOGGED IN USER IN REGISTERED ACCOUNTS
			for (Account acc: Register_frame.account_list) {
				if (acc.account_username.equals(log_user) && acc.account_password.equals(log_pass)) {
					found = true;
					break;
				}
			}
			// IF LOGGED IN ACCOUNT IS FOUND ON ACCOUNT LIST, PROCEED TO ENROLLMENT SYSTEM
			if (found == true) {
				if (remember.isSelected()) {
					// IF REMEMBER IS CLICKED, ADD ACCOUNTS TO BE IN AUTOFILL SELECTION
					autofilled_accounts.add(new Autofiller(log_user, log_pass));
				}
				// GO TO ENROLLMENT PAGE
				JOptionPane.showMessageDialog(frame, "Successfully logged in");
				Enrollment enroll = new Enrollment();
				enroll.frame.setVisible(true);
				this.frame.setVisible(false);
			} else { // INVALIDATION
				JOptionPane.showMessageDialog(frame, "INVALID INPUT");
			}
		}
		// FOROOT PASSWORD BRINGS A NEW FRAME 
		else if (e.getSource() == forgot_pw) {
			Forgot_password pwframe = new Forgot_password();
			pwframe.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}
