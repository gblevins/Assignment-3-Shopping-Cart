package Assignment3;

public class Electronics extends Item 
{
// variables
	protected boolean fragile;
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
	
	public boolean hasTax(String stateName)
	{
		//must check if this is a valid state name
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
