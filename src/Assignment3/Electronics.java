package Assignment3;

public class Electronics extends Item 
{
// variables
	// is the item fragile?
	protected boolean fragile;
	
	// what state is the item shipping to?
	protected String state;
	
// constructor
	public Electronics(String itemName, float itemPrice, int itemQuantity, int itemWeight, boolean itemFragile, String itemState)
	{
		name = itemName;
		price = itemPrice;
		quantity = itemQuantity;
		weight = itemWeight;
		fragile = itemFragile;
		state = itemState;
	}

// operational methods, some are overrides of superclass methods
	/******************************************************************************
	* Method Name: calculatePrice                            				     *
	* Purpose: Calculates the total price of an item including tax and shipping  * 			
	* and returns it								    						 *
	* Returns: The total price of the item                                       *
	******************************************************************************/
	public float calculatePrice () 
	{
		float final_price = 0;
		float initPrice = price * quantity;
		float shipping  = 20 * weight * quantity;
		float premShipping = (shipping) * (float)(1.2);
		float tax = 0;
		if(hasTax(state))
		{
			tax = initPrice*(float)0.1;
		}

		if(fragile)
		{
			final_price = initPrice + shipping + tax;
		}
		else
		{
			final_price = initPrice + premShipping +tax;
		}
		return final_price;
	}

	/******************************************************************************
	* Method Name: hasTax			                           				     *
	* Purpose: Determines if the state of the item has a tax on electronics		 *
	* Returns: True or False				                                     *
	******************************************************************************/
	public boolean hasTax(String stateName)
	{
		if (stateName.equals("TX") || stateName.equals("NM") || stateName.equals("VA") ||
				stateName.equals("AZ") || stateName.equals("AK"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	// prints the items attributes
	public void printItemAttributes () 
	{
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight);
		if(fragile)
		{
			System.out.println("Fragile: Yes");
		}
		else
		{
			System.out.println("Fragile: No");
		}
	}
}
