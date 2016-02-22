package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
		// Open file; file name specified in args (command line)
		// Parse input, take appropriate actions.
		//A3Driver driver = new A3Driver();
		ArrayList<Item> shoppingCart = new ArrayList<Item>();
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				//String pigLatin = translator.translate(s);
				//System.out.println(pigLatin);
				if (isValidInput(s) == true)
				{
					//driver.process(s, shoppingCart);
					process(s, shoppingCart);
				}
				else
				{
					// print that the input was invalid
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
	* Method Name: isValidInput                                                   *
	* Purpose: Checks if the customer's input is valid.                           *
	* Returns: boolean, returns true if the input is valid                        *
	******************************************************************************/
	public static boolean isValidInput(String input)
	{
		return true;
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
		if (operands[0].equals("insert"))
		{
			insert(input, shoppingCart);
		}
		else if (operands[0].equals("search"))
		{
			search(input, shoppingCart);
		}
		else if (operands[0].equals("delete"))
		{
			delete(input, shoppingCart);
		}
		else if (operands[0].equals("update"))
		{
			update(input, shoppingCart);
		}
		else if (operands[0].equals("print"))
		{
			print(input, shoppingCart);
		}
	}
	
	public static void print(String input, ArrayList<Item> shoppingCart)
	{
		
	}

	public static void update(String input, ArrayList<Item> shoppingCart)
	{
		
	}

	public static void delete(String input, ArrayList<Item> shoppingCart)
	{
		
	}

	public static void search(String input, ArrayList<Item> shoppingCart)
	{
		
	}

	/******************************************************************************
	* Method Name: insert			                                              *
	* Purpose: Inserts an item into the shopping cart. They are sorted in         *
	* 		   ascending order (A to Z) by name.                                  *
	* Returns: None                                                               *
	******************************************************************************/
	public static void insert(String input, ArrayList<Item> shoppingCart)
	{
		String operands[] = input.split("//s+");
		String category = new String(operands[1]);
		if (shoppingCart.isEmpty() == true)
		{
			if (category.equals("groceries") == true)
			{
				boolean isPerishable = false; 
				if (operands[6].equals("P") == true)
				{
					isPerishable = true;
				}
				shoppingCart.add(new Item(operands[2], Float.parseFloat(operands[3]), Integer.parseInt(operands[4]), Integer.parseInt(operands[5]), isPerishable)));
			}
			if (category.equals("electronics") == true)
			{
				
			}
			if (category.equals("clothing") == true)
			{
				
			}
		}
	}

	public void extra(String input)
	{
		//Stub for arraylist.
		ArrayList<Item> shoppingCart = new ArrayList<Item>(); 

		// General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			temp.calculatePrice(); 
			temp.printItemAttributes();
			//This (above) works because of polymorphism: a determination is made at runtime, 
			//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
			// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
		}
	}
}
