package ru.dsavina.judit;

import ru.dsavina.judit.pieces.*;

public class Board {

    private Piece[][] board = new Piece[8][8];

    public void initPiece(Piece piece, boolean isWhite, int i, int j) {
        piece.isWhite = isWhite;
        this.setPiece(piece, i, j);
    }

    public Board() {

        for (int j = 0; j <= 7; j++) {
            this.initPiece(new Pawn(), true, 6, j);
        }

        for (int j = 0; j <= 7; j++) {
            this.initPiece(new Pawn(), false, 1, j);
        }

        this.initPiece(new Castle(), true, 7, 0);
        this.initPiece(new Castle(), true, 7, 7);

        this.initPiece(new Castle(), false, 0, 0);
        this.initPiece(new Castle(), false, 0, 7);

        this.initPiece(new Knight(), true, 7, 1);
        this.initPiece(new Knight(), true, 7, 6);

        this.initPiece(new Knight(), false, 0, 1);
        this.initPiece(new Knight(), false, 0, 6);

        this.initPiece(new Bishop(), true, 7, 2);
        this.initPiece(new Bishop(), true, 7, 5);

        this.initPiece(new Bishop(), false, 0, 2);
        this.initPiece(new Bishop(), false, 0, 5);

        this.initPiece(new Queen(), true, 7, 3);
        this.initPiece(new Queen(), false, 0, 3);

        this.initPiece(new King(), true, 7, 4);
        this.initPiece(new King(), false, 0, 4);
    }

    public Piece getPiece(int i, int j) {

        return board[i][j];
    }

    public void setPiece(Piece piece, int i, int j) {

        board[i][j] = piece;
    }

    public void move(int i, int j, int x, int y) throws Exception {
        if (i < 0 || i > 7 || j < 0 || j > 7) {
            throw new Exception("Where the hell are you going!");
        }

        if (board[i][j] == null) {
            throw new Exception("No piece on the square.");
        }

        if (i == x && j == y) {
            throw new Exception("");
        }

        board[i][j].move(this, i, j, x, y);
    }

    public void printBoard() {
        for (int d = 0; d < this.board.length; d++) {
            System.out.print((8 - d) + " ");
            for (int k = 0; k < this.board[d].length; k++) {
                if (this.getPiece(d, k) == null) {
                    System.out.print("  ");
                } else {
                    if (!this.getPiece(d, k).isWhite) {
                        System.out.print("\033[34m");
                    }

                    System.out.print(this.board[d][k] + " ");
                    System.out.print("\033[0m");
                }
            }

            System.out.println();
        }

        System.out.println("  A B C D E F G H "); //напечатать сереньким
    }

    public int[] convertCoordinates(String koordinatko) {
        char colChar = koordinatko.charAt(0);
        char rowChar = koordinatko.charAt(1);

        int row = 0;
        int column = 0;

        if (colChar == 'a') {
            column = 0;
        } else if (colChar == 'b') {
            column = 1;
        } else if (colChar == 'c') {
            column = 2;
        } else if (colChar == 'd') {
            column = 3;
        } else if (colChar == 'e') {
            column = 4;
        } else if (colChar == 'f') {
            column = 5;
        } else if (colChar == 'g') {
            column = 6;
        } else if (colChar == 'h') {
            column = 7;
        }

        if (rowChar == '1') {
            row = 7;
        } else if (rowChar == '2') {
            row = 6;
        } else if (rowChar == '3') {
            row = 5;
        } else if (rowChar == '4') {
            row = 4;
        } else if (rowChar == '5') {
            row = 3;
        } else if (rowChar == '6') {
            row = 2;
        } else if (rowChar == '7') {
            row = 1;
        } else if (rowChar == '8') {
            row = 0;
        }

        int[] result = new int[2];
        result[0] = row;
        result[1] = column;

        return result;
    }

    public boolean hasCheck(boolean isWhite) {

        int i = 0;
        int j = 0;

        for (int d = 0; d < board.length; d++) {
            for (int k = 0; k < board[d].length; k++) {
                if (board[d][k] != null && board[d][k].toString().equals("K") && board[d][k].isWhite == isWhite) {
                    i = d;
                    j = k;
                }
            }
        }

        for (int d = 0; d < board.length; d++) {
            for (int k = 0; k < board[d].length; k++) {
                if (board[d][k] != null && board[d][k].isWhite != isWhite) {
                    if (board[d][k].canAttack(this, d, k, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}