package plants;

import java.util.Random;

public class Grain extends Plant {
	
	Random randomGenerator = new Random();

	public Grain() {
		super("Wheat", '!', 4, 8);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sell() {
		// TODO Auto-generated method stub
		int basePrice = randomGenerator.nextInt(3)+2;
		int sellPrice = basePrice * yield;
		
		return sellPrice;
	}

	@Override
	public String getPlantType() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName().toLowerCase();
	}

}
