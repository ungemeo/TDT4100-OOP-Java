package inheritance;


public class DebitAccount extends AbstractAccount
{		
	@Override
	public void internalWithdraw(double balance)
	{
		if (super.getBalance() - balance > 0)
			super.balance -= balance;
		else
			throw new IllegalStateException("Du kan ikke bruke penger du ikke har!");
	}
}