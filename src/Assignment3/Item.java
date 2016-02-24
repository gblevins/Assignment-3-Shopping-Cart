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
		float tax = (float) (initPrice * 0.1);
		final_price = initPrice + shipping + tax;
		return final_price;
	}

	/******************************************************************************
	* Method Name: printItemAttributes                             				  *
	* Purpose: Prints out the attributes of item to the console					  *
	* Returns: None				                                                  *
	******************************************************************************/
	public void printItemAttributes () 
	{
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("Quantity: " + quantity);
		System.out.println("Weight: " + weight);
	}
	
// getters and setters
	
	/******************************************************************************
	* Method Name: getName                                        				  *
	* Purpose: Returns name of the item											  *
	* Returns: Name of the item                                                   *
	******************************************************************************/
	public String getName()
	{
		return name;
	}
	
	/******************************************************************************
	* Method Name: getQuantity                                          		  *
	* Purpose: Returns the quantity value of an item	 						  *
	* Returns: Quantity of the item                                               *
	******************************************************************************/
	public int getQuantity()
	{
		return quantity;
	}
	
	/******************************************************************************
	* Method Name: setQuantity                                          		  *
	* Purpose: Sets the quantity of an item to a new value 						  *
	* Returns: None                                                               *
	******************************************************************************/
	public void setQuantity(int value)
	{
		quantity = value;
	}
}
