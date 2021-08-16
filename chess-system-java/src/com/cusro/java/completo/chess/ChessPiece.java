package com.cusro.java.completo.chess;

import com.cusro.java.completo.boardgame.Board;
import com.cusro.java.completo.boardgame.Piece;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
