package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Enrollment implements ActionListener {

	public JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JButton register;
	
String id_number, firstname, lastname, student_type, course;
private JLabel GooglePicture_Label;
private JComboBox comboBox_1;
private JComboBox comboBox_2;
private JButton Logout;
	
	public Enrollment(String id_number, String firstname, String lastname, String student_type, String course) {
		this.id_number = id_number;
		this.firstname = firstname;
		this.lastname = lastname;
		this.student_type = student_type;
		this.course = course;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enrollment window = new Enrollment();
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
	public Enrollment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 777, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enrollment Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		lblNewLabel.setBounds(218, 82, 342, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Number:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(169, 178, 104, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textField_1.setBounds(283, 178, 292, 37);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(169, 226, 104, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(283, 226, 292, 37);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name:");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(169, 274, 104, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(283, 274, 292, 37);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Student Type:");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(169, 322, 104, 37);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Course:");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(169, 372, 104, 37);
		frame.getContentPane().add(lblNewLabel_5);
		
		register = new JButton("Register");
		register.setForeground(Color.WHITE);
		register.setBackground(new Color(0, 128, 255));
		register.setFont(new Font("Century Gothic", Font.BOLD, 15));
		register.setBounds(471, 420, 104, 37);
		frame.getContentPane().add(register);
		register.addActionListener(this);
		
		GooglePicture_Label = new JLabel(new ImageIcon("C:\\Users\\Rainnand\\Downloads\\file-google-logo-svg-wikimedia-commons-23 (3).png"));
		GooglePicture_Label.setText("");
		GooglePicture_Label.setBounds(10, 11, 144, 50);
		frame.getContentPane().add(GooglePicture_Label);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select your student type", "Discounted (Gold)", "Discounted (Blue)", "Discounted (White)", "Continuing", "Walk-in"}));
		comboBox_1.setBounds(283, 324, 292, 37);
		frame.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select your course", "Tourism", "Computer Science", "Engineering", "Nursing", "Architecture"}));
		comboBox_2.setBounds(283, 372, 292, 37);
		frame.getContentPane().add(comboBox_2);
		
		Logout = new JButton("Logout");
		Logout.setForeground(Color.WHITE);
		Logout.setFont(new Font("Century Gothic", Font.BOLD, 15));
		Logout.setBackground(new Color(0, 128, 255));
		Logout.setBounds(654, 11, 99, 37);
		frame.getContentPane().add(Logout);
		Logout.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == register) {//condition if button is clicked
			//conditions if the text fields or boxes
			if(textField_1.getText().equals("") || textField_2.getText().equals("") ||textField_3.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "Please do not leave any blanks.");
			}else if (comboBox_1.getSelectedItem().equals("Select your student type")) {
				JOptionPane.showMessageDialog(frame, "Please choose your student type.");
			}else if (comboBox_2.getSelectedItem().equals("Select your course")) {
				JOptionPane.showMessageDialog(frame, "Please choose your course.");
			}
			else {//condition if all the boxes are completely filled
				Enrollment_output output = new Enrollment_output();
				tuition t = new tuition(comboBox_1.getSelectedItem(), comboBox_2.getSelectedItem());
			
				//The 8 lines below this comment will set the text of the labels in Enrollment_output frame.
				output.lblNewLabel_1_1.setText(textField_1.getText());
				output.lblNewLabel_2_2.setText(textField_2.getText() + " " + textField_3.getText());
				output.lblNewLabel_3_3.setText(t.studentType);
				output.lblNewLabel_4_4.setText(t.courseName);
				output.lblNewLabel_5_5.setText("Php " + Integer.toString(t.tuition));
				output.lblNewLabel_6_6.setText("Php " + Integer.toString(t.miscellaneous));
				output.lblNewLabel_7_7.setText("Php " + Integer.toString(t.totalTuition));
				output.lblNewLabel_d.setText(t.discount);
				this.frame.setVisible(false);//hide the current frame
				output.frame.setVisible(true);//show the next frame
			}
		}
		else if(e.getSource() == Logout) {
			//code for logout button
			Main_frame mf = new Main_frame();
			mf.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}

