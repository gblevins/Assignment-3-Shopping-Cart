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
		while (i.hasNext()) 
		{
			Item temp = i.next();
			String tempName = temp.getName();
			if (name.equals(tempName))
			{
				quantity = quantity + temp.getQuantity();
				i.remove();
			}
		}
		if (quantity == 0)
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
		while (i.hasNext()) 
		{
			Item temp = i.next();
			String tempName = temp.getName();
			if (name.equals(tempName))
			{
				quantity = quantity + temp.getQuantity();
			}
		}
		if (quantity == 0)
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
