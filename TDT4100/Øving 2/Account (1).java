package encapsulation;

public class Account {

	double balance;
	double interestRate;
	
	//konstruktør
	public Account(double balance, double interestRate) {
		if (balance < 0 || interestRate < 0) {
			throw new IllegalArgumentException("Balance and Interest Rate can not be negative.");
		}
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	//ctrl+mellomrom for autofyll sysout
	public static void main (String[] args) {
		Account account1 = new Account(20,1);
		account1.deposit(20);
		account1.setInterestRate(4.0);
		account1.addInterest(); 
		account1.withdraw(1);
		System.out.println("Renten til den nye kontoen er: " + account1.getInterestRate());
		System.out.println("Balansen til den nye kontoen er: " + account1.getBalance());
		System.out.println("account1: "+ account1.toString());

	}
	
	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Deposit may not have a negative value.");
		}
		balance +=amount;
	}
	
	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("You can not withdraw a negative value."); 
		}		
		else if (amount > balance) {
			throw new IllegalArgumentException("You do not have sufficient funds to withdraw the requested amount.");
		}
		balance -= amount; 
	}

	public void setInterestRate(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("Interest rate may not be negative.");
		}
		this.interestRate = interestRate;
	}

	public void addInterest() {
		balance *=(1+(interestRate/100));	//*=
	}
	@Override
	public String toString() {
		return "balance=" + balance + ", interestRate=" + interestRate;
	}
} 