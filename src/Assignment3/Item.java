package Assignment3;

public class Item 
{
// variables
	// name of the item
	protected String name;
	
	// price of each item
	protected float price;
	
	// number of items
	protected int quantity;
	
	// weight of each item
	protected int weight;
	
// operational methods
	// calculate the total price of the item
	public float calculatePrice () 
	{
		float final_price = 0;
		float initPrice = price * quantity;
		float shipping  = 20 * weight * quantity;
		float tax = (float) (initPrice * 0.1);
		final_price = initPrice + shipping + tax;
		return final_price;
	}

	// print the attributes of the item
	public void printItemAttributes () 
	{
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight);
	}
	
// get and sets
	// get the item name string
	public String getName()
	{
		return name;
	}
	
	// get the item quantity
	public int getQuantity()
	{
		return quantity;
	}
	
	// set the item quantity
	public void setQuantity(int value)
	{
		quantity = value;
	}
}
