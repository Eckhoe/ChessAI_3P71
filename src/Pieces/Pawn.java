package Pieces;

import main.Player;

public class Pawn extends Piece{

	boolean firstMove = false;

	public Pawn(int xPos, int yPos, int rank, char type, boolean isWhite) {
		super(xPos, yPos, rank, type, isWhite);
	}

	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){
		//make sure that the user doesnt move the piece to a spot where a piece of the same colour sits and that the user can only move a piece of the same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);

		//allows the pawn to move 2 tiles on the board on its first move
		if(xMove == 0 && yMove == 2 && !firstMove) {
			firstMove = true;
			return true;
		}

		//allows the pawn to move 1 tile on the board
		if(xMove == 0 && yMove == 1) {
			firstMove = true;
			return true;
		}

		//allows the pawn to move diagonally to capture a piece only if it is not the same color
		if(xMove == 1 && yMove == 1 && board[newYPos][newXPos].isWhite != this.isWhite){
			firstMove = true;
			return true;
		}
		return false;
	}
}
