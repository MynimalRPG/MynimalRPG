/** Player ***************************************************
 * Interface for a Mynimal RPG Player
 * 
 * @author Ronald Macmaster
 * @author Kevin Cho
 * @version 1.01 4/30/2016
 ************************************************************/
package RPGManager;

/**
 * Interface for a Mynimal RPG Player
 */
public class Player{

	// player metadata
	public String name;

	// player static stats
	private byte hp;
	private byte offense;
	private byte defense;

	// player gameplay stats
	private boolean alive;
	private byte lifepoints;

	public Player(){
		hp = 10;
		offense = 1;
		defense = 1;
		lifepoints = hp;
		alive = true;
	}

	/**
	 * Place an attack on the other player.
	 * 
	 * @param otherPlayer
	 */
	public void attack(Player opponent){
		byte damage = (byte)((offense + 1) * Math.random());
		opponent.takeDamage(damage);
	}

	/**
	 * Place an attack on the other player.
	 * 
	 * @param otherPlayer
	 */
	public void attack(Enemy opponent){
		byte damage = (byte)((offense + 1) * Math.random());
		opponent.takeDamage(damage);
	}

	/**
	 * Take a lifepoints hit.
	 * 
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
