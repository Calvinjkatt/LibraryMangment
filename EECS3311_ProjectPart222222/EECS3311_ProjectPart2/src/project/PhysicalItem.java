package project;

import java.time.LocalDate;

public class PhysicalItem 
{
	public String name;
	public String location;
	public int itemID;
	
	//This may be incorrect right now.
	//This means multiple books would share the same quantity value.
	//I want different items to each have their own quantity
	//value, but not each item itself.
	
	public static int quantity = 20; //The number of copies of this item in the library, 20.
	
	public LocalDate rentDate; //If rented, update the rentDate.
	public LocalDate dueDate; //If rented, update the dueDate to 1 month later.
	
	//Physical items may be purchasable, rentable, or both.
	
	public boolean purchaseable = true;
	public boolean rentable = true;
	public boolean discounted = true;
	
	public double discountedPrice;
	public double purchasePrice;
	
	protected PhysicalItem(String name, String location)
	{
		this.name = name;
		this.location = location;

		itemID = IDGenerator.getInstance().getNextID();
	}

	public static void addItem(String name, String location)
	{
		new PhysicalItem(name, location);
	}
	
	public void setPurchasePrice(double price)
	{
		if(purchaseable)
		{
			purchasePrice = price;
		}
	}
	
	public void setDiscountedPrice(double price)
	{
		if(purchaseable && discounted)
		{
			discountedPrice = price;
		}		
	}

	public String getTitle() 
	{
		return name;
	}

	public String getLocation() 
	{
		return location;
	}

	public LocalDate getRentDate() 
	{
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate)
	{
		this.rentDate = rentDate;
	}
	
	public LocalDate getDueDate() 
	{
		return dueDate;
	}
	
	public void setDueDate(LocalDate dueDate)
	{
		this.dueDate = dueDate;
	}
}
