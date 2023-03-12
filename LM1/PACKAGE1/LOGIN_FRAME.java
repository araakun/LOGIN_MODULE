package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login_frame implements ActionListener {

	public JFrame frame;
	private JTextField log_user_or_gmail_tf;
	private JPasswordField log_pf;
	private JButton log_enter_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_frame window = new Login_frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param pass 
	 * @param user 
	 * @param gmail 
	 */
	public Login_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 472);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		JLabel log_text = new JLabel("LOGIN");
		log_text.setFont(new Font("Tahoma", Font.PLAIN, 30));
		log_text.setBounds(258, 8, 102, 80);
		frame.getContentPane().add(log_text);
		
		JLabel user_or_email_lbl = new JLabel("Username or gmail: ");
		user_or_email_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user_or_email_lbl.setBounds(72, 137, 149, 44);
		frame.getContentPane().add(user_or_email_lbl);
		
		log_user_or_gmail_tf = new JTextField();
		log_user_or_gmail_tf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		log_user_or_gmail_tf.setColumns(10);
		log_user_or_gmail_tf.setBounds(228, 148, 180, 28);
		frame.getContentPane().add(log_user_or_gmail_tf);
		
		JLabel log_pw_lbl = new JLabel("Password:");
		log_pw_lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		log_pw_lbl.setBounds(141, 241, 80, 44);
		frame.getContentPane().add(log_pw_lbl);
		
		log_pf = new JPasswordField();
		log_pf.setBounds(229, 257, 179, 17);
		frame.getContentPane().add(log_pf);
		
		log_enter_btn = new JButton("ENTER");
		log_enter_btn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		log_enter_btn.setBounds(259, 349, 115, 35);
		frame.getContentPane().add(log_enter_btn);
		log_enter_btn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String log_pass = new String(log_pf.getPassword());
		boolean found = false;
		for (Account acc: Register_frame.account_list) {
			if (acc.account_username.equals(log_user_or_gmail_tf.getText())
					&& acc.account_password.equals(log_pass)) {
				found = true;
				break;
			}
		}
		if (found == true) {
			Welcome_user welcome = new Welcome_user();
			welcome.frame.setVisible(true);
		}
		
	}

}
