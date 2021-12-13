package Pieces;

import main.Player;

public abstract class Piece {

	int rank;
	char type;
	boolean isWhite;


	public Piece(int rank, char type, boolean isWhite) {
		this.rank = rank;
		this.type = type;
		this.isWhite = isWhite;
	}

	public int getRank(){
		return rank;
	}

	public char getType(){
		return type;
	}

	public abstract boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos);
}


