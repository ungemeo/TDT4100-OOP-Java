package stateandbehavior;

public class Location {

	int x;
	int y;
	
	public Location() {
		x=0; //antar at vi starter i 0,0.
		y=0;
	}
	
	public static void main(String[] args) {
		Location flyttapaadeg = new Location();
	}
	
	public void up() {
		y--;	
	}
	
	public void down() {
		y++;
	}
	
	public void right() {
		x++;
	}
	
	public void left() {
		x--;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Location: x=" + x + ", y=" + y ;
	}
	
	
}
