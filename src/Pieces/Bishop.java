package Pieces;

import main.Player;

public class Bishop extends Piece{

	public Bishop(int rank, char type, boolean isWhite) {
		super(rank, type, isWhite);
	}

	public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){
		//check colour of the current piece and see if that spot is taken by same colour
		if(board[newYPos][newXPos].isWhite == this.isWhite && board[newYPos][newXPos].type != '-' || currPlayer.getIsWhite() != this.isWhite)
			return false;

		int xMove = Math.abs(xPos - newXPos);
		int yMove = Math.abs(yPos - newYPos);

		//only move a piece on the board if the abs is 0
		if(Math.abs(xMove - yMove) == 0 && checkDiagonal(xPos, yPos, newXPos, newYPos, board))
			return true;

		return false;
	}

	private boolean checkDiagonal(int xPos, int yPos, int newXPos, int newYPos, Piece[][] board){
		int xDist = xPos - newXPos;
		int yDist = yPos - newYPos;

		//down to the right
		if(xDist < 0 && yDist < 0){
			for(int i = 1; i < Math.abs(xDist); i++){
				if(board[yPos + i][xPos + i].type != '-'){
					return false;
				}
			}
			return true;
		}

		//up to right
		else if(xDist < 0 && yDist > 0){
			for(int i = 1; i < Math.abs(xDist); i++){
				if(board[yPos - i][xPos + i].type != '-'){
					return false;
				}
			}
			return true;
		}

		//down to left
		else if(xDist > 0 && yDist < 0){
			for(int i = 0; i < Math.abs(xDist); i++){
				if(board[yPos + i][xPos - i].type != '-'){
					return false;
				}
			}
			return true;
		}
//		//up to left
		else if(xDist > 0 && yDist > 0){
			for(int i = 0; i < Math.abs(xDist); i++){
				if(board[yPos - i][xPos - i].type != '-'){
					return false;
				}
			}
		}
		return false;
	}
}

//if(board[yPos + i][xPos + i].type != '-'){
//		return false;
//		}
