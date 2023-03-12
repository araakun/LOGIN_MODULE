package PACKAGE1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class Welcome {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
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
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\x\\Downloads\\pngtree-instagram-icon-png-image_6315974.png"));
		frame.setBounds(100, 100, 260, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome New User!");
		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcome.setBounds(10, 153, 224, 14);
		frame.getContentPane().add(lblWelcome);
		
		JLabel lblInstagram = new JLabel("New label");
		lblInstagram.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\output-onlinepngtools.png"));
		lblInstagram.setBounds(54, 37, 134, 44);
		frame.getContentPane().add(lblInstagram);
		
		JLabel lblBackground = new JLabel("New label");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\x\\Downloads\\272200857_4686664818095300_1242704759968710139_n.png"));
		lblBackground.setBounds(-62, 0, 306, 361);
		frame.getContentPane().add(lblBackground);
		
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
