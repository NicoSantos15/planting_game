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
//			pw.print(newString);
			
			
			
			int rowNum = 0;
			int colNum = 0;

			System.out.print(" ");
			for(int row=0; row<spaces.length; row++) {
				for(int col=0; col<spaces[row].length; col++) {
					if(row == 0)
						pw.print(" " + rowNum++);
				}
			}
			pw.print("");

			for(int row=0; row<spaces.length; row++) {
				for(int col=0; col<spaces[row].length; col++) {
					if(col == 0)
						pw.print(colNum++);
					if(spaces[row][col]==null)
						pw.print(" .");
					else if(spaces[row][col]!=null)
						pw.print(" " + spaces[row][col].symbol);
				}
				pw.print("");
			}
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
		int rowNum = 0;
		int colNum = 0;

		System.out.print(" ");
		for(int row=0; row<spaces.length; row++) {
			for(int col=0; col<spaces[row].length; col++) {
				if(row == 0)
					System.out.print(" "+ rowNum++);
			}
		}
		System.out.println();

		for(int row=0; row<spaces.length; row++) {
			for(int col=0; col<spaces[row].length; col++) {
				if(col == 0)
					System.out.print(colNum++);
				if(spaces[row][col]==null)
					System.out.print(" .");
				else if(spaces[row][col]!=null)
					System.out.print(" " + spaces[row][col].symbol);
			}
			System.out.println();
		}
		return "";
	}
}