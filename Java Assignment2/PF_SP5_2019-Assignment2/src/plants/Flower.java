package plants;

import java.util.Random;

public class Flower extends Plant {
	
	Random randomGenerator = new Random();
	
	private String colour;
	
	public Flower() {
		super("Daisy", '*', 7, 3);
		// TODO Auto-generated constructor stub
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}


	@Override
	public int sell() {
		// TODO Auto-generated method stub
		int basePrice = randomGenerator.nextInt(5)+7;
		int sellPrice = basePrice * yield;
		
		return sellPrice;
	}


	@Override
	public String getPlantType() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName().toLowerCase();
	}


}
