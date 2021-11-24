package Pieces;

public class King extends Piece{

	private boolean castling = false;

	public King(int xPos, int yPos, int rank, char type) {
		super(xPos, yPos, rank, type);
	}
}
