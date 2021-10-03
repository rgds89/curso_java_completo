package com.cusro.java.completo.chess.pieces;

import com.cusro.java.completo.boardgame.Board;
import com.cusro.java.completo.boardgame.Position;
import com.cusro.java.completo.chess.ChessMatch;
import com.cusro.java.completo.chess.ChessPiece;
import com.cusro.java.completo.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    private boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
    private Position p = new Position(0, 0);

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        possibleMovesAbove();
        possibleMovesBelow();
        possibleMovesLeft();
        possibleMovesRight();
        possibleMovesNw();
        possibleMovesNe();
        possibleMovesSw();
        possibleMovesSe();
        return mat;
    }

    private void possibleMovesAbove() {
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {

            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesBelow() {
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesLeft() {
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesRight() {
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesNw() {
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesNe() {
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesSw() {
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesSe() {
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

    private void possibleMovesCastling() {
        // #specialMove castling kingside rook
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            Position pT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(pT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[p.getRow()][p.getColumn() + 2] = true;
                }
            }
        }

        // #specialMove castling queenside rook
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            Position pT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(pT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[p.getRow()][p.getColumn() - 2] = true;
                }
            }
        }
    }
}