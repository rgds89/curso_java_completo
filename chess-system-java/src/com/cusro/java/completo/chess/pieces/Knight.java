package com.cusro.java.completo.chess.pieces;

import com.cusro.java.completo.boardgame.Board;
import com.cusro.java.completo.boardgame.Position;
import com.cusro.java.completo.chess.ChessPiece;
import com.cusro.java.completo.chess.Color;

public class Knight extends ChessPiece {

    private boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
    private Position p = new Position(0, 0);

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        possibleMovesAboveLeft();
        possibleMovesAboveRight();
        possibleMovesLeftAbove();
        possibleMovesRightAbove();
        possibleMovesBelowLeft();
        possibleMovesBelowRight();
        possibleMovesLeftBelow();
        possibleMovesRightBelow();
        return mat;
    }

    @Override
    public String toString() {
        return "N";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private void possibleMovesAboveLeft(){
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesLeftAbove(){
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesAboveRight() {
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesRightAbove(){
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesLeftBelow() {
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesRightBelow() {
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesBelowLeft() {
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesBelowRight() {
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }
}
