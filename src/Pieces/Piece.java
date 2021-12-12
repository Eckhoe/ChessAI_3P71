package Pieces;

import main.Player;

public abstract class Piece {

	int xPos;
	int yPos;
	int rank;
	char type;
	boolean isWhite;


	public Piece(int xPos, int yPos, int rank, char type, boolean isWhite) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rank = rank;
		this.type = type;
		this.isWhite = isWhite;
	}

	public int[] getCoords() {
		return new int[]{ xPos, yPos };
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

	public abstract boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos);
}


