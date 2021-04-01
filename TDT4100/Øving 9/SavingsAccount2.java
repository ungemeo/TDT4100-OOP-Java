package inheritance;

public class SavingsAccount2 extends AbstractAccount {
	
	private int withdrawals;
	private double fee;
	
	
	public SavingsAccount2(int withdrawals, double fee)
	{
		this.withdrawals = withdrawals;
		this.fee = fee;
	}
	
	@Override
	public void internalWithdraw(double balance)
	{
		if (withdrawals > 0 && super.balance - balance > 0)
		{
			withdrawals -= 1;
			super.balance -= balance;
		}
		
		else if (withdrawals <= 0 && super.balance - balance - fee > 0)
			super.balance -= balance + fee;
		
		else if (super.balance - balance - fee < 0)
			throw new IllegalStateException("Du har ikke penger nok til å ta ut "+balance+" med en avgift på "+fee);
	}
}