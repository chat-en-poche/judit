package ru.dsavina.judit.pieces;

import ru.dsavina.judit.Board;
import ru.dsavina.judit.Piece;

public class Pawn extends Piece {

    @Override
    public void move(Board board, int i, int j, int x, int y) throws Exception {

        // TODO Handle en passant.

        if (this.isWhite) {
            if (j == y) {
                if (i == 6) {
                    if (x < 4) {
                        throw new Exception("Wrong move.");
                    }
                    if (x == 4 && board.getPiece(5, j) != null) {
                        throw new Exception("A pawn cannot jump over another piece.");
                    }
                    if (x == 4 && board.getPiece(4, j) != null) {
                        throw new Exception("Target square is occupied.");
                    }
                    if (x == 5 && board.getPiece(5, j) != null) {
                        throw new Exception("Target square is occupied.");
                    }

                } else if (x < i - 1) {
                    throw new Exception("Wrong move.");
                } else if (x > i) {
                    throw new Exception("A pawn cannot move backward.");
                }

            } else if (y == j + 1 || y == j - 1) {
                if (x != i - 1) {
                    throw new Exception("A pawn captures one square diagonally.");
                }

                if (board.getPiece(x, y) == null) {
                    throw new Exception("A pawn moves forward.");
                }

                if (board.getPiece(x, y).isWhite) {
                    throw new Exception("Target square is occupied.");
                }

            } else {
                throw new Exception("Wrong move.");
            }
        } else {
            if (j == y) {
                if (i == 1) {
                    if (x > 3) {
                        throw new Exception("Wrong move.");
                    }
                    if (x == 3 && board.getPiece(2, j) != null) {
                        throw new Exception("A pawn cannot jump over another piece.");
                    }
                    if (x == 3 && board.getPiece(3, j) != null) {
                        throw new Exception("Target square is occupied.");
                    }
                    if (x == 2 && board.getPiece(2, j) != null) {
                        throw new Exception("Target square is occupied.");
                    }

                } else if (x > i + 1) {
                    throw new Exception("Wrong move.");
                } else if (x < i) {
                    throw new Exception("A pawn cannot move backward.");
                }

            } else if (y == j + 1 || y == j - 1) {
                if (x != i + 1) {
                    throw new Exception("A pawn captures one square diagonally.");
                }

                if (board.getPiece(x, y) == null) {
                    throw new Exception("A pawn moves forward.");
                }

                if (!board.getPiece(x, y).isWhite) {
                    throw new Exception("Target square is occupied.");
                }

            } else {
                throw new Exception("Wrong move.");
            }
        }

        // TODO Handle promotion.

        board.setPiece(board.getPiece(i, j), x, y);
        board.setPiece(null, i, j);
    }

    @Override
    public String toString() {
        return "p";
    }

    @Override
    public boolean canAttack(Board board, int i, int j, int x, int y) {
        if (this.isWhite) {
            if (x == i - 1 && (y == j + 1 || y == j - 1)) {
                return true;
            }
        } else {
            if (x == i + 1 && (y == j + 1 || y == j - 1)) {
                return true;
            }
        }

        return false;
    }
}
