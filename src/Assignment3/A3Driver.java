package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//this is a test
public class A3Driver 
{
	public static void main(String[] args) 
	{
		if (args.length != 1) 
		{
			System.err.println ("Error: incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesinFile (args[0]);
	}
	
	/******************************************************************************
	* Method Name: processLinesinFile                                             *
	* Purpose: Opens the file specified in String filename, reads each line in it *
	*          and performs operation specified in line.                          *
	* Returns: None                                                               *
	******************************************************************************/
	public static void processLinesinFile (String filename)
	{
		ArrayList<Item> shoppingCart = new ArrayList<Item>();
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				if (errorHandling.isValidInput(s) == true)
				{
					process(s, shoppingCart);
				}
			}
			reader.close();
		}
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: iO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/******************************************************************************
	* Method Name: process			                                              *
	* Purpose: Opens the file specified in String filename, reads each line in it *
	*          and performs operation specified in line.                          *
	* Returns: None                                                               *
	******************************************************************************/
	public static void process(String input, ArrayList<Item> shoppingCart)
	{
		String operands[] = input.split("\\s+");
		if (operands[0].equalsIgnoreCase("insert"))
		{
			ShoppingCartFunctions.insert(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("search"))
		{
			ShoppingCartFunctions.search(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("delete"))
		{
			ShoppingCartFunctions.delete(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("update"))
		{
			ShoppingCartFunctions.update(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("print"))
		{
			ShoppingCartFunctions.print(input, shoppingCart);
		}
	}
}
