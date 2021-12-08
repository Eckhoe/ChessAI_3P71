package main;

public class Player {

    int playerNumber;
    boolean isWhite;

    Player(int playerNumber, boolean isWhite){
        this.playerNumber = playerNumber;
        this.isWhite = isWhite;
    }

    public boolean getIsWhite(){
        return isWhite;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

}
