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
		if (input.isEmpty() == true)
		{
			System.out.println("Nothing was entered.");
			return false;
		}
		String operands[] = input.split("//s+");
		String operation = new String(operands[0]);
		if (!(operation.equalsIgnoreCase("insert") || operation.equalsIgnoreCase("search") ||
				operation.equalsIgnoreCase("delete") || operation.equalsIgnoreCase("update") ||
				operation.equalsIgnoreCase("print")))
		{
			System.out.println("Invalid operation.");
			return false;
		}
		
		if (operation.equalsIgnoreCase("insert"))
		{
			if (operands.length == 1)
			{
				System.out.println("Incomplete input.");
				return false;
			}
			String category = new String(operands[1]);
			if (!(category.equalsIgnoreCase("groceries") || category.equalsIgnoreCase("electronics") ||
					category.equalsIgnoreCase("clothing")))
			{
				System.out.println("Invalid category.");
				return false;
			}
			
			if (category.equalsIgnoreCase("groceries"))
			{
				if (operands.length != 7)
				{
					System.out.println("Invalid input.");
					return false;
				}
				float price = Float.parseFloat(operands[3]);
				if (price < 0)
				{
					System.out.println("Do not input a negative price.");
					return false;
				}
				int quantity = Integer.parseInt(operands[4]);
				if (quantity < 0)
				{
					System.out.println("Do no input a negative quantity.");
					return false;
				}
				int weight = Integer.parseInt(operands[5]);
				if (weight < 0)
				{
					System.out.println("Do not input a negative weight.");
					return false;
				}
				String isPerishable = new String(operands[6]);
				if (!(isPerishable.equalsIgnoreCase("P") || isPerishable.equalsIgnoreCase("NP")))
				{
					System.out.println("Invalid perishable item verifier.");
					return false;
				}
				return true;
			}
			if (category.equalsIgnoreCase("electronics"))
			{
				if (operands.length != 8)
				{
					System.out.println("Invalid input.");
					return false;
				}
				float price = Float.parseFloat(operands[3]);
				if (price < 0)
				{
					System.out.println("Do not input a negative price.");
					return false;
				}
				int quantity = Integer.parseInt(operands[4]);
				if (quantity < 0)
				{
					System.out.println("Do no input a negative quantity.");
					return false;
				}
				int weight = Integer.parseInt(operands[5]);
				if (weight < 0)
				{
					System.out.println("Do not input a negative weight.");
					return false;
				}
				String isFragile = new String(operands[6]);
				if (!(isFragile.equalsIgnoreCase("F") || isFragile.equalsIgnoreCase("NF")))
				{
					System.out.println("Invalid fragile item verifier.");
					return false;
				}
				String state = new String(operands[7]);
				final Set<String> STATES = new HashSet<String>(Arrays.asList(
					     new String[] {"AK", "AL", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
									 "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS",
									 "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK",
									 "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
									 "WI", "WY"}));
				if (!STATES.contains(state.toUpperCase()))
				{
					System.out.println("Invalid state to ship to.");
					return false;
				}
				return true;
			}
			if (category.equalsIgnoreCase("clothing"))
			{
				if (operands.length != 6)
				{
					System.out.println("Invalid input.");
					return false;
				}
				float price = Float.parseFloat(operands[3]);
				if (price < 0)
				{
					System.out.println("Do not input a negative price.");
					return false;
				}
				int quantity = Integer.parseInt(operands[4]);
				if (quantity < 0)
				{
					System.out.println("Do no input a negative quantity.");
					return false;
				}
				int weight = Integer.parseInt(operands[5]);
				if (weight < 0)
				{
					System.out.println("Do not input a negative weight.");
					return false;
				}
				return true;
			}
		}
		if (operation.equalsIgnoreCase("search") || operation.equalsIgnoreCase("delete"))
		{
			if (operands.length != 2)
			{
				System.out.println("Invalid input.");
				return false;
			}
			else
			{
				return true;
			}
		}
		if (operation.equalsIgnoreCase("update"))
		{
			if (operands.length != 3)
			{
				System.out.println("Invalid input.");
				return false;
			}
			
			int newQuantity = Integer.parseInt(operands[2]);
			if (newQuantity < 0)
			{
				System.out.println("Do not input negative quantities.");
				return false;
			}
			return true;
		}
		if (operation.equalsIgnoreCase("print"))
		{
			if (operands.length == 1)
			{
				return true;
			}
			else
			{
				System.out.println("Invalid input.");
				return false;
			}
		}
		
		return false;
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
			insert(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("search"))
		{
			search(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("delete"))
		{
			delete(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("update"))
		{
			update(input, shoppingCart);
		}
		else if (operands[0].equalsIgnoreCase("print"))
		{
			print(input, shoppingCart);
		}
	}
	
	/******************************************************************************
	* Method Name: print			                                              *
	* Purpose: print the contents of the shopping cart in order by name,          *
	* 		   showing all attribute values for each object as well as the        *
	* 		   total charges for each. This is followed by the total charges      *
	* 		   for entire the shopping cart. Output of the shopping cart should   *
	*		   be to the standard output stream (screen) and should be            *
	*		   appropriately formatted and labeled for readability. This is       *
	*		   not a complete shipping list, which would be handled separately    *
	*		   by a different program.                                            *
	* Returns: None                                                               *
	******************************************************************************/
	// use an iterator? can remove from iterator and will remove from list (test to make sure)
	// check if valid state? create an array of all the state abbreviations and then use does contain method
	public static void print(String input, ArrayList<Item> shoppingCart)
	{
		Iterator<Item> i = shoppingCart.iterator();
		float totalPrice = 0;
		while (i.hasNext()) 
		{
			Item temp = i.next();
			float totalItemPrice = temp.calculatePrice();
			totalPrice = totalPrice + totalItemPrice;
			temp.printItemAttributes();
			System.out.println("The total price for this item is: " + Float.toString(totalItemPrice));
		}
		System.out.println("The total price for the shopping cart is: " + Float.toString(totalPrice));
	}

	/******************************************************************************
	* Method Name: update			                                              *
	* Purpose: Searches for item named "input name" in the cart and updates the   *
	*          first item with the right name to a new specified quantity.        *
	* Returns: None                                                               *
	******************************************************************************/
	public static void update(String input, ArrayList<Item> shoppingCart)
	{
		String operands[] = input.split("//s+");
		String name = new String(operands[1]);
		int newQuantity = Integer.parseInt(operands[2]);
		Iterator<Item> i = shoppingCart.iterator();
		boolean found = false;
		while (i.hasNext()) 
		{
			Item temp = i.next();
			String tempName = temp.getName();
			if (name.equals(tempName))
			{
				temp.setQuantity(newQuantity);
				found = true;
				break
			}
		}
		if (found == false)
		{
			System.out.println("No items named " + name + " found.");
		}
		else 
		{
			System.out.println(name + " updated to quantity " + Integer.toString(newQuantity));
		}
	}

	/******************************************************************************
	* Method Name: delete			                                              *
	* Purpose: Searches for items named "input name" in the cart and deletes all  *
	* 		   of them. This is case sensitive.                                   *
	* Returns: None                                                               *
	******************************************************************************/
	public static void delete(String input, ArrayList<Item> shoppingCart)
	{
		String operands[] = input.split("//s+");
		String name = new String(operands[1]);
		Iterator<Item> i = shoppingCart.iterator();
		int quantity = 0;
		boolean itemFound = false;
		while (i.hasNext()) 
		{
			Item temp = i.next();
			String tempName = temp.getName();
			if (name.equals(tempName))
			{
				quantity = quantity + temp.getQuantity();
				itemFound = true;
				i.remove();
			}
		}
		if (itemFound == false)
		{
			System.out.println("No items named " + name + " found.");
		}
		else 
		{
			System.out.println(Integer.toString(quantity) + " items named " + name + " found and deleted.");
		}
	}

	/******************************************************************************
	* Method Name: search			                                              *
	* Purpose: Searches for an item name in the cart. This is case sensitive.     *
	* Returns: None                                                               *
	******************************************************************************/
	public static void search(String input, ArrayList<Item> shoppingCart)
	{
		String operands[] = input.split("//s+");
		String name = new String(operands[1]);
		Iterator<Item> i = shoppingCart.iterator();
		int quantity = 0;
		boolean itemFound = false;
		while (i.hasNext()) 
		{
			Item temp = i.next();
			String tempName = temp.getName();
			if (name.equals(tempName))
			{
				quantity = quantity + temp.getQuantity();
				itemFound = true;
			}
		}
		if (itemFound == false)
		{
			System.out.println("No items named " + name + " found.");
		}
		else 
		{
			System.out.println(Integer.toString(quantity) + " items named " + name + " found.");
		}
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
		String name = new String(operands[2]); // items can have the same name and different price
		float price = Float.parseFloat(operands[3]);
		price = Math.round(price*100)/100;
		int quantity = Integer.parseInt(operands[4]);
		int weight = Integer.parseInt(operands[5]);
		if (shoppingCart.isEmpty() == true)
		{
			if (category.equalsIgnoreCase("groceries") == true)
			{
				boolean isPerishable = false; 
				if (operands[6].equalsIgnoreCase("P") == true)
				{
					isPerishable = true;
				}
				shoppingCart.add(new Item(name, price, quantity, weight, isPerishable)));
			}
			else if (category.equalsIgnoreCase("electronics") == true)
			{
				String state = new String(operands[7]);
				boolean isFragile = false; 
				if (operands[6].equalsIgnoreCase("F") == true)
				{
					isFragile = true;
				}
				shoppingCart.add(new Item(name, price, quantity, weight, isFragile, state)));
			}
			else if (category.equalsIgnoreCase("clothing") == true)
			{
				shoppingCart.add(new Item(name, price, quantity, weight)));
			}
		}
		else
		{
			int index = 0;
			int size = shoppingCart.size();
			while (index < size)
			{
				Item temp = shoppingCart.get(index);
				String tempName = temp.getName;
				int result = name.compareTo(tempName);
				if (result < 0)	// item should be placed before
				{
					break;
				}
				index = index + 1;
			}
			if (index == size)
			{
				if (category.equalsIgnoreCase("groceries") == true)
				{
					boolean isPerishable = false; 
					if (operands[6].equalsIgnoreCase("P") == true)
					{
						isPerishable = true;
					}
					shoppingCart.add(new Item(name, price, quantity, weight, isPerishable)));
				}
				else if (category.equalsIgnoreCase("electronics") == true)
				{
					String state = new String(operands[7]);
					boolean isFragile = false; 
					if (operands[6].equalsIgnoreCase("F") == true)
					{
						isFragile = true;
					}
					shoppingCart.add(new Item(name, price, quantity, weight, isFragile, state)));
				}
				else if (category.equalsIgnoreCase("clothing") == true)
				{
					shoppingCart.add(new Item(name, price, quantity, weight)));
				}
			}
			else
			{
				if (category.equalsIgnoreCase("groceries") == true)
				{
					boolean isPerishable = false; 
					if (operands[6].equalsIgnoreCase("P") == true)
					{
						isPerishable = true;
					}
					shoppingCart.add(index, new Item(name, price, quantity, weight, isPerishable)));
				}
				else if (category.equalsIgnoreCase("electronics") == true)
				{
					String state = new String(operands[7]);
					boolean isFragile = false; 
					if (operands[6].equalsIgnoreCase("F") == true)
					{
						isFragile = true;
					}
					shoppingCart.add(index, new Item(name, price, quantity, weight, isFragile, state)));
				}
				else if (category.equalsIgnoreCase("clothing") == true)
				{
					shoppingCart.add(index, new Item(name, price, quantity, weight)));
				}
			}
		}
	}

	public void extra(String input, ArrayList<Item> shoppingCart)
	{
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			temp.calculatePrice(); 
			temp.printItemAttributes();
		}
	}
}
