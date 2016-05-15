/** MynimalLauncher ******************************************
 * Top-level driver interface to launch the Mynimal RPG 
 * 
 * @author Ronald Macmaster
 * @author Kevin Cho
 * @version 1.01 4/30/2016
 ************************************************************/
package Driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Top-level driver interface to launch the Mynimal RPG 
 */
public final class MynimalLauncher{

	public static Set<String> playerSet = new HashSet<String>();
	public static Map<String, String> passwordMap = new LinkedHashMap<String, String>();
	
	public static void main(String[] args){
		System.out.println("Launching Mynimal, please wait...");
		openMynimal();
		createUser();
		closeMynimal();
		
	}
	
	/**
	 * Initializethe RPG
	 */
	public static void openMynimal(){
		try{
			// read user file
			String userdata;
			FileReader fstream = new FileReader("data/users.dat");
			BufferedReader userfile = new BufferedReader(fstream);
			
			// build username data structures
			while((userdata = userfile.readLine()) != null){
				String[] tokens = userdata.split("\t");
				String username = tokens[0];
				String password = tokens[1];
				
				playerSet.add(username.toLowerCase());
				passwordMap.put(username, password);
			}
			
			// close streams
			userfile.close();
			fstream.close();
		}
		catch(Exception e){e.printStackTrace();
			System.err.println("Users file not found.");
		}
	}
	
	/**
	 * Close the RPG
	 */
	public static void closeMynimal(){
		try{
			// store the user data
			FileWriter fstream = new FileWriter("data/users.dat");
			BufferedWriter userfile = new BufferedWriter(fstream);
			
			// store the user data in file
			for(String username : passwordMap.keySet()){
				String password = passwordMap.get(username);
				userfile.write(username + "\t" + password + "\n");
			}
			
			// close streams
			userfile.close();
			fstream.close();
		}
		catch(Exception e){
			System.err.println("Users file not found. Close failed!");
		}
	}
	
	/**
	 * Creates a new Mynimal RPG user
	 */
	public static void createUser(){
		// read a username and password
		String username = "", password = "";
		Scanner input = new Scanner(System.in);
		
		// poll valid username
		System.out.println("Please choose a username: ");
		username = input.nextLine().split("\t")[0];
		while(playerSet.contains(username.toLowerCase())){
			System.out.println("Username taken! Please choose another username: ");
			username = input.nextLine().split(" ")[0];
		}
		
		// poll valid password
		System.out.println("Please choose a password: ");
		password = input.nextLine();
		while(password.split(" ").length > 1){
			System.out.println("Password must be one word! Please choose another password: ");
			password = input.nextLine();
		}
		
		// add new user
		System.out.println("Welcome to MynimalRPG!");
		playerSet.add(username.toLowerCase());
		passwordMap.put(username, password);
		input.close();
	}
	
	/**
	 * login the user on the current session
	 */
	public static void login(){

	}

}
