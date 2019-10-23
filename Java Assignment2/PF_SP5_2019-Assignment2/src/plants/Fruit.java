package plants;

import java.util.Random;

public class Fruit extends Plant {
	
	Random randomGenerator = new Random();

	public Fruit() {
		super("Apple", '@', 14, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sell() {
		// TODO Auto-generated method stub
		
		int basePrice = randomGenerator.nextInt(21)+40;
		int sellPrice = basePrice * yield;
		
		return sellPrice;
	}

	@Override
	public String getPlantType() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName().toLowerCase();
	}

}
