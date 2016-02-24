package Assignment3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class errorHandling
{
	/******************************************************************************
	* Method Name: isValidInput                                                   *
	* Purpose: Checks if the customer's input is valid.                           *
	* Returns: boolean, returns true if the input is valid                        *
	******************************************************************************/
	public static boolean isValidInput(String input)
	{
		if (input.isEmpty() == true)
		{
			System.err.println("Nothing was entered.");
			return false;
		}
		String operands[] = input.split("\\s+");
		if (operands.length == 0)
		{
			System.err.println("Nothing was entered.");
			return false;
		}
		String operation = new String(operands[0]);
		switch (operation.toLowerCase())
		{
		case "insert":
			return isValidInsert(input);
		case "search":
			return isValidSearchorDelete(input);
		case "delete":
			return isValidSearchorDelete(input);
		case "update":
			return isValidUpdate(input);
		case "print":
			return isValidPrint(input);
		default:
			System.err.println("Invalid operation.");
			return false;
		}
	}
		
	public static boolean isValidInsert(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length == 1)
		{
			System.err.println("Incomplete input.");
			return false;
		}
		String category = new String(operands[1]);
		switch(category.toLowerCase())
		{
		case "groceries":
			return isValidGroceriesInsert(input);
		case "electronics":
			return isValidElectronicsInsert(input);
		case "clothing":
			return isValidClothingInsert(input);
		default:
			System.err.println("Invalid category.");
			return false;
		}
	}
			
	public static boolean isValidGroceriesInsert(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length != 7)
		{
			System.err.println("Invalid input.");
			return false;
		}
		if (!(isValidPrice(operands[3]) && isValidQuantity(operands[4]) && isValidWeight(operands[5])))
			return false;
		if (!(operands[6].equalsIgnoreCase("P") || operands[6].equalsIgnoreCase("NP")))
		{
			System.err.println("Invalid perishable input.");
			return false;
		}
		return true;
	}
	
	public static boolean isValidElectronicsInsert(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length != 8)
		{
			System.err.println("Invalid input.");
			return false;
		}
		if (!(isValidPrice(operands[3]) && isValidQuantity(operands[4]) && isValidWeight(operands[5])))
			return false;
		if (!(operands[6].equalsIgnoreCase("F") || operands[6].equalsIgnoreCase("NF")))
		{
			System.err.println("Invalid fragile input.");
			return false;
		}
		final Set<String> STATES = new HashSet<String>(Arrays.asList(
			     new String[] {"AK", "AL", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
							 "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS",
							 "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK",
							 "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
							 "WI", "WY"}));
		if (!STATES.contains(operands[7].toUpperCase()))
		{
			System.err.println("Invalid state to ship to.");
			return false;
		}
		return true;
	}
	
	public static boolean isValidClothingInsert(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length != 6)
		{
			System.err.println("Invalid input.");
			return false;
		}
		if (!(isValidPrice(operands[3]) && isValidQuantity(operands[4]) && isValidWeight(operands[5])))
			return false;
		return true;
	}
	
	public static boolean isValidPrice(String priceInput)
	{
		float price;
		try
		{
			price = Float.parseFloat(priceInput);
		} catch (NumberFormatException e)
		{
			System.err.println("Invalid price input.");
			return false;
		}
		if (price < 0)
		{
			System.err.println("Do not enter a negative price.");
			return false;
		}
		return true;
	}

	public static boolean isValidQuantity(String quantityInput)
	{
		Float quantity;
		try
		{
			quantity = Float.parseFloat(quantityInput);
		} catch (NumberFormatException e)
		{
			System.err.println("Invalid quantity input.");
			return false;
		}
		Integer test = quantity.intValue();
		Float test2 = test.floatValue();
		if(quantity.compareTo(test2) != 0)
		{
			System.err.println("Only enter whole numbers for the quantity field.");
			return false;
		}
		if (quantity < 0)
		{
			System.err.println("Do not enter a negative quantity.");
			return false;
		}
		return true;
	}

	public static boolean isValidWeight(String weightInput)
	{
		float weight;
		try
		{
			weight = Float.parseFloat(weightInput);
		} catch (NumberFormatException e)
		{
			System.err.println("Invalid weight input.");
			return false;
		}
		if (weight < 0)
		{
			System.err.println("Do not enter a negative weight.");
			return false;
		}
		return true;
	}
	
	public static boolean isValidSearchorDelete(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length != 2)
		{
			System.err.println("Invalid input.");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static boolean isValidUpdate(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length != 3)
		{
			System.err.println("Invalid input.");
			return false;
		}
		if (!isValidQuantity(operands[2]))
			return false;
		return true;
	}
	
	public static boolean isValidPrint(String input)
	{
		String operands[] = input.split("\\s+");
		if (operands.length == 1)
		{
			return true;
		}
		else
		{
			System.err.println("Invalid input.");
			return false;
		}
	}
}
