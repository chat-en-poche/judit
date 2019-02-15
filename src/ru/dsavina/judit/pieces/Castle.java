package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class Castle extends Piece {
    @Override
    public void move(Board board, int i, int j, int x, int y) throws Exception {

        if (x != i || y != j) {
            throw new Exception("A castle moves horizontally or vertically.");
        }

        if (j == y) {
            if (i < x) {
                for (int d = i + 1; d < x - 1; d++) {
                    if (board.getPiece(d, j) != null) {
                        throw new Exception("A castle cannot jump over another piece.");
                    }
                }
            } else {
                for (int d = i - 1; d > x + 1; d--) {
                    if (board.getPiece(d, j) != null) {
                        throw new Exception("A castle cannot jump over another piece.");
                    }
                }
            }
        } else {
            if (j < y) {
                for (int d = j + 1; d < y - 1; d++) {
                    if (board.getPiece(i, d) != null) {
                        throw new Exception("A castle cannot jump over another piece.");
                    }
                }
            } else {
                for (int d = j - 1; d > y + 1; d--) {
                    if (board.getPiece(i, d) != null) {
                        throw new Exception("A castle cannot jump over another piece.");
                    }
                }
            }
        }

        if (board.getPiece(x, y) != null && this.isWhite == board.getPiece(x, y).isWhite) {
            throw new Exception("Target square is occupied.");
        }

        board.setPiece(board.getPiece(i, j), x, y);
        board.setPiece(null, i, j);

    }

    @Override
    public String toString() {
        return "C";
    }
}