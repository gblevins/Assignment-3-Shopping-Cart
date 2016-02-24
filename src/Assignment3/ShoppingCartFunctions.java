package Assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCartFunctions
{
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
	public static void print(String input, ArrayList<Item> shoppingCart)
	{
		if (shoppingCart.size() == 0)
		{
			System.err.println("The Shopping Cart is empty.");
			return;
		}
		Iterator<Item> i = shoppingCart.iterator();
		float totalPrice = 0;
		while (i.hasNext()) 
		{
			Item temp = i.next();
			float totalItemPrice = temp.calculatePrice();
			totalPrice = totalPrice + totalItemPrice;
			temp.printItemAttributes();
			System.out.println("The total price for this item is: " + Float.toString(totalItemPrice) + "\n");
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
		String operands[] = input.split("\\s+");
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
				break;
			}
		}
		if (found == false)
		{
			System.err.println("No items named " + name + " found.");
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
		String operands[] = input.split("\\s+");
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
			System.err.println("No items named " + name + " found.");
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
		String operands[] = input.split("\\s+");
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
			System.err.println("No items named " + name + " found.");
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
		String operands[] = input.split("\\s+");
		String name = new String(operands[2]); // items can have the same name and different price
		if (shoppingCart.isEmpty() == true)
		{
			insertAtIndexOfCart(shoppingCart.size(), input, shoppingCart);
		}
		else
		{
			int index = 0;
			int size = shoppingCart.size();
			while (index < size)
			{
				Item temp = shoppingCart.get(index);
				String tempName = temp.getName();
				int result = (name.toLowerCase()).compareTo(tempName.toLowerCase());
				if (result < 0)	// item should be placed before
				{
					break;
				}
				index = index + 1;
			}
			if (index == size)
			{
				insertAtIndexOfCart(shoppingCart.size(), input, shoppingCart);
			}
			else
			{
				insertAtIndexOfCart(index, input, shoppingCart);
			}
		}
	}
	
	/******************************************************************************
	* Method Name: insertAtIndexOfCart                                            *
	* Purpose: Inserts an item into the shopping cart at the specified index.     *
	* Returns: None                                                               *
	******************************************************************************/
	public static void insertAtIndexOfCart(int index, String input, ArrayList<Item> shoppingCart)
	{
		String operands[] = input.split("\\s+");
		String category = new String(operands[1]);
		String name = new String(operands[2]); // items can have the same name and different price
		
		Double priceInput = Double.parseDouble(operands[3]);
		Integer roundPrice = (int) (priceInput * 100);
		Double price = (double) roundPrice / 100;
		Float priceFloat = price.floatValue();
		Float inputPriceFloat = priceInput.floatValue();
		if (inputPriceFloat.compareTo(priceFloat) != 0)
		{
			System.err.println("Price of the item truncated.");
		}
		
		Float floatQuantity = Float.parseFloat(operands[4]);
		int quantity = floatQuantity.intValue();
		Float floatWeight = Float.parseFloat(operands[5]);
		Integer weight = floatWeight.intValue();
		Float test2 = weight.floatValue();
		if (floatWeight.compareTo(test2) != 0)
		{
			System.err.println("Weight of the item truncated.");
		}
		
		if (category.equalsIgnoreCase("groceries") == true)
		{
			boolean isPerishable = false; 
			if (operands[6].equalsIgnoreCase("P") == true)
			{
				isPerishable = true;
			}
			shoppingCart.add(index, new Grocery(name, priceFloat, quantity, weight, isPerishable));
		}
		else if (category.equalsIgnoreCase("electronics") == true)
		{
			String state = new String(operands[7]);
			boolean isFragile = false; 
			if (operands[6].equalsIgnoreCase("F") == true)
			{
				isFragile = true;
			}
			shoppingCart.add(index, new Electronics(name, priceFloat, quantity, weight, isFragile, state.toUpperCase()));
		}
		else if (category.equalsIgnoreCase("clothing") == true)
		{
			shoppingCart.add(index, new Clothing(name, priceFloat, quantity, weight));
		}
	}
}
