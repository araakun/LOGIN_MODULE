import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MainFrame extends JFrame implements ActionListener, MouseListener{
	
	// FONTS
	private InputStream fB = MainFrame.class.getResourceAsStream("GTWalsheimPro-Bold.ttf");
	private InputStream fM = MainFrame.class.getResourceAsStream("GTWalsheimPro-Medium.ttf");
	private InputStream fR = MainFrame.class.getResourceAsStream("GTWalsheimPro-Regular.ttf");
	
	private Font fontBold = Font.createFont(Font.TRUETYPE_FONT, fB);
	private Font fontRegular = Font.createFont(Font.TRUETYPE_FONT, fR);
	private Font fontMedium = Font.createFont(Font.TRUETYPE_FONT, fM);
	
	private Font bold = fontBold.deriveFont(23f);
	private Font regular = fontBold.deriveFont(15f);
	private Font smallMedium = fontMedium.deriveFont(12f);
	private Font mediumBold = fontBold.deriveFont(13f);
	private Font mediumMedium = fontMedium.deriveFont(12f);
	private Font smallRegular = fontRegular.deriveFont(13f);

	// Main Pages
	private JLayeredPane mainContentPane = new JLayeredPane();
	private JPanel textSection;
	private JPanel loginSection = new JPanel();
	private JLayeredPane enrollmentPage = new EnrollmentPage();

	// redirects
	private JPanel facebookRedicrect;
	private JPanel googleRedirect;
	private JPanel appleRedirect;
	
	// fields
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField confirmPassword;
	
	// buttons
	private JButton signInButton;
	private JLabel SignUp = new JLabel("Sign Up.");
	
	// items
	private JCheckBox keepSignIn = new JCheckBox("Keep me signed in until I sign out");
	
	// image paths
	private String facebookPath = "/Assets/facebook.png";
	private String googlePath = "/Assets/google.png";
	private String applePath = "/Assets/apple.png";
	private String errorPath = "/Assets/err.png";
	private String backgroundPath = "/Assets/background.png";
	
	//labels
	JTextPane TextLabel = new JTextPane();
	JTextPane description = new JTextPane();
	JLabel notAMemberYet = new JLabel("Not a member yet? ");
	JLabel forgotPassword = new JLabel("Forgot password?");
	
	// flags
	private String mode = "Sign In";
	private JLabel invalidEmail  = new JLabel("");
	private boolean emailFlagAdded = false;
	JLabel passwordEmpty = new JLabel("Password is required");
	private boolean passwordFlagAdded = false;
	JLabel passwordMisMatch = new JLabel("Password don't match");
	private boolean passwordMisMatchAdded = false;


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public MainFrame() throws FontFormatException, IOException {
		setResizable(false);
		setBounds(500, 500, 900, 710);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainContentPane.setLayout(null);
		
		initializePages();
		setContentPane(mainContentPane);
		
		if (checkIfSignedIn()) mainContentPane.add(this.enrollmentPage, JLayeredPane.PALETTE_LAYER);
		addLoginPage();
	}
		
	private void addLoginPage(){
		addTextSection();
		addLoginSection();
		addListeners();
	}
	
	private void initializePages() {
		
		enrollmentPage.setBounds(150, 80, 600, 550);
		
		ImageIcon icon = new ImageIcon(MainFrame.class.getResource(this.backgroundPath)); 
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(900, 750,  java.awt.Image.SCALE_SMOOTH); 
		icon = new ImageIcon(newimg);
		
		JLabel backgroundImg = new JLabel("");
		backgroundImg.setBounds(0, 0, 900, 678);
		backgroundImg.setIcon(icon);
		mainContentPane.add(backgroundImg, JLayeredPane.DEFAULT_LAYER);
	}
	
	private void addTextSection() {
		
		textSection = new JPanel();
		textSection.setToolTipText("Input password");
		textSection.setBounds(176, 69, 237, 556);
		textSection.setBackground(new Color(0, 35, 51));
		mainContentPane.add(textSection, JLayeredPane.PALETTE_LAYER);
		textSection.setLayout(null);
		
		
		TextLabel.setText("Welcome Back To Skill Share");
		TextLabel.setEditable(false);
		TextLabel.setForeground(new Color(232, 232, 232));
		TextLabel.setBackground(new Color(0, 35, 51));
		TextLabel.setFont(bold);
		TextLabel.setBounds(20, 109, 207, 60);
		textSection.add(TextLabel);
		
		description.setEditable(false);
		description.setForeground(new Color(232, 232, 232));
		description.setBackground(new Color(0, 35, 51));
		description.setFont(regular);
		description.setText("Sign In to continue your account");
		description.setBounds(20, 199, 195, 122);
		textSection.add(description);
		
		JButton green = new JButton("");

		green.setForeground(new Color(0, 255, 132));
		green.setBackground(new Color(0, 255, 132));
		green.setBounds(22, 180, 97, 8);
		green.setBorder(new RoundedBorder(30)); //10 is the radius
		green.setFocusable(false);
		
		textSection.add(green);
	}
	
	private void addLoginSection() {
		loginSection.setBounds(410, 69, 274, 556);
		loginSection.setLayout(null);
		mainContentPane.add(loginSection, JLayeredPane.PALETTE_LAYER);
		
		facebookRedicrect = new JPanel();
		facebookRedicrect.setBorder(new LineBorder(new Color(0, 0, 0)));
		facebookRedicrect.setBounds(29, 32, 225, 46);
		loginSection.add(facebookRedicrect);
		
		ImageIcon facebook = new ImageIcon(MainFrame.class.getResource(facebookPath));
		Image image = facebook.getImage();
		Image newimg = image.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH); 
		facebook = new ImageIcon(newimg);
		facebookRedicrect.setLayout(null);
		
		JLabel facebookLabel = new JLabel("Continue With Facebook");
		facebookLabel.setForeground(new Color(0, 35, 51));
		facebookLabel.setFont(smallMedium);
		facebookLabel.setBounds(10, 0, 211, 44);
		facebookLabel.setIconTextGap(30);
		facebookLabel.setIcon(facebook);
		facebookRedicrect.add(facebookLabel);
		
		googleRedirect = new JPanel();
		googleRedirect.setLayout(null);
		googleRedirect.setBorder(new LineBorder(new Color(0, 0, 0)));
		googleRedirect.setBounds(29, 89, 225, 46);
		loginSection.add(googleRedirect);
		
		ImageIcon google = new ImageIcon(MainFrame.class.getResource(googlePath));
		Image image_1 = google.getImage();
		Image newimg_1 = image_1.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH); 
		google = new ImageIcon(newimg_1);
		
		JLabel googleLabel = new JLabel("Continue With Google");
		googleLabel.setIcon(google);
		googleLabel.setIconTextGap(30);
		googleLabel.setForeground(new Color(0, 35, 51));
		googleLabel.setFont(smallMedium);
		googleLabel.setBounds(10, 0, 211, 44);
		googleRedirect.add(googleLabel);
		
		appleRedirect = new JPanel();
		appleRedirect.setLayout(null);
		appleRedirect.setBorder(new LineBorder(new Color(0, 0, 0)));
		appleRedirect.setBounds(29, 146, 225, 46);
		loginSection.add(appleRedirect);
		
		ImageIcon apple = new ImageIcon(MainFrame.class.getResource(applePath));
		Image image_2 = apple.getImage();
		Image newimg_2 = image_2.getScaledInstance(22, 22,  java.awt.Image.SCALE_SMOOTH); 
		apple = new ImageIcon(newimg_2);
		
		JLabel appleLabel = new JLabel("Continue With Apple");
		appleLabel.setIcon(apple);
		appleLabel.setIconTextGap(30);
		appleLabel.setForeground(new Color(0, 35, 51));
		appleLabel.setFont(smallMedium);
		appleLabel.setBounds(10, 0, 211, 44);
		appleRedirect.add(appleLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(29, 215, 87, 2);
		loginSection.add(separator);
		
		JLabel or = new JLabel("or");
		or.setFont(mediumBold);
		or.setBounds(130, 210, 46, 14);
		loginSection.add(or);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(154, 215, 100, 2);
		loginSection.add(separator_1);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email address");
		txtEmail.setFont(smallRegular);
		txtEmail.setToolTipText("input email address here");
		txtEmail.setForeground(new Color(0, 34, 51));
		txtEmail.setBounds(29, 251, 225, 33);
		loginSection.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Input Password here");
		txtPassword.setFont(smallRegular);
		txtPassword.setForeground(new Color(0, 35, 51));
		txtPassword.setColumns(10);
		txtPassword.setBounds(29, 308, 225, 33);
		loginSection.add(txtPassword);
		
		this.confirmPassword = new JPasswordField();
		confirmPassword.setToolTipText("Verify Password");
		confirmPassword.setFont(smallRegular);
		confirmPassword.setText("");
		confirmPassword.setForeground(new Color(0, 35, 51));
		confirmPassword.setColumns(10);
		confirmPassword.setBounds(29, 367, 225, 33);
		
		keepSignIn.setForeground(new Color(0, 35, 51));
		keepSignIn.setFont(smallRegular);
		keepSignIn.setBounds(29, 360, 239, 33);
		loginSection.add(keepSignIn);
		
		signInButton = new JButton("Sign In");
		signInButton.setForeground(new Color(0, 35, 51));
		signInButton.setFont(regular);
		signInButton.setBorder(null); //10 is the radius
		signInButton.setBackground(new Color(0, 255, 132));
		signInButton.setBounds(29, 445, 225, 33);
		loginSection.add(signInButton);
		
		forgotPassword.setFont(mediumBold);
		forgotPassword.setForeground(new Color(55, 34, 211));
		forgotPassword.setBounds(29, 455, 135, 14);
		loginSection.add(forgotPassword);
		
		notAMemberYet.setFont(smallRegular);
		notAMemberYet.setForeground(new Color(0, 35, 51));
		notAMemberYet.setBounds(61, 512, 115, 14);
		loginSection.add(notAMemberYet);
		
		SignUp.setFocusable(false);
		SignUp.setFont(smallMedium);
		SignUp.setForeground(new Color(55, 34, 211));
		SignUp.setBounds(180, 512, 70, 14);
		loginSection.add(SignUp);
		
		changeToSignIn();
	}
	private void changeToSignUp() {
		if (this.emailFlagAdded) {
			this.loginSection.remove(invalidEmail);
			emailFlagAdded = false;
		}
		
		if (this.passwordFlagAdded) {
			this.loginSection.remove(passwordEmpty);
			this.passwordFlagAdded = false;
		}
		
		this.TextLabel.setText("Sign Up For Free");
		this.description.setText("Explore your creativity"
				+ " with thousands of inspiring classes in design,"
				+ " illustration, photography, and more.");
		
		this.signInButton.setText("Sign Up");
		this.signInButton.setBounds(29, 434, 227, 33);
		
		this.SignUp.setText("Sign In");
		this.notAMemberYet.setText("Already A Member?");
		
		this.forgotPassword.setVisible(false);
		this.keepSignIn.setVisible(false);
		
		loginSection.add(confirmPassword);
	}
	private void  changeToSignIn() {
		if (this.emailFlagAdded) {
			this.loginSection.remove(invalidEmail);
			emailFlagAdded = false;
		}
		
		if (this.passwordFlagAdded) {
			this.loginSection.remove(passwordEmpty);
			this.passwordFlagAdded = false;
		}
		
		if (this.passwordMisMatchAdded) {
			this.loginSection.remove(passwordMisMatch);
			this.passwordMisMatchAdded = false;
		}
		
		this.TextLabel.setText("Welcome Back to Skill Share");
		this.description.setText("Sign In to continue your account");
		
		this.signInButton.setText("Sign In");
		this.signInButton.setBounds(29, 400, 225, 33);
		
		this.SignUp.setText("Sign Up");
		this.notAMemberYet.setText("Not A Member Yet?");
		
		this.forgotPassword.setVisible(true);
		this.keepSignIn.setVisible(true);
		
		loginSection.remove(confirmPassword);
	}
	private boolean checkIfSignedIn() {
		try { 
            BufferedReader reader = new BufferedReader(new FileReader("Settings"));
            String line = reader.readLine();
            while (line != null){
            	String[] data = line.split(":");
            	
            	if (Objects.equals(data[0], "KeepSignedIn")){
            		if (Objects.equals(data[1], "true")) return true;
            		else return false;
            	}
            	
            	line = reader.readLine();
            }
            reader.close();
        } 
		catch(IOException e){
			e.printStackTrace();
        }
		return false;
	}
	
	private void modifySignIn() {

		try {
            // initializes my file reader
            BufferedReader myReader = new BufferedReader(new FileReader("Settings"));
            
            String line;

            ArrayList<String> oldText = new ArrayList<>(); // will hold the old text

            boolean found = false; // will be flagged if the text to read was found
            while ((line = myReader.readLine()) != null){
            	String[] data = line.split(":");
            			
                if (data[0].equals("KeepSignedIn")) {
                	String value;
                
                	if (this.keepSignIn.isSelected()) value = "true";
                	else value = "false";
                	
                	oldText.add("KeepSignedIn:"+value);
                    found = true; // flags found to true
                }
                else oldText.add(line); // adds the old line to the array list for future usage
            }

            if (found) { // if the old text should be modified because the target string was found rewrite the entire file
                FileWriter myWriter = new FileWriter("Settings"); // initializes the file writer
                for (String text : oldText) // copies context from old text and rewrites the file
                    myWriter.write(text + "\n");
                // closes the writer
                myWriter.close();
            }

            // closes the reader
            myReader.close();
        }
        catch (IOException e) { // throws an error if something went wrong while reading the file (i.e. corrupted)
            System.out.println("Something went wrong while reading");
        }
		
	}
	
	private boolean verifySignIn(String email, String password) {

		try { 
            BufferedReader reader = new BufferedReader(new FileReader("Database"));
            String line = reader.readLine();
            while (line != null){
            	String[] data = line.split(":");
            	
            	if (Objects.equals(data[0], email) && Objects.equals(data[1], password)) return true;
            	line = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
		return false;
	}

	
	// Mouse listener events
	
	
	private void addListeners() {
		signInButton.addActionListener(this);
		txtEmail.addActionListener(this);
		
		txtEmail.addMouseListener(this);
		txtPassword.addMouseListener(this);
		SignUp.addMouseListener(this);
	}
	
	// ACTION LISTENEREs
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signInButton) {
			ImageIcon error = new ImageIcon(MainFrame.class.getResource(errorPath));
			Image image_1 = error.getImage();
			Image newimg_1 = image_1.getScaledInstance(13, 13,  java.awt.Image.SCALE_SMOOTH); 
			error = new ImageIcon(newimg_1);
			
			this.invalidEmail.setFont(mediumMedium);
			this.invalidEmail.setForeground(new Color(255, 74, 74));
			this.invalidEmail.setBounds(55, 228, 176, 14);
			this.invalidEmail.setIcon(error);
			
			String email = txtEmail.getText().trim();
			String password = String.valueOf(txtPassword.getPassword()).trim();
		   
			boolean validInput = true;
			
			if (Objects.equals(email, "")) {
				this.invalidEmail.setText("Email is required");
				
				if (!this.emailFlagAdded) {
					this.loginSection.add(this.invalidEmail);
					this.emailFlagAdded = true;
				}
				
				validInput = false;
			}
			else if (!Pattern.compile("^(.+)@(.+)$").matcher(email).matches()){
				this.invalidEmail.setText("Invalid email");
				
				if (!this.emailFlagAdded) {
					this.loginSection.add(this.invalidEmail);
					this.emailFlagAdded = true;
				}
				
				validInput = false;
			}
			
			if (Objects.equals(password, "")) {
				this.passwordEmpty.setFont(mediumMedium);
				this.passwordEmpty.setForeground(new Color(255, 74, 74));
				this.passwordEmpty.setBounds(55, 290, 176, 14);
				this.passwordEmpty.setIcon(error);
				
				if (!this.passwordFlagAdded) {
					this.loginSection.add(this.passwordEmpty);
					this.passwordFlagAdded = true;
				}
				
				validInput = false;
			}
			
			if (mode == "Sign Up") {
				if (!Objects.equals(String.valueOf(txtPassword.getPassword()), String.valueOf(confirmPassword.getPassword()))) {
					this.passwordMisMatch.setFont(mediumMedium);
					this.passwordMisMatch.setForeground(new Color(255, 74, 74));
					this.passwordMisMatch.setBounds(55, 350, 176, 14);
					this.passwordMisMatch.setIcon(error);
					
					if (!passwordMisMatchAdded) {
						loginSection.add(this.passwordMisMatch);
						passwordMisMatchAdded = true;
					}
					this.confirmPassword.setText("");
					validInput = false;
				}
			}
			
			
			if (validInput && Objects.equals(mode, "Sign In")) {
				if (this.emailFlagAdded) {
					this.loginSection.remove(invalidEmail);
					this.emailFlagAdded = false;
				}
				
				if (this.passwordFlagAdded) {
					this.loginSection.remove(passwordEmpty);
					this.passwordFlagAdded = false;
				}
				
				
				if (verifySignIn(email, password)) {
					modifySignIn(); // modifies the state of the keep login in settings files
					
					this.mainContentPane.remove(textSection);
					this.mainContentPane.remove(loginSection);
					this.mainContentPane.add(this.enrollmentPage, JLayeredPane.PALETTE_LAYER);
					
					this.mainContentPane.repaint();
					this.enrollmentPage.revalidate();
				}
				else {
					this.invalidEmail.setText("Wrong Email or Password");
					this.loginSection.add(invalidEmail);
					this.emailFlagAdded = true;
				}
			}
			
			else if (validInput && Objects.equals(mode, "Sign Up")) {
				try{
		            FileWriter writer = new FileWriter("Database", true);
		            writer.append("\n"+this.txtEmail.getText()+":"+String.valueOf(this.txtPassword.getPassword()));
		            writer.close();
		        }
		        catch(IOException err){
		            err.printStackTrace();
		        }
				
				mode = "Sign In";
				invalidEmail.setText("Account succesfully created");
				invalidEmail.setForeground(new Color(0, 255, 132));
				changeToSignIn();
				
				if (!this.emailFlagAdded) {
					this.loginSection.add(invalidEmail);
					this.emailFlagAdded = true;
				}
			}
			
			txtPassword.setText("");
			this.loginSection.repaint();
		}
	}
	
	
	// MOUSE EVENTS
	@Override
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.txtEmail && Objects.equals(txtEmail.getText(), "Email address")) {
			txtEmail.setText("");
		}
		
		if (e.getSource() == this.SignUp) {
			if (Objects.equals(mode, "Sign In")) {
				mode = "Sign Up";
				changeToSignUp();
			}
			else if (Objects.equals(mode, "Sign Up")) {
				mode = "Sign In";
				changeToSignIn();
			}
			
			this.repaint();
			this.revalidate();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
