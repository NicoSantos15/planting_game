package game;

import plants.*;

import java.util.ArrayList;

import exceptions.InsufficientFundsException;
import exceptions.NoAvailableSeedlingException;

public class Player {
	private int funds;
	public ArrayList<Plant> seedlings = new ArrayList<>();

	public Player() {
		funds = 200;
	}

	/**
	 * getPlant
	 * This method searches the player's seedlings list for a
	 * plant object that matches the type provided. The method must determine
	 * the subclass of each Plant object in the list and return
	 * the first that matches the provided type. It should also remove
	 * it from the seedlings list. If there are no matching seedling
	 * objects of the provided type, it should throw a
	 * NoAvailableSeedlingException. See the specification for more information.
	 * @param type A string representation of the Plant type
	 * @return The first matching plant object from the seedlings list
	 * @throws NoAvailableSeedlingException
	 */


	public Plant getPlant(String plant) throws NoAvailableSeedlingException {
		//TODO create a get method to iterate over the
		//plant objects and see if its equals

		Plant newPlant = null;
		String fullName = null;
		
		switch (plant) {
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
		}
		
		for(int i=0; i<seedlings.size(); i++)
			if(fullName.equals(seedlings.get(i).getPlantType())) {
				newPlant = seedlings.get(i);
				break;
			}
		
		return newPlant;
	}

	/**
	 * pay
	 * This method attempts to subtract a provided amount from the player's
	 * funds. If there is not enough money, it should throw an
	 * InsufficientFundsException. See the specification for more information.
	 * @param payment The amount to be deducted
	 * @throws InsufficientFundsException
	 */

	public void pay(int i) throws InsufficientFundsException {
		// TODO Auto-generated method stub

		try {
			if(funds >= i)
				this.funds -= i;
			else if(funds < i)
				throw new InsufficientFundsException();
		}catch(InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}


	/**
	 * Increments funds by the provided amount.
	 * @param income
	 */
	public void addIncome(int income) {
		funds += income;
	}


	public void setSeedlings(ArrayList<Plant> seedlings) {
		this.seedlings = seedlings;
	}

	public int getFunds() {
		return funds;
	}

}
