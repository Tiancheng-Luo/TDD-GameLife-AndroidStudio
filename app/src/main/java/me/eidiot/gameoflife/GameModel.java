package me.eidiot.gameoflife;

public class GameModel {
    private int rows;
    private int columns;

    public GameModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
