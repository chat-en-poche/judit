package ru.dsavina.judit;

public class Board {

    private Piece[][] board = new Piece[8][8];

    public Board() {
    }

    public Piece getPiece(int i, int j) {

        return board[i][j];
    }

    public void setPiece(Piece piece, int i, int j) {

        board[i][j] = piece;
    }

    public void move(int i, int j, int x, int y) throws Exception {
        if (board[i][j] == null) {
            throw new Exception("No piece on the square.");
        }

        if (i < 0 || i > 7 || j < 0 || j > 7) {
            throw new Exception("Where the hell are you going!");
        }

        if (i == x && j == y) {
            throw new Exception("");
        }

        board[i][j].move(this, i, j, x, y);

    }


}