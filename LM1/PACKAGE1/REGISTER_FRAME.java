package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;

public class Register_frame implements ActionListener {

	public JFrame frame;
	private JTextField reg_user_tf;
	private JPasswordField reg_pw_pf;
	private JPasswordField reg_rpw_pf;
	private JButton reg_enter_btn;
	public static ArrayList <Account> account_list = new ArrayList <Account>();
	public JButton log;
	public JButton goback;
	private JTextField firstname_textField;
	private JLabel first_name_lb;
	private JTextField lastname_textfield;
	private JLabel user_lbl_2;
	private JLabel user_lbl_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_frame window = new Register_frame();
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
	public Register_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 777, 557);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		
		JLabel reg_text = new JLabel("Create your Google Account");
		reg_text.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		reg_text.setBounds(19, 36, 297, 44);
		frame.getContentPane().add(reg_text);
		
		JLabel user_lbl = new JLabel("Username");
		user_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user_lbl.setBounds(19, 215, 91, 44);
		frame.getContentPane().add(user_lbl);
		
		JLabel pw_lbl = new JLabel("Password");
		pw_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		pw_lbl.setBounds(19, 306, 80, 44);
		frame.getContentPane().add(pw_lbl);
		
		JLabel rpw_lbl = new JLabel("Confirm password");
		rpw_lbl.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		rpw_lbl.setBounds(231, 306, 136, 44);
		frame.getContentPane().add(rpw_lbl);
		
		reg_user_tf = new JTextField();
		reg_user_tf.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		reg_user_tf.setBounds(19, 248, 179, 28);
		frame.getContentPane().add(reg_user_tf);
		reg_user_tf.setColumns(10);
		
		reg_pw_pf = new JPasswordField();
		reg_pw_pf.setBounds(19, 337, 179, 17);
		frame.getContentPane().add(reg_pw_pf);
		
		reg_rpw_pf = new JPasswordField();
		reg_rpw_pf.setBounds(231, 337, 179, 17);
		frame.getContentPane().add(reg_rpw_pf);
		
		reg_enter_btn = new JButton("Enter");
		reg_enter_btn.setForeground(Color.WHITE);
		reg_enter_btn.setBackground(new Color(0, 128, 255));
		reg_enter_btn.setFont(new Font("Century Gothic", Font.BOLD, 15));
		reg_enter_btn.setBounds(490, 373, 115, 35);
		frame.getContentPane().add(reg_enter_btn);
		
		firstname_textField = new JTextField();
		firstname_textField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		firstname_textField.setColumns(10);
		firstname_textField.setBounds(19, 160, 179, 28);
		frame.getContentPane().add(firstname_textField);
		
		first_name_lb = new JLabel("First name");
		first_name_lb.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		first_name_lb.setBounds(19, 124, 91, 44);
		frame.getContentPane().add(first_name_lb);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lastname_textfield.setColumns(10);
		lastname_textfield.setBounds(231, 160, 179, 28);
		frame.getContentPane().add(lastname_textfield);
		
		user_lbl_2 = new JLabel("Last name");
		user_lbl_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user_lbl_2.setBounds(231, 124, 91, 44);
		frame.getContentPane().add(user_lbl_2);
		
		user_lbl_3 = new JLabel("<HTML><u>@gmail.com</u></HTML>");
		user_lbl_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		user_lbl_3.setBounds(231, 240, 91, 44);
		frame.getContentPane().add(user_lbl_3);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\file-google-logo-svg-wikimedia-commons-23 (3).png"));
		lblNewLabel.setBounds(19, 8, 91, 35);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\icon_reg1 (1).png"));
		lblNewLabel_1.setBounds(424, 92, 271, 273);
		frame.getContentPane().add(lblNewLabel_1);
		
		log = new JButton("<HTML><u>Sign In instead</u><HTML>");
		log.setForeground(Color.BLUE);
		log.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		log.setBackground(Color.WHITE);
		log.setBorder(null);
		log.setBounds(12, 374, 103, 35);
		frame.getContentPane().add(log);
		
		goback = new JButton("Go back");
		goback.setForeground(Color.WHITE);
		goback.setFont(new Font("Century Gothic", Font.BOLD, 15));
		goback.setBackground(new Color(0, 128, 255));
		goback.setBounds(490, 420, 115, 35);
		frame.getContentPane().add(goback);
		log.addActionListener(this);
		
		goback.addActionListener(this);
		log.addActionListener(this);
		reg_enter_btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// VARIABLE DECLARTION
		if (e.getSource() == reg_enter_btn) {
			String pw = new String(reg_pw_pf.getPassword());
			String rpw = new String(reg_rpw_pf.getPassword());
			boolean proceed = true;
			
			// DETERMINE IF PASSWORD IS EQUAL TO RE-ENTERED PASSWORD
			if(!pw.equals(rpw)){
				proceed = false;
			}
			
			// BOOLEAN AND VALIDATION
			if (proceed == false) {
				JOptionPane.showMessageDialog(frame, "Invalid Input");
			} else {
				account_list.add(new Account(reg_user_tf.getText(), pw ));
				JOptionPane.showMessageDialog(frame, "Registered Successfully");
			}
			
		} else if (e.getSource() == goback || e.getSource() == log ) {
			Main_frame mf = new Main_frame();
			mf.frame.setVisible(true);
			this.frame.setVisible(false);
		}

	}
}
