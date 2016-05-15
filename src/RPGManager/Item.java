/** Item *****************************************************
 * Interface for a Mynimal game item
 * 
 * @author Ronald Macmaster
 * @author Kevin Cho
 * @version 1.01 4/30/2016
 ************************************************************/
package RPGManager;

/**
 * Interface for a Mynimal game item
 */
public class Item{
	// item data
	private String itemName;
	
	
	//private Boolean status[]; I assume that we can make an array of statuses which can either be true of false to determine the status of the item... Sort of but for now I'll write something basic
	private byte healpoints;
	private byte attackboost;
	private byte defenseboost;
	
	
	public Item(String Name, byte healpts, byte atkboost, byte defboost){
		itemName = Name;
		healpoints = healpts;
		attackboost = atkboost;
		defenseboost = defboost;
	}
	
	
	// Accessor functions... I assume this is needed to access private data like C++
	public byte getHeal(){
		return healpoints;
	}
	
	public byte getAttack(){
		return attackboost;
	}
	
	public byte getDefense(){
		return defenseboost;
	}
	

}
