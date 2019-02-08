package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class Bishop extends Piece {
    @Override
    public void move(Board board, int i, int j, int x, int y) throws Exception {

        int diffIx;
        int diffJy;

        if (i > x) {
            diffIx = i - x;
        } else {
            diffIx = x - i;
        }

        if (j > y) {
            diffJy = j - y;
        } else {
            diffJy = y - j;
        }

        if (diffIx != diffJy) {
            throw new Exception("A bishop moves diagonally.");
        }

        if (i > x) {
            if (j > y) {
                for (int d = i - 1, k = j - 1; d > x + 1 && k > y + 1; d--, k--) {
                    if (board.getPiece(d, k) != null) {
                        throw new Exception("A bishop cannot jump over another piece.");
                    }
                }
            } else {
                for (int d = i - 1, k = j + 1; d > x + 1 && k < y - 1; d--, k++) {
                    if (board.getPiece(d, k) != null) {
                        throw new Exception("A bishop cannot jump over another piece.");
                    }
                }
            }
        } else {
            if (j > y) {
                for (int d = i + 1, k = j - 1; d < x - 1 && k > y + 1; d++, k--) {
                    if (board.getPiece(d, k) != null) {
                        throw new Exception("A bishop cannot jump over another piece.");
                    }
                }
            } else {
                for (int d = i + 1, k = j + 1; d < x - 1 && k < y - 1; d++, k++) {
                    if (board.getPiece(d, k) != null) {
                        throw new Exception("A bishop cannot jump over another piece.");
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
}
