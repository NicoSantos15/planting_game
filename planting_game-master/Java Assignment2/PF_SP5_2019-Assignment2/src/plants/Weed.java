package plants;

public class Weed extends Plant {




	public Weed(String name, char symbol, int maturationTime, int yield) {
		super(name, symbol, maturationTime, yield);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sell() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPlantType() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName().toLowerCase();
	}
}
