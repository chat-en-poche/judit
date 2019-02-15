package ru.dsavina.judit;

import ru.dsavina.judit.pieces.*;

public class Board {

    private Piece[][] board = new Piece[8][8];

    public Board() {

        Piece piece = new Pawn();
        piece.isWhite = true;
        for (int j = 0; j <= 7; j++) {
            this.setPiece(piece, 6, j);
        }

        piece = new Pawn();
        piece.isWhite = false;
        for (int j = 0; j <= 7; j++) {
            this.setPiece(piece, 1, j);
        }

        piece = new Castle();
        piece.isWhite = true;
        this.setPiece(piece, 7, 0);

        piece = new Castle();
        piece.isWhite = true;
        this.setPiece(piece, 7, 7);

        piece = new Castle();
        piece.isWhite = false;
        this.setPiece(piece, 0, 0);

        piece = new Castle();
        piece.isWhite = false;
        this.setPiece(piece, 0, 7);

        piece = new Knight();
        piece.isWhite = true;
        this.setPiece(piece, 7, 1);

        piece = new Knight();
        piece.isWhite = true;
        this.setPiece(piece, 7, 6);

        piece = new Knight();
        piece.isWhite = false;
        this.setPiece(piece, 0, 1);

        piece = new Knight();
        piece.isWhite = false;
        this.setPiece(piece, 0, 6);

        piece = new Bishop();
        piece.isWhite = true;
        this.setPiece(piece, 7, 2);

        piece = new Bishop();
        piece.isWhite = true;
        this.setPiece(piece, 7, 5);

        piece = new Bishop();
        piece.isWhite = false;
        this.setPiece(piece, 0, 2);

        piece = new Bishop();
        piece.isWhite = false;
        this.setPiece(piece, 0, 5);

        piece = new Queen();
        piece.isWhite = true;
        this.setPiece(piece, 7, 3);

        piece = new Queen();
        piece.isWhite = false;
        this.setPiece(piece, 0, 3);

        piece = new King();
        piece.isWhite = true;
        this.setPiece(piece, 7, 4);

        piece = new King();
        piece.isWhite = false;
        this.setPiece(piece, 0, 4);
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


}