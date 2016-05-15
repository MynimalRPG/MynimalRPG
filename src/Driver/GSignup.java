package Driver;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GSignup extends JPanel{

	private final GMynimalClient parent;
	private final JLabel lblSignup = new JLabel("Signup");
	private final JTextField textField = new JTextField();
	private final JLabel label = new JLabel("username");
	private final JLabel label_1 = new JLabel("password");
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton btnJoin = new JButton("join!");
	private final JLabel lblUsernameInvalid = new JLabel("username is invalid.");
	private final JLabel lblPasswordInvalid = new JLabel("password has invalid characters.");
	private final JLabel lblNewLabel = new JLabel(new ImageIcon("rsc/signup_pic.png"));

	/**
	 * Create the panel.
	 */
	public GSignup(GMynimalClient parent){
		this.parent = parent;
		setLayout(null);
		lblSignup.setBounds(142, 11, 159, 37);
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setForeground(new Color(139, 0, 0));
		lblSignup.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

		add(lblSignup);
		textField.setColumns(10);
		textField.setBounds(83, 78, 116, 20);

		add(textField);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label.setBounds(10, 77, 62, 15);

		add(label);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_1.setBounds(10, 109, 62, 19);

		add(label_1);
		passwordField.setBounds(83, 110, 116, 20);

		add(passwordField);
		btnJoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				lblUsernameInvalid.setVisible(false);
				lblPasswordInvalid.setVisible(false);
				if(!MynimalLauncher.validUsername(username)){
					if(username.contains(" ")){
						lblUsernameInvalid.setText("username is invalid.");
					}
					else{
						lblUsernameInvalid.setText("username is already taken.");
					}
					lblUsernameInvalid.setVisible(true);
				}
				else if(!MynimalLauncher.validPassword(password)){
					if(password.contains(" ")){
						lblPasswordInvalid.setText("password has invalid characters.");
					}
					else{
						lblPasswordInvalid // doesn't fit on one line
								.setText("<html><p>password must be at least <br> 5 characters long.</p></html>");
					}
					lblPasswordInvalid.setVisible(true);
					passwordField.setText("");
				}
				else{
					textField.setText("");
					passwordField.setText("");
					MynimalLauncher.createUser(username, password);
					parent.setScreen("login");
				}
			}
		});
		btnJoin.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnJoin.setBackground(Color.GREEN);
		btnJoin.setBounds(83, 141, 116, 23);

		add(btnJoin);
		lblUsernameInvalid.setForeground(Color.RED);
		lblUsernameInvalid.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblUsernameInvalid.setBounds(209, 78, 188, 14);
		lblUsernameInvalid.setVisible(false);

		add(lblUsernameInvalid);
		lblPasswordInvalid.setForeground(Color.RED);
		lblPasswordInvalid.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPasswordInvalid.setBounds(209, 97, 213, 43);
		lblPasswordInvalid.setVisible(false);

		add(lblPasswordInvalid);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(320, 141, 102, 104);
		
		add(lblNewLabel);
	}
}
