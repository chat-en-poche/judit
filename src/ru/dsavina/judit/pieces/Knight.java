package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class Knight extends Piece {

    public void move(Board board, int i, int j, int x, int y) throws Exception {

        if (((x == i + 1 || x == i - 1) && (y == j + 2 || y == j - 2))
                || ((x == i + 2 || x == i - 2) && (y == j + 1 || y == j - 1))) {
            throw new Exception("Wrong move.");
        }

        if (board.getPiece(x, y) != null && this.isWhite == board.getPiece(x, y).isWhite) {
            throw new Exception("Target square is occupied.");
        }

        board.setPiece(board.getPiece(i, j), x, y);
        board.setPiece(null, i, j);
    }

}


