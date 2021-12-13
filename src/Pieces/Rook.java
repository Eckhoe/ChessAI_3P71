package Pieces;

import main.Player;

public class Rook extends Piece{

	public Rook(int rank, char type, boolean isWhite) {
		super(rank, type, isWhite);
	}

	//take the current board state along with x/y coordinates of the selected piece and x/y coordinates of where you want to move
	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){

		//make sure that the user doesnt move the piece to a spot where a piece of the same colour sits and that the user can only move a piece of the same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);

		//horizontal movements
		if(xMove > 0 && xMove < board.length && yMove == 0 && checkHorizontal(xPos,yPos,newXPos,newYPos,board))
			return true;

		//vertical movements
		if(yMove > 0 && yMove < board.length && xMove == 0 && checkVertical(xPos,yPos,newXPos,newYPos,board))
			return true;

		return false;
	}

	private boolean checkVertical(int xPos, int yPos, int newXPos, int newYPos, Piece [][] board){
		int xDist = xPos - newXPos;
		int yDist = yPos - newYPos;

		//towards the bottom of the array
		if(yDist < 0) {
			for (int i = yPos + 1; i < newYPos; i++) {
				if (board[i][xPos].type != '-' ) {
					return false;
				}
			}
			return true;
		}

		//towards the top of the array
		else if(yDist > 0) {
			for (int i = yPos - 1; i > newYPos; i--) {
				if (board[i][xPos].type != '-') {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean checkHorizontal(int xPos, int yPos, int newXPos, int newYPos, Piece [][] board){
		int xDist = xPos - newXPos;
		int yDist = yPos - newYPos;

		//towards the right of the array
		if(xDist < 0){
			for(int i = xPos + 1; i < newXPos; i++){
				if (board[i][xPos].type != '-') {
					return false;
				}
			}
			return true;
		}
		//towards the left of the array
		else if(xDist > 0){
			for(int i = xPos - 1; i > newXPos; i--){
				if (board[i][xPos].type != '-') {
					return false;
				}
			}
			return true;
		}
		return false;
	}


}
