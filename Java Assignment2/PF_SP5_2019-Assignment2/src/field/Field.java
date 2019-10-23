package field;

import java.util.Arrays;

import exceptions.FieldNotTilledException;
import plants.Flower;
import plants.Plant;

public class Field {
	public Plant[][] spaces;

	public Field() {
		spaces = new Plant[10][10];
	}


	/**
	 * This method should plant a provided plant in the given
	 * field space. If the field space is not empty, it should
	 * throw a FieldNotTilledException.
	 * @param plant The provided Plant object
	 * @param row The provided row
	 * @param column The provided column
	 * @throws FieldNotTilledException
	 */

	public void plantSeed (Plant[][] plant, int row, int col ) throws FieldNotTilledException{
		//TODO implement this method

		try {
			if(spaces == null) {

				for(int row2=0; row2<plant.length; row2++) {
					for(int col2=0; col<plant[row2].length; col2++) {
						if((row2==row)&&(col2==col))
							spaces[row2][col2] = plant[row][col];
					}
				}
			}
			else
				throw new FieldNotTilledException(null);
		}catch (FieldNotTilledException e) {
			System.out.println("FieldNotTilledException");
		}
	}

	/**
	 * writeToFile
	 * This method should write the current field out to a file
	 * called 'field.txt'. It should match the format produced by
	 * toString. See the specification for more information.
	 */

	public void writeToFile() {
		// TODO Auto-generated method stub

	}


	/**
	 * toString
	 * This method should produce a string representation of the current field.
	 * See the specification for more information and formatting requirements.
	 * @return A text representation of the field
	 */


	@Override
	public String toString() {
		
		for(int row=0; row<spaces.length; row++) {
			for(int col=0; col<spaces[row].length; col++) {
				if(spaces[row][col]==null)
					System.out.println(".");
				else
				}
		}


		for(Plant[] row : spaces) {
			if(spaces == null) 
				return ".";
			else
				return "#";
		}
	}


	/**
	 * printField 
	 * This method will print the field and execute the process of
	 * inserting plant in the field
	 */
	public static void printRow(String[] row) {
		for(String i:row) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
}
