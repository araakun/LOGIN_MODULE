package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Forgot_password implements ActionListener {

	public JFrame frame;
	private JTextField user_tf;
	private JPasswordField new_pass;
	private JPasswordField confirm_pass;
	public JButton login_page;
	public JButton enter_btn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot_password window = new Forgot_password();
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
	public Forgot_password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		user_tf = new JTextField();
		user_tf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user_tf.setColumns(10);
		user_tf.setBounds(292, 189, 179, 28);
		frame.getContentPane().add(user_tf);
		
		new_pass = new JPasswordField();
		new_pass.setBounds(292, 238, 179, 17);
		frame.getContentPane().add(new_pass);
		
		confirm_pass = new JPasswordField();
		confirm_pass.setBounds(292, 275, 179, 17);
		frame.getContentPane().add(confirm_pass);
		
		JLabel new_pw_lbl = new JLabel("New Password");
		new_pw_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		new_pw_lbl.setBounds(147, 224, 115, 44);
		frame.getContentPane().add(new_pw_lbl);
		
		JLabel rpw_lbl = new JLabel("Confirm password");
		rpw_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		rpw_lbl.setBounds(126, 261, 136, 44);
		frame.getContentPane().add(rpw_lbl);
		
		JLabel user_lbl = new JLabel("Username or Email Address");
		user_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user_lbl.setBounds(59, 183, 197, 44);
		frame.getContentPane().add(user_lbl);
		
		enter_btn = new JButton("ENTER");
		enter_btn.setForeground(Color.WHITE);
		enter_btn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		enter_btn.setBackground(new Color(0, 128, 255));
		enter_btn.setBounds(329, 332, 115, 35);
		frame.getContentPane().add(enter_btn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\file-google-logo-svg-wikimedia-commons-23 (3).png"));
		lblNewLabel.setBounds(329, 81, 99, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\google-logo-png-suite-everything-you-need-know-about-google-newest-0 (1).png"));
		lblNewLabel_1.setBounds(341, 12, 60, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel reg_text = new JLabel("Set up a new password");
		reg_text.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		reg_text.setBounds(247, 123, 240, 44);
		frame.getContentPane().add(reg_text);
		
		login_page = new JButton("Return to Login");
		login_page.setForeground(Color.WHITE);
		login_page.setFont(new Font("Century Gothic", Font.BOLD, 15));
		login_page.setBackground(new Color(0, 128, 255));
		login_page.setBounds(594, 449, 155, 35);
		frame.getContentPane().add(login_page);
		frame.setBounds(100, 100, 777, 557);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		login_page.addActionListener(this);
		enter_btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// PROMPTS FOR NEW PASSWORD VALIDATION
		if (e.getSource() == enter_btn) {
			String user = user_tf.getText();
			String pass = new String(new_pass.getPassword());
			String confirmed_pass = new String(confirm_pass.getPassword());
			if (!pass.equals(confirmed_pass)) {
				JOptionPane.showMessageDialog(frame, "Please Enter the Correct Password");
			} else {
				if (user.endsWith("@gmail.com")) {
					user = user.substring(0, user.length() - 10);
				}
				
				boolean found = false;
				for (Account acc: Register_frame.account_list) {
					if (acc.account_username.equals(user)) {
						found = true;
						break;
					}
				}
				
				if (found == true) {
					Register_frame.account_list.add(new Account(user, pass));
					JOptionPane.showMessageDialog(frame, "New password implemented");
					
					
				} else {
					JOptionPane.showMessageDialog(frame, "INVALID INPUT");
				}
			}
			
		// RETURNS BACK TO LOGIN PAGE
		} else if (e.getSource() == login_page) {
			Main_frame mf = new Main_frame();
			mf.frame.setVisible(true);
			this.frame.setVisible(false);
		}
		
	}

}
