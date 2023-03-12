import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class EnrollmentPage extends JLayeredPane implements ActionListener, ItemListener{
	// fonts
	private InputStream fB = MainFrame.class.getResourceAsStream("GTWalsheimPro-Bold.ttf");
	private InputStream fM = MainFrame.class.getResourceAsStream("GTWalsheimPro-Medium.ttf");
	private InputStream fR = MainFrame.class.getResourceAsStream("GTWalsheimPro-Regular.ttf");
	
	private Font fontBold = Font.createFont(Font.TRUETYPE_FONT, fB);
	private Font fontRegular = Font.createFont(Font.TRUETYPE_FONT, fR);
	private Font fontMedium = Font.createFont(Font.TRUETYPE_FONT, fM);
	
	private Font bold = fontBold.deriveFont(30f);
	private Font regular = fontBold.deriveFont(14f);
	private Font smallBold = fontMedium.deriveFont(12f);
	private Font mediumBold = fontBold.deriveFont(17f);
	private Font mediumMedium = fontMedium.deriveFont(14f);
	private Font smallRegular = fontRegular.deriveFont(13f);
	
	// components
	private JPanel BackgroundPanel = new JPanel();
	private JPanel DetailsPanel = new JPanel();
	private JPanel Receipt;
	
	// textFields
	private JTextField IDName = new JTextField();
	private JTextField FirstName = new JTextField();
	private JTextField LastName = new JTextField();
	
	// buttons
	private JButton enrollBtn = new JButton("Enroll");
	private JButton ExitBtn = new JButton("Exit");
	private JButton finish;
	
	// image paths
	private String errorPath = "/Assets/err.png";
	private String check = "/Assets/check.jpg";
	
	// combo boxes
	private JComboBox Course = new JComboBox();
	private JComboBox Type = new JComboBox();
	
	// J labels
	private JLabel TypeName = new JLabel("Continuing");
	private JLabel TDiscount = new JLabel("Tuition Fee Discount: 10%");
	private JLabel MDiscount = new JLabel("Miscellaneous Fee Discount: 0%");
	
	private JLabel CourseName = new JLabel("Tourism");
	private JLabel TFee = new JLabel("Tuition Fee: 10,000");
	private JLabel MFee = new JLabel("Miscellaneous Fee: 22,500");
	
	// errors
	private JLabel invalidIdNumber = new JLabel("ID number is required");
	private boolean invalidIdNumberAdded = false;
	private JLabel invalidFirstName = new JLabel("First name is required");
	private boolean invalidFirstNameAdded = false;
	private JLabel  invalidLastName = new JLabel("Last name is required");
	private boolean invalidLastNameAdded = false;
	
	// Storage Values
	private HashMap<String, int[]> Fees = new HashMap<>(); // holds the tuitionFee and Miscellaneous Fee in format Course:[tuition fee, miscellaneous fee]
	private HashMap<String, double[]> Discounts = new HashMap<>(); // holds the tuitionFee discount and Miscellaneous Fee discount in format Course:[tuition fee, miscellaneous fee]
	
	/**
	 * Create the panel.
	 */
	
	public EnrollmentPage() throws FontFormatException, IOException{
		this.setBounds(500, 500, 600, 550);
		
		initializeHashMaps();
		initializeErrors();
		
		addBackgroundPanel();
		addDetailsPanels();
		setLayout(null);
		
	}
	private void initializeHashMaps() {
		this.Fees.put("Tourism", new int[] {10000, 22500});
		this.Fees.put("Computer Science", new int[] {20000, 11000});
		this.Fees.put("Engineering", new int[] {30000, 25000});
		this.Fees.put("Nursing", new int[] {15000, 15000});
		this.Fees.put("Architecture", new int[] {25000, 23000});
		
		this.Discounts.put("Continuing", new double[] {.1, 0});
		this.Discounts.put("Walk In", new double[] {0, 0});
		this.Discounts.put("Gold", new double[] {.5, .5});
		this.Discounts.put("Blue", new double[] {.3, .3});
		this.Discounts.put("White", new double[] {.1, .1});
	}
	
	private void initializeErrors() {
		ImageIcon error = new ImageIcon(MainFrame.class.getResource(this.errorPath));
		Image image_1 = error.getImage();
		Image newimg_1 = image_1.getScaledInstance(13, 13,  java.awt.Image.SCALE_SMOOTH); 
		error = new ImageIcon(newimg_1);
		
		this.invalidIdNumber.setFont(smallBold);
		this.invalidIdNumber.setForeground(new Color(255, 74, 74));
		this.invalidIdNumber.setBounds(100, 5, 153, 14);
		this.invalidIdNumber.setIcon(error);
		
		this.invalidFirstName.setFont(smallBold);
		this.invalidFirstName.setForeground(new Color(255, 74, 74));
		this.invalidFirstName.setBounds(178, 60, 131, 14);
		this.invalidFirstName.setIcon(error);
		
		this.invalidLastName.setFont(smallBold);
		this.invalidLastName.setForeground(new Color(255, 74, 74));
		this.invalidLastName.setBounds(28, 60, 140, 14);
		this.invalidLastName.setIcon(error);
	}
	
	private void addBackgroundPanel() {
		BackgroundPanel.setBounds(0, 0, 271, 550);
		BackgroundPanel.setBackground(new Color(0, 35, 51));
		this.add(BackgroundPanel, JLayeredPane.DEFAULT_LAYER);
		BackgroundPanel.setLayout(null);
		
		JLabel greetings = new JLabel("Welcome To");
		greetings.setForeground(new Color(255, 255, 255));
		greetings.setFont(bold);
		greetings.setBounds(45, 37, 304, 116);
		BackgroundPanel.add(greetings);
		
		JLabel lblHonorata = new JLabel("Honorata");
		lblHonorata.setForeground(Color.WHITE);
		lblHonorata.setFont(bold);
		lblHonorata.setBounds(55, 80, 370, 100);
		BackgroundPanel.add(lblHonorata);
		
		JLabel lblHighschool = new JLabel("Highschool");
		lblHighschool.setForeground(Color.WHITE);
		lblHighschool.setFont(bold);
		lblHighschool.setBounds(48, 119, 370, 94);
		BackgroundPanel.add(lblHighschool);
		
		JButton green = new JButton("");
		green.setForeground(new Color(0, 255, 132));
		green.setBackground(new Color(0, 255, 132));
		green.setBounds(45, 215, 136, 8);
		green.setBorder(new RoundedBorder(30)); //10 is the radius
		green.setFocusable(false);

		BackgroundPanel.add(green);
		
		JTextPane description = new JTextPane();
		description.setEditable(false);
		description.setForeground(new Color(232, 232, 232));
		description.setBackground(new Color(0, 35, 51));
		description.setFont(regular);
		description.setText("Here we inspire discovery through creativity, "
				+ "making you see the beauty of learning one problem at time."
				+ "\n\nHelp us help you help the world!"
				+ "\n\nTo enroll, Please fill up the following requirements");
		description.setBounds(40, 249, 209, 301);
		BackgroundPanel.add(description);
		
		
	}
	
	private void produceReceipt() {
		this.remove(DetailsPanel);
		Receipt = new JPanel();
		Receipt.setBounds(268, 0, 332, 550);
		Receipt.setLayout(null);
		
		JLabel holder = new JLabel("");
		holder.setBounds(89, 45, 161, 100);
		
		ImageIcon icon = new ImageIcon(MainFrame.class.getResource(this.check)); 
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); 
		icon = new ImageIcon(newimg);
		holder.setIcon(icon);
		Receipt.add(holder);
		
		finish = new JButton("Finish");
		finish.setForeground(new Color(0, 35, 51));
		finish.setFont(regular);
		finish.setBorder(null); //10 is the radius
		finish.setBackground(new Color(0, 255, 132));
		finish.setBounds(59, 446, 225, 33);
		finish.addActionListener(this);
		Receipt.add(finish);
		
		JLabel IDN = new JLabel("ID Number: "+this.IDName.getText()); // id number
		IDN.setBounds(59, 190, 263, 14);
		IDN.setForeground(new Color(0, 35, 51));
		IDN.setFont(mediumMedium);
		
		JLabel FN = new JLabel("First Name: "+this.FirstName.getText()); // first name
		FN.setBounds(59, 220, 277, 14);
		FN.setForeground(new Color(0, 35, 51));
		FN.setFont(mediumMedium);
		
		JLabel LN = new JLabel("Last Name: "+this.LastName.getText()); // last name
		LN.setBounds(59, 245, 277, 14);
		LN.setForeground(new Color(0, 35, 51));
		LN.setFont(mediumMedium);
		
		JLabel C = new JLabel("Course: "+(String) this.Course.getSelectedItem()); // course name
		C.setBounds(59, 316, 263, 14);
		C.setForeground(new Color(0, 35, 51));
		C.setFont(mediumMedium);
		
		JLabel T = new JLabel("Type: "+(String) this.Type.getSelectedItem()); // Type name
		T.setBounds(59, 292, 287, 14);
		T.setForeground(new Color(0, 35, 51));
		T.setFont(mediumMedium);
		
		int[] fee = this.Fees.get(this.Course.getSelectedItem());
		double[] discount = this.Discounts.get(this.Type.getSelectedItem());
		double total = fee[0]*(1-discount[0]) + fee[1]*(1-discount[1]);
		
		JLabel S = new JLabel("Total Fee: "+total); // Sum of total fee
		S.setBounds(59, 353, 154, 68);
		S.setForeground(new Color(0, 35, 51));
		S.setFont(mediumBold);
		
		
		Receipt.add(IDN);
		Receipt.add(FN);
		Receipt.add(LN);
		Receipt.add(C);
		Receipt.add(T);
		Receipt.add(S);
		
		this.add(Receipt, JLayeredPane.PALETTE_LAYER);
		this.repaint();
		this.revalidate();
	}
	
	private void addDetailsPanels() {
		DetailsPanel.setBounds(268, 0, 463, 650);
		add(DetailsPanel, JLayeredPane.DEFAULT_LAYER);
		DetailsPanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(229, 5, 5, 22);
		DetailsPanel.add(textArea);
		
		FirstName.setDropMode(DropMode.INSERT);
		FirstName.setToolTipText("Input First name here");
		FirstName.setText("First Name");
		FirstName.setForeground(new Color(0, 34, 51));
		FirstName.setFont(new Font("GT Walsheim Pro", Font.PLAIN, 13));
		FirstName.setColumns(10);
		FirstName.setBounds(178, 77, 142, 33);
		DetailsPanel.add(FirstName);
		
		LastName.setToolTipText("Input Last name here\r\n");
		LastName.setText("Last Name");
		LastName.setForeground(new Color(0, 34, 51));
		LastName.setFont(new Font("Dialog", Font.PLAIN, 13));
		LastName.setColumns(10);
		LastName.setBounds(28, 77, 140, 33);
		DetailsPanel.add(LastName);
		
		JPanel CourseDesctiption = new JPanel();
		CourseDesctiption.setBackground(new Color(0, 35, 51));
		CourseDesctiption.setBounds(50, 301, 231, 126);
		DetailsPanel.add(CourseDesctiption);
		CourseDesctiption.setLayout(null);
		
		CourseName.setHorizontalAlignment(SwingConstants.CENTER);
		CourseName.setForeground(Color.WHITE);
		CourseName.setFont(mediumBold);
		CourseName.setBounds(0, 22, 231, 21);
		CourseDesctiption.add(CourseName);
		
		TFee.setHorizontalAlignment(SwingConstants.CENTER);
		TFee.setForeground(Color.WHITE);
		TFee.setBounds(0, 54, 231, 14);
		CourseDesctiption.add(TFee);
		
		MFee.setHorizontalAlignment(SwingConstants.CENTER);
		MFee.setForeground(Color.WHITE);
		MFee.setBounds(0, 87, 231, 14);
		CourseDesctiption.add(MFee);
		
		Type.setForeground(new Color(0, 35, 51));
		Type.setModel(new DefaultComboBoxModel(new String[] {"Continuing", "Walk In", "Gold", "Blue", "White"}));
		Type.setFont(smallRegular);
		Type.setMaximumRowCount(5);
		Type.setBounds(110, 268, 98, 22);
		Type.addItemListener(this);
		DetailsPanel.add(Type);
		
		Course.setModel(new DefaultComboBoxModel(new String[] {"Tourism", "Computer Science", "Engineering", "Nursing", "Architecture"}));
		Course.setMaximumRowCount(5);
		Course.setForeground(new Color(0, 35, 51));
		Course.setFont(new Font("GT Walsheim Pro", Font.PLAIN, 13));
		Course.setBounds(110, 440, 98, 22);
		Course.addItemListener(this);
		DetailsPanel.add(Course);
		
		enrollBtn.setForeground(new Color(0, 35, 51));
		enrollBtn.setFont(regular);
		enrollBtn.setBorder(null); //10 is the radius
		enrollBtn.setBackground(new Color(0, 255, 132));
		enrollBtn.setBounds(161, 496, 120, 33);
		enrollBtn.addActionListener(this);
		DetailsPanel.add(enrollBtn);
		
		ExitBtn.setForeground(new Color(0, 35, 51));
		ExitBtn.setFont(regular);
		ExitBtn.setBorder(null);
		ExitBtn.setBackground(new Color(255, 94, 89));
		ExitBtn.setBounds(50, 496, 101, 33);
		DetailsPanel.add(ExitBtn);
		
		JPanel TypeDescription = new JPanel();
		TypeDescription.setBounds(50, 131, 231, 126);
		DetailsPanel.add(TypeDescription);
		TypeDescription.setBackground(new Color(0, 35, 51));
		TypeDescription.setLayout(null);
		
		TypeName.setHorizontalAlignment(SwingConstants.CENTER);
		TypeName.setFont(mediumBold);
		TypeName.setForeground(new Color(255, 255, 255));
		TypeName.setBounds(0, 21, 231, 21);
		TypeDescription.add(TypeName);
		
		TDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		TDiscount.setForeground(new Color(255, 255, 255));
		TDiscount.setBounds(0, 59, 231, 14);
		TypeDescription.add(TDiscount);
		
		MDiscount.setHorizontalAlignment(SwingConstants.CENTER);
		MDiscount.setForeground(Color.WHITE);
		MDiscount.setBounds(0, 87, 231, 14);
		TypeDescription.add(MDiscount);
		IDName.setBounds(28, 24, 292, 33);
		DetailsPanel.add(IDName);
		
		IDName.setText("ID Number");
		IDName.setFont(smallRegular);
		IDName.setToolTipText("input ID number here");
		IDName.setForeground(new Color(0, 34, 51));
		IDName.setColumns(10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.enrollBtn) {
			boolean valid = true;
			
			String idName = this.IDName.getText().trim();
			String firstName = this.FirstName.getText().trim();
			String lastName = this.LastName.getText().trim();
			
			if (Objects.equals(idName, "") && !this.invalidIdNumberAdded) {
				this.DetailsPanel.add(this.invalidIdNumber);
				this.invalidIdNumberAdded = true;
				valid = false;
			}
			if (Objects.equals(firstName, "") && !this.invalidFirstNameAdded) {
				this.DetailsPanel.add(this.invalidFirstName);
				this.invalidFirstNameAdded = true;
				valid = false;
			}
			if (Objects.equals(lastName, "") && !this.invalidLastNameAdded) {
				this.DetailsPanel.add(this.invalidLastName);
				this.invalidLastNameAdded = true;
				valid = false;
			}
			
			if (valid) produceReceipt();
			
			 this.IDName.setText("");
			 this.FirstName.setText("");
			 this.LastName.setText("");
			 this.DetailsPanel.repaint();
		}
		if (e.getSource() == this.finish) {
			this.remove(this.Receipt);
			this.add(DetailsPanel, JLayeredPane.PALETTE_LAYER);
			this.repaint();
			this.revalidate();
		}
	}
	
	public JButton getExitButton() {
		return this.ExitBtn;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == Type) {
			String type = (String) Type.getSelectedItem();
			double[] discounts = this.Discounts.get(type);
	
			this.TypeName.setText(type);
			this.TDiscount.setText("Tuition Fee Discount: "+(discounts[0]*100)+"%");
			this.MDiscount.setText("Miscellaneous Fee Discount: "+(discounts[1]*100)+"%");
		}
		
		if (e.getSource() == Course) {
			String course = (String) Course.getSelectedItem();
			int[] fee = this.Fees.get(course);
			
			this.CourseName.setText(course);
			this.TFee.setText("Tuition Fee: "+(fee[0]));
			this.MFee.setText("Miscellaneous Fee: "+(fee[1]));
		}
		
		this.DetailsPanel.repaint();
	}
}
