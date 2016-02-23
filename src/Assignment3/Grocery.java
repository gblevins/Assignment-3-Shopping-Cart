package Assignment3;

public class Grocery extends Item {
	//variables, constructor here
	private boolean perishable;
	
	
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	double calculatePrice () 
	{
		double final_price = 0;
		// Insert price calculation here
		double initPrice = price*quantity;
		double shipping  = 20* weight * quantity;
		double premShipping = (shipping)*(1.2);
		double tax = 0;
		if(persiable)
		{
			final_price = initPrice + shipping + tax;
		}
		else
		{
			final_price = initPrice + premShipping +tax;
		}
		return final_price;
	}
}
void printItemAttributes () 
{
	System.out.println("Name: "+name);
	System.out.println("Price: "+price);
	System.out.println("Quantity: "+quantity);
	System.out.println("Weight: "+weight);
	if(perishable)
	{
		System.out.println("Perishable: Yes");
	}
	else
	{
		System.out.println("Perishable: No");
	}
}