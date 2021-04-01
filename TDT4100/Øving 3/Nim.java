package encapsulation;

public class Nim {

	  private int[] piles = new int[3];

	  public Nim(int pileSize) {
	    piles[0] = pileSize;
	    piles[1] = pileSize;
	    piles[2] = pileSize;
	  }

	  public Nim() {
	    piles[0] = 10;
	    piles[1] = 10;
	    piles[2] = 10;
	  }

	  public void removePieces(int number, int targetPile) {
		    if (number <= 0) {
		      throw new IllegalArgumentException("The number of pieces to remove can not be zero or under.");
		    }
		    if (targetPile < 0 || targetPile > 2) {
		      throw new IllegalArgumentException("The pile number does not exist.");
		    }
		    if (isGameOver()) {
		      throw new IllegalStateException("The game is over.");
		    }
		    if (number > piles[targetPile]) {
		      throw new IllegalArgumentException("Can't remove more pieces than available");
		    }
		    piles[targetPile] -= number;
		  }

	  public boolean isValidMove(int number, int targetPile) {
			    if (number <= 0) {
			      return false;
			    }
			    if (targetPile < 0 || targetPile > 2) {
			      return false;
			    }
			    if (isGameOver()) {
			      return false;
			    }
			    if (number > piles[targetPile]) {
			      return false;
			    }
			    return true;
			  }

	  public boolean isGameOver() {
	    if (piles[0] == 0) {
	      return true;
	    }
	    else if (piles[1] == 0) {
	      return true;
	    }
	    else if (piles[2] == 0) {
	      return true;
	    }
	    else {
	      return false;
	    }
	  }

	  public int getPile(int targetPile) {
	    return piles[targetPile];
	  }

	}