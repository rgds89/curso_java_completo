package com.cusro.java.completo.chess.pieces;

import com.cusro.java.completo.boardgame.Board;
import com.cusro.java.completo.chess.ChessPiece;
import com.cusro.java.completo.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}