package main;

import Pieces.Empty;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;

import java.util.ArrayList;

public class AlphaBeta {

    Piece[][] board;
    int boardScore;
    ArrayList<Piece[][]> children;

    AlphaBeta(Piece[][] board) {
        this.board = board;
        //generate the current score of the board using minimax
        //generate the children based on the current board state
        //return the best move based on the score
    }

    //this is going to loop through the entire array looking for pieces that can be moved by the player, if a move can be made it will enter the check for move method
    public void findPieces(Player currPlayer, Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].isWhite() == currPlayer.getIsWhite() && board[i][j].getType() != '-')
                    checkForMoves(currPlayer, board, i, j);
            }
        }
    }

    //check for moves will generate all the possible moves for the current piece that is being looked at from the findPieces method by passing in x and y coordinates in as parameters and will create new board states
    private void checkForMoves(Player currPlayer, Piece[][] board, int xPos, int yPos) {
        Piece currPiece = board[yPos][xPos];
        Piece[][] currBoard = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (currPiece.makeMove(currPlayer, board, xPos, yPos, j, i))
                    children.add(editBoard(currBoard, currPiece, currPlayer, xPos, yPos, j, i));
            }
        }
    }

    private Piece[][] editBoard(Piece[][] currBoard, Piece currPiece, Player currPlayer, int xPos, int yPos, int newXPos, int newYPos) {
        currBoard[yPos][xPos] = new Empty(0, '-', false);//replaces the spot where the piece left
        currBoard[newYPos][newXPos] = currPiece;//replaces whatever was at the position with the new piece
        currBoard[newYPos][newXPos] = checkForPromotion(currPiece, currPlayer, newYPos);
        return currBoard;
    }

    private Piece checkForPromotion(Piece currPiece, Player currPlayer, int newYPos) {
        if (currPiece.getClass() == Pawn.class)
            if (currPlayer.playerNumber == 1 && newYPos == 0)
                return new Queen(25, 'q', true);
            else if (currPlayer.playerNumber == 2 && newYPos == 7)
                return new Queen(25, 'Q', false);
        return currPiece;
    }


}
