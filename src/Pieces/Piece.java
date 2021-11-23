package Pieces;

public abstract class Piece {
	int xPos;
	int yPos;
	int rank;
	boolean isWhite;

	public Piece(int xPos, int yPos, int rank, boolean isWhite) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rank = rank;
		this.isWhite = isWhite;
	}

	public int[] getCoords() {
		int[] coord = { xPos, yPos };
		return coord;
	}

	public void setCoords(int x, int y){
		xPos = x;
		yPos = y;
	}

	public boolean checkIfWhite(){
		return isWhite;
	}

	public int getRank(){
		return rank;
	}
}
