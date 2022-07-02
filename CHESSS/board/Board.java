package board;

import java.io.FileNotFoundException;
import java.util.*;
import game.Game;
import Pieces.*;

public class Board implements Cloneable{
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;
	
	public int[][] grid;
	public Piece[][] pieces;
	public Piece lastPieceMoved;
	public Move lastMove;
	public Piece died;
	
	public Stack<Move> lastMoves = new Stack<>();
	public Stack<Piece> deadPieces = new  Stack<>();
	public  List<Piece> piecesList = new ArrayList<Piece>();
	
	public Board() {
		grid = new int[ROWS][COLUMNS];
		pieces = new Piece[ROWS][COLUMNS];
	}
	

	public void setPieceIntoBoard(int x,int y,Piece piece){
		if(piece != null) {
			grid[x][y] = piece.getValueInTheboard();
			pieces[x][y] = piece;
			piecesList.add(piece);			
		}else {
			grid[x][y] = 0;
			pieces[x][y] = null;
		}
	}	
	public void updatePieces(int fromX,int fromY,int toX,int toY,Piece piece) {
		lastMove = new Move(fromX, fromY, toX, toY, piece);
		lastMoves.add(lastMove);
		if(pieces[toX][toY] != null) {
			died = pieces[toX][toY];
			deadPieces.add(died);
			
			piecesList.remove(died);
			Game.AllPieces.remove(died);
			Game.fillPieces();
		}else {
			deadPieces.add(null);
		}
		grid[fromX][fromY] = 0;
		grid[toX][toY] =  piece.getValueInTheboard();
		pieces[fromX][fromY] = null;
		pieces[toX][toY] = piece;
	}
	
	
	
	public Piece getPiece(int x,int y) {
		return pieces[x][y];
	}


	public int[][] getGrid() {
		return grid;
	}
	

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	public int getXY(int x,int y) {
		return grid[x][y];
	}
	
	public void setXY(int x,int y,int v) {
		 grid[x][y] = v ;
	}
	
	public Board getNewBoard() {
		Board b = new Board();
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(this.getPiece(i, j) != null) {
					b.setPieceIntoBoard(i, j, this.getPiece(i, j).getClone());
				}
			}
		}
		return b;
	}
	
	public void printBoard() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(grid[j][i] +  "  ");
			}
			System.out.println();
		}
	}
	
	
	
}
