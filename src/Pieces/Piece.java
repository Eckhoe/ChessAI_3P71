package Pieces;

public abstract class Piece {
	int xPos;
	int yPos;
	int rank;
	char type;

	public Piece(int xPos, int yPos, int rank, char type) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rank = rank;
		this.type = type;
	}

	public int[] getCoords() {
		int[] coord = { xPos, yPos };
		return coord;
	}

	public void setCoords(int x, int y){
		xPos = x;
		yPos = y;
	}

	public int getRank(){
		return rank;
	}

	public char getType(){
		return type;
	}
}
