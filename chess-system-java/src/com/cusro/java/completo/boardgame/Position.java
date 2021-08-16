package com.cusro.java.completo.boardgame;

public class Position {
    private Long row;
    private Long column;

    public Position(Long row, Long column) {
        this.row = row;
        this.column = column;
    }

    public Long getRow() {
        return row;
    }

    public void setRow(Long row) {
        this.row = row;
    }

    public Long getColumn() {
        return column;
    }

    public void setColumn(Long column) {
        this.column = column;
    }

    @Override
    public String toString(){
        return row + ", " + column;
    }
}
