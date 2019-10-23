package game;

import field.Field;
import plants.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import exceptions.BeyondStockException;
import exceptions.OutOfStockException;

public class Main {
	private Field field;
	private Scanner input = new Scanner(System.in);
	private static final int HARVEST_DIVISOR = 10;
	private String harvestReceipt = "";
	private Player player = new Player();



	/**
	 * sellHarvest
	 * This method sells all plants to local buyers, receiving
	 * the current buy price for each plant type and adding it to
	 * the player's funds. It also generates an itemised receipt,
	 * showing the value of each crop. See the specification
	 * for more information.
	 * @param plants An array of plants to sell
	 * @return The total sell price of the harvest
	 */

	private int sellHarvest(Plant[] plants) {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * harvestPlants
	 * This method checks each field space, and harvests any plants
	 * that are at or beyond their maturation date. It should not harvest
	 * or till any weeds. See the specification for more information.
	 * @return An array of mature Plant objects
	 */

	private Plant[] harvestPlants() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * buyPlants
	 * This method receives a string of input from the console. It
	 * parses this string and buys the number of specific Plant objects.
	 * It should add these bought plants to the player's seedlings and
	 * deduct the cost from the player's funds. See the specification for
	 * more information.
	 * @param inputString A string of input in the form "v,3 fl,6"
	 */

	private void buyPlants(String purchases) {
		// TODO Auto-generated method stub
		
		
		
		
	}

	/**
	 * plantPlants
	 * This method receives a string of input from the console. It
	 * parses this string and plants the specified Plant types in the
	 * specified field spaces. It should remove the plants Plant objects
	 * from the player's seedlings array. See the specification for
	 * more information.
	 * @param inputString A string of input in the form "v,2,5 fr,5,4"
	 */

	private void plantPlants(String planting) {
		// TODO Auto-generated method stub

	}

	/**
	 * tillSoil
	 * This method receives a string of input from the console. It
	 * parses this string and tills the soil at the specified field space.
	 * The tilling should remove any Plant object in that space, resetting the
	 * field space to null. See the specification for more information.
	 * @param inputString
	 */

	private void tillSoil(String plot) {
		// TODO Auto-generated method stub

	}


	/**
	 * maturePlants
	 * This method should check all field spaces for a Plant
	 * object and increment its daysPlanted variable by one.
	 */


	private void maturePlants() {
		// TODO Auto-generated method stub

	}






	// ----------- DO NOT MODIFY ANY CODE BELOW ----------- //

	private void runGameLoop() {
		int round = 1;
		String inputString = "";
		while (!isExiting(inputString)) {
			System.out.println(field);
			field.writeToFile();
			if (round % HARVEST_DIVISOR == 0) {
				// Harvest day
				System.out.printf("Round number: %d | Harvest day!\n", round);
				Plant[] plants = harvestPlants();
				int returns = sellHarvest(plants);
				System.out.println(harvestReceipt);
				harvestReceipt = "";
				System.out.printf("Total sales: $%d\n", returns);
				spawnWeeds();
				Nursery.setPrices();
				Nursery.restock();
			}
			else {
				// Regular day, present options
				System.out.printf("Round number: %d | %d rounds until harvest | Funds: $%d\n", round,
						HARVEST_DIVISOR - round % HARVEST_DIVISOR,
						player.getFunds());
				inputString = getInputString();

				while (!inputString.equals("e")) {
					switch (inputString.toLowerCase()) {
					case "b":
						// Buy plants from store
						System.out.println("Welcome to the nursery. What would you like to buy?");
						System.out.println("We have in stock: " + printStockLevels());
						System.out.println("Our prices are: " + printPrices());
						System.out.println("Your available choices are: [fl = Flowers | fr = Fruit | g = Grain | v = Vegetable | l = leave]");
						System.out.println("Enter in the form 'v,3 fl,6' to buy 3 vegetables and 6 flowers");
						System.out.print("Choice: ");
						// Flush the input
						input.nextLine();
						// Take input for the purchases
						String purchases = input.nextLine().trim();
						buyPlants(purchases);
						break;
					case "p":
						// Plant plants
						System.out.println("What would you like to plant?");
						System.out.println("Your available seedlings are: " + printSeedlings());
						System.out.println("Enter in the form 'v,2,5 fr,5,4' to plant a vegetable in plot row 2, column 5 | l = leave");
						System.out.print("Choice: ");
						// Flush the input
						input.nextLine();
						// Take input for planting
						String planting = input.nextLine().trim();
						plantPlants(planting);
						break;
					case "t":
						// Till soil
						System.out.println("Which soil plots would you like to till?");
						System.out.println("Enter in the form '4,7 9,1' to till the soil plots in row 4, column 7 and row 9, column 1 | l = leave");
						System.out.print("Choice: ");
						input.nextLine();
						// Take input for planting
						String plot = input.nextLine().trim();
						tillSoil(plot);
						break;
					case "q":
						// Quit game
						System.exit(0);
					default:
						throw new IllegalStateException("Unexpected value: " + inputString.toLowerCase());
					}
					inputString = getInputString();
				}
			}
			// End round
			round++;
			System.out.println("Round end");
			maturePlants();
		}
	}

	/*
	 * Output the top-level game options to the player and returns their choice.
	 */
	private String getInputString() {
		System.out.println("What would you like to do?");
		System.out.println("Your available choices are: [b = Buy Plant | p = Plant plants | t = Till Soil | e = End Round | q = Quit Game]");
		System.out.print("Choice: ");
		return input.next();
	}

	/*
	 * Neatly prints the stock level of the nursery.
	 */
	private String printStockLevels() {
		return "" +
				"Flowers = " + Nursery.getQuantity("flowers") + " " +
				"Fruit = " + Nursery.getQuantity("fruit") + " " +
				"Grain = " + Nursery.getQuantity("grain") + " " +
				"Vegetables = " + Nursery.getQuantity("vegetables");
	}

	/*
	 * Neatly prints the prices of the nursery.
	 */
	private String printPrices() {
		return "" +
				"Flowers = $" + Nursery.getPrice("flowers") + " " +
				"Fruit = $" + Nursery.getPrice("fruit") + " " +
				"Grain = $" + Nursery.getPrice("grain") + " " +
				"Vegetables = $" + Nursery.getPrice("vegetables");
	}

	/*
	 * Neatly prints the number of each seedling type in the player's seedlings list.
	 */
	private String printSeedlings() {
		int[] numberOfSeedlings = new int[4];
		for (Plant p : player.seedlings) {
			if (p instanceof Flower) {
				numberOfSeedlings[0]++;
			}
			else if (p instanceof Fruit) {
				numberOfSeedlings[1]++;
			}
			else if (p instanceof Grain) {
				numberOfSeedlings[2]++;
			}
			else if (p instanceof Vegetable) {
				numberOfSeedlings[3]++;
			}
			else {
				System.out.println("Something went terribly wrong here");
			}
		}
		String output = "" +
				"Flowers = " + numberOfSeedlings[0] + " " +
				"Fruit = " + numberOfSeedlings[1] + " " +
				"Grain = " + numberOfSeedlings[2] + " " +
				"Vegetables = " + numberOfSeedlings[3];
		return output;
	}

	/*
	 * Generates the initial field.
	 */
	private void populateStartingField() {
		if (field == null) return;

		// Generate weeds
		for (int i = 0; i < field.spaces.length; i++) {
			for (int j = 0; j < field.spaces[i].length; j++) {
				if (new Random().nextInt(100) < 5) {
					// 5% chance of a weed spawning
					Plant p = new Weed("Dandelion", '#', 4, 1);
					field.spaces[i][j] = p;
				}
			}
		}
	}

	/*
	 * Called every harvest to spawn some random weeds.
	 */
	private void spawnWeeds() {
		// Generate weeds
		for (int i = 0; i < field.spaces.length; i++) {
			for (int j = 0; j < field.spaces[i].length; j++) {
				if (field.spaces[i][j] == null && new Random().nextInt(100) < 25) {
					// 25% chance of a weed spawning
					Plant p = new Weed("Dandelion", '#', 4, 1);
					field.spaces[i][j] = p;
				}
			}
		}
	}

	/*
	 * Exits the game.
	 */
	private boolean isExiting(String inputString) {
		return inputString.equalsIgnoreCase("q");
	}

	/*
	 * Runs the main game loop.
	 */
	public static void main(String[] args) {
		Field fi = new Field();
		System.out.println(fi.toString());
		
		
		Main main = new Main();
		main.field = new Field();
		main.populateStartingField();
		main.runGameLoop();
	}
}
