package main;

import Pieces.*;

import java.util.ArrayList;
import java.util.Scanner;

/*
Creators: David Bailey & Fahad Arain
IDs: 6675482 & 6770127
Date: Dec 1/21
 */

public class Chess {
    Scanner sc = new Scanner(System.in);
    Player playerOne = new Player(1, true);
    Player playerTwo = new Player(2, false);
    int[] playerOneKingCoordinate = new int[2];
    int[] playerTwoKingCoordinate = new int[2];
    int gameType = 0;
    int xPosInput = Integer.MAX_VALUE;//xPos in which the piece is on board
    int yPosInput = Integer.MAX_VALUE;//yPos i which the piece is on board
    int xPosMove = Integer.MAX_VALUE;//xPos where you want to move piece
    int yPosMove = Integer.MAX_VALUE;//yPos where you want to move piece
    Piece[][] board = new Piece[8][8];//board declaration
    boolean gameWon = false;

    private Chess() {
        do {
            System.out.println("PvP [1] or PvAI [2]: ");
            gameType = sc.nextInt();
            if (gameType != 1 && gameType != 2)
                System.out.println(gameType + " IS NOT VALID INPUT");
        } while (gameType != 1 && gameType != 2);
        build2();

        switch (gameType) {
            case 1:// PvP
                System.out.println("YOU CHOSE PvP!");
                int gameCheck;
                printBoard();
                while (true) {
                    movePiece(playerOne);
                    printBoard();
                    checkGame(playerTwo, playerOne,playerTwoKingCoordinate);
                    movePiece(playerTwo);
                    printBoard();
                    checkGame(playerOne, playerTwo, playerOneKingCoordinate);
                    //checks game

                }

            case 2:// PvAI
                System.out.println("YOU CHOSE PvAI!");
                break;
        }
    }

