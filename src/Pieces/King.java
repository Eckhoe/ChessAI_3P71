package Pieces;

import main.Player;

public class King extends Piece{

	public King(int rank, char type, boolean isWhite) {
		super(rank, type, isWhite);
	}

	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){
		//check colour of the current piece and see if that spot is taken by same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);

		//this allows the king to move in one direction each way
		if(xMove + yMove == 1)
			return true;
		return false;
	}
}