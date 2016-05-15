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

public class GSignup extends JPanel{

	private final GMynimalClient parent;
	private final JLabel lblSignup = new JLabel("Signup");
	private final JTextField textField = new JTextField();
	private final JLabel label = new JLabel("username");
	private final JLabel label_1 = new JLabel("password");
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton btnJoin = new JButton("join!");
	
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
		textField.setBounds(161, 84, 116, 20);
		
		add(textField);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label.setBounds(89, 85, 62, 14);
		
		add(label);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_1.setBounds(89, 116, 62, 14);
		
		add(label_1);
		passwordField.setBounds(161, 115, 116, 20);
		
		add(passwordField);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setScreen("login");
			}
		});
		btnJoin.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnJoin.setBackground(Color.GREEN);
		btnJoin.setBounds(161, 146, 89, 23);
		
		add(btnJoin);
	}

}
