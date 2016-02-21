/***
 * To create a fortress object that represents the player and their health
 */

package minions;

public class Fortress {
	private int health;

	Fortress() {
		health = 1500;
	}

	int getHealth() {
		return health;
	}

	void decreaseHealthBy(int damage) {
		health = health - damage;
		
		if (health < 0) {
			health = 0;
		}
	}

	boolean isAlive() {
		if (health == 0) {
			return false;
		}
		return true;
	}
}
