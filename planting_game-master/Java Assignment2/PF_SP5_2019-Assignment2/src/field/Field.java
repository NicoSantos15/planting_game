package field;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

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
			if(spaces[row][col] == null) {
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

		String newString = toString();
		try {
			File file = new File("field.txt");
			PrintWriter pw = new PrintWriter(file);
			pw.print(newString);
			pw.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * toString
	 * This method should produce a string representation of the current field.
	 * See the specification for more information and formatting requirements.
	 * @return A text representation of the field
	 */


	@Override
	public String toString() {

		String newString = " ";
		int col;
		int row;

		for(int row1=0; row1<spaces.length; row1++) {
			for(int col1=0; col1<spaces[row1].length; col1++) {
				if(row1 == 0)
					newString = newString + " "+ col1;
			}
		}
		newString = newString + " \n";
		for(row=0; row<spaces.length;row++) {
			for(col=0; col<spaces[row].length;col++) {
				if(col==0)
					newString = newString + row;
				if(spaces[row][col]==null)
					newString = newString + " " + ".";
				else
					newString = newString + " " + spaces[row][col].symbol;
			}
			newString = newString + "\n";
		}
		return newString;
	}
}