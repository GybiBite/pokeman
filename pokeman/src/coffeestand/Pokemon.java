package coffeestand;

import static coffeestand.Type.*;

public abstract class Pokemon {
	final Type TYPE;
	int MAX_HEALTH, ATTACK, DEFENSE, SPEED;
	
	public Pokemon(final Type type) {
		this.TYPE = type;
	}
	
	double takeDamage(double baseDmg, Type atkType) {
		if(TYPE.hasWeakness(atkType)){
			return baseDmg * 1.25;
		} else if(TYPE.hasStrength(atkType)) {
			return baseDmg * 0.75;
		} else {
			return baseDmg;
		}
	}
}

class Charmander extends Pokemon {
	public Charmander() {
		super(Fire);
		MAX_HEALTH = 39;
		ATTACK = 52;
		DEFENSE = 43;
		SPEED = 65;
	}
}