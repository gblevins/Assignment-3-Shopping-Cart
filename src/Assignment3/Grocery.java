package Assignment3;

public class Grocery extends Item {
// variables
	protected boolean perishable;

// constructor
	public Grocery(String itemName, float itemPrice, int itemQuantity, int itemWeight, boolean itemPerishable)
	{
		name = itemName;
		price  = itemPrice;
		quantity = itemQuantity;
		weight = itemWeight;
		perishable = itemPerishable;
	}

// operational methods, some are overrides of the superclass
	public float calculatePrice () 
	{
		float final_price = 0;
		float initPrice = price * quantity;
		float shipping  = 20 * weight * quantity;
		float premShipping = (float)((shipping)*(1.2));
		float tax = 0;
		if(perishable)
		{
			final_price = initPrice + shipping + tax;
		}
		else
		{
			final_price = initPrice + premShipping +tax;
		}
		return final_price;
	}

	public void printItemAttributes () 
	{
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight);
		if(perishable)
		{
			System.out.println("Perishable: Yes");
		}
		else
		{
			System.out.println("Perishable: No");
		}
	}
}