package coffeestand;

import static coffeestand.Type.*;

public enum Move {
	Tackle(Normal, 40, 100),
	Ember(Fire, 40, 100),
	DynamicPunch(Fighting, 100, 50);
	
	public final Type type;
	public final int basePower;
	/*
	 * may not use accuracy, depending on team ideas.
	 * adding it just in case.
	 */
	public final float accuracy;
	Move(Type type, int basePower, float accuracy) {
		this.type = type;
		this.basePower = basePower;
		this.accuracy = accuracy;
	}
}
