package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class Knight extends Piece {

    public void move(Board board, int i, int j, int x, int y) throws Exception {

        if (!(((x == i + 1 || x == i - 1) && (y == j + 2 || y == j - 2))
                || ((x == i + 2 || x == i - 2) && (y == j + 1 || y == j - 1)))) {
            throw new Exception("dhfsj");
        }

        /*if (x == i + 1 || x == i - 1) {
            if (y != j + 2 || y != j - 2) {
                throw new Exception("Wrong move.");
            }
        } else if (x == i + 2 || x == i - 2) {
            if (y != j + 1 || y != j - 1) {
                throw new Exception("Wrong move.");
            }
        } else {
            throw new Exception("Wrong move.");
        }*/

        if (board.getPiece(x, y) != null && this.isWhite == board.getPiece(x, y).isWhite) {
            throw new Exception("Target square is occupied.");
        }

        board.setPiece(board.getPiece(i, j), x, y);
        board.setPiece(null, i, j);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean canAttack(Board board, int i, int j, int x, int y) {

        if (((x == i + 1 || x == i - 1) && (y == j + 2 || y == j - 2))
                || ((x == i + 2 || x == i - 2) && (y == j + 1 || y == j - 1))) {

            return true;
        }

        return false;
    }
}
