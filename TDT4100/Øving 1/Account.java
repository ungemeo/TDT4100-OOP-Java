package stateandbehavior;

public class Account {

	double balance;
	double interestRate;
	
	//konstruktør
	public Account() {
		balance = 0;
		interestRate = 0;
	}
	
	//ctrl+mellomrom for autofyll sysout
	public static void main (String[] args) {
		Account account1 = new Account();
		account1.deposit(20);
		account1.setInterestRate(4.0);
		account1.addInterest(); 
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
		if (amount>0) {
			balance +=amount;
		}
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
		
	}

	public void addInterest() {
		balance = balance*(1+(interestRate/100));	
	}
	@Override
	public String toString() {
		return "balance=" + balance + ", interestRate=" + interestRate;
	}
} 