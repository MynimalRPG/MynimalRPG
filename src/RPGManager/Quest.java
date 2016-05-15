/** Quest ****************************************************
 * Interface for a Mynimal RPG Quest
 * 
 * @author Ronald Macmaster
 * @author Kevin Cho
 * @version 1.01 4/30/2016
 ************************************************************/
package RPGManager;

/**
 * Interface for a Mynimal RPG Quest
 */
public class Quest{
	private byte questId;
	private byte reward;
	private String questDescription;
	
	public Quest( byte quest, byte questreward, String description){
		questId = quest;
		reward = questreward;
		questDescription = description;
		
	}

}
