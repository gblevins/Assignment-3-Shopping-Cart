package Assignment3;

public class Item 
{
	//Declare variables for this class. Think about its type: public, protected or private?
	private String name;
	private double price;
	private int quantity;
	private double weight;


// You will need a constructor (Why?). Create it here.
	public void Item(String itemName, double itemPrice, int itemQuantity, double itemWeight)
	{
		name = itemName;
		price = itemPrice;
		quantity = itemQuantity;
		weight = itemWeight;
		
	}
	
	double calculatePrice () 
	{
		double final_price = 0;
		// Insert price calculation here
		double initPrice = price*quantity;
		double shipping  = 20* weight * quantity;
		double tax = initPrice *0.1;
		final_price = initPrice + shipping + tax;
		return final_price;
	}
	

	void printItemAttributes () 
	{
		System.out.println("Name: "+name);
		System.out.println("Price: "+price);
		System.out.println("Quantity: "+quantity);
		System.out.println("Weight: "+weight);
	}

}
