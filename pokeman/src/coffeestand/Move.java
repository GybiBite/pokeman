package coffeestand;

import static coffeestand.Type.*;

public enum Move {
	Tackle("Tackle", Normal, 40, 100),
	Ember("Ember", Fire, 40, 100),
	DynamicPunch("Dynamic Punch", Fighting, 100, 50),
	SelfDestruct("Self Destruct", Normal, 130, 100),
	Thunderbolt("Thunderbolt", Electric, 95, 100);
	RazorLeaf("Razor Leaf", Grass, 55, 95);
	WaterGun("Water Gun", Water, 40, 100);
	Bulldoze("Bulldoze", Ground, 60, 100);
	Gust("Gust", Flying, 40, 100);
	BodySlam("Body Slam", Normal, 85, 100);
	
	public final Type type;
	public final int basePower;
	public final String name;
	/*
	 * may not use accuracy, depending on team ideas.
	 * adding it just in case.
	 */
	public final float accuracy;
	Move(String name, Type type, int basePower, float accuracy) {
		this.name = name;
		this.type = type;
		this.basePower = basePower;
		this.accuracy = accuracy;
	}
	
	public void printName() {
		System.out.println(name);
	}
}
