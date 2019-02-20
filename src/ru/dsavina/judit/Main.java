package ru.dsavina.judit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        Board board = new Board();

        board.printBoard();

        System.out.println();

        System.out.print("> ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        for (String command = br.readLine(); !command.equals("exit"); command = br.readLine()) {

            String[] parts = command.split(" ");

            int[] startSquare = board.convertCoordinates(parts[0]);

            int[] targetSquare = board.convertCoordinates(parts[1]);

            board.move(startSquare[0], startSquare[1], targetSquare[0], targetSquare[1]);

            if (board.hasCheck(true)) {
                System.out.println("Check to whites.");
            }

            if (board.hasCheck(false)) {
                System.out.println("Check to blacks.");
            }

            System.out.println();
            board.printBoard();

            System.out.println();

            System.out.print("> ");


        }
    }
}