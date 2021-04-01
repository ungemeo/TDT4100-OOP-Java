package stateandbehavior;

public class Digit {

	int tallSystem;
	static int sifferVerdi;
	
	public Digit(int tallSystem) {
		this.tallSystem = tallSystem;
		sifferVerdi = 0;
	}
	
	public int getValue() {
		return sifferVerdi;
	}
	
	public int getBase() {
		return tallSystem;
	}
	
	public boolean increment() {
		sifferVerdi++;
		if (sifferVerdi == tallSystem) {
			sifferVerdi = 0;
			return true;
		}
		return false; 
	}

	@Override
	public String toString() {
		// String[] stringArray= new String{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
		return (Integer.toString(sifferVerdi, tallSystem)).toUpperCase();
	} 

	public static void main(String[] args) {
		Digit testTall = new Digit(16);
		for (int i = 0; i < 10; i++) {
			testTall.increment();
		}
		
		System.out.println("sifferVerdi: " + sifferVerdi);
		System.out.println(testTall.toString());
	}
}