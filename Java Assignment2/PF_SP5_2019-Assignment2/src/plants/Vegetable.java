package plants;

import java.util.Random;

public class Vegetable extends Plant{
	
	Random randomGenerator = new Random();

	public Vegetable() {
		super("Capsicum", '^', 8, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sell() {
		// TODO Auto-generated method stub
		int basePrice = randomGenerator.nextInt(10)+6;
		int sellPrice = basePrice * yield;
		
		return sellPrice;
	}

	@Override
	public String getPlantType() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName().toLowerCase();

	}
}
