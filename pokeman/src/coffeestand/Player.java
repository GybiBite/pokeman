package coffeestand;

import java.util.ArrayList;

public class Player {
	final ArrayList<Pokemon> PARTY;
	Pokemon currPkmn = null;
	
	public Player(final ArrayList<Pokemon> PARTY) {
		this.PARTY = PARTY;
		currPkmn = PARTY.get(0);
	}
	
	public boolean hasLost() {
		return PARTY.isEmpty();
	}
	
	
}
