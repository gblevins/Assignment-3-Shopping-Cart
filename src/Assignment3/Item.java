package Assignment3;

public class Item 
{
// variables
	protected String name;
	protected float price;
	protected int quantity;
	protected int weight;

// constructors
	public Item()
	{
		name = "";
		price = 0;
		quantity = 0;
		weight = 0;
	}

	public Item(String itemName, float itemPrice, int itemQuantity, int itemWeight)
	{
		name = itemName;
		price = itemPrice;
		quantity = itemQuantity;
		weight = itemWeight;
	}
	
// operational methods
	public float calculatePrice () 
	{
		float final_price = 0;
		float initPrice = price * quantity;
		float shipping  = 20 * weight * quantity;
		float tax = (float) (initPrice * 0.1);
		final_price = initPrice + shipping + tax;
		return final_price;
	}

	public void printItemAttributes () 
	{
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight);
	}
	
// get and sets
	public String getName()
	{
		return name;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int value)
	{
		quantity = value;
	}
}
