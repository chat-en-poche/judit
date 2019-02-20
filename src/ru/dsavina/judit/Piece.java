package ru.dsavina.judit;

public abstract class Piece {

    public boolean isWhite;

    public abstract void move(Board board, int i, int j, int x, int y) throws Exception;

    public abstract boolean canAttack(Board board, int i, int j, int x, int y);

}
