package Pieces;

import main.Player;

public class Bishop extends Piece{

	public Bishop(int xPos, int yPos, int rank, char type, boolean isWhite) {
		super(xPos, yPos, rank, type, isWhite);
	}

	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){
		//check colour of the current piece and see if that spot is taken by same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);

		//only move a piece on the board if the abs is 0
		if(Math.abs(xMove - yMove) == 0)
			return true;

		return false;
	}
}
