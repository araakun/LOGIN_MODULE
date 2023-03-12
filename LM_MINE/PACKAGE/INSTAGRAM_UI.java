package PACKAGE1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import PACKAGE2.SignUp;
import PACKAGE3.ForgotPass;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class INSTAGRAM_UI {

	private JFrame frame;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;
	private final JSeparator separator_2 = new JSeparator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INSTAGRAM_UI window = new INSTAGRAM_UI();
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
	public INSTAGRAM_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.getContentPane().setBackground(new Color(255, 0, 255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\x\\Downloads\\pngtree-instagram-icon-png-image_6315974.png"));
		frame.setBounds(100, 100, 260, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\output-onlinepngtools.png"));
		lblInstagram.setBounds(55, 38, 134, 44);
		frame.getContentPane().add(lblInstagram);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (textFieldUsername.equals("AraGonzaga18") && passwordFieldPassword.equals("031804")) {
						JOptionPane.showMessageDialog(frame, "LOGIN SUCCESSFUL");
						
						Welcome window = new Welcome();
						window.frame.setVisible(true);
					}
					else if (textFieldUsername.equals("DianaDanga07") && passwordFieldPassword.equals("050703")) {
						JOptionPane.showMessageDialog(frame, "LOGIN SUCCESSFUL");
						
						Welcome window = new Welcome();
						window.frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(frame, "INVALID ACCOUNT");
					}
					
				}
			
		});
		
		btnLogIn.setBackground(new Color(0, 128, 255));
		btnLogIn.setFont(new Font("Arial", Font.BOLD, 11));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBounds(23, 193, 197, 23);
		btnLogIn.setBorder(new RoundedBorder(10));
		btnLogIn.setFocusable(false);
		frame.getContentPane().add(btnLogIn);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPass window = new ForgotPass();
				ForgotPass.main(null);
			}
		});
		lblForgotPassword.setForeground(new Color(255, 255, 255));
		lblForgotPassword.setFont(new Font("Arial", Font.PLAIN, 10));
		lblForgotPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForgotPassword.setBounds(121, 169, 99, 13);
		frame.getContentPane().add(lblForgotPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 239, 84, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(136, 239, 84, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("OR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(105, 227, 30, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Log in with Faceboook");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.facebook.com/").toURI());
				}
				catch (Exception e1)
				{}
			}
		});
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\download (1).jpg"));
		lblNewLabel_1.setBounds(23, 252, 197, 49);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 8));
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setBounds(23, 134, 53, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("  Phone number, username, or email");
		lblNewLabel_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 8));
		lblNewLabel_2_1.setBounds(23, 107, 139, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(23, 107, 197, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JButton btnShow = new JButton("");	
		
		btnShow.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\output-onlinepngtools (2).png"));
		btnShow.setBackground(new Color(255, 255, 255));
		btnShow.setForeground(new Color(255, 255, 255));
		btnShow.setFont(new Font("Arial", Font.BOLD, 8));
		btnShow.setBounds(196, 138, 24, 23);
		frame.getContentPane().add(btnShow);
		
		
		JButton btnDont_Show = new JButton("");
		
		btnDont_Show.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\output-onlinepngtools (3).png"));
		btnDont_Show.setForeground(Color.WHITE);
		btnDont_Show.setFont(new Font("Arial", Font.BOLD, 8));
		btnDont_Show.setBackground(Color.WHITE);
		btnDont_Show.setBounds(196, 138, 24, 23);
		frame.getContentPane().add(btnDont_Show);
		
		btnShow.addMouseListener(new MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				btnDont_Show.setVisible(true);
				btnShow.setVisible(false);
				passwordFieldPassword.setEchoChar((char)0);
				
			}
		});
		
		btnDont_Show.addMouseListener(new MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				btnShow.setVisible(true);
				btnDont_Show.setVisible(false);
				passwordFieldPassword.setEchoChar('•');
				
			}
		});
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(23, 138, 197, 23);
		frame.getContentPane().add(passwordFieldPassword);
		
		JCheckBox chckbxRM = new JCheckBox("");
		chckbxRM.addMouseListener(new MouseAdapter() {
			
		});
		chckbxRM.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxRM.setBackground(new Color(255, 0, 255));
		chckbxRM.setBounds(23, 169, 11, 13);
		frame.getContentPane().add(chckbxRM);
		
		JLabel lblRememberMe = new JLabel("     Remember me");
		lblRememberMe.setHorizontalAlignment(SwingConstants.LEFT);
		lblRememberMe.setForeground(Color.WHITE);
		lblRememberMe.setFont(new Font("Arial", Font.PLAIN, 10));
		lblRememberMe.setBounds(23, 165, 99, 20);
		frame.getContentPane().add(lblRememberMe);
		separator_2.setForeground(new Color(128, 128, 128));
		separator_2.setBounds(0, 337, 244, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account? ");
		lblDontHaveAn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDontHaveAn.setForeground(Color.WHITE);
		lblDontHaveAn.setFont(new Font("Arial", Font.PLAIN, 10));
		lblDontHaveAn.setBounds(36, 337, 126, 24);
		frame.getContentPane().add(lblDontHaveAn);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				SignUp window = new SignUp();
				SignUp.main(null);
					
				}
		});
		lblSignUp.setHorizontalAlignment(SwingConstants.LEFT);
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 9));
		lblSignUp.setBounds(161, 337, 39, 24);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\272200857_4686664818095300_1242704759968710139_n.png"));
		lblNewLabel_3.setBounds(-62, 0, 306, 361);
		frame.getContentPane().add(lblNewLabel_3);
		frame.setVisible(true);
	}
}
