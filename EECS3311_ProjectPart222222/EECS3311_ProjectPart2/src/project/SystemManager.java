package project;

public class SystemManager 
{
	private String itemName;
	
	//Changes rentable to true in PhysicalItem.
	//An item is now able to be rented.
	private void enable()
	{
		
	}
	
	//Changes rentable to false in PhysicalItem. 
	//An item is now not able to be rented.
	private void disable()
	{
		
	}
	
	//Changes discoubtable to true in PhysicalItem.
	//An item is now discounted.
	private void setDiscounted()
	{
		
	}
	
	//Changes purchaseable to true in PhysicalItem.
	//An item is now purchaseable.
	private void setPurchaseable()
	{
		
	}
	
	private void addBook()
	{
		
	}
	
	private void addMagazine()
	{
		
	}
	
	private void addCD()
	{
		
	}
	
	private Memento StoreInMemento(PhysicalItem newState)
	{
		return new Memento(newState);
	}
	
	private PhysicalItem restoreFromMemento(Memento memento)
	{
		PhysicalItem pastItem = memento.getSavedItem();
		return pastItem;
	}
}
