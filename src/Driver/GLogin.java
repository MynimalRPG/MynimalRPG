package Driver;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class GLogin extends JFrame{

	private JPanel contentPane;
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel = new JLabel("username");
	private final JLabel lblPassword = new JLabel("password");
	private final JButton btnNewButton = new JButton("submit");
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton btnSignUp = new JButton("sign up");
	private final JLabel lblMynimalRpg = new JLabel("Mynimal RPG");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					GLogin frame = new GLogin();
					frame.setVisible(true);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GLogin(){
		setBackground(SystemColor.menu);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\ronald\\Documents\\GitHub\\MynimalRPG\\rsc\\mynimal_lg.png"));
		setTitle("Mynimal RPG v1.0");
		textField.setBounds(142, 106, 116, 20);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(textField);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(70, 107, 62, 14);

		contentPane.add(lblNewLabel);
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPassword.setBounds(70, 138, 62, 14);

		contentPane.add(lblPassword);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.out.println("submit!");
				MynimalLauncher.login();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnNewButton.setBounds(268, 135, 89, 23);

		contentPane.add(btnNewButton);
		passwordField.setBounds(142, 137, 116, 20);

		contentPane.add(passwordField);
		btnSignUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("signup!");
				MynimalLauncher.createUser();
			}
		});
		btnSignUp.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnSignUp.setBackground(Color.CYAN);
		btnSignUp.setBounds(268, 103, 89, 23);

		contentPane.add(btnSignUp);
		lblMynimalRpg.setForeground(new Color(139, 0, 0));
		lblMynimalRpg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMynimalRpg.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblMynimalRpg.setBounds(10, 28, 414, 48);

		contentPane.add(lblMynimalRpg);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {btnNewButton,
				btnSignUp, lblNewLabel, lblPassword, textField, passwordField}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {textField, passwordField,
				btnNewButton, btnSignUp, contentPane, lblNewLabel, lblPassword}));
	}
}