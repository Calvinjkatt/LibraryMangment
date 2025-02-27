package project;

public class PurchasePhysical 
{
	//Needs to check if user balance is more than price of phyiscal item.
	//Needs either discounted and more than 
		//discountPrice or purchaseable and more than purchasePrice
	//Needs to give discount prices if available.
	protected static void purchase(PhysicalItem physical, User user)
	{
		double userBalance = user.getBalance().getBalance();
		
		if(userBalance > 0 && 
				((physical.discounted && userBalance >= physical.discountedPrice) 
						|| physical.purchaseable && userBalance >= physical.purchasePrice)) 
		{
			if(physical.discounted)
			{
				user.getBalance().removeFromBalance(physical.discountedPrice);
				System.out.println("You have purchased the item at a discount.");
			}
			else if(physical.purchaseable && !(physical.discounted))
			{
				user.getBalance().removeFromBalance(physical.purchasePrice);
				System.out.println("You have purchased the item at normal price.");
			}
		}
		else
		{
			System.out.println("You have insufficient funds to purchase the item.");
		}
	}
	
	public static void main(String [] args)
	{
		PhysicalItem book = new PhysicalItem("Nate is Great!", "C24");
		
		book.setDiscountedPrice(8);
		
		User Zack = new Student("zacklovesnoodle", "As123!", UserType.STUDENT);
		
		Zack.getBalance().addToBalance(12);
		
		System.out.println(Zack.getBalance().getBalance());
		
		Zack.purchaseItem(book);
		
		System.out.println(Zack.getBalance().getBalance());
	}
}
