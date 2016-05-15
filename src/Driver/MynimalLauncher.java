/** MynimalLauncher ******************************************
 * Top-level driver interface to launch the Mynimal RPG 
 * 
 * @author Ronald Macmaster
 * @author Kevin Cho
 * @version 1.01 4/30/2016
 ************************************************************/
package Driver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Top-level driver interface to launch the Mynimal RPG 
 */
public final class MynimalLauncher{

	public static Set<String> playerSet = new HashSet<String>();
	public static Map<String, String> passwordMap = new HashMap<String, String>();
	
	public static void main(String[] args){
		System.out.println("Launching Mynimal, please wait...");
		
	}
	
	/**
	 * Initialization routine
	 */
	public static void startRPG(){
		
	}
	
	/**
	 * Creates a new Mynimal RPG user
	 */
	public static void createUser(){
		// read a username
		String username = "";
		Scanner input = new Scanner(System.in);
		
		// poll valid username
		System.out.println("Please choose a username: ");
		username = input.nextLine().split(" ")[0];
		while(playerSet.contains(username)){
			System.out.println("Username taken! Please choose another username: ");
			username = input.nextLine().split(" ")[0];
		}
		
		// add new user
		System.out.println("Welcome to MynimalRPG!");
		playerSet.add(username);
	}

}
