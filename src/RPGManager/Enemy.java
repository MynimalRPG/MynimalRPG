/** Enemy ****************************************************
 * Interface for a Mynimal game enemy
 * 
 * @author Ronald Macmaster
 * @author Kevin Cho
 * @version 1.01 4/30/2016
 ************************************************************/
package RPGManager;

/**
 * Interface for a Mynimal RPG enemy
 */
public class Enemy{

	// enemy data
	public String name;
	
	// enemy static stats
	private byte hp;
	private byte offense;
	private byte defense;
	
	// enemy gameplay stats
	private boolean alive;
	private byte lifepoints;
	
	
	public Enemy(String name, byte hp, byte offense, byte defense){
		this.hp = hp;
		this.offense = offense;
		this.defense = defense;
		

		lifepoints = hp;
		alive = true;
	}
	
	/**
	 * Take a lifepoints hit.
	 * @param damage
	 */
	public void takeDamage(byte damage){
		byte buffer = (byte)(defense * Math.random()); 
		lifepoints -= damage / buffer;

		// lifepoints check
		if(lifepoints <= 0){
			alive = false;
		}
	}

}
