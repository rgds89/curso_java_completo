package com.cusro.java.completo.chess;

import com.cusro.java.completo.boardgame.BoardException;

public class ChessException extends BoardException {
    private static final long serialVersionUID = 1L;

    public ChessException(String msg){
        super(msg);
    }
}
