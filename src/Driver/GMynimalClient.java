package Driver;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GMynimalClient extends JFrame{

	private JPanel currentScreen;
	private Map<String, JPanel> screens = new HashMap<String, JPanel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					GMynimalClient frame = new GMynimalClient();
					frame.setVisible(true);
				} catch(Exception e){
					e.printStackTrace();
				} finally{
					// close the RPG
					MynimalLauncher.closeMynimal();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GMynimalClient(){
		// Frame metadata
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\ronald\\Documents\\GitHub\\MynimalRPG\\rsc\\mynimal_lg.png"));
		setTitle("Mynimal RPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// frame position and size
		int xpos, ypos;
		int width = 450, height = 300;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		xpos = (int)((screenSize.getWidth() - width) / 2);
		ypos  = (int)((screenSize.getHeight() - height) / 2);
		setBounds(xpos, ypos, width, height);
		setResizable(false);

		// initialize screen map
		currentScreen = new JPanel(new CardLayout());
		currentScreen.add("login", new GLogin(this));
		currentScreen.add("signup", new GSignup(this));
		setContentPane(currentScreen);

		// RPG opener and closer
		MynimalLauncher.openMynimal();
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent){
				MynimalLauncher.closeMynimal();
			}
		});
	}

	/**
	 * Switches the current screen on the client
	 * 
	 * @param screenName
	 */
	public void setScreen(String screenName){
		CardLayout cl = (CardLayout)(currentScreen.getLayout());
		cl.show(currentScreen, screenName);
	}

}
