package Pieces;

import main.Player;

public class Rook extends Piece{

	public Rook(int xPos, int yPos, int rank, char type, boolean isWhite) {
		super(xPos, yPos, rank, type, isWhite);
	}

	//take the current board state along with x/y coordinates of the selected piece and x/y coordinates of where you want to move
	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){

		//make sure that the user doesnt move the piece to a spot where a piece of the same colour sits and that the user can only move a piece of the same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);

		//if rook is moving  on the x-axis
		if(xMove > 0 && xMove < board.length && yMove == 0)
			return true;

		//if rook is moving on the y-axis
		if(yMove > 0 && yMove < board.length && xMove == 0)
			return true;

		return false;
	}
}
