package com.cusro.java.completo.application;

import com.cusro.java.completo.boardgame.Board;
import com.cusro.java.completo.boardgame.Position;
import com.cusro.java.completo.chess.ChessMatch;

public class Program {
    public static void main(String[] args){
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
