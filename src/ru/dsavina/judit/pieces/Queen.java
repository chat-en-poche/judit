package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class Queen extends Piece {
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

        if (diffIx != diffJy && (x != i && y != j)) {
            throw new Exception("Wrong move.");
        }



        if (board.getPiece(x, y) != null && this.isWhite == board.getPiece(x, y).isWhite) {
            throw new Exception("Target square is occupied.");
        }

        board.setPiece(board.getPiece(i, j), x, y);
        board.setPiece(null, i, j);

    }
}
