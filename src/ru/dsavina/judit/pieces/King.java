package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class King extends Piece {
    @Override
    public void move(Board board, int i, int j, int x, int y) throws Exception {

        boolean lilWhiteCastling = this.isWhite && i == 7 && j == 4 && x == 7 && y == 6 && board.getPiece(7, 5) == null
                && board.getPiece(7, 6) == null && board.getPiece(7, 7) != null
                && board.getPiece(7, 7).getClass().equals(Castle.class);

        boolean bigWhiteCastling = this.isWhite && i == 7 && j == 4 && x == 7 && y == 2 && board.getPiece(7, 1) == null
                && board.getPiece(7, 2) == null && board.getPiece(7, 3) == null
                && board.getPiece(7, 0) != null && board.getPiece(7, 0).getClass().equals(Castle.class);

        boolean lilBlackCastling = !this.isWhite && i == 0 && j == 4 && x == 0 && y == 6 && board.getPiece(0, 5) == null
                && board.getPiece(0, 6) == null && board.getPiece(0, 7) != null
                && board.getPiece(0, 7).getClass().equals(Castle.class);

        boolean bigBlackCastling = !this.isWhite && i == 0 && j == 4 && x == 0 && y == 2 && board.getPiece(0, 1) == null
                && board.getPiece(0, 2) == null && board.getPiece(0, 3) == null
                && board.getPiece(0, 0) != null && board.getPiece(0, 0).getClass().equals(Castle.class);

        if (x != i + 1 && x != i - 1 && y != j + 1 && y != j - 1 && !lilWhiteCastling && !bigWhiteCastling
                && !lilBlackCastling && !bigBlackCastling) {
            throw new Exception("Wrong move.");
        }

        board.setPiece(board.getPiece(i, j), x, y);
        board.setPiece(null, i, j);

        if (lilWhiteCastling) {
            board.setPiece(board.getPiece(7, 7), 7, 5);
            board.setPiece(null, 7, 7);
        }

        if (bigWhiteCastling) {
            board.setPiece(board.getPiece(7, 1), 7, 3);
            board.setPiece(null, 7, 1);
        }

        if (lilBlackCastling) {
            board.setPiece(board.getPiece(0, 7), 0, 5);
            board.setPiece(null, 0, 7);
        }

        if (bigBlackCastling) {
            board.setPiece(board.getPiece(0, 1), 0, 3);
            board.setPiece(null, 0, 1);
        }
    }
}
