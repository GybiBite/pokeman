package coffeestand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PokemanMain {

	static final HashSet<Pokemon> POKEMONS = new HashSet<Pokemon>();
	static final Player[] PLAYERS = { null, null };
	static Scanner scanner = new Scanner(System.in);
	static Random rng = new Random();

	static {
		POKEMONS.add(new Charmander());
		POKEMONS.add(new Electrode());
		POKEMONS.add(new Oddish());
		POKEMONS.add(new JigglyPuff());
		POKEMONS.add(new Machoke());
		POKEMONS.add(new Cloyster());
	}

	public static void main(String[] args) {
		/**
		 * Here we'd have the user prompts, maybe ask how many Pokemon per player, how
		 * big a stack size, whatever our game opts for. Then we'd initialize the card
		 * stack with initDeck
		 * 
		 * Afterwards, the game will ask the first player to make a move, the second
		 * player to make a move, and so on until a winning condition is met.
		 */

		while (true) {

			int pkmnPerParty = promptNumberReadLine(scanner, "How many pokemon would you like each player to have?", 6);
			PLAYERS[0] = new Player(initParty(pkmnPerParty));
			PLAYERS[1] = new Player(initParty(pkmnPerParty));

			while (!(PLAYERS[0].hasLost() || PLAYERS[1].hasLost())) {

			}
		}
	}

	static ArrayList<Pokemon> initParty(int count) {
		ArrayList<Pokemon> newParty = new ArrayList<Pokemon>();
		for (int i = 0; i < count; i++) {
			try {
				newParty.add((Pokemon) POKEMONS.toArray()[rng.nextInt(POKEMONS.size())].getClass().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		return newParty;
	}

	static int promptNumberReadLine(Scanner s, String prompt, int max) {
		int num = Integer.MIN_VALUE;
		do {
			try {
				System.out.format("%f (1-%f): ", prompt, max);
				num = (s.nextInt());
				if (num > max || num < 1) {
					num = Integer.MIN_VALUE;
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("That was not a valid number! Please try again.");
				s.nextLine();
			} catch (Exception e) {
				System.err.println("Unhandled exception caught in method promptNumberReadLine");
				e.printStackTrace();
				System.exit(0);
			}
		} while (num == Integer.MIN_VALUE);

		return num;
	}

	/**
	 * This is a special method to calculate the damage to be dealt in battle based
	 * on the official formula from Pokemon Red & Blue. It is a direct (and sloppy)
	 * translation from math, to code. Any constants specified are supposed to be
	 * variables, but a lot of features are absent from our battle game that are
	 * supposed to be in the real one.
	 * 
	 * @param m   The move used by the attacker
	 * @param atk The attacking Pokemon
	 * @param def The defending Pokemon
	 * 
	 * @return Damage output based on the factors supplied through the parameters
	 * 
	 * @see <a href=
	 *      "https://bulbapedia.bulbagarden.net/wiki/Damage#Generation_I">Damage -
	 *      Bulbapedia</a>
	 */
	public static int calcDamage(Move m, Pokemon atk, Pokemon def) {
		/* Level is the level of the attacking Pokémon. */
		int level = 10;
		/* Critical is 2 for a critical hit, and 1 otherwise. */
		int critical = 1;
		/* A is the effective Attack stat of the attacking Pokémon */
		int atkDmg = atk.ATTACK;
		/* D is the effective Defense stat of the target */
		int defDmg = def.DEFENSE;
		/* Power is the power of the used move. */
		int mPower = m.basePower;
		/* STAB is the same-type attack bonus. */
		double stab = 1;
		if (m.type == atk.TYPE) {
			stab = 1.5;
		}
		/*
		 * Type1 is the type effectiveness of the used move against the target's type
		 * that comes first in the type matchup table, or only type if it only has one
		 * type.
		 */
		double type1 = 1;
		if(def.TYPE.hasWeakness(m.type)) {
			type1 = 2;
		} else if (def.TYPE.hasStrength(m.type)) {
			type1 = 0.5;
		}
		
		/* If the target only has one type, Type2 is 1. */
		int type2 = 1;
		/*
		 * random is realized as a multiplication by a random uniformly distributed
		 * integer between 217 and 255 (inclusive), followed by an integer division by
		 * 255.
		 */
		double rand = (rng.nextInt(16) + 85) / 100; //(rng.nextInt(217, 255) / 255);
		
		double sectA = (2*level*critical)/5+2;
		double sectB = Math.floor(((sectA * mPower * atkDmg/defDmg)/50) + 2);
		return (int) Math.floor(sectB * stab * type1 * type2 * rand);
	}
}
