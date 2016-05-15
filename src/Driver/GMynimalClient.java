package Driver;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
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
					// init the RPG
					MynimalLauncher.openMynimal();
					
					// init gui
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ronald\\Documents\\GitHub\\MynimalRPG\\rsc\\mynimal_lg.png"));
		setTitle("Mynimal RPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		currentScreen = new JPanel(new CardLayout());
		// initialize screen map	
		currentScreen.add("login", new GLogin(this));
		currentScreen.add("signup", new GSignup(this));
		setContentPane(currentScreen);
	}
	
	/**
	 * Switches the current screen on the client
	 * @param screenName
	 */
	public void setScreen(String screenName){
	    CardLayout cl = (CardLayout)(currentScreen.getLayout());
	    cl.show(currentScreen, screenName);
	}

}
