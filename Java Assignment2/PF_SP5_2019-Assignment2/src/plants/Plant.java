package plants;


import java.util.Random;


public abstract class Plant {
	public String name;
	public char symbol;
	public int yield;
	public int maturationTime;
	public int daysPlanted;
	
	public Plant() {
		super();
	}

	public Plant(String name, char symbol, int maturationTime, int yield) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.yield = yield;
		this.maturationTime = maturationTime;
		this.daysPlanted = daysPlanted;
	}
	
	public boolean isMature() {
		return false;
		
	}
	
	public String toString() {
		return "";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plant other = (Plant) obj;
		if (daysPlanted != other.daysPlanted)
			return false;
		if (maturationTime != other.maturationTime)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (symbol != other.symbol)
			return false;
		if (yield != other.yield)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + daysPlanted;
		result = prime * result + maturationTime;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + symbol;
		result = prime * result + yield;
		return result;
	}
	
	public abstract int sell();
	public abstract String getPlantType();
}
