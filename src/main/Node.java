package main;

import Pieces.Piece;

import java.util.ArrayList;

public class Node {

    Piece [][] board;
    int boardScore;
    ArrayList<Piece[][]> children;

    Node(Piece [][] board){
     this.board = board;
     //generate the current score of the board using minimax
        //generate the children based on the current board state
        //return the best move based on the score
    }
}
