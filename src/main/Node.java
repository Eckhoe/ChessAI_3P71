package main;

import Pieces.Empty;
import Pieces.Piece;

import java.util.ArrayList;

public class Node {

    Player currPlayer;
    Piece[][] board; //current board state

    int boardScore; //score of the current board
    ArrayList<Node> children;
    boolean isExpanded;

    Node(Piece [][] board, Player currPlayer){
        this.board = board;
        this.currPlayer = currPlayer;
        boardScore = evaluateBoard();
        children = new ArrayList<>();
    }

    private void findMoves(){
        Piece currPiece;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                currPiece = board[i][j];
             generateMoves(currPiece,j,i);
            }
        }
    }

    private void generateMoves(Piece currPiece, int x, int y){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++) {
                if(currPiece.makeMove(currPlayer,board,x,y,j,i)){
                    children.add(new Node(editBoard(currPiece,x,y,j,i), currPlayer));
                }
            }
            }
    }

    private Piece[][] editBoard(Piece currPiece, int xPos, int yPos, int newXPos, int newYPos){
        Piece [][] newBoard = copyBoard();
        newBoard[yPos][xPos] = new Empty(0, '-', false);//replaces the spot where the piece left
        newBoard[newYPos][newXPos] = currPiece;//replaces whatever was at the position with the new piece
        return newBoard;
    }

    public ArrayList<Node> getChildren(){
        if(isExpanded)
            return children;
        else
            expandNode();
        return children;
    }

    public void expandNode(){
        if(!isExpanded){
            findMoves();
            isExpanded = true;
        }
    }

    //evaluate the current board
    private int evaluateBoard() {
        int score = 0;
        int empty = 0;
        Piece currPiece;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                currPiece = board[i][j];
                if (currPiece.getType() == '-')
                    empty += currPiece.getRank();
                else if (currPiece.isWhite() == currPlayer.getIsWhite() && currPiece.getType() != '-')
                    score += currPiece.getRank();
            }
        }
        int overall = score - empty;
        return overall;
    }

    public Piece[][] getBoard(){
        return board;
    }

    public int getBoardScore(){
        return boardScore;
    }

    private Piece[][] copyBoard(){
        Piece [][] newBoard = new Piece[8][8];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }
}
