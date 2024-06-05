package coffeestand;

import static coffeestand.Type.*;

public abstract class Pokemon {
	/**
	 * What type variant the Pokemon is set as
	 * <li>This will be defined in the constructor</li>
	 * 
	 * @see Type
	 */
	final Type TYPE;
	final int MAX_HEALTH, ATTACK, DEFENSE, SPEED;
	int hp;

	public Pokemon(final Type TYPE, final int MAX_HEALTH, final int ATTACK, final int DEFENSE, final int SPEED) {
		this.TYPE = TYPE;
		this.MAX_HEALTH = MAX_HEALTH;
		this.ATTACK = ATTACK;
		this.DEFENSE = DEFENSE;
		this.SPEED = SPEED;
		hp = MAX_HEALTH;
	}

	double takeDamage(double baseDmg, Type atkType) {
		if (TYPE.hasWeakness(atkType)) {
			return baseDmg * 1.25;
		} else if (TYPE.hasStrength(atkType)) {
			return baseDmg * 0.75;
		} else {
			return baseDmg;
		}
	}
}

class Charmander extends Pokemon {
	public Charmander() {
		super(Fire, 39, 52, 43, 65);
	}
}