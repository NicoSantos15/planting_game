package game;

import java.util.HashMap;
import java.util.Random;

import exceptions.BeyondStockException;
import exceptions.InsufficientFundsException;
import exceptions.OutOfStockException;

public class Nursery {
	private static HashMap<String, Integer> quantities;
	private static HashMap<String, Integer> prices;
	private static Random random = new Random();

	static {
		// Fill initial stock
		quantities = new HashMap<>();
		quantities.put("flowers", 10);
		quantities.put("fruit", 10);
		quantities.put("grain", 10);
		quantities.put("vegetables", 10);

		// Set initial prices
		prices = new HashMap<>();
		setPrices();
	}

	/**
	 * This method purchase a number of a specific plant from the Nursery.
	 * If successful, it deducts the purchase amount from the player's funds
	 * and returns true.
	 * @param type The type of Plant to buy, expected as shorthand
	 * @param quantity The number of plants to buy
	 * @param buyer The Player object, representing the buyer
	 * @return True if purchase successful, false if not
	 * @throws BeyondStockException
	 * @throws OutOfStockException
	 */
	public static boolean buyPlant(String type, int quantity, Player buyer)
			throws BeyondStockException, OutOfStockException {
		String fullName;
		switch (type) {
		case "fl":
			fullName = "flower";
			break;
		case "fr":
			fullName = "fruit";
			break;
		case "g":
			fullName = "grain";
			break;
		case "v":
			fullName = "vegetables";
			break;
		default:
			throw new BeyondStockException(type);
		}

		// Get the current in-stock amount of that plant
		int stockAmount = quantities.get(fullName);
		if (quantity > stockAmount) {
			// The store cannot provide that much
			throw new BeyondStockException(fullName);
		}
		else if (stockAmount <= 0) {
			// The store is out of stock
			throw new OutOfStockException(fullName);
		}
		
		try {
			buyer.pay(prices.get(fullName) * quantity);
			quantities.put(fullName, stockAmount - quantity);
			return true;
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * This method randomises the prices of each plant type. It is
	 * called at every harvest.
	 */
	public static void setPrices() {
		prices.put("flowers", random.nextInt(6) + 10);   // $10-15
		prices.put("fruit", random.nextInt(11) + 20);    // $20-30
		prices.put("grain", random.nextInt(9) + 8);      // $8-16
		prices.put("vegetables", random.nextInt(7) + 4); // $4-10
	}

	/**
	 * This refreshes the stock by randomising the stock quantity. It is
	 * called at every harvest.
	 */
	public static void restock() {
		quantities.put("flowers", random.nextInt(6) + 5);       // 5-10
		quantities.put("fruit", random.nextInt(6) + 5);         // 5-10
		quantities.put("grain", random.nextInt(6) + 5);         // 5-10
		quantities.put("vegetables", random.nextInt(6) + 5);    // 5-10
	}

	public static int getPrice(String key) {
		return prices.get(key);
	}

	public static int getQuantity(String key) {
		return quantities.get(key);
	}
}
