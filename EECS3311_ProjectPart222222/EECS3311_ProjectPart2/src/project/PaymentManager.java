package project;

public class PaymentManager 
{
	private double balance;
	
	public void addToBalance(double money)
	{
		balance += money;
	}
	
	public void removeFromBalance(double money)
	{
		balance -= money;
	}
	
	public double getBalance()
	{
		return balance;
	}
}
