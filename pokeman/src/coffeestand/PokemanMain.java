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
	 * supposed to be in the real ones.
	 * 
	 * @param m The move used by the attacker
	 * @param atk The attacking Pokemon
	 * @param def The defending Pokemon
	 * 
	 * @return Damage output based on the factors supplied through the parameters
	 * 
	 * @see <a href="https://bulbapedia.bulbagarden.net/wiki/Damage#Generation_I">Damage - Bulbapedia</a>
	 */
	public static int calcDamage(Move m, Pokemon atk, Pokemon def) {
		return 0;
	}
}
