package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Icon;

public class Enrollment_output implements ActionListener{

	public JFrame frame;
	public JLabel lblNewLabel_1_1;
	public JLabel lblNewLabel_2_2;
	public JLabel lblNewLabel_3_3;
	public JLabel lblNewLabel_4_4;
	public JLabel lblNewLabel_5_5;
	private JLabel lblNewLabel_6;
	public JLabel lblNewLabel_6_6;
	private JLabel lblNewLabel_7;
	public JLabel lblNewLabel_7_7;
	private JButton enroll;
	private JButton back;
	private JLabel GooglePicture_Label;
	public JLabel lblNewLabel_d;
	private JButton Logout;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enrollment_output window = new Enrollment_output();
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
	public Enrollment_output() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 777, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Course:");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(148, 226, 145, 37);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Student Type:");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(148, 176, 145, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(148, 128, 145, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("ID Number:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(148, 80, 119, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel();
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(303, 80, 199, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		lblNewLabel_2_2 = new JLabel();
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(303, 128, 199, 37);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		lblNewLabel_3_3 = new JLabel();
		lblNewLabel_3_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(303, 176, 199, 37);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		lblNewLabel_4_4 = new JLabel();
		lblNewLabel_4_4.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_4_4.setBounds(303, 226, 199, 37);
		frame.getContentPane().add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tuition:");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(148, 274, 145, 37);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_5_5 = new JLabel("");
		lblNewLabel_5_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_5_5.setBounds(303, 274, 199, 37);
		frame.getContentPane().add(lblNewLabel_5_5);
		
		lblNewLabel_6 = new JLabel("Miscellaneous:");
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(148, 322, 145, 37);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_6_6 = new JLabel("");
		lblNewLabel_6_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_6_6.setBounds(303, 322, 199, 37);
		frame.getContentPane().add(lblNewLabel_6_6);
		
		lblNewLabel_7 = new JLabel("Total Amount:");
		lblNewLabel_7.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(148, 370, 145, 37);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_7_7 = new JLabel("");
		lblNewLabel_7_7.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_7_7.setBounds(303, 370, 199, 37);
		frame.getContentPane().add(lblNewLabel_7_7);
		
		enroll = new JButton("Enroll");
		enroll.setBackground(new Color(0, 128, 255));
		enroll.setForeground(Color.WHITE);
		enroll.setFont(new Font("Century Gothic", Font.BOLD, 15));
		enroll.setBounds(398, 418, 104, 37);
		frame.getContentPane().add(enroll);
		enroll.addActionListener(this);
		
		back = new JButton("Back");
		back.setBackground(Color.LIGHT_GRAY);
		back.setFont(new Font("Century Gothic", Font.BOLD, 15));
		back.setBounds(274, 418, 104, 37);
		frame.getContentPane().add(back);
		
		GooglePicture_Label = new JLabel(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\file-google-logo-svg-wikimedia-commons-23 (3).png"));
		GooglePicture_Label.setText("");
		GooglePicture_Label.setBounds(10, 11, 119, 37);
		frame.getContentPane().add(GooglePicture_Label);
		
		lblNewLabel_d = new JLabel("");
		lblNewLabel_d.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel_d.setBounds(418, 370, 199, 37);
		frame.getContentPane().add(lblNewLabel_d);
		
		Logout = new JButton("Logout");
		Logout.setForeground(Color.WHITE);
		Logout.setBackground(new Color(0, 128, 255));
		Logout.setFont(new Font("Century Gothic", Font.BOLD, 15));
		Logout.setBounds(654, 11, 99, 37);
		frame.getContentPane().add(Logout);
		
		JLabel ENROLL = new JLabel("ENROLLMENT");
		ENROLL.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		ENROLL.setBounds(284, 11, 207, 37);
		frame.getContentPane().add(ENROLL);
		back.addActionListener(this);
		
	//	Logout = new JButton("Logout");
		//Logout.setBounds(654, 11, 99, 37);
		//frame.getContentPane().add(Logout);
		//Logout.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enroll) {
			//will pop up a message dialog question (yes or no)
			 int result = JOptionPane.showConfirmDialog(frame,"Submit Enrollment Form?", "Swing Tester",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
		            if(result == JOptionPane.YES_OPTION){//statements if user click yes
		               Enrollment enroll = new Enrollment();
		               this.frame.setVisible(false);//hide frame
		               JOptionPane.showMessageDialog(frame, "Successfully Enrolled.");
		               enroll.frame.setVisible(true);//show frame
		            }
		            //no condition if user click no, therefore nothing will progress
		}else if (e.getSource() == back) {//will go back to previous frame before this frame
			Enrollment enroll = new Enrollment();
			enroll.frame.setVisible(true);	
			this.frame.setVisible(false);
		}
		else if(e.getSource() == Logout) {
			//code for logout button
			Main_frame mf = new Main_frame();
			mf.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}
