package Pieces;

import main.Player;

public class Knight extends Piece {

	public Knight(int xPos, int yPos, int rank, char type, boolean isWhite) {
		super(xPos, yPos, rank, type, isWhite);
	}

	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){
		//make sure that the user doesnt move the piece to a spot where a piece of the same colour sits and that the user can only move a piece of the same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);


		if(xMove * yMove == 2)
			return true;

		return false;
	}
}
