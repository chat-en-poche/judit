package ru.dsavina.judit;

public class Main {
    public static void main(String[] args) throws Exception {

        Board board = new Board();

        board.printBoard();

        System.out.println("----------------");

        board.move(6, 4, 4, 4);

        board.printBoard();


    }
}