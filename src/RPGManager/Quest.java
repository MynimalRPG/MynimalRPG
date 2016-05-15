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
	
	public Quest( byte questId, byte reward, String questDescription){
		this.questId = questId;
		this.reward = reward;
		this.questDescription = questDescription;
	}

	public byte getquestID(){
		return questId;
	}

	public byte getReward(){
		return reward;
	}
	public byte getDescription(){
		return questDescription;
	}

	public void questTrigger(){

	}


}
