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

        if (diffIx != diffJy && x != i && y != j) {
            throw new Exception("Wrong move.");
        }

        if (diffIx == diffJy) {
            if (i > x) {
                if (j > y) {
                    for (int d = i - 1, k = j - 1; d > x + 1 && k > y + 1; d--, k--) {
                        if (board.getPiece(d, k) != null) {
                            throw new Exception("");
                        }
                    }
                } else {
                    for (int d = i - 1, k = j + 1; d > x + 1 && k < y - 1; d--, k++) {
                        if (board.getPiece(d, k) != null) {
                            throw new Exception("");
                        }
                    }
                }
            } else {
                if (j > y) {
                    for (int d = i + 1, k = j - 1; d < x - 1 && k > y + 1; d++, k--) {
                        if (board.getPiece(d, k) != null) {
                            throw new Exception("");
                        }
                    }
                } else {
                    for (int d = i + 1, k = j + 1; d < x - 1 && k < y - 1; d++, k++) {
                        if (board.getPiece(d, k) != null) {
                            throw new Exception("");
                        }
                    }
                }
            }
        } else {
            if (j == y) {
                if (i < x) {
                    for (int d = i + 1; d < x - 1; d++) {
                        if (board.getPiece(d, j) != null) {
                            throw new Exception("A");
                        }
                    }
                } else {
                    for (int d = i - 1; d > x + 1; d--) {
                        if (board.getPiece(d, j) != null) {
                            throw new Exception("");
                        }
                    }
                }
            } else {
                if (j < y) {
                    for (int d = j + 1; d < y - 1; d++) {
                        if (board.getPiece(i, d) != null) {
                            throw new Exception("");
                        }
                    }
                } else {
                    for (int d = j - 1; d > y + 1; d--) {
                        if (board.getPiece(i, d) != null) {
                            throw new Exception("");
                        }
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
        return "Q";
    }
}