    private void checkGame(Player currPlayer, Player opponent, int[] currKingCoordinates) {
        int checkCounter = 0;
        Piece currPiece;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                currPiece = board[i][j];
                //System.out.println(currPiece.makeMove(currPlayer, board, j, i, currKingCoordinates[0], currKingCoordinates[1]));
                 if(currPiece.getType() != '-' & currPiece.makeMove(opponent,board,j,i,currKingCoordinates[0], currKingCoordinates[1])){
                    checkCounter++;
                     System.out.println("INSIDE");
                 }
            }

        }
        if (checkCounter > 0)
            System.out.println("Player " + currPlayer.playerNumber + " is currently checked by " + checkCounter + " pieces. Move your king to avoid losing the game");
    }


    //checks  to see if we promote a pawn
    private Piece checkForPromotion(Piece currPiece, Player currPlayer) {
        if (currPlayer.playerNumber == 1 && yPosMove == 0 && currPiece.getType() == 'p') {
            System.out.println("What would you like to promote too:");
            System.out.println("[1] Queen, [2] Rook, [3] Knight, [4] Bishop");
            int promotion = sc.nextInt();
            if (promotion == 1)
                return new Queen(25, 'q', true);
            else if (promotion == 2)
                return new Rook(10, 'r', true);
            else if (promotion == 3)
                return new Knight(8, 'h', true);
            else if (promotion == 4)
                return new Bishop(6, 'b', true);
        } else if (currPlayer.playerNumber == 2 && yPosMove == 7 && currPiece.getType() == 'P') {
            System.out.println("What would you like to promote too:");
            System.out.println("[1] Queen, [2] Rook, [3] Knight, [4] Bishop");
            int promotion = sc.nextInt();
            if (promotion == 1)
                return new Queen(25, 'Q', false);
            else if (promotion == 2)
                return new Rook(10, 'R', false);
            else if (promotion == 3)
                return new Knight(8, 'H', false);
            else if (promotion == 4)
                return new Bishop(6, 'B', false);
        }
        return currPiece;
    }

    private void movePiece(Player currPlayer) {
        //take valid inputs in order to move the piece
        Piece currPiece;
        while (true) {
            getPiece();
            currPiece = board[yPosInput][xPosInput];
            getMove();
            if (currPiece.makeMove(currPlayer, board, xPosInput, yPosInput, xPosMove, yPosMove)) {
                editBoard(currPiece, currPlayer);
                break;
            } else
                System.out.println("MOVE CANNOT BE MADE, RE-INPUT WHICH PIECE YOU WANT TO MOVE AND THE PLACE YOU WANT TO MOVE");

        }
    }

    private void getPiece() {
        do {
            System.out.println("To move a piece an x coordinate and y coordinate are required to get the correct piece");
            System.out.println("Please enter the x coordinate for the piece you want to move: ");
            xPosInput = sc.nextInt();
            System.out.println("Please enter the y coordinate for the piece you want to move: ");
            yPosInput = sc.nextInt();
        }
        while (xPosInput < 0 || xPosInput > board.length || yPosInput < 0 || yPosInput > board.length);
    }

    private void getMove() {
        do {
            System.out.println("To move the selected piece an x coordinate and y coordinate are required to get the correct location to move to");
            System.out.println("Please enter the x coordinate for where you want the piece you want to move: ");
            xPosMove = sc.nextInt();
            System.out.println("Please enter the y coordinate for where you want the piece you want to move: ");
            yPosMove = sc.nextInt();
        }
        while (xPosMove < 0 || xPosMove > board.length || yPosMove < 0 || yPosMove > board.length);
    }

    private void editBoard(Piece currPiece, Player currPlayer) {
        if (currPiece.getClass() == King.class)
            if (currPlayer.playerNumber == 1) {
                playerOneKingCoordinate[0] = xPosMove;
                playerOneKingCoordinate[1] = yPosMove;
            } else if (currPlayer.playerNumber == 2) {
                playerTwoKingCoordinate[0] = xPosMove;
                playerTwoKingCoordinate[1] = yPosMove;
            }
        board[yPosInput][xPosInput] = new Empty(0, '-', false);//replaces the spot where the piece left
        board[yPosMove][xPosMove] = currPiece;//replaces whatever was at the position with the new piece
        board[yPosMove][xPosMove] = checkForPromotion(currPiece, currPlayer);
    }

    private void buildBoard() {
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Empty(0, '-', false);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            board[1][i] = new Pawn(1, 'P', false);//creates black pawns
            board[6][i] = new Pawn(1, 'p', true);//creates white pawns
        }

        board[0][0] = new Rook(10, 'R', false);
        board[0][1] = new Knight(8, 'H', false);
        board[0][2] = new Bishop(6, 'B', false);
        board[0][3] = new Queen(25, 'Q', false);
        board[0][4] = new King(Integer.MAX_VALUE, 'K', false);
        board[0][5] = new Bishop(6, 'B', false);
        board[0][6] = new Knight(8, 'H', false);
        board[0][7] = new Rook(10, 'R', false);

        board[7][0] = new Rook(10, 'r', true);
        board[7][1] = new Knight(8, 'h', true);
        board[7][2] = new Bishop(6, 'b', true);
        board[7][3] = new Queen(25, 'q', true);
        board[7][4] = new King(Integer.MAX_VALUE, 'k', true);
        board[7][5] = new Bishop(6, 'b', true);
        board[7][6] = new Knight(8, 'h', true);
        board[7][7] = new Rook(10, 'r', true);

        playerOneKingCoordinate[0] = 4;
        playerOneKingCoordinate[1] = 7;

        playerTwoKingCoordinate[0] = 4;
        playerTwoKingCoordinate[1] = 0;
    }

    private void printBoard() {
        System.out.println("y/x 0   1   2   3   4   5   6   7");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getType() + " | ");
            }
            System.out.println();
        }
    }

    private void build2() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Empty(0, '-', false);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            board[1][i] = new Pawn(1, 'P', false);//creates black pawns
            board[6][i] = new Pawn(1, 'p', true);//creates white pawns
        }

        board[6][0] = new Empty(0, '-', false);

        board[0][4] = new King(Integer.MAX_VALUE, 'K', false);

        board[7][0] = new Rook(10, 'r', true);
        board[7][1] = new Knight(8, 'h', true);
        board[7][2] = new Bishop(6, 'b', true);
        board[7][3] = new Queen(25, 'q', true);
        board[7][4] = new King(Integer.MAX_VALUE, 'k', true);
        board[7][5] = new Bishop(6, 'b', true);
        board[7][6] = new Knight(8, 'h', true);
        board[7][7] = new Rook(10, 'r', true);

        playerOneKingCoordinate[0] = 4;
        playerOneKingCoordinate[1] = 7;

        playerTwoKingCoordinate[0] = 4;
        playerTwoKingCoordinate[1] = 0;

    }

    public static void main(String[] args) {
        new Chess();
    }
}
