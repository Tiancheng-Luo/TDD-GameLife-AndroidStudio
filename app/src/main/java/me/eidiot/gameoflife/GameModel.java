package me.eidiot.gameoflife;

public class GameModel {
    private int rows;
    private int columns;

    private boolean map[][];

    public GameModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        map = new boolean[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean isAlive(int row, int column) {
        return !isOutOfMap(row, column) && map[row][column];
    }

    public void makeAlive(int row, int column) {
        if (!isOutOfMap(row, column)) {
            map[row][column] = true;
        }
    }

    public void makeDead(int row, int column) {
        if (!isOutOfMap(row, column)) {
            map[row][column] = false;
        }
    }

    private boolean isOutOfMap(int row, int column) {
        return row < 0 || row > rows - 1 || column < 0 || column > columns - 1;
    }
}
