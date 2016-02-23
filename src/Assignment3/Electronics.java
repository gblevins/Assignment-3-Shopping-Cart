package Assignment3;

public class Electronics extends Item 
{
	private boolean fragile;
	private String state;
	// Variables, constructors etc. here.
	public void Item(String itemName, double itemPrice, int itemQuantity, double itemWeight, boolean itemFragile, String itemState)
	{
		name = itemName;
		price = itemPrice;
		quantity = itemQuantity;
		weight = itemWeight;
		fragile = itemFragile;
		state = itemState;
	
	//Implement calculate price/print methods as necessary
	double calculatePrice () 
	{
		double final_price = 0;
		// Insert price calculation here
		double initPrice = price*quantity;
		double shipping  = 20* weight * quantity;
		double premShipping = (shipping)*(1.2);
		double tax = 0;
		if(hasTax(state))
		{
			tax = initPrice*0.1;
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
	
	public boolean hasTax(String state)
	{
		//must check if this is a valid state name
		if (stateName.equals("TX")||stateName.equals("NM")||stateName.equals("VA")||stateName.equals("AZ")||stateName.equals("AK"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	void printItemAttributes () 
	{
		System.out.println("Name: "+name);
		System.out.println("Price: "+price);
		System.out.println("Quantity: "+quantity);
		System.out.println("Weight: "+weight);
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
