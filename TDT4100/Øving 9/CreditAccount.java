package inheritance;

public class CreditAccount extends AbstractAccount
{
	private double creditLine;
	
	public CreditAccount(double creditLine)
	{
		this.creditLine = creditLine;
	}
	
	
	@Override
	public void internalWithdraw(double balance)
	{
		if (super.balance - balance >= - creditLine)
			super.balance -= balance;
		else
			throw new IllegalStateException();
	}
	
	public double getCreditLine()
	{
		return creditLine;
	}
	
	public void setCreditLine(double creditLine)
	{
		if (creditLine >= 0)
		{
			if (super.balance < 0)
			{
				if (super.balance + creditLine > 0)
				{
					super.balance += creditLine;
					this.creditLine = super.getBalance();
				}
				else
					throw new IllegalStateException();
			}
			else
				this.creditLine = creditLine;
		}
		else
			throw new IllegalArgumentException("Du kan ikke sette credit line til å være mindre enn 0!");
	}
}