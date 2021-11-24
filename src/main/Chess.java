package main;

import Pieces.*;

public class Chess {
    Piece[][] board = new Piece[8][8];

    private Chess() {
        buildBoard();
    }

    private void buildBoard() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Empty(j, i, 0, '-');
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            board[1][i] = new Pawn(i, 1, 1, 'P');//creates black pawns
            board[6][i] = new Pawn(i, 6, 1, 'p');//creates white pawns
        }

        board[0][0] = new Rook(0, 0, 10, 'R');
        board[0][1] = new Knight(1, 0, 8, 'H');
        board[0][2] = new Bishop(2, 0, 6, 'B');
        board[0][3] = new Queen(3, 0, 25, 'Q');
        board[0][4] = new King(4, 0, Integer.MAX_VALUE, 'K');
        board[0][5] = new Bishop(5, 0, 6, 'B');
        board[0][6] = new Knight(6, 0, 8, 'H');
        board[0][7] = new Rook(7, 0, 10, 'R');

        board[7][0] = new Rook(0, 7, 10, 'r');
        board[7][1] = new Knight(1, 7, 8, 'h');
        board[7][2] = new Bishop(2, 7, 6, 'b');
        board[7][3] = new Queen(3, 7, 25, 'q');
        board[7][4] = new King(4, 7, Integer.MAX_VALUE, 'k');
        board[7][5] = new Bishop(5, 7, 6, 'b');
        board[7][6] = new Knight(6, 7, 8, 'h');
        board[7][7] = new Rook(7, 7, 10, 'r');
    }


    public static void main(String[] args) {
        new Chess();
    }
}
