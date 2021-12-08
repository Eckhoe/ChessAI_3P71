package Pieces;

import main.Player;

public class Empty extends Piece{

    public Empty(int xPos, int yPos, int rank, char type, boolean isWhite) {
        super(xPos, yPos, rank, type, isWhite);
    }

    public boolean makeMove(Player currPlayer, Piece [][] board, int xPos, int yPos, int newXPos, int newYPos){
        //check colour of the current piece and see if that spot is taken by same colour
        System.out.println("YOU CANNOT MOVE AN EMPTY SPACE");
        return false;
    }
}
