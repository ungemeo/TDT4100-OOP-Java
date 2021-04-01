package objectstructures;

//variabeldeklarasjon og klasse
public class Card {
	
	private int face;
	private char suit;
	
//konstruktør
	public Card(char suit, int face) {
		if (!(suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C')) {
			throw new IllegalArgumentException("Suit must be either S, H, D or C.");
		}
		else if (face > 13 || face < 1) {
			throw new IllegalArgumentException("Face must be between 1 and 13.");
		}
			this.suit=suit;
			this.face=face;
	}
	
	//getter
	public char getSuit() {
		return suit;
	}
	
	//getter
	public int getFace() {
		return face;
	}
	
	//toString
	@Override
	public String toString() {
		return "" + suit + face;
	}
	
	//main
	public static void main(String[] args) {
		Card card = new Card('S',3);
		System.out.println(card.toString());
	}
	
}//class

	

