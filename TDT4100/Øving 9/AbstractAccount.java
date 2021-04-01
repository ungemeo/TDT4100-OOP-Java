package inheritance;

public abstract class AbstractAccount
{
	protected double balance;
	
	public AbstractAccount()
	{
		this.balance = 0;
	}
	
	public void deposit(double balance)
	{
		if (balance > 0)
			this.balance += balance;
		else
			throw new IllegalArgumentException("Du må sette inn minst en eller fler kroner");
	}
	
	public void withdraw(double balance)
	{
		if (balance > 0)
			internalWithdraw(balance);
		else
			throw new IllegalArgumentException("Du må minst ta ut en eller fler kroner");
	}
	
	public abstract void internalWithdraw(double balance);
	
	public double getBalance()
	{
		return balance;
	}
}