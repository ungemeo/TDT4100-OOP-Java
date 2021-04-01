package patterns.observable.gridgame;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TicTacToe implements GenericGridGame<Character> {

	private StringBuilder sb;
	private char player;
	private TrekkLagrer trekkLagrer;
	private BufferedWriter writer;
	private String fileString;
	private BufferedReader reader;
	private FileReader file;
	private List<GridListener<Character>> listeners = new ArrayList<>();
		
	
	public TicTacToe() {
		this.sb = new StringBuilder("         ");
		this.player = 'x';
		// this.trekkLagrer = new TrekkLagrer();
	}
	
	
	public int map(int x, int y) {
		if (x == 1) {
			if (y == 1) {
				return 1;
			}
			else if (y == 2) {
				return 2;
			}
			else if (y == 3) {
				return 3;
			}
			else {
				return 0;
			}
		}
		else if (x == 2) {
			if (y == 1) {
				return 4;
			}
			else if (y == 2) {
				return 5;
			}
			else if (y == 3) {
				return 6;
			}
			else {
				return 0;
			}
		}
		else if (x == 3) {
			if (y == 1) {
				return 7;
			}
			else if (y == 2) {
				return 8;
			}
			else if (y == 3) {
				return 9;
			}
			else {
				return 0;
			}
		}
		else {
		return 0;
		}
	}
	
	
	public Character getCell (int x, int y) {
		int posisjon = map(x, y);
		return this.sb.toString().charAt(posisjon - 1);
	}
	
	
	public boolean setCell(char c, int x, int y) {
		if (!isOccupied(x, y)) {
			int plass = map(x, y);
			this.sb.setCharAt(plass - 1, c);
			return true;
		}
		else {
			return false;
		}
	}


	public boolean isOccupied(int x, int y) {
		int var1 = map(x, y);
		if (sb.toString().charAt(var1 - 1) == ' ') {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public char getCurrentPlayer() {
		int count = 0;
		for (int i = 0; i < 9; i++ ) {
			if (this.sb.toString().charAt(i) != ' ') {
				count += 1;
			}
		}
		if (count == 0 || count == 2 || count == 4 || count == 6 || count == 8) {
			return 'x';
		}
		else {
			return 'o';
		}
	}
	
	@Override
	public String toString() {
		if (hasWinner()){
			return " " + this.sb.toString().charAt(0) +  " | " + this.sb.toString().charAt(1) + " | " + this.sb.toString().charAt(2) + "\n" + "-----------\n" + " " + this.sb.toString().charAt(3) +  " | " + this.sb.toString().charAt(4) + " | " + this.sb.toString().charAt(5) + "\n" + "-----------\n"+ " " + this.sb.toString().charAt(6) +  " | " + this.sb.toString().charAt(7) + " | " + this.sb.toString().charAt(8) + "\n Spillet er nå over! Taperen er: " + this.player;
		}
		else if (isFinished()) {
			return " " + this.sb.toString().charAt(0) +  " | " + this.sb.toString().charAt(1) + " | " + this.sb.toString().charAt(2) + "\n" + "-----------\n" + " " + this.sb.toString().charAt(3) +  " | " + this.sb.toString().charAt(4) + " | " + this.sb.toString().charAt(5) + "\n" + "-----------\n"+ " " + this.sb.toString().charAt(6) +  " | " + this.sb.toString().charAt(7) + " | " + this.sb.toString().charAt(8) + "\n Spillet er nå over! Det ble uavgjort.";
		}
		else {
			return " " + this.sb.toString().charAt(0) +  " | " + this.sb.toString().charAt(1) + " | " + this.sb.toString().charAt(2) + "\n" + "-----------\n" + " " + this.sb.toString().charAt(3) +  " | " + this.sb.toString().charAt(4) + " | " + this.sb.toString().charAt(5) + "\n" + "-----------\n"+ " " + this.sb.toString().charAt(6) +  " | " + this.sb.toString().charAt(7) + " | " + this.sb.toString().charAt(8);
		}
	}
	
	
	public void play(int x, int y) {
		char spiller = getCurrentPlayer();
		setCell(spiller, x, y);
		if (this.player == 'x') {
			this.player = 'o';
		}
		else if (this.player == 'o') {
			this.player = 'x';
		}
		this.trekkLagrer.Lagre(x, y);
	}
	
	
	boolean isWinner(char c) {
		if (hasWinner()) {
			if (c == this.player) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	
	boolean hasWinner() {
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		
		//rad
		
		for (int i = 1; i < 4; i++) {
				if ( getCell(1, i) == 'x') {
					count += 1;
				}
				else if (getCell(1, i) == 'o') {
					count -= 1;
				}
				if (count == 3 || count == -3) {
					return true;
				}
			}
		for (int i = 1; i < 4; i++) {
			if ( getCell(2, i) == 'x') {
				count1 += 1;
			}
			else if (getCell(2, i) == 'o') {
				count1 -= 1;
			}
			if (count1 == 3 || count1 == -3) {
				return true;
			}
		}
		for (int i = 1; i < 4; i++) {
			if ( getCell(3, i) == 'x') {
				count2 += 1;
			}
			else if (getCell(3, i) == 'o') {
				count2 -= 1;
			}
			if (count2 == 3 || count2 == -3) {
				return true;
			}
		}
		// kolonne
		for (int i = 1; i < 4; i++) {
			if ( getCell(i, 1) == 'x') {
				count3 += 1;
			}
			else if (getCell(i, 1) == 'o') {
				count3 -= 1;
			}
			if (count3 == 3 || count3 == -3) {
				return true;
			}
		}
		for (int i = 1; i < 4; i++) {
			if ( getCell(i, 2) == 'x') {
				count4 += 1;
			}
			else if (getCell(i, 2) == 'o') {
				count4 -= 1;
			}
			if (count4 == 3 || count4 == -3) {
				return true;
			}
		}
		for (int i = 1; i < 4; i++) {
			if ( getCell(i, 3) == 'x') {
				count5 += 1;
			}
			else if (getCell(i, 3) == 'o') {
				count5 -= 1;
			}
			if (count5 == 3 || count5 == -3) {
				return true;
			}
		}
		// diagonal 1
		for (int i = 1; i < 4; i++) {
			if (getCell(i, i) == 'x') {
				count6 += 1;
			}
			else if (getCell(i, i) == 'o') {
				count6 -= 1;
			}
			if (count6 == 3 || count6 == -3) {
				return true;
			}
		}
		// diagonal 2
		if (getCell(3,1) == 'x' && getCell(2,2) == 'x' && getCell(1,3) == 'x') {
			return true;
		}
		else if (getCell(3,1) == 'o' && getCell(2,2) == 'o' && getCell(1,3) == 'o') {
			return true;
		}
		
		return false;
	}
	
	
	boolean isFinished() {
		int count = 0;
		if (hasWinner()) {
			return true;
		}
		for (int i = 0; i < 9; i++) {
			if (this.sb.toString().charAt(i) != ' ') {
				count += 1;
			}
		}
		if (count == 9) {
			return true;
		}
		
		return false;
	}
	
	
	public void getInput(String in) {
		char charX = in.charAt(0);
		char charY = in.charAt(1);
		int xpos = Character.getNumericValue(charX);
		int ypos = Character.getNumericValue(charY);
		play(xpos, ypos);
		
	}
	
	
	public void reverse(int x, int y) {
		if (isOccupied(x, y)) {
			int plass = map(x, y);
			this.sb.setCharAt(plass - 1, ' ');
		}
	}
	
	
	public void undo() {
		String trekkString = this.trekkLagrer.undo();
		int x = Character.getNumericValue(trekkString.charAt(0));
		int y = Character.getNumericValue(trekkString.charAt(1));
		reverse(x, y);
	}
	
	
	public void redo() {
		String trekkString = this.trekkLagrer.redo();
		int x = Character.getNumericValue(trekkString.charAt(0));
		int y = Character.getNumericValue(trekkString.charAt(1));
		play(x, y);
	}
	
	
	public void save(String fileName) {
		fileString = this.sb.toString();
		try {
			writer = new BufferedWriter(new FileWriter(".\\" + fileName + ".txt"));
			writer.write(fileString);
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void load(String fileName) {
		try {
			file = new FileReader(".\\" + fileName + ".txt");
			reader = new BufferedReader(file);
			fileString = reader.readLine();
			for (int i = 0; i < 9; i++) {
				this.sb.insert(i, fileString.charAt(i));
				toString();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public boolean canUndo() {
		if (trekkLagrer.isUndoEmpty()) {
			return false;
		}
		return true;
	}


	public boolean canRedo() {
		if (trekkLagrer.isRedoEmpty()) {
			return false;
			}
		return true;
	}


	public int getColumnCount() {
		return 3;
	}


	public int getRowCount() {
		return 3;
	}
	
	public void gridChanged(GenericGridGame<Character> gridGame, int col, int row, int width, int height) {
		for (GridListener<Character> listener : listeners) {
			listener.gridChanged(gridGame, col, row, width, height);
		}
	}

	@Override
	public String[] getImages(Character t) {
		String imageDesc = (t == ' ' ? "empty" : String.valueOf(t)) + ".png";
		return new String[] { imageDesc };

	}


	@Override
	public void addGridListener(GridListener<Character> listener) {
		if (!listeners.contains(listener))
		listeners.add(listener);
	}


	@Override
	public void removeGridListener(GridListener<Character> listener) {
		if (listeners.contains(listener))
		listeners.remove(listener);
	}
	
}